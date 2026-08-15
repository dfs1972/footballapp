package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.LeagueTableGroupUiModel

/**
 * UI state for the League Table screen.
 */
data class LeagueTableUiState(

    val isLoading: Boolean = true,

    val table: List<LeagueTableGroupUiModel> = emptyList(),

    val error: String? = null

)