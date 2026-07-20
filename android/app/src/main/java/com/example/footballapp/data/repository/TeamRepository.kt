package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.ClubUiModel

/**
 * Repository for retrieving club data.
 */
class TeamRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get all clubs for a league season.
     */
    suspend fun getTeams(
        leagueId: Int,
        season: Int
    ): List<ClubUiModel> {

        return service
            .getTeams(
                leagueId,
                season
            )
            .map {
                it.toUiModel()
            }

    }

}