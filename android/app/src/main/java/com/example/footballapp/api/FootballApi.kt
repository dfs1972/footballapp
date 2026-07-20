package com.example.footballapp.api

import com.example.footballapp.dto.LeagueOverviewDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApi {

    @GET("/leagueOverview")
    suspend fun getLeagueOverview(

        @Query("leagueId")
        leagueId: Int,

        @Query("season")
        season: Int

    ): LeagueOverviewDto

}