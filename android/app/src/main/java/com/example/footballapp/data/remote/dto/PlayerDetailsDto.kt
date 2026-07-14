package com.example.footballapp.data.remote.dto

data class PlayerDetailsDto(

    val playerId: Int,

    val displayName: String,

    val firstName: String?,

    val lastName: String?,

    val birthDate: String?,

    val age: Int?,

    val height: String?,

    val weight: String?,

    val nationality: String?,

    val photoUrl: String?,

    val position: String,

    val shirtNumber: Int?,

    val captain: Boolean,

    val starts: Int?,

    val appearances: Int?,

    val minutes: Int?,

    val goals: Int?,

    val assists: Int?,

    val yellowCards: Int?,

    val redCards: Int?,

    val rating: String?,

    val teamId: Int,

    val teamName: String,

    val leagueId: Int,

    val leagueName: String,

    val season: Int

)