package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.SquadRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SquadViewModel : ViewModel() {

    private val repository =
        SquadRepository()

    private val _uiState =
        MutableStateFlow(
            SquadUiState()
        )

    val uiState: StateFlow<SquadUiState> =
        _uiState.asStateFlow()

    fun loadPlayers(
        teamId: Int,
        leagueId: Int,
        season: Int
    ) {

        val currentState = _uiState.value

        if (currentState.teamId == teamId &&
            currentState.leagueId == leagueId &&
            currentState.season == season &&
            currentState.players.isNotEmpty()) {
            return
        }

        /*************** TEST PRINT *******************************/

        println(">>> SquadViewModel.loadPlayers called")

        viewModelScope.launch {

            println(">>> Coroutine started")

            _uiState.value =
                SquadUiState(
                    isLoading = true
                )

            try {

                val players =
                    repository.getPlayers(
                        teamId,
                        leagueId,
                        season
                    )

                println("Players received = ${players.size}")

                players.forEach {
                    println("${it.name} -> ${it.position}")
                }

                _uiState.value =
                    SquadUiState(
                        isLoading = false,
                        teamId = teamId,
                        leagueId = leagueId,
                        season = season,
                        players = players
                    )

            } catch (e: Exception) {

                _uiState.value =
                    SquadUiState(
                        isLoading = false,
                        error = e.message
                    )

                e.printStackTrace()

                println("Repository failed: ${e.message}")

            }

        }

    }
}