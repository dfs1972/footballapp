package com.example.footballapp.repositories

import com.example.footballapp.model.LeagueRow

class LeagueSelectionRepository {

    fun getLeagues(): List<LeagueRow> {

        return listOf(
            LeagueRow(
                179,
                "Scottish Premiership"
            ),

            LeagueRow(
                39,
                "Premier League"
            ),

            LeagueRow(
                140,
                "La Liga"
            ),

            LeagueRow(
                78,
                "Bundesliga"
            )
        )
    }
}