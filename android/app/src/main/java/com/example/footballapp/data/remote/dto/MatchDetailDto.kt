package com.example.footballapp.data.remote.dto

data class MatchDetailDto(
    val fixture: FixtureDetailsDto,
    val lineup: FixtureLineupDto?,
    val events: List<FixtureEventDto>?
)
