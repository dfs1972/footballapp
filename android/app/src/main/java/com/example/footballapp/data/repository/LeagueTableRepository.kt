package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel

/**
 * Repository for retrieving league standings.
 */
class LeagueTableRepository {

    private val service =
        FootballApiClient.service

    suspend fun getLeagueTable(
        leagueId: Int,
        season: Int
    ): List<LeagueTableRowUiModel> {

        return service
            .getLeagueTable(
                leagueId = leagueId,
                season = season
            )
            .map {
                it.toUiModel()
            }
    }
}
