package com.example.footballapp.data.remote.dto

data class FixtureTeamStatisticsDto(
    val team: TeamDto,
    val statistics: List<StatisticDto>
)

data class StatisticDto(
    val type: String,
    val value: Any?
)
