package com.example.footballapp.data.remote.dto

data class FixtureTeamLineupDto(

    val teamId: Int,

    val coachId: Int?,

    val coachName: String?,

    val formation: String?,

    val players: List<PlayerLineupDto>

)