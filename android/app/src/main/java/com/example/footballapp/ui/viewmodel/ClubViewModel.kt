package com.example.footballapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.ClubRepository
import com.example.footballapp.data.repository.FixtureRepository
import com.example.footballapp.data.repository.TeamColorRepository
import com.example.footballapp.ui.model.FixtureStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ClubRepository()
    private val fixtureRepository = FixtureRepository()
    private val colorRepository = TeamColorRepository(application)

    private val _uiState =
        MutableStateFlow(
            ClubUiState()
        )

    val uiState: StateFlow<ClubUiState> =
        _uiState.asStateFlow()

    fun loadClub(
        clubId: Int,
        leagueId: Int? = null,
        season: Int? = null
    ) {

        val currentState = _uiState.value

        if (currentState.clubId == clubId &&
            currentState.club != null) {
            return
        }

        viewModelScope.launch {

            _uiState.value =
                ClubUiState(
                    isLoading = true
                )

            try {

                var club =
                    repository.getClub(
                        clubId
                    )

                // 1. Check cache first (includes manual overrides)
                var cachedColors = colorRepository.getTeamColors(clubId, club.name)
                
                // 2. If missing and we have league context, try to discover from recent fixture
                if (cachedColors == null && leagueId != null && season != null) {
                    try {
                        val fixtures = fixtureRepository.getTeamFixtures(clubId, leagueId, season)
                        val latestFinished = fixtures
                            .filter { it.status == FixtureStatus.FINISHED }
                            .maxByOrNull { it.fixtureDate }
                        
                        if (latestFinished != null) {
                            val lineup = fixtureRepository.getFixtureLineup(latestFinished.fixtureId)
                            val teamLineup = lineup.teams.find { it.teamId == clubId }
                            if (teamLineup?.colors != null) {
                                colorRepository.saveTeamColors(clubId, teamLineup.colors)
                                cachedColors = teamLineup.colors
                            }
                        }
                    } catch (e: Exception) {
                        // Discovery failed, fall back to whatever we have
                    }
                }

                if (cachedColors != null) {
                    club = club.copy(colors = cachedColors)
                }

                _uiState.value =
                    ClubUiState(

                        isLoading = false,

                        clubId = clubId,

                        club = club

                    )

            } catch (e: Exception) {

                _uiState.value =
                    ClubUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}
