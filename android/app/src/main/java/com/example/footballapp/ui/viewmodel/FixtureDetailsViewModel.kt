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

        /************ TEMP LOG.d ************************/
        android.util.Log.d(
            "FixtureDetails",
            "loadFixture called: $fixtureId"
        )

        viewModelScope.launch {

            /*
             * Start with a clean loading state.
             */
            _uiState.value =
                FixtureDetailsUiState(
                    isLoading = true
                )

            /*
             * ---------------------------------------------------------
             * Fixture details
             * ---------------------------------------------------------
             *
             * This is the essential request.
             *
             * If it fails, the fixture cannot be displayed.
             */
            try {

                val fixture =
                    repository
                        .getFixtureDetails(
                            fixtureId
                        )
                        .toUiModel()

                /*
                 * Display the fixture immediately.
                 *
                 * The lineup is deliberately loaded separately.
                 */
                _uiState.value =
                    FixtureDetailsUiState(

                        isLoading = false,

                        fixture = fixture

                    )

            } catch (e: Exception) {

                /*
                 * Fixture request failed.
                 *
                 * There is no fixture to display.
                 */
                _uiState.value =
                    FixtureDetailsUiState(

                        isLoading = false,

                        error =
                            e.message
                                ?: "Unable to load fixture"

                    )

                return@launch
            }

            /*
             * ---------------------------------------------------------
             * Fixture lineup
             * ---------------------------------------------------------
             *
             * The lineup is optional.
             *
             * A failure here must NOT remove the fixture
             * that we have already successfully loaded.
             */
            try {

                android.util.Log.d(
                    "FixtureDetails",
                    "About to request lineup: $fixtureId"
                )

                val lineup =
                    repository
                        .getFixtureLineup(
                            fixtureId
                        )

                android.util.Log.d(
                    "FixtureDetails",
                    "Lineup returned: teams=${lineup.teams.size}"
                )

                _uiState.value =
                    _uiState.value.copy(
                        lineup = lineup
                    )

            } catch (e: Exception) {

                android.util.Log.e(
                    "FixtureDetails",
                    "Lineup request failed",
                    e
                )

                _uiState.value =
                    _uiState.value.copy(
                        lineup = null
                    )
            }
        }
    }
}