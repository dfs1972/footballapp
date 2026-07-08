package com.example.footballapp.ui.model

/**
 * UI model representing a player in a club squad.
 *
 * Used by:
 * - PlayerRow
 * - PlayerList
 * - SquadScreen
 */
data class PlayerUiModel(

    val playerId: Int,

    val shirtNumber: Int?,

    val name: String,

    val position: String

)