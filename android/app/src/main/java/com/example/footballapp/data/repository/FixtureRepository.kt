package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.FixtureDetailsDto
import com.example.footballapp.ui.model.FixtureLineupUiModel
import com.example.footballapp.ui.model.FixtureUiModel

/**
 * Repository for retrieving fixture data.
 */
class FixtureRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get all fixtures for a league season.
     */
    suspend fun getFixtures(
        leagueId: Int,
        season: Int
    ): List<FixtureUiModel> {

        return service
            .getFixtures(
                leagueId,
                season
            )
            .map {
                it.toUiModel()
            }

    }

    /**
     * Get fixtures for a single club.
     */
    suspend fun getTeamFixtures(
        teamId: Int,
        leagueId: Int,
        season: Int
    ): List<FixtureUiModel> {

        return service
            .getTeamFixtures(
                teamId,
                leagueId,
                season
            )
            .map {
                it.toUiModel()
            }

    }

    /**
     * Get fixture details.
     *
     * Left returning DTO for now until the Fixture Details
     * feature is migrated.
     */
    suspend fun getFixtureDetails(
        fixtureId: Long
    ): FixtureDetailsDto {

        return service.getFixtureDetails(
            fixtureId
        )

    }


    /**
     * Get fixture lineups.
     */

    suspend fun getFixtureLineup(
        fixtureId: Long
    ): FixtureLineupUiModel {

        return service
            .getFixtureLineup(
                fixtureId
            )
            .toUiModel()

    }

}