package com.example.footballapp.ui.model

data class FixtureTeamLineupUiModel(

    val teamId: Int,
    val coachId: Int?,
    val coachName: String?,
    val formation: String?,
    val players: List<PlayerLineupUiModel>
)