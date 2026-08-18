package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.CompetitionMetadataDto

class CompetitionMetadataRepository {

    private val service =
        FootballApiClient.service

    suspend fun getCompetitionMetadata(
        leagueId: Int,
        season: Int
    ): CompetitionMetadataDto {

        return service.getCompetitionMetadata(
            leagueId,
            season
        )
    }
}