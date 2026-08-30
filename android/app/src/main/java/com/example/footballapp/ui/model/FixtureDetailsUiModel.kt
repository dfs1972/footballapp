package com.example.footballapp.ui.model

data class FixtureDetailsUiModel(

    val fixtureId: Long,

    val fixtureDate: String,

    val homeTeam: String,
    val homeTeamLogo: String?,

    val awayTeam: String,
    val awayTeamLogo: String?,

    val homeGoals: Int?,
    val awayGoals: Int?,

    val venueName: String?,

    val leagueName: String,

    val season: String,

    val round: String,

    val statusLong: String? = null,

    val statusShort: String? = null,

    val elapsed: Int? = null

)