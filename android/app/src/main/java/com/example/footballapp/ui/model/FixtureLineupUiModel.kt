package com.example.footballapp.ui.model

data class FixtureLineupUiModel(

    val fixtureId: Long,
    val teams: List<FixtureTeamLineupUiModel>
)