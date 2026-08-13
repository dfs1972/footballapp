package com.example.footballapp.data.remote.dto

data class FixtureEventDto(

    val elapsed: Int,

    val extra: Int?,

    val teamId: Int,

    val teamName: String,

    val playerId: Int?,

    val playerName: String?,

    val assistId: Int?,

    val assistName: String?,

    val type: String,

    val detail: String,

    val comments: String?

)