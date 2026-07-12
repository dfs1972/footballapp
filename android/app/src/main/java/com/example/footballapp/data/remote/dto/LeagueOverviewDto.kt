package com.example.footballapp.data.remote.dto

/**
 * DTO returned by:
 *
 * GET /leagueOverview
 */
data class LeagueOverviewDto(

    val leagueId: Int,

    val leagueName: String,

    val season: Int,

    val teamCount: Int,

    val fixtureCount: Int

)