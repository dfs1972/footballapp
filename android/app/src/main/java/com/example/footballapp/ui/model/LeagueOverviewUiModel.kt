package com.example.footballapp.ui.model

data class LeagueOverviewUiModel(
    val leagueId: Int,
    val leagueName: String,
    val countryName: String,
    val countryFlag: String?,
    val season: String
)