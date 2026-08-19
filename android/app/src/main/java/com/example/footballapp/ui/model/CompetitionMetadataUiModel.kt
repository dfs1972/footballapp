package com.example.footballapp.ui.model

data class CompetitionMetadataUiModel(
    val stages: List<CompetitionStageUiModel>,
    val currentRound: String?,
    val standings: List<LeagueTableGroupUiModel>
)