package com.example.footballapp.data.remote.dto

data class FixtureLineupDto(

    val fixtureId: Long,

    val teams: List<FixtureTeamLineupDto>

)