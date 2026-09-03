package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.FixtureLineupDto
import com.example.footballapp.data.remote.dto.MatchDetailDto

class MatchDetailRepository {

    private val service =
        FootballApiClient.service

    suspend fun getMatchDetails(
        fixtureId: Long
    ): MatchDetailDto {

        return service.getMatchDetails(
            fixtureId = fixtureId
        )
    }

    suspend fun getFixtureLineup(
        fixtureId: Long
    ): FixtureLineupDto {
        return service.getFixtureLineup(fixtureId)
    }
}
