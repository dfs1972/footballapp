package com.example.footballapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.dto.LeagueOverviewDto
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.repository.LeagueRepository
import com.example.footballapp.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LeagueOverviewViewModel(
    private val repository: LeagueRepository = LeagueRepository()
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<LeagueOverviewUiModel>>(
            UiState.Loading
        )

    val uiState: StateFlow<UiState<LeagueOverviewUiModel>> =
        _uiState

    fun loadLeagueOverview(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            _uiState.value = UiState.Loading

            try {

                val overview =
                    repository.getLeagueOverview(
                        leagueId,
                        season
                    )

                _uiState.value =
                    UiState.Success(overview)

            } catch (e: Exception) {

                _uiState.value =
                    UiState.Error(
                        e.message ?: "Unknown error"
                    )

            }

        }

    }

}