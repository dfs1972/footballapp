package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

/**
 * UI state for the League Overview screen.
 */
data class LeagueOverviewUiState(

    val isLoading: Boolean = true,

    val leagueId: Int? = null,

    val season: Int? = null,

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
     * Competitions available in the current country.
     */
    val competitions: List<CompetitionUiModel> = emptyList(),

    /**
     * Error message displayed if loading fails.
     */
    val error: String? = null

)