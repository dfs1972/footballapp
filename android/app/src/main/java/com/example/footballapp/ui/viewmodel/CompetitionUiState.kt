package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

data class CompetitionUiState(

    val isLoading: Boolean = true,

    val competitionGroups: List<CompetitionGroupUiModel> = emptyList(),

    val error: String? = null

)