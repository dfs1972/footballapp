package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.CompetitionUiModel

data class CompetitionUiState(

    val isLoading: Boolean = true,

    val competitions: List<CompetitionUiModel> = emptyList(),

    val error: String? = null

)