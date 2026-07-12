package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.LeagueOverviewUiModel

/**
 * Repository responsible for retrieving League Overview
 * data from the FootballApp backend.
 */
class LeagueOverviewRepository {

    suspend fun getLeagueOverview(
        leagueId: Int,
        season: Int
    ): LeagueOverviewUiModel {

        val response =
            FootballApiClient
                .service
                .getLeagueOverview(
                    leagueId,
                    season
                )

        if (!response.isSuccessful) {

            throw Exception(
                "Failed to load League Overview " +
                        "(HTTP ${response.code()})"
            )
        }

        val dto =
            response.body()
                ?: throw Exception(
                    "League Overview response was empty."
                )

        return dto.toUiModel()
    }
}