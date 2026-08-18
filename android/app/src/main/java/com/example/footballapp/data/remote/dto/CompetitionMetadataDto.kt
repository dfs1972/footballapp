package com.example.footballapp.data.remote.dto

data class CompetitionMetadataDto(

    val stages: List<CompetitionStageDto>,

    val currentRound: String?,

    val standings: List<LeagueTableGroupDto>

)