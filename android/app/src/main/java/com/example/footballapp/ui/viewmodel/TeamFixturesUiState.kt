package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDayUiModel

data class TeamFixturesUiState(

    val isLoading: Boolean = true,

    val teamId: Int? = null,

    val leagueId: Int? = null,

    val season: Int? = null,

    val fixtureDays: List<FixtureDayUiModel> = emptyList(),

    val error: String? = null

)