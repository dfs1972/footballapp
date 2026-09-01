package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
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
        
        if (currentState.fixture?.fixtureId == fixtureId && 
            currentState.events.isNotEmpty()) {
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
            val lineupUi = response.lineup?.toUiModel()

            _uiState.value = MatchDetailUiState(
                isLoading = false,
                fixture = fixtureUi,
                events = eventsUi,
                lineup = lineupUi
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
            while (true) {
                // Wait for the next poll interval first, since we just fetched data
                val currentStatus = _uiState.value.fixture?.statusShort
                    ?.let { FixtureStatusResolver.fromShortStatus(it) }

                val interval = when {
                    currentStatus == null -> 60_000L
                    FixtureStatusResolver.isLive(currentStatus) -> 15_000L
                    FixtureStatusResolver.isFinished(currentStatus) -> return@launch // Stop polling
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
