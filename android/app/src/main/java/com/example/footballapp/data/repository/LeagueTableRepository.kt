package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.ui.model.LeagueTableGroupUiModel

/**
 * Repository for retrieving league standings.
 */
class LeagueTableRepository {

    private val service =
        FootballApiClient.service

    suspend fun getLeagueTable(
        leagueId: Int,
        season: Int
    ): List<LeagueTableGroupUiModel> {

        val response =
            service.getLeagueTable(
                leagueId = leagueId,
                season = season
            )

        response.forEach { group ->

            println(
                "ANDROID GROUP: ${group.group}"
            )

            group.standings.forEach { row ->

                println(
                    "  position=${row.position} " +
                            "team=${row.teamName} " +
                            "points=${row.points}"
                )
            }
        }

        return response.map {
            it.toUiModel()
        }
    }
}