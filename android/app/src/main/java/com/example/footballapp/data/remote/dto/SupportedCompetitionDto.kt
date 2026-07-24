package com.example.footballapp.data.remote.dto

data class SupportedCompetitionDto(

    val competitionId: Int,

    val name: String,

    val type: String,

    val enabled: Boolean,

    val logoUrl: String

)