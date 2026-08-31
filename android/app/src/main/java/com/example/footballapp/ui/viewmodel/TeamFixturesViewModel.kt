package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.FixtureRepository
import com.example.footballapp.ui.model.extensions.groupByDay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TeamFixturesViewModel : ViewModel() {

    private val repository =
        FixtureRepository()

    private val _uiState =
        MutableStateFlow(
            TeamFixturesUiState()
        )

    val uiState: StateFlow<TeamFixturesUiState> =
        _uiState.asStateFlow()

    fun loadFixtures(
        teamId: Int,
        leagueId: Int,
        season: Int
    ) {

        val currentState = _uiState.value

        if (currentState.teamId == teamId &&
            currentState.leagueId == leagueId &&
            currentState.season == season &&
            currentState.fixtureDays.isNotEmpty()) {
            return
        }

        viewModelScope.launch {

            try {

                val fixtureDays =
                    repository
                        .getTeamFixtures(
                            teamId,
                            leagueId,
                            season
                        )
                        .groupByDay()

                _uiState.value =
                    TeamFixturesUiState(

                        isLoading = false,

                        teamId = teamId,

                        leagueId = leagueId,

                        season = season,

                        fixtureDays = fixtureDays

                    )

            } catch (e: Exception) {

                _uiState.value =
                    TeamFixturesUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}