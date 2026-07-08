package com.example.footballapp.ui.model

/**
 * UI model representing detailed player information.
 *
 * Used by:
 * - PlayerDetailsScreen
 */
data class PlayerDetailsUiModel(

    val playerId: Int,

    val name: String,

    val photoUrl: String?,

    val shirtNumber: Int?,

    val position: String,

    val nationality: String?,

    val dateOfBirth: String?,

    val age: Int?,

    val height: String?,

    val weight: String?,

    val preferredFoot: String?,

    val captain: Boolean,

    val appearances: Int?,

    val goals: Int?,

    val assists: Int?,

    val yellowCards: Int?,

    val redCards: Int?,

    val minutesPlayed: Int?

)