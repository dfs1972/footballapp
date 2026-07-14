package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.FixtureUiModel

data class TeamFixturesUiState(

    val isLoading: Boolean = true,

    val fixtureDays: List<FixtureDayUiModel> = emptyList(),

    val error: String? = null

)