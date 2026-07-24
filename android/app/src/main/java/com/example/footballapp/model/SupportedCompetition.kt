package com.example.footballapp.model

import retrofit2.http.Url

data class SupportedCompetition(

    val competitionId: Int,

    val name: String,

    val type: CompetitionType,

    val enabled: Boolean,

    val logoUrl: String

)