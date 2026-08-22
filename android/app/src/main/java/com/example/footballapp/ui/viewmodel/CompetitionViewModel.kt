package com.example.footballapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.CompetitionRepository
import com.example.footballapp.ui.model.CompetitionUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CompetitionViewModel(
    private val repository: CompetitionRepository = CompetitionRepository()
) : ViewModel() {

    private val _competitions =
        MutableStateFlow<List<CompetitionUiModel>>(emptyList())

    val competitions: StateFlow<List<CompetitionUiModel>> =
        _competitions.asStateFlow()

    private val _isLoading =
        MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> =
        _isLoading.asStateFlow()

    private val _error =
        MutableStateFlow<String?>(null)

    val error: StateFlow<String?> =
        _error.asStateFlow()

    fun loadCompetitions(
        country: String,
        season: Int
    ) {

        if (_isLoading.value) {
            return
        }

        _competitions.value = emptyList()

        viewModelScope.launch {

            _isLoading.value = true
            _error.value = null

            Log.d(
                "CompetitionViewModel",
                "Loading competitions for $country / $season"
            )

            try {

                val response =
                    repository.getLeaguesByCountry(
                        country = country,
                        season = season
                    )

                val uiModels =
                    response.map { competition ->

                        CompetitionUiModel(

                            id = competition.league.id,

                            name = competition.league.name,

                            country = competition.country.name,

                            type = competition.league.type

                        )
                    }

                _competitions.value = uiModels

                Log.d(
                    "CompetitionViewModel",
                    "Repository returned ${uiModels.size} competitions"
                )

                Log.d(
                    "CompetitionViewModel",
                    "Competitions: ${
                        uiModels.map {
                            "${it.name} (${it.type})"
                        }
                    }"
                )

            } catch (exception: Exception) {

                _error.value =
                    exception.message
                        ?: "Failed to load competitions."

                Log.e(
                    "CompetitionViewModel",
                    "Failed to load competitions",
                    exception
                )

            } finally {

                _isLoading.value = false

                Log.d(
                    "CompetitionViewModel",
                    "Loading finished"
                )
            }
        }
    }
}