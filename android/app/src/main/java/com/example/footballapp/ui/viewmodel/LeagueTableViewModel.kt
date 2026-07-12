package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
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

        viewModelScope.launch {

            try {

                val table = repository
                    .getLeagueTable(
                        leagueId,
                        season
                    )
                    .map {
                        it.toUiModel()
                    }

                _uiState.value =
                    LeagueTableUiState(

                        isLoading = false,

                        table = table

                    )
                //println("League table size = ${table.size}")

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