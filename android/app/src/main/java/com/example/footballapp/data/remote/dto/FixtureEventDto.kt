package com.example.footballapp.data.remote.dto

data class FixtureEventDto(
    val time: EventTimeDto,
    val team: EventTeamDto,
    val player: EventPlayerDto?,
    val assist: EventPlayerDto?,
    val type: String,
    val detail: String,
    val comments: String?
)

data class EventTimeDto(
    val elapsed: Int,
    val extra: Int?
)

data class EventTeamDto(
    val id: Int,
    val name: String,
    val logo: String
)

data class EventPlayerDto(
    val id: Int?,
    val name: String?
)
