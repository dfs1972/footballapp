package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.PlayerDto

class SquadRepository {

    private val service =
        FootballApiClient.service

    suspend fun getPlayers(
        teamId: Int,
        leagueId: Int,
        season: Int
    ): List<PlayerDto> {

        return service.getTeamPlayers(
            teamId,
            leagueId,
            season
        )

    }

}