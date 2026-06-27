package com.example.footballapp.model

data class PlayerDetails(

    val playerId: Int,

    val displayName: String,

    val firstName: String,

    val lastName: String,

    val age: Int?,

    val nationality: String,

    val photoUrl: String,

    val position: String,

    val shirtNumber: Int?,

    val captain: Boolean,

    val appearances: Int?,

    val minutes: Int?,

    val goals: Int?,

    val assists: Int?,

    val yellowCards: Int?,

    val redCards: Int?,

    val rating: Double?,

    val teamId: Int?,

    val teamName: String?,

    val leagueId: Int?,

    val leagueName: String?,

    val season: Int?
)