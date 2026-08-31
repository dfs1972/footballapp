package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.LeagueTableRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeagueTableViewModel : ViewModel() {

    private val repository =
        LeagueTableRepository()

    private val _uiState =
        MutableStateFlow(
            LeagueTableUiState()
        )

    val uiState: StateFlow<LeagueTableUiState> =
        _uiState.asStateFlow()

    fun loadLeagueTable(
        leagueId: Int,
        season: Int
    ) {

        val currentState = _uiState.value

        if (currentState.leagueId == leagueId &&
            currentState.season == season &&
            currentState.table.isNotEmpty()) {
            return
        }

        viewModelScope.launch {

            _uiState.value =
                LeagueTableUiState(
                    isLoading = true
                )

            try {

                val table =
                    repository.getLeagueTable(
                        leagueId,
                        season
                    )

                _uiState.value =
                    LeagueTableUiState(

                        isLoading = false,

                        leagueId = leagueId,

                        season = season,

                        table = table

                    )

            } catch (e: Exception) {

                _uiState.value =
                    LeagueTableUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}