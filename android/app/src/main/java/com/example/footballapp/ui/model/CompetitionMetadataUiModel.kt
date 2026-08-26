package com.example.footballapp.ui.model

data class CompetitionMetadataUiModel(
    val currentRound: String?,
    val standings: List<LeagueTableGroupUiModel>
)