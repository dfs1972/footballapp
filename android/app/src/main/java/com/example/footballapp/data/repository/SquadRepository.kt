package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.PlayerUiModel

/**
 * Repository for retrieving squad data.
 */
class SquadRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get all players for a club in a league season.
     */
    suspend fun getPlayers(
        teamId: Int,
        leagueId: Int,
        season: Int
    ): List<PlayerUiModel> {

        return service
            .getTeamPlayers(
                teamId,
                leagueId,
                season
            )
            .map {
                it.toUiModel()
            }

    }

}