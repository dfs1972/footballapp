package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.FixtureRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FixtureDetailsViewModel : ViewModel() {

    private val repository =
        FixtureRepository()

    private val _uiState =
        MutableStateFlow(
            FixtureDetailsUiState()
        )

    val uiState: StateFlow<FixtureDetailsUiState> =
        _uiState.asStateFlow()

    fun loadFixture(
        fixtureId: Long
    ) {

        viewModelScope.launch {

            try {

                val fixture =
                    repository
                        .getFixtureDetails(
                            fixtureId
                        )
                        .toUiModel()

                val lineup =
                    repository
                        .getFixtureLineup(
                            fixtureId
                        )

                _uiState.value =
                    FixtureDetailsUiState(

                        isLoading = false,

                        fixture = fixture,

                        lineup = lineup

                    )

            } catch (e: Exception) {

                _uiState.value =
                    FixtureDetailsUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}