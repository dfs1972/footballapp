package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.CompetitionMetadataRepository
import com.example.footballapp.data.repository.LeagueOverviewRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeagueOverviewViewModel : ViewModel() {

    private val repository =
        LeagueOverviewRepository()

    private val metadataRepository =
        CompetitionMetadataRepository()

    private val _uiState =
        MutableStateFlow(
            LeagueOverviewUiState()
        )

    val uiState: StateFlow<LeagueOverviewUiState> =
        _uiState.asStateFlow()

    fun loadLeagueOverview(
        leagueId: Int,
        season: Int
    ) {

        val currentState = _uiState.value

        if (currentState.leagueId == leagueId &&
            currentState.season == season &&
            currentState.overview != null) {
            return
        }

        viewModelScope.launch {

            _uiState.value =
                LeagueOverviewUiState(
                    isLoading = true
                )

            try {

                val overview =
                    repository.getLeagueOverview(
                        leagueId,
                        season
                    )

                val metadata =
                    metadataRepository
                        .getCompetitionMetadata(
                            leagueId,
                            season
                        )

                _uiState.value =
                    LeagueOverviewUiState(

                        isLoading = false,

                        leagueId = leagueId,

                        season = season,

                        overview = overview,

                        topStandings =
                            metadata.standings,

                        currentRound =
                            metadata.currentRound,

                        competitions =
                            overview.featuredLeagues

                    )

            } catch (e: Exception) {

                _uiState.value =
                    LeagueOverviewUiState(

                        isLoading = false,

                        error =
                            e.message

                    )
            }
        }
    }
}