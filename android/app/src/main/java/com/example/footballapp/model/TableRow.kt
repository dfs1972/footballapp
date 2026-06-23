package com.example.footballapp.model

data class TableRow(
    val position: Int,
    val teamId: Int,
    val teamName: String,
    val played: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalDifference: Int,
    val points: Int
)