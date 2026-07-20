package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.TeamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubsViewModel : ViewModel() {

    private val repository =
        TeamRepository()

    private val _uiState =
        MutableStateFlow(
            ClubsUiState()
        )

    val uiState: StateFlow<ClubsUiState> =
        _uiState.asStateFlow()

    fun loadClubs(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            _uiState.value =
                ClubsUiState(
                    isLoading = true
                )

            try {

                val clubs =
                    repository.getTeams(
                        leagueId,
                        season
                    )

                _uiState.value =
                    ClubsUiState(

                        isLoading = false,

                        clubs = clubs

                    )

            } catch (e: Exception) {

                _uiState.value =
                    ClubsUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}