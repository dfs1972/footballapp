package com.example.footballapp.ui.model

data class FixtureEventUiModel(
    val elapsed: Int,
    val extra: Int?,
    val teamId: Int,
    val teamName: String,
    val teamLogo: String,
    val playerId: Int?,
    val playerName: String?,
    val assistId: Int?,
    val assistName: String?,
    val type: String,
    val detail: String,
    val comments: String?
)
