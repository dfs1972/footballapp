package com.example.footballapp.ui.model

data class PlayerLineupUiModel(

    val playerId: Int,
    val playerName: String,
    val photo: String?,
    val shirtNumber: Int?,
    val position: String,
    val grid: String?,
    val starting: Boolean,
    val displayOrder: Int
)