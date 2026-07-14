package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
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

        viewModelScope.launch {

            try {

                val players =
                    repository
                        .getPlayers(
                            teamId,
                            leagueId,
                            season
                        )
                        .map {
                            it.toUiModel()
                        }

                println("Squad size = ${players.size}")

                _uiState.value =
                    SquadUiState(

                        isLoading = false,

                        players = players

                    )

            } catch (e: Exception) {

                _uiState.value =
                    SquadUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}