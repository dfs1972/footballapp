package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.PlayerDetailsUiModel

/**
 * Repository for retrieving player details.
 */
class PlayerDetailsRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get details for a single player.
     */
    suspend fun getPlayerDetails(
        playerId: Int,
        leagueId: Int,
        season: Int
    ): PlayerDetailsUiModel {

        return service
            .getPlayerDetails(
                playerId,
                leagueId,
                season
            )
            .toUiModel()

    }

}