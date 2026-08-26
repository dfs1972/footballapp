package com.example.footballapp.data.remote.dto

data class CompetitionMetadataDto(

    val currentRound: String?,

    val standings: List<LeagueTableGroupDto>

)