package com.example.footballapp.repository

import com.example.footballapp.api.RetrofitClient
import com.example.footballapp.ui.model.LeagueOverviewUiModel

class LeagueRepository {

    suspend fun getLeagueOverview(
        leagueId: Int,
        season: Int
    ): LeagueOverviewUiModel {

        val dto = RetrofitClient.api.getLeagueOverview(
            leagueId,
            season
        )

        return LeagueOverviewUiModel(
            leagueId = dto.leagueId,
            leagueName = dto.leagueName,
            season = dto.season.toString(),
            teamCount = dto.teamCount,
            fixtureCount = dto.fixtureCount
        )
    }
}