package org.footballapp.model

/**
 * Team statistics returned by the FootballApp backend.
 */
data class TeamStatistics(

    /**
     * Team identifier.
     */
    val teamId: Int,

    /**
     * League identifier.
     */
    val leagueId: Int,

    /**
     * Season.
     */
    val season: Int,

    /**
     * Matches played.
     */
    val played: Int,

    /**
     * Matches won.
     */
    val wins: Int,

    /**
     * Matches drawn.
     */
    val draws: Int,

    /**
     * Matches lost.
     */
    val losses: Int,

    /**
     * Goals scored.
     */
    val goalsFor: Int,

    /**
     * Goals conceded.
     */
    val goalsAgainst: Int,

    /**
     * Clean sheets.
     */
    val cleanSheets: Int,

    /**
     * Matches where the team failed to score.
     */
    val failedToScore: Int,

    /**
     * Total yellow cards.
     */
    val yellowCards: Int,

    /**
     * Total red cards.
     */
    val redCards: Int,

    /**
     * Calculated goal difference.
     *
     * Returned directly by the backend.
     */
    val goalDifference: Int,

    /**
     * Calculated decided matches.
     *
     * Returned directly by the backend.
     */
    val decidedMatches: Int
)