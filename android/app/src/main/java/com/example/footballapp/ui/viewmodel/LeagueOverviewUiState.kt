package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel

/**
 * UI state for the League Overview screen.
 */
data class LeagueOverviewUiState(

    /**
     * True while loading data.
     */
    val isLoading: Boolean = true,

    /**
     * League overview returned from the backend.
     */
    val overview: LeagueOverviewUiModel? = null,

    /**
     * List of Top 5(?) Clubs in the League
     */

    val topStandings: List<LeagueTableRowUiModel> = emptyList(),

    /**
     * Error message displayed if loading fails.
     */
    val error: String? = null

)