package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.TeamDto

class TeamRepository {

    private val service =
        FootballApiClient.service

    suspend fun getTeams(
        leagueId: Int,
        season: Int
    ): List<TeamDto> {

        return service.getTeams(
            leagueId,
            season
        )

    }

}