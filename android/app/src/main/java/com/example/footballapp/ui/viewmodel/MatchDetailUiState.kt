package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.model.FixtureEventUiModel
import com.example.footballapp.ui.model.FixtureLineupUiModel

data class MatchDetailUiState(
    val isLoading: Boolean = false,
    val fixture: FixtureDetailsUiModel? = null,
    val lineup: FixtureLineupUiModel? = null,
    val events: List<FixtureEventUiModel> = emptyList(),
    val error: String? = null
)
