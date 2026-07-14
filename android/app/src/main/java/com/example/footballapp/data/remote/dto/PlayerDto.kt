package com.example.footballapp.data.remote.dto

data class PlayerDto(

    val playerId: Int,

    val age: Int,

    val nationality: String,

    val displayName: String,

    val photoUrl: String?,

    val position: String,

    val shirtNumber: Int?,

    val captain: Boolean,

    val appearances: Int?,

    val goals: Int?,

    val assists: Int?

)