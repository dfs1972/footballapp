package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.PlayerDetailsDto

class PlayerDetailsRepository {

    private val service =
        FootballApiClient.service

    suspend fun getPlayerDetails(

        playerId: Int,

        leagueId: Int,

        season: Int

    ): PlayerDetailsDto {

        return service.getPlayerDetails(

            playerId,

            leagueId,

            season

        )

    }

}