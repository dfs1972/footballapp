package com.example.footballapp.data.remote.dto

/**
 * DTO representing a single row in the league table.
 *
 * Mirrors the Spring Boot LeagueTableRow model.
 */
data class LeagueTableRowDto(

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