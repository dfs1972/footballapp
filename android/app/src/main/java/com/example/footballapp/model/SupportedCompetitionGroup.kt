package com.example.footballapp.model

data class SupportedCompetitionGroup(

    val country: String,

    val displayOrder: Int,

    val headerIcon: String,

    val competitions: List<SupportedCompetition>

)