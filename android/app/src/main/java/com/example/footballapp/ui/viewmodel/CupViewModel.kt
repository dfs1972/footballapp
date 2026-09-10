package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.FixtureRepository
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.data.mapper.toUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class CupUiState(
    val leagueId: Int? = null,
    val season: Int? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val rounds: List<String> = emptyList(),
    val selectedRound: String? = null,
    val fixtures: List<FixtureUiModel> = emptyList()
)

class CupViewModel : ViewModel() {

    private val repository = FixtureRepository()

    private val _uiState = MutableStateFlow(CupUiState())
    val uiState: StateFlow<CupUiState> = _uiState.asStateFlow()

    private var allFixtures: List<FixtureUiModel> = emptyList()

    fun loadCup(leagueId: Int, season: Int) {
        if (_uiState.value.leagueId == leagueId && _uiState.value.season == season) return

        viewModelScope.launch {
            _uiState.value = CupUiState(leagueId = leagueId, season = season, isLoading = true)

            try {
                val rounds = repository.getFixtureRounds(leagueId, season)
                val fixtures = repository.getFixtures(leagueId, season)
                
                allFixtures = fixtures
                
                // Default to the latest round that has fixtures, or the last one if none
                val defaultRound = rounds.lastOrNull { r -> fixtures.any { it.round == r } } ?: rounds.lastOrNull()

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    rounds = rounds,
                    selectedRound = defaultRound,
                    fixtures = if (defaultRound != null) fixtures.filter { it.round == defaultRound } else fixtures
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    fun selectRound(round: String) {
        _uiState.value = _uiState.value.copy(
            selectedRound = round,
            fixtures = allFixtures.filter { it.round == round }
        )
    }
}
