package com.example.footballapp.data.remote

import com.example.footballapp.data.remote.dto.ClubDto
import com.example.footballapp.data.remote.dto.CompetitionDto
import com.example.footballapp.data.remote.dto.FixtureDetailsDto
import com.example.footballapp.data.remote.dto.FixtureDto
import com.example.footballapp.data.remote.dto.FixtureLineupDto
import com.example.footballapp.data.remote.dto.LeagueOverviewDto
import com.example.footballapp.data.remote.dto.LeagueTableRowDto
import com.example.footballapp.data.remote.dto.PlayerDetailsDto
import com.example.footballapp.data.remote.dto.PlayerDto
import com.example.footballapp.data.remote.dto.TeamDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApiService {

    /**
     * Get Leagues
     */
    @GET("leagues")
    suspend fun getLeagues(): Response<List<CompetitionDto>>

    /**
     * Get LeagueOverview
     */
    @GET("leagueOverview")
    suspend fun getLeagueOverview(

        @Query("leagueId")
        leagueId: Int,

        @Query("season")
        season: Int

    ): Response<LeagueOverviewDto>

    /**
     * Get LeagueTable
     */
    @GET("leagueTable")
    suspend fun getLeagueTable(
        @Query("leagueId") leagueId: Int,
        @Query("season") season: Int
    ): List<LeagueTableRowDto>

    /**
     * Get Fixtures
     */
    @GET("fixtures")
    suspend fun getFixtures(
        @Query("leagueId") leagueId: Int,
        @Query("season") season: Int
    ): List<FixtureDto>

    /**
     * Get Team Fixtures
     */
    @GET("teamFixtures")
    suspend fun getTeamFixtures(

        @Query("teamId")
        teamId: Int,

        @Query("leagueId")
        leagueId: Int,

        @Query("season")
        season: Int

    ): List<FixtureDto>

    /**
     * Get Fixture Lineups
     */

    @GET("fixtureLineup")
    suspend fun getFixtureLineup(
        @Query("fixtureId")
        fixtureId: Long
    ): FixtureLineupDto

    /**
     * Get League Teams
     */
    @GET("teams")
    suspend fun getTeams(
        @Query("leagueId") leagueId: Int,
        @Query("season") season: Int
    ): List<TeamDto>

    /**
     * Get Club
     */
    @GET("club")
    suspend fun getClub(

        @Query("clubId")
        clubId: Int

    ): ClubDto

    /**
     * Get Team Players
     */
    @GET("teamPlayers")
    suspend fun getTeamPlayers(

        @Query("teamId")
        teamId: Int,

        @Query("leagueId")
        leagueId: Int,

        @Query("season")
        season: Int

    ): List<PlayerDto>

    /**
     * Get Player Details
     */
    @GET("playerDetails")
    suspend fun getPlayerDetails(

        @Query("playerId")
        playerId: Int,

        @Query("leagueId")
        leagueId: Int,

        @Query("season")
        season: Int

    ): PlayerDetailsDto

    /**
     * Get Fixture Details
     */
    @GET("fixtureDetails")
    suspend fun getFixtureDetails(

        @Query("fixtureId")
        fixtureId: Long

    ): FixtureDetailsDto

}