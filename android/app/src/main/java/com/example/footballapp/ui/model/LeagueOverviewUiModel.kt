package com.example.footballapp.ui.model

data class LeagueOverviewUiModel(
    val leagueId: Int,
    val leagueName: String,
    val season: String,
    val teamCount: Int,
    val fixtureCount: Int
)