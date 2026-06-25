package com.example.footballapp.model

data class TeamDetails(

    val team: Team,

    val venue: Venue? = null,

    val leaguePosition: Int,

    val points: Int,

    val form: String,

    val recentFixtures: List<FixtureRow>
)
