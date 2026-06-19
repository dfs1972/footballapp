package com.example.footballapp

import com.example.footballapp.model.TeamDetails

class TeamRepository {

    fun getTeamDetails(
        teamName: String
    ): TeamDetails {

        return TeamDetails(
            teamName = teamName,
            position = 1,
            points = 81,
            form = "DWWDW"
        )
    }
}