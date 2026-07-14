package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.PlayerDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerDetailsViewModel : ViewModel() {

    private val repository =
        PlayerDetailsRepository()

    private val _uiState =
        MutableStateFlow(
            PlayerDetailsUiState()
        )

    val uiState: StateFlow<PlayerDetailsUiState> =
        _uiState.asStateFlow()

    fun loadPlayerDetails(

        playerId: Int,

        leagueId: Int,

        season: Int

    ) {

        viewModelScope.launch {

            try {

                val player =

                    repository
                        .getPlayerDetails(

                            playerId,

                            leagueId,

                            season

                        )
                        .toUiModel()

                _uiState.value =

                    PlayerDetailsUiState(

                        isLoading = false,

                        player = player

                    )

            } catch (e: Exception) {

                _uiState.value =

                    PlayerDetailsUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}