package com.example.footballapp.data.remote.dto

data class PlayerLineupDto(

    val playerId: Int,
    val playerName: String,
    val photo: String?,
    val shirtNumber: Int?,
    val position: String,
    val grid: String?,
    val starting: Boolean,
    val displayOrder: Int
)