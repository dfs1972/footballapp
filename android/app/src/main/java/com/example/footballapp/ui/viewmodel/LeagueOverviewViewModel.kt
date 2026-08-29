package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.CompetitionMetadataRepository
import com.example.footballapp.data.repository.CompetitionRepository
import com.example.footballapp.data.repository.LeagueOverviewRepository
import com.example.footballapp.ui.model.CompetitionUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeagueOverviewViewModel : ViewModel() {

    private val repository =
        LeagueOverviewRepository()

    private val metadataRepository =
        CompetitionMetadataRepository()

    private val competitionRepository =
        CompetitionRepository()

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

                val competitions =
                    competitionRepository
                        .getFeaturedLeagues(
                            country = overview.countryName,
                            season = season
                        )
                        .map { competition ->

                            CompetitionUiModel(
                                id = competition.league.id,
                                name = competition.league.name,
                                country = competition.country.name,
                                type = competition.league.type
                            )
                        }

                _uiState.value =
                    LeagueOverviewUiState(

                        isLoading = false,

                        overview = overview,

                        topStandings =
                            metadata.standings,

                        currentRound =
                            metadata.currentRound,

                        competitions =
                            competitions

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