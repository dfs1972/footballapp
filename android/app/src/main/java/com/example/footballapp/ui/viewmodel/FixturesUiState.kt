package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDayUiModel

data class FixturesUiState(

    val isLoading: Boolean = true,

    val leagueId: Int? = null,

    val season: Int? = null,

    val fixtureDays: List<FixtureDayUiModel> = emptyList(),

    val error: String? = null

)