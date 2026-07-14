package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.ClubDto

class ClubRepository {

    private val service =
        FootballApiClient.service

    suspend fun getClub(
        clubId: Int
    ): ClubDto {

        return service.getClub(
            clubId
        )

    }

}