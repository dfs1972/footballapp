package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.FixtureDto

class FixtureRepository {

    private val service =
        FootballApiClient.service

    suspend fun getFixtures(
        leagueId: Int,
        season: Int
    ): List<FixtureDto> {

        return service.getFixtures(
            leagueId,
            season
        )

    }

}