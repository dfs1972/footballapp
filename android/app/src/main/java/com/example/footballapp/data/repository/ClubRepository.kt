package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toDetailsUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.ClubDetailsUiModel

/**
 * Repository for retrieving club details.
 */
class ClubRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get details for a single club.
     */
    suspend fun getClub(
        clubId: Int
    ): ClubDetailsUiModel {

        return service
            .getClub(
                clubId
            )
            .toDetailsUiModel()

    }

}