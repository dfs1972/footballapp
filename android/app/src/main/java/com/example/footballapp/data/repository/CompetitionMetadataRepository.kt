package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.CompetitionMetadataUiModel

class CompetitionMetadataRepository {

    private val service =
        FootballApiClient.service

    suspend fun getCompetitionMetadata(
        leagueId: Int,
        season: Int
    ): CompetitionMetadataUiModel {

        return service
            .getCompetitionMetadata(
                leagueId,
                season
            )
            .toUiModel()
    }
}