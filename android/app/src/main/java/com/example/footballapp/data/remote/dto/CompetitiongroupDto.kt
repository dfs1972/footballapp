package com.example.footballapp.data.remote.dto

data class CompetitionGroupDto(

    val country: String,

    val headerIcon: String,

    val competitions: List<SupportedCompetitionDto>

)