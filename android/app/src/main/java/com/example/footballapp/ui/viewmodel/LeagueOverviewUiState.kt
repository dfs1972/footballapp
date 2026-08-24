package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.CompetitionStageUiModel
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel

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
     * Standings displayed on the League Overview screen.
     *
     * Currently the top five clubs are shown, although
     * the UI decides how many rows to display.
     */

    val topStandings: List<LeagueTableGroupUiModel> = emptyList(),

    /**
     * Current competition round.
     */
    val currentRound: String? = null,

    /**
     * Error message displayed if loading fails.
     */
    val error: String? = null

)