package com.example.footballapp.data.remote

import com.example.footballapp.data.remote.dto.CompetitionDto
import retrofit2.Response
import retrofit2.http.GET

interface FootballApiService {

    @GET("leagues")
    suspend fun getLeagues(): Response<List<CompetitionDto>>

}