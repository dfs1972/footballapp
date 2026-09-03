package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.*
import com.example.footballapp.data.repository.MatchDetailRepository
import com.example.footballapp.util.FixtureStatusResolver
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MatchDetailViewModel : ViewModel() {

    private val repository = MatchDetailRepository()

    private val _uiState = MutableStateFlow(MatchDetailUiState())
    val uiState: StateFlow<MatchDetailUiState> = _uiState.asStateFlow()

    private var pollingJob: Job? = null

    fun loadMatchDetails(fixtureId: Long) {
        val currentState = _uiState.value
        
        // Only return if we have the correct fixture and it's already finished (data won't change)
        // and we have a complete lineup with colors.
        val isFinished = currentState.fixture?.statusShort?.let { 
            FixtureStatusResolver.isFinished(FixtureStatusResolver.fromShortStatus(it)) 
        } ?: false
        
        val hasCompleteLineup = currentState.lineup?.teams?.let { teams ->
            teams.size >= 2 && teams.all { 
                !it.colors?.player?.primary.isNullOrBlank() || !it.colors?.goalkeeper?.primary.isNullOrBlank()
            }
        } ?: false

        if (currentState.fixture?.fixtureId == fixtureId && isFinished && hasCompleteLineup) {
            return
        }

        // Stop any existing polling
        pollingJob?.cancel()

        viewModelScope.launch {
            _uiState.value = MatchDetailUiState(isLoading = true)
            fetchData(fixtureId)
            startAdaptivePolling(fixtureId)
        }
    }

    private suspend fun fetchData(fixtureId: Long) {
        try {
            val response = repository.getMatchDetails(fixtureId)

            val fixtureUi = response.fixture.toUiModel()
            val eventsUi = response.events?.map { it.toUiModel() } ?: emptyList()
            var lineupUi = response.lineup?.toUiModel()
            val statsUi = response.statistics?.toUiModel() ?: emptyList()

            // If lineup is missing, incomplete, or missing colors, fallback to the dedicated endpoint
            val needsLineupFetch = lineupUi == null || 
                                   lineupUi.teams.size < 2 || 
                                   lineupUi.teams.any { 
                                       it.colors?.player?.primary.isNullOrBlank() && 
                                       it.colors?.goalkeeper?.primary.isNullOrBlank()
                                   }
            
            if (needsLineupFetch) {
                try {
                    val fallbackLineup = repository.getFixtureLineup(fixtureId).toUiModel()
                    if (fallbackLineup.teams.isNotEmpty()) {
                        lineupUi = fallbackLineup
                    }
                } catch (e: Exception) {
                    // Fallback failed, keep original lineupUi
                }
            }

            _uiState.value = MatchDetailUiState(
                isLoading = false,
                fixture = fixtureUi,
                events = eventsUi,
                lineup = lineupUi,
                statistics = statsUi
            )
        } catch (e: Exception) {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                error = e.message ?: "Failed to load match details"
            )
        }
    }

    private fun startAdaptivePolling(fixtureId: Long) {
        pollingJob = viewModelScope.launch {
            var finishedFetchCount = 0
            while (true) {
                val currentStatus = _uiState.value.fixture?.statusShort
                    ?.let { FixtureStatusResolver.fromShortStatus(it) }

                val isFinished = currentStatus?.let { FixtureStatusResolver.isFinished(it) } ?: false
                val hasCompleteLineup = _uiState.value.lineup?.teams?.let { teams ->
                    teams.size >= 2 && teams.all { 
                        !it.colors?.player?.primary.isNullOrBlank() || !it.colors?.goalkeeper?.primary.isNullOrBlank()
                    }
                } ?: false

                // If finished and we have complete data, or we've tried several times after finishing
                if (isFinished && (hasCompleteLineup || finishedFetchCount >= 5)) {
                    return@launch
                }

                if (isFinished) {
                    finishedFetchCount++
                }

                val interval = when {
                    currentStatus == null -> 60_000L
                    FixtureStatusResolver.isLive(currentStatus) -> 15_000L
                    isFinished -> 45_000L // Poll a bit more slowly after finishing
                    else -> 60_000L // Scheduled
                }

                delay(interval)
                fetchData(fixtureId)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        pollingJob?.cancel()
    }
}
