package com.example.footballapp.data.remote.dto

data class LeagueTableGroupDto(
    val group: String,
    val standings: List<LeagueTableRowDto>
)