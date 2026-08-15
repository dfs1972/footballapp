package com.example.footballapp.ui.model

data class LeagueTableGroupUiModel(
    val group: String,
    val standings: List<LeagueTableRowUiModel>
)