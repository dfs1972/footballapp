package com.example.footballapp.ui.model

data class FixtureUiModel(

    val fixtureId: Long,

    val homeTeamId: Int,
    val homeTeamName: String,
    val homeTeamLogo: String? = null,

    val awayTeamId: Int,
    val awayTeamName: String,
    val awayTeamLogo: String? = null,

    val kickOff: String,

    val status: FixtureStatus,

    val homeScore: Int? = null,
    val awayScore: Int? = null

)