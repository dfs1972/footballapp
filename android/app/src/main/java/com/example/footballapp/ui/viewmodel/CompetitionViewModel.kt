package com.example.footballapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toCompetitionGroups
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.CompetitionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CompetitionViewModel : ViewModel() {

    private val repository = CompetitionRepository()

    private val _uiState =
        MutableStateFlow(CompetitionUiState())

    val uiState: StateFlow<CompetitionUiState> =
        _uiState.asStateFlow()

    init {
        loadCompetitions()
    }

    private fun loadCompetitions() {

        viewModelScope.launch {

            try {

                val competitionGroups =
                    repository
                        .getCompetitions()
                        .map { it.toUiModel() }
                        .toCompetitionGroups()

                _uiState.value =
                    CompetitionUiState(
                        isLoading = false,
                        competitionGroups = competitionGroups
                    )

            } catch (e: Exception) {

                _uiState.value =
                    CompetitionUiState(
                        isLoading = false,
                        error = e.message
                    )
            }

        }

    }

}