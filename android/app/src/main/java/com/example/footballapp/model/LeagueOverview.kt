package com.example.footballapp.model

data class LeagueOverview(
    val leagueId: Int,
    val leagueName: String,
    val season: Int,
    val teamCount: Int,
    val fixtureCount: Int
)