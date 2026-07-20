package com.example.footballapp.dto

data class LeagueOverviewDto(

    val leagueId: Int,

    val leagueName: String,

    val season: Int,

    val teamCount: Int,

    val fixtureCount: Int

)