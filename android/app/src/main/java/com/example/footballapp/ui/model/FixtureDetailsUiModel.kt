package com.example.footballapp.ui.model

data class FixtureDetailsUiModel(

    val fixtureId: Long,

    val fixtureDate: String,

    val homeTeam: String,
    val awayTeam: String,

    val homeGoals: Int?,
    val awayGoals: Int?,

    val venueName: String?,

    val leagueName: String,

    val season: String,

    val round: String

)