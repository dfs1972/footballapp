package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.LeagueOverviewRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeagueOverviewViewModel : ViewModel() {

    private val repository = LeagueOverviewRepository()

    private val _uiState =
        MutableStateFlow(LeagueOverviewUiState())

    val uiState: StateFlow<LeagueOverviewUiState> =
        _uiState.asStateFlow()

    fun loadLeagueOverview(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            _uiState.value =
                LeagueOverviewUiState(isLoading = true)

            try {

                val overview =
                    repository.getLeagueOverview(
                        leagueId,
                        season
                    )

                _uiState.value =
                    LeagueOverviewUiState(
                        isLoading = false,
                        overview = overview
                    )

            } catch (e: Exception) {

                _uiState.value =
                    LeagueOverviewUiState(
                        isLoading = false,
                        error = e.message
                    )
            }
        }
    }
}