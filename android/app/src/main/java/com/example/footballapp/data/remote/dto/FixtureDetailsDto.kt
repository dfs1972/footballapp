package com.example.footballapp.data.remote.dto

data class FixtureDetailsDto(

    val fixtureId: Long,

    val fixtureDate: String,

    val homeTeamId: Int,
    val homeTeam: String,

    val awayTeamId: Int,
    val awayTeam: String,

    val homeGoals: Int?,
    val awayGoals: Int?,

    val venueName: String?,

    val leagueId: Int,
    val leagueName: String,

    val season: Int,

    val round: String

)