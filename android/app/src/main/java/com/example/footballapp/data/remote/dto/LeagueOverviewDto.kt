package com.example.footballapp.data.remote.dto

/**
 * DTO returned by:
 *
 * GET /leagueOverview
 */
data class LeagueOverviewDto(
    val leagueId: Int,
    val leagueName: String,
    val countryName: String,
    val countryFlag: String?,
    val season: Int,
    val featuredLeagues: List<FeaturedLeagueOverviewDto> = emptyList()
)