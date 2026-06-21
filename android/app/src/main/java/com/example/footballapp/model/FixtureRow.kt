package com.example.footballapp.model

data class FixtureRow(
    val fixtureDate: String,
    val homeTeam: String,
    val awayTeam: String,
    val homeGoals: Int,
    val awayGoals: Int,
    val round: String
)