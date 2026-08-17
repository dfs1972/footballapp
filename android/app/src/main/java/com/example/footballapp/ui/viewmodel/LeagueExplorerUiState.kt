package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.LeagueOverviewRepository
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class LeagueExplorerUiState(

    val isLoading: Boolean = false,

    val league: LeagueOverviewUiModel? = null,

    val error: String? = null

)

class LeagueExplorerViewModel : ViewModel() {

    private val repository =
        LeagueOverviewRepository()

    private val _uiState =
        MutableStateFlow(
            LeagueExplorerUiState()
        )

    val uiState: StateFlow<LeagueExplorerUiState> =
        _uiState.asStateFlow()

    fun loadLeague(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            _uiState.value =
                LeagueExplorerUiState(
                    isLoading = true
                )

            try {

                val league =
                    repository.getLeagueOverview(
                        leagueId,
                        season
                    )

                _uiState.value =
                    LeagueExplorerUiState(
                        isLoading = false,
                        league = league
                    )

            } catch (e: Exception) {

                _uiState.value =
                    LeagueExplorerUiState(
                        isLoading = false,
                        error =
                            e.message
                                ?: "Unable to load league"
                    )
            }
        }
    }
}