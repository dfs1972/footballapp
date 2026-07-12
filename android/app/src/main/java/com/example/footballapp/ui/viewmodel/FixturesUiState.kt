package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDayUiModel

data class FixturesUiState(

    val isLoading: Boolean = true,

    val fixtureDays: List<FixtureDayUiModel> = emptyList(),

    val error: String? = null

)