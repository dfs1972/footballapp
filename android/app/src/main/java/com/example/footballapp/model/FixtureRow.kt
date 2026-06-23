package com.example.footballapp.model

data class FixtureRow(
    val fixtureId: Long,
    val fixtureDate: String,
    val fixtureTime: String?,
    val homeTeamId: Int,
    val awayTeamId: Int,
    val homeTeam: String,
    val awayTeam: String,
    val homeGoals: Int,
    val awayGoals: Int,
    //val round: String
)