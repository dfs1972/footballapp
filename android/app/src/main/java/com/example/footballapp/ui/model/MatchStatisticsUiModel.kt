package com.example.footballapp.ui.model

data class MatchStatisticsUiModel(
    val type: String,
    val homeValue: String,
    val awayValue: String,
    val homePercentage: Float = 0f,
    val awayPercentage: Float = 0f
)
