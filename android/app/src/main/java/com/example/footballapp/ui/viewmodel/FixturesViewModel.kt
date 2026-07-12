package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.FixtureRepository
import com.example.footballapp.ui.model.FixtureDayUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FixturesViewModel : ViewModel() {

    private val repository =
        FixtureRepository()

    private val _uiState =
        MutableStateFlow(
            FixturesUiState()
        )

    val uiState: StateFlow<FixturesUiState> =
        _uiState.asStateFlow()

    fun loadFixtures(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            try {

                val fixtureDays =
                    repository
                        .getFixtures(
                            leagueId,
                            season
                        )
                        .map {
                            it.toUiModel()
                        }
                        .groupBy {

                            /*
                             * Group fixtures by the date
                             * supplied by the backend.
                             */
                            it.fixtureDate // temporary placeholder

                        }

                        .map { (date, fixtures) ->

                            FixtureDayUiModel(

                                heading = date,

                                fixtures = fixtures

                            )

                        }

                _uiState.value =
                    FixturesUiState(

                        isLoading = false,

                        fixtureDays = fixtureDays

                    )

            } catch (e: Exception) {

                _uiState.value =
                    FixturesUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}