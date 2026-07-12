package com.example.footballapp.data.remote.dto

data class FixtureDto(

    val fixtureId: Int,

    val fixtureDate: String,

    val fixtureTime: String,

    val homeTeamId: Int,

    val awayTeamId: Int,

    val homeTeam: String,

    val awayTeam: String,

    val homeGoals: Int,

    val awayGoals: Int

)