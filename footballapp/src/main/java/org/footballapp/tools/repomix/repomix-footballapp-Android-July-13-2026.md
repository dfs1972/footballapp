This file is a merged representation of a subset of the codebase, containing specifically included files, combined into a single document by Repomix.
The content has been processed where security check has been disabled.

# File Summary

## Purpose
This file contains a packed representation of a subset of the repository's contents that is considered the most important context.
It is designed to be easily consumable by AI systems for analysis, code review,
or other automated processes.

## File Format
The content is organized as follows:
1. This summary section
2. Repository information
3. Directory structure
4. Repository files (if enabled)
5. Multiple file entries, each consisting of:
  a. A header with the file path (## File: path/to/file)
  b. The full contents of the file in a code block

## Usage Guidelines
- This file should be treated as read-only. Any changes should be made to the
  original repository files, not this packed version.
- When processing this file, use the file path to distinguish
  between different files in the repository.
- Be aware that this file may contain sensitive information. Handle it with
  the same level of security as you would the original repository.

## Notes
- Some files may have been excluded based on .gitignore rules and Repomix's configuration
- Binary files are not included in this packed representation. Please refer to the Repository Structure section for a complete list of file paths, including binary files
- Only files matching these patterns are included: android/app/src/main/java/com/example/footballapp/**/*.kt
- Files matching patterns in .gitignore are excluded
- Files matching default ignore patterns are excluded
- Security check has been disabled - content may contain sensitive information
- Files are sorted by Git change count (files with more changes are at the bottom)

# Directory Structure
```
android/
  app/
    src/
      main/
        java/
          com/
            example/
              footballapp/
                data/
                  mapper/
                    CompetitionGrouping.kt
                    CompetitionMapper.kt
                    FixtureMapper.kt
                    LeagueOverviewMapper.kt
                    LeagueTableMapper.kt
                    TeamMapper.kt
                  remote/
                    dto/
                      CompetitionDto.kt
                      FixtureDto.kt
                      LeagueOverviewDto.kt
                      LeagueTableRowDto.kt
                      TeamDto.kt
                    FootballApiClient.kt
                    FootballApiService.kt
                  repository/
                    CompetitionRepository.kt
                    FixtureRepository.kt
                    LeagueOverviewRepository.kt
                    LeagueTableRepository.kt
                    TeamRepository.kt
                model/
                  FixtureRow.kt
                  LeagueOverview.kt
                  LeagueRow.kt
                  LeagueUk.kt
                  PlayerDetails.kt
                  PlayerSummary.kt
                  TableRow.kt
                  Team.kt
                  TeamDetails.kt
                  TeamFixtureRow.kt
                  TeamRow.kt
                  TeamStatistics.kt
                navigation/
                  FootballNavGraph.kt
                  Screen.kt
                repositories/
                  FixtureDetailsApiRepository.kt
                  FixtureRepository.kt
                  FixturesApiRepository.kt
                  LeagueApiRepository.kt
                  LeagueRepository.kt
                  TeamDetailsApiRepository.kt
                  TeamFixturesRepository.kt
                  TeamRepository.kt
                  TeamsApiRepository.kt
                  TeamsRepository.kt
                screens/
                  ClubFixturesScreen.kt
                  ClubScreen.kt
                  ClubsScreen.kt
                  FixtureDetailsScreen.kt
                  FixturesScreen.kt
                  LeagueSelectionScreen.kt
                  LeagueTableScreen.kt
                  PlayerDetailsScreen.kt
                  SquadScreen.kt
                ui/
                  components/
                    ClubBadge.kt
                    ClubList.kt
                    ClubRow.kt
                    CompetitionList.kt
                    CompetitionRow.kt
                    FixtureCard.kt
                    InfoRow.kt
                    LeagueTableCard.kt
                    LeagueTableHeader.kt
                    LeagueTableRow.kt
                    NavigationCard.kt
                    PlayerList.kt
                    PlayerPhoto.kt
                    PlayerRow.kt
                    ScreenHeader.kt
                    ScreenScaffold.kt
                    SectionCard.kt
                    SectionHeading.kt
                    StatusChip.kt
                    TableDivider.kt
                    TopStandingsCard.kt
                  design/
                    Animation.kt
                    AppConstants.kt
                    AppSpacing.kt
                    Dimensions.kt
                    Icons.kt
                    Strings.kt
                  model/
                    ClubDetailsUiModel.kt
                    ClubUiModel.kt
                    CompetitionGroupUIModel.kt
                    CompetitionType.kt
                    CompetitionUiModel.kt
                    FixtureDayUiModel.kt
                    FixtureStatus.kt
                    FixtureUiModel.kt
                    LeagueOverviewUiModel.kt
                    LeagueTableRowUiModel.kt
                    PlayerDetailsUiModel.kt
                    PlayerUiModel.kt
                    QualificationType.kt
                    StandingUiModel.kt
                  navigation/
                    DemoData.kt
                    FootballDestination.kt
                    FootballNavhost.kt
                  previews/
                    PreviewData.kt
                  screens/
                    club/
                      ClubScreen.kt
                    clubs/
                      ClubsScreen.kt
                    competitions/
                      CompetitionsScreen.kt
                    fixtures/
                      FixturesScreen.kt
                    league/
                      LeagueOverviewScreen.kt
                      LeagueTableScreen.kt
                    player/
                      PlayerDetailsSceen.kt
                    squad/
                      SquadScreen.kt
                  theme/
                    AppDimensions.kt
                    AppElevation.kt
                    AppShapes.kt
                    AppTypography.kt
                    Color.kt
                    Theme.kt
                    Type.kt
                  viewmodel/
                    ClubsUiState.kt
                    ClubsViewModel.kt
                    CompetitionUiState.kt
                    CompetitionViewModel.kt
                    FixturesUiState.kt
                    FixturesViewModel.kt
                    LeagueOverviewUiState.kt
                    LeagueOverviewViewModel.kt
                    LeagueTableUiState.kt
                    LeagueTableViewModel.kt
                ApiConfig.kt
                AppState.kt
                MainActivity.kt
```

# Files

## File: android/app/src/main/java/com/example/footballapp/data/mapper/CompetitionGrouping.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

/**
 * Groups competitions into the sections displayed by the
 * Competitions screen.
 *
 * The backend returns a flat list of competitions.
 * This mapper organises them into UI groups.
 */
fun List<CompetitionUiModel>.toCompetitionGroups(): List<CompetitionGroupUiModel> {

    // -------------------------------------------------------------------------
    // Scotland
    // -------------------------------------------------------------------------

    val scotland = filter {

        it.name.contains("Scottish", ignoreCase = true) ||
                it.name == "League Cup"

    }

    val scottishLeagues = scotland.filter {

        "Championship" in it.name ||
                "League One" in it.name ||
                "League Two" in it.name ||
                "Premiership" in it.name

    }

    val scottishCups = scotland.filter {

        it.name == "Scottish Cup" ||
                it.name == "League Cup"

    }

    val groups = mutableListOf<CompetitionGroupUiModel>()

    if (scotland.isNotEmpty()) {

        groups.add(

            CompetitionGroupUiModel(

                title = "Scotland",

                headerIcon = "\uD83C\uDFF4",

                leagues = scottishLeagues,

                domesticCups = scottishCups,

                displayOrder = 1

            )

        )

    }

    return groups.sortedBy {

        it.displayOrder

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/CompetitionMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.CompetitionDto
import com.example.footballapp.ui.model.CompetitionUiModel

fun CompetitionDto.toUiModel() =
    CompetitionUiModel(
        id = leagueId,
        name = name,
        logoUrl = logoUrl
    )
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/FixtureMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureDto
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel

fun FixtureDto.toUiModel() =
    FixtureUiModel(

        fixtureId = fixtureId.toLong(),

        fixtureDate = fixtureDate,

        homeTeamId = homeTeamId,
        homeTeamName = homeTeam,
        homeTeamLogo = null,

        awayTeamId = awayTeamId,
        awayTeamName = awayTeam,
        awayTeamLogo = null,

        kickOff = fixtureTime,

        status = FixtureStatus.SCHEDULED,

        homeScore = homeGoals,
        awayScore = awayGoals

    )
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/LeagueOverviewMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.LeagueOverviewDto
import com.example.footballapp.ui.model.LeagueOverviewUiModel

/**
 * Maps a LeagueOverviewDto received from the backend
 * into a LeagueOverviewUiModel used by the Compose UI.
 */
fun LeagueOverviewDto.toUiModel(): LeagueOverviewUiModel {

    return LeagueOverviewUiModel(

        leagueId = leagueId,

        leagueName = leagueName,

        season = season.toString(),

        teamCount = teamCount,

        fixtureCount = fixtureCount

    )

}
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/LeagueTableMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.LeagueTableRowDto
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType

/**
 * Maps a LeagueTableRowDto to the UI model.
 */
fun LeagueTableRowDto.toUiModel(): LeagueTableRowUiModel {

    return LeagueTableRowUiModel(

        position = position,

        teamId = teamId,

        teamName = teamName,

        teamLogo = null,

        played = played,

        wins = wins,

        draws = draws,

        losses = losses,

        goalDifference = goalDifference,

        points = points,

        qualification = position.toQualification(),

        form = null

    )

}

/**
 * Converts a league position into the qualification band
 * displayed by the UI.
 *
 * Current implementation is for the Scottish Premiership.
 * This can be expanded later to support league-specific
 * qualification rules.
 */
private fun Int.toQualification(): QualificationType =
    when (this) {

        1 -> QualificationType.CHAMPION

        12 -> QualificationType.RELEGATION

        else -> QualificationType.SAFE

    }
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/TeamMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.TeamDto
import com.example.footballapp.ui.model.ClubUiModel

fun TeamDto.toUiModel() =
    ClubUiModel(

        clubId = id,

        name = name,

        shortName = null,

        badgeUrl = null,

        stadium = null

    )
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/CompetitionDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class CompetitionDto(

    val leagueId: Int,

    val name: String,

    val country: String,

    val logoUrl: String,

    val  season: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class FixtureDto(

    val fixtureId: Int,

    val fixtureDate: String,

    val fixtureTime: String,

    val homeTeamId: Int,

    val awayTeamId: Int,

    val homeTeam: String,

    val awayTeam: String,

    val homeGoals: Int,

    val awayGoals: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/LeagueOverviewDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

/**
 * DTO returned by:
 *
 * GET /leagueOverview
 */
data class LeagueOverviewDto(

    val leagueId: Int,

    val leagueName: String,

    val season: Int,

    val teamCount: Int,

    val fixtureCount: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/LeagueTableRowDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

/**
 * DTO representing a single row in the league table.
 *
 * Mirrors the Spring Boot LeagueTableRow model.
 */
data class LeagueTableRowDto(

    val position: Int,

    val teamId: Int,

    val teamName: String,

    val played: Int,

    val wins: Int,

    val draws: Int,

    val losses: Int,

    val goalDifference: Int,

    val points: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/TeamDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class TeamDto(

    val id: Int,

    val name: String,

    val country: String,

    val founded: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/FootballApiClient.kt
```kotlin
package com.example.footballapp.data.remote

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object FootballApiClient {

    private const val BASE_URL =
        "http://10.0.2.2:8081/"

    private val logging =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client =
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    private val mapper =
        jacksonObjectMapper()
            .configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
            )

    val service: FootballApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(
                JacksonConverterFactory.create(mapper)
            )
            .build()
            .create(FootballApiService::class.java)

}
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/FootballApiService.kt
```kotlin
package com.example.footballapp.data.remote

import com.example.footballapp.data.remote.dto.CompetitionDto
import com.example.footballapp.data.remote.dto.FixtureDto
import com.example.footballapp.data.remote.dto.LeagueOverviewDto
import com.example.footballapp.data.remote.dto.LeagueTableRowDto
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
     * Get League Teams
     */
    @GET("teams")
    suspend fun getTeams(
        @Query("leagueId") leagueId: Int,
        @Query("season") season: Int
    ): List<TeamDto>

}
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/CompetitionRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.CompetitionDto

class CompetitionRepository {

    suspend fun getCompetitions(): List<CompetitionDto> {

        val response =
            FootballApiClient.service.getLeagues()

        if (response.isSuccessful) {

            return response.body() ?: emptyList()

        }

        throw Exception(
            "Failed to load competitions: ${response.code()}"
        )
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/FixtureRepository.kt
```kotlin
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
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/LeagueOverviewRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.LeagueOverviewUiModel

/**
 * Repository responsible for retrieving League Overview
 * data from the FootballApp backend.
 */
class LeagueOverviewRepository {

    suspend fun getLeagueOverview(
        leagueId: Int,
        season: Int
    ): LeagueOverviewUiModel {

        val response =
            FootballApiClient
                .service
                .getLeagueOverview(
                    leagueId,
                    season
                )

        if (!response.isSuccessful) {

            throw Exception(
                "Failed to load League Overview " +
                        "(HTTP ${response.code()})"
            )
        }

        val dto =
            response.body()
                ?: throw Exception(
                    "League Overview response was empty."
                )

        return dto.toUiModel()
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/LeagueTableRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.LeagueTableRowDto

/**
 * Repository for retrieving league standings.
 */
class LeagueTableRepository {

    private val service =
        FootballApiClient.service

    suspend fun getLeagueTable(
        leagueId: Int,
        season: Int
    ): List<LeagueTableRowDto> {

        return service.getLeagueTable(
            leagueId = leagueId,
            season = season
        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/TeamRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.TeamDto

class TeamRepository {

    private val service =
        FootballApiClient.service

    suspend fun getTeams(
        leagueId: Int,
        season: Int
    ): List<TeamDto> {

        return service.getTeams(
            leagueId,
            season
        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/model/FixtureRow.kt
```kotlin
package com.example.footballapp.model

data class FixtureRow(
    val fixtureId: Long,
    val fixtureDate: String,
    val fixtureTime: String?,
    val homeTeamId: Int,
    val awayTeamId: Int,
    val homeTeam: String,
    val awayTeam: String,
    val homeGoals: Int,
    val awayGoals: Int,
    //val round: String
)
```

## File: android/app/src/main/java/com/example/footballapp/model/LeagueOverview.kt
```kotlin
package com.example.footballapp.model

data class LeagueOverview(
    val leagueId: Int,
    val leagueName: String,
    val season: Int,
    val teamCount: Int,
    val fixtureCount: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/model/LeagueRow.kt
```kotlin
package com.example.footballapp.model

data class LeagueRow(
    val leagueId: Int,
    val leagueName: String
)
```

## File: android/app/src/main/java/com/example/footballapp/model/LeagueUk.kt
```kotlin
package com.example.footballapp.model

data class LeagueUk(
    val leagueId: Int,
    val name: String,
    val country: String,
    val logoUrl: String?
)
```

## File: android/app/src/main/java/com/example/footballapp/model/PlayerDetails.kt
```kotlin
package com.example.footballapp.model

data class PlayerDetails(

    val playerId: Int,

    val displayName: String,

    val firstName: String,

    val lastName: String,

    val age: Int?,

    val nationality: String,

    val photoUrl: String,

    val position: String,

    val shirtNumber: Int?,

    val captain: Boolean,

    val appearances: Int?,

    val minutes: Int?,

    val goals: Int?,

    val assists: Int?,

    val yellowCards: Int?,

    val redCards: Int?,

    val rating: Double?,

    val teamId: Int?,

    val teamName: String?,

    val leagueId: Int?,

    val leagueName: String?,

    val season: Int?
)
```

## File: android/app/src/main/java/com/example/footballapp/model/PlayerSummary.kt
```kotlin
package com.example.footballapp.model

data class PlayerSummary(

    val playerId: Int,

    val age: Int?,

    val nationality: String,

    val displayName: String,

    val photoUrl: String,

    val position: String,

    val shirtNumber: Int?,

    val captain: Boolean,

    val appearances: Int?,

    val goals: Int?,

    val assists: Int?
)
```

## File: android/app/src/main/java/com/example/footballapp/model/TableRow.kt
```kotlin
package com.example.footballapp.model

data class TableRow(
    val position: Int,
    val teamId: Int,
    val teamName: String,
    val played: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalDifference: Int,
    val points: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/model/Team.kt
```kotlin
package com.example.footballapp.model

data class Team(
    val id: Int,
    val name: String,
    val country: String,
    val founded: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/model/TeamDetails.kt
```kotlin
package com.example.footballapp.model

data class TeamDetails(

    val team: Team,

    val venue: Venue? = null,

    val leaguePosition: Int,

    val points: Int,

    val form: String,

    val recentFixtures: List<FixtureRow>
)
```

## File: android/app/src/main/java/com/example/footballapp/model/TeamFixtureRow.kt
```kotlin
package com.example.footballapp.model

data class TeamFixtureRow(
    val homeTeam: String,
    val awayTeam: String,
    val homeGoals: Int,
    val awayGoals: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/model/TeamRow.kt
```kotlin
package com.example.footballapp.model

data class TeamRow(
    val id: Int,
    val name: String,
    val country: String,
    val founded: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/model/TeamStatistics.kt
```kotlin
package org.footballapp.model

/**
 * Team statistics returned by the FootballApp backend.
 */
data class TeamStatistics(

    /**
     * Team identifier.
     */
    val teamId: Int,

    /**
     * League identifier.
     */
    val leagueId: Int,

    /**
     * Season.
     */
    val season: Int,

    /**
     * Matches played.
     */
    val played: Int,

    /**
     * Matches won.
     */
    val wins: Int,

    /**
     * Matches drawn.
     */
    val draws: Int,

    /**
     * Matches lost.
     */
    val losses: Int,

    /**
     * Goals scored.
     */
    val goalsFor: Int,

    /**
     * Goals conceded.
     */
    val goalsAgainst: Int,

    /**
     * Clean sheets.
     */
    val cleanSheets: Int,

    /**
     * Matches where the team failed to score.
     */
    val failedToScore: Int,

    /**
     * Total yellow cards.
     */
    val yellowCards: Int,

    /**
     * Total red cards.
     */
    val redCards: Int,

    /**
     * Calculated goal difference.
     *
     * Returned directly by the backend.
     */
    val goalDifference: Int,

    /**
     * Calculated decided matches.
     *
     * Returned directly by the backend.
     */
    val decidedMatches: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/navigation/FootballNavGraph.kt
```kotlin
//package com.example.footballapp.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.footballapp.AppState
//
//import com.example.footballapp.screens.FixturesScreen
//import com.example.footballapp.screens.LeagueSelectionScreen
//import com.example.footballapp.MainScreen
//import com.example.footballapp.screens.FixtureDetailsScreen
//import com.example.footballapp.screens.TeamFixturesScreen
//import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
//import com.example.footballapp.screens.LeagueTableScreen
//import com.example.footballapp.screens.TeamScreen
//import com.example.footballapp.screens.TeamsScreen
//import com.example.footballapp.screens.SquadScreen
//import com.example.footballapp.screens.PlayerDetailsScreen
//
//@Composable
//fun FootballNavGraph() {
//
//    val navController =
//        rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Home.route
//    ) {
//
//        /** MainScreen */
//        composable(
//            Screen.Home.route
//        ) {
//
//            MainScreen(
//
//                onLeagueSelectionClick = {
//                    navController.navigate(
//                        Screen.LeagueSelection.route
//                    )
//                },
//
//                onLeagueTableClick = {
//                    navController.navigate(
//                        Screen.LeagueTable.route
//                    )
//                },
//
//                onFixturesClick = {
//                    navController.navigate(
//                        Screen.Fixtures.route
//                    )
//                },
//                onTeamsClick = {
//                    navController.navigate(
//                        Screen.Teams.route
//                    )
//                }
//            )
//        } // End of MainScreen
//
//        /** LeagueSelectionScreen */
//        composable(
//            Screen.LeagueSelection.route
//        ) {
//
//            LeagueSelectionScreen(
//                onLeagueClick = {
//                        leagueId,
//                        leagueName ->
//
//                    AppState.selectedLeagueId =
//                        leagueId
//
//                    AppState.selectedLeagueName =
//                        leagueName
//
//                    navController.navigate(
//                        Screen.LeagueOverview.route
//                    )
//                }
//            )
//        }
//
//            /** LeagueTableScreen */
//            composable(
//                Screen.LeagueTable.route
//            ) {
//
//                LeagueTableScreen(
//                    onTeamClick = { teamId ->
//
//                        navController.navigate(
//                            "team/$teamId"
//                        )
//                    }
//                )
//            }
//
//            /** TeamScreen */
//            composable(
//                Screen.Team.route
//            ) { backStackEntry ->
//
//                val teamId =
//                    backStackEntry.arguments
//                        ?.getString("teamId")
//                        ?.toIntOrNull()
//                        ?: 0
//
//                TeamScreen(
//                    teamId = teamId,
//
//                    onFixturesClick = { teamName ->
//
//                        navController.navigate(
//                            Screen.TeamFixtures.createRoute(teamName)
//                        )
//                    },
//                    onSquadClick = {
//
//                        navController.navigate(
//
//                            Screen.Squad.createRoute(it)
//
//                        )
//                    }
//                )
//            }
//
//            /**
//             * Squad Screen
//             */
//            composable(
//                Screen.Squad.route
//            ) { backStackEntry ->
//
//                val teamId =
//                    backStackEntry.arguments
//                        ?.getString("teamId")
//                        ?.toIntOrNull()
//                        ?: 0
//
//                SquadScreen(
//
//                    teamId = teamId,
//
//                    onPlayerClick = { playerId ->
//
//                        navController.navigate(
//
//                            Screen.PlayerDetails.createRoute(
//                                playerId
//                            )
//                        )
//                    }
//                )
//            }
//
//            /**
//            * PlayerDetailsScreen
//            */
//            /** PlayerDetailsScreen */
//            composable(
//                Screen.PlayerDetails.route
//            ) { backStackEntry ->
//
//                val playerId =
//                    backStackEntry.arguments
//                        ?.getString("playerId")
//                        ?.toIntOrNull()
//                        ?: 0
//
//                PlayerDetailsScreen(
//                    playerId = playerId
//                )
//            }
//
//            /** FixturesScreen */
//            composable(
//                Screen.Fixtures.route
//            ) {
//
//                FixturesScreen(
//
//                    onFixtureClick = { fixture ->
//
//                        navController.navigate(
//                            Screen.FixtureDetails.createRoute(
//                                fixture.fixtureId
//                            )
//                        )
//                    }
//                )
//            }
//
//            /** FixtureDetailsScreen */
//            composable(
//                Screen.FixtureDetails.route
//            ) { backStackEntry ->
//
//                val fixtureId =
//                    backStackEntry.arguments
//                        ?.getString("fixtureId")
//                        ?.toLongOrNull()
//                        ?: 0L
//
//                FixtureDetailsScreen(
//                    fixtureId = fixtureId
//                )
//            }
//
//            /** TeamsScreen */
//            composable(
//                Screen.Teams.route)
//            {
//                TeamsScreen(
//                    onTeamClick = { teamId ->
//                        println(
//                            "NavGraph received teamId = $teamId"
//                        )
//                        navController.navigate(
//                        "team/$teamId"
//                    )
//                }
//            )
//        }
//
//            /** TeamFixturesScreen */
//            composable(
//                Screen.TeamFixtures.route
//            ) { backStackEntry ->
//
//                val teamName =
//                    backStackEntry.arguments
//                        ?.getString("teamName")
//                        ?: ""
//
//                TeamFixturesScreen(
//                    teamName = teamName
//                )
//            }
//
//            /** LeagueOverviewScreen */
//            composable(
//                Screen.LeagueOverview.route
//            ) {
//
//                LeagueOverviewScreen(
//
//                    competition = AppState.selectedCompetition,
//
//                    onLeagueTableClick = {
//                        navController.navigate(
//                            Screen.LeagueTable.route
//                        )
//                    },
//
//                    onClubsClick = {
//                        navController.navigate(
//                            Screen.Teams.route
//                        )
//                    },
//
//                    onFixturesClick = {
//                        navController.navigate(
//                            Screen.Fixtures.route
//                        )
//                    },
//
//                    onClubClick = { teamId ->
//
//                        navController.navigate(
//                            Screen.Team.createRoute(teamId)
//                        )
//
//                    }
//
//                )
//            }
//
//    } // End of NavHost
//
//} // End of FootballNavGraph
```

## File: android/app/src/main/java/com/example/footballapp/navigation/Screen.kt
```kotlin
package com.example.footballapp.navigation

sealed class Screen(
    val route: String
) {

    object Home :
        Screen("home")

    object LeagueSelection :
        Screen("league_selection")

    object LeagueTable :
        Screen("league_table")

    object Team :
        Screen("team/{teamId}") {

        fun createRoute(
            teamId: Int
        ): String {

            return "team/$teamId"
        }
    }

    object Fixtures :
        Screen("fixtures")

    object Teams :
        Screen("teams")

    object TeamFixtures :
        Screen("team_fixtures/{teamName}") {

        fun createRoute(
            teamName: String
        ): String {

            return "team_fixtures/$teamName"
        }
    }

    object LeagueOverview :
        Screen("league_overview")

    object FixtureDetails :
        Screen("fixture_details/{fixtureId}") {

        fun createRoute(
            fixtureId: Long
        ): String {

            return "fixture_details/$fixtureId"
        }
    }

    object Squad :
        Screen(
            "squad/{teamId}"
        ) {

        fun createRoute(
            teamId: Int
        ) =
            "squad/$teamId"
    }

    object PlayerDetails :
        Screen("player/{playerId}") {

        fun createRoute(
            playerId: Int
        ) = "player/$playerId"
    }


}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/FixtureDetailsApiRepository.kt
```kotlin
package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.model.FixtureRow
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class FixtureDetailsApiRepository {

    fun getFixture(
        fixtureId: Long
    ): FixtureRow {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/fixture" +
                            "?fixtureId=$fixtureId"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "{}"

        val mapper =
            jacksonObjectMapper()

        System.out.println(json)
        return mapper.readValue(json)
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/FixtureRepository.kt
```kotlin
//package com.example.footballapp.repositories
//
//import com.example.footballapp.model.FixtureRow
//
//class FixtureRepository {
//
//    fun getFixtures(): List<FixtureRow> {
//
//        return listOf(
//
//            FixtureRow(
//                "Celtic",
//                "Aberdeen",
//                4,
//                0
//            ),
//
//            FixtureRow(
//                "Rangers",
//                "Hearts",
//                1,
//                1
//            ),
//
//            FixtureRow(
//                "Hibernian",
//                "Dundee United",
//                2,
//                1
//            ),
//
//            FixtureRow(
//                "Motherwell",
//                "Kilmarnock",
//                0,
//                0
//            )
//        )
//    }
//}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/FixturesApiRepository.kt
```kotlin
package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.model.FixtureRow
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class FixturesApiRepository {

    fun getFixtures(
        leagueId: Int,
        season: Int
    ): List<FixtureRow> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/fixtures" +
                            "?leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "[]"

        val mapper =
            jacksonObjectMapper()
        System.out.println(json)

        return mapper.readValue(json)
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/LeagueApiRepository.kt
```kotlin
package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.model.LeagueUk
import com.example.footballapp.model.TableRow
import com.example.footballapp.model.LeagueOverview
import com.example.footballapp.model.PlayerSummary
import com.example.footballapp.model.PlayerDetails
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class LeagueApiRepository {

    fun getTeamPlayers(
        teamId: Int,
        leagueId: Int,
        season: Int
    ): List<PlayerSummary> {

        val client = OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/teamPlayers" +
                            "?teamId=$teamId" +
                            "&leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "[]"

        return jacksonObjectMapper()
            .readValue(json)
    }

    fun getPlayerDetails(
        playerId: Int,
        leagueId: Int,
        season: Int
    ): PlayerDetails {

        val client = OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/playerDetails" +
                            "?playerId=$playerId" +
                            "&leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: throw RuntimeException(
                    "Empty response from server."
                )

        return jacksonObjectMapper()
            .readValue(json)
    }

    fun getLeagueTable(leagueId: Int, season: Int): List<TableRow> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/leagueTable" +
                            "?leagueId=$leagueId" +
                            "&season=$season"                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "[]"

        val mapper =
            jacksonObjectMapper()

        return mapper.readValue(json)
    }

    fun getLeagues(): List<LeagueUk> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/leagues"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "[]"

        val mapper =
            jacksonObjectMapper()

        return mapper.readValue(json)
    } // End of getLeagues()

    fun getLeagueOverview(
        leagueId: Int,
        season: Int
    ): LeagueOverview {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/leagueOverview" +
                            "?leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "{}"

        val mapper =
            jacksonObjectMapper()

        return mapper.readValue(json)
    } // End of getLeagueOverview()
}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/LeagueRepository.kt
```kotlin
package com.example.footballapp.repositories

import com.example.footballapp.repositories.LeagueApiRepository

class LeagueRepository {

    fun getLeagueTable() {
        LeagueApiRepository()
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/TeamDetailsApiRepository.kt
```kotlin
package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.AppState
import com.example.footballapp.model.TeamDetails
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class TeamDetailsApiRepository {

    fun getTeamDetails(
        teamId: Int
    ): TeamDetails {


        val client =
            OkHttpClient()

//        val request =
//            Request.Builder()
//                .url(
//                    "${ApiConfig.BASE_URL}/teamDetails" +
//                            "?leagueId=${AppState.selectedLeagueId}" +
//                            "&season=${AppState.selectedSeason}" +
//                            "&teamId=$teamId"
//                )
//                .build()
        val url =
            "${ApiConfig.BASE_URL}/teamDetails" +
                    "?leagueId=${AppState.selectedLeagueId}" +
                    "&season=${AppState.selectedSeason}" +
                    "&teamId=$teamId"

        val request =
            Request.Builder()
                .url(url)
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "{}"

        val mapper =
            jacksonObjectMapper()

        return mapper.readValue(json)
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/TeamFixturesRepository.kt
```kotlin
package com.example.footballapp.repositories

import com.example.footballapp.model.TeamFixtureRow

class TeamFixturesRepository {

    fun getFixtures(
        teamName: String
    ): List<TeamFixtureRow> {

        return listOf(

            TeamFixtureRow(
                "Celtic",
                "Aberdeen",
                4,
                0
            ),

            TeamFixtureRow(
                "Rangers",
                "Celtic",
                1,
                1
            ),

            TeamFixtureRow(
                "Celtic",
                "Hibernian",
                3,
                1
            ),

            TeamFixtureRow(
                "Hearts",
                "Celtic",
                0,
                2
            )
        )
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/TeamRepository.kt
```kotlin
//package com.example.footballapp.repositories
//
//import com.example.footballapp.model.TeamDetails
//
//class TeamRepository {
//
//    fun getTeamDetails(
//        teamName: String
//    ): TeamDetails {
//
//        return TeamDetails(
//            teamName = teamName,
//            position = 1,
//            points = 81,
//            form = "DWWDW"
//        )
//    }
//}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/TeamsApiRepository.kt
```kotlin
package com.example.footballapp.repositories

import com.example.footballapp.ApiConfig
import com.example.footballapp.model.TeamRow
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class TeamsApiRepository {

    fun getTeams(
        leagueId: Int,
        season: Int
    ): List<TeamRow> {

        val client =
            OkHttpClient()

        val request =
            Request.Builder()
                .url(
                    "${ApiConfig.BASE_URL}/teams" +
                            "?leagueId=$leagueId" +
                            "&season=$season"
                )
                .build()

        val json =
            client.newCall(request)
                .execute()
                .body
                ?.string()
                ?: "[]"

        val mapper =
            jacksonObjectMapper()

        return mapper.readValue(json)
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/repositories/TeamsRepository.kt
```kotlin
//package com.example.footballapp.repositories
//
//import com.example.footballapp.model.TeamRow
//
//class TeamsRepository {
//
//    fun getTeams(): List<TeamRow> {
//
//        return listOf(
//            TeamRow("Celtic"),
//            TeamRow("Rangers"),
//            TeamRow("Hibernian"),
//            TeamRow("Hearts"),
//            TeamRow("Aberdeen"),
//            TeamRow("Dundee United")
//        )
//    }
//}
```

## File: android/app/src/main/java/com/example/footballapp/screens/ClubFixturesScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.repositories.TeamFixturesRepository

@Composable
fun TeamFixturesScreen(
    teamName: String
) {

    val repository =
        TeamFixturesRepository()

    val fixtures =
        repository.getFixtures(
            teamName
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "$teamName Fixtures",
            style =
                MaterialTheme.typography.headlineMedium
        )
        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(fixtures) { fixture ->

                Text(
                    text =
                        "${fixture.homeTeam} " +
                                "${fixture.homeGoals} - " +
                                "${fixture.awayGoals} " +
                                fixture.awayTeam,

                    modifier =
                        Modifier.padding(8.dp)
                )
            }
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/ClubScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballapp.model.TeamDetails
import com.example.footballapp.repositories.TeamDetailsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.NumberFormat

@Composable
fun TeamScreen(
    teamId: Int,
    onFixturesClick: (String) -> Unit,
    onSquadClick: (Int) -> Unit
) {

    var teamState by remember {
        mutableStateOf<TeamScreenState>(
            TeamScreenState.Loading
        )
    }

    LaunchedEffect(
        teamId
    ) {

        teamState =
            TeamScreenState.Loading

        teamState =
            withContext(
                Dispatchers.IO
            ) {

                runCatching {
                    TeamDetailsApiRepository()
                        .getTeamDetails(
                            teamId
                        )
                }.fold(
                    onSuccess = { details ->
                        TeamScreenState.Ready(details)
                    },
                    onFailure = { error ->
                        TeamScreenState.Error(
                            error.message
                                ?: "Unable to load team details"
                        )
                    }
                )
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(16.dp)
    ) {

        when (val state = teamState) {

            TeamScreenState.Loading -> {
                Text(
                    text = "Loading team...",
                    style =
                        MaterialTheme.typography.bodyMedium
                )
            }

            is TeamScreenState.Error -> {
                Text(
                    text = state.message,
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.error
                )
            }

            is TeamScreenState.Ready -> {
                TeamDetailsContent(
                    teamDetails = state.teamDetails,
                    onFixturesClick = onFixturesClick,
                    onSquadClick = onSquadClick
                )
            }
        }
    }
}

@Composable
private fun TeamDetailsContent(
    teamDetails: TeamDetails,
    onFixturesClick: (String) -> Unit,
    onSquadClick: (Int) -> Unit
) {

    val team =
        teamDetails.team

    val venue =
        teamDetails.venue

    Text(
        text =
            team.name,
        style =
            MaterialTheme.typography.headlineSmall,
        fontWeight =
            FontWeight.SemiBold,
        maxLines =
            2,
        overflow =
            TextOverflow.Ellipsis
    )

    Spacer(
        modifier =
            Modifier.height(20.dp)
    )

    Surface(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(8.dp),
        color =
            MaterialTheme.colorScheme.surface,
        tonalElevation =
            1.dp
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            SectionTitle(
                text = "Club"
            )

            DetailRow(
                label = "Name",
                value = team.name
            )

            DetailRow(
                label = "Founded",
                value = team.founded.toDisplayText()
            )

            DetailRow(
                label = "Country",
                value = team.country
            )

            HorizontalDivider(
                modifier =
                    Modifier.padding(vertical = 10.dp),
                color =
                    MaterialTheme.colorScheme.outlineVariant
            )

            SectionTitle(
                text = "Stadium"
            )

            DetailRow(
                label = "Name",
                value = venue?.name.toDisplayText()
            )

            DetailRow(
                label = "Address",
                value = formatAddress(
                    venue?.address,
                    venue?.city
                )
            )

            DetailRow(
                label = "Capacity",
                value = venue?.capacity.toCapacityText()
            )
        }
    }

    Spacer(
        modifier =
            Modifier.height(16.dp)
    )

    Button(
        onClick = {
            onFixturesClick(
                team.name
            )
        },
        modifier =
            Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Fixtures"
        )
    }

    Spacer(
        modifier =
            Modifier.height(8.dp)
    )

    Button(
        onClick = {

            onSquadClick(
                team.id
            )
        },
        modifier =
            Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Squad"
        )
    }
}

@Composable
private fun SectionTitle(
    text: String
) {

    Text(
        text = text,
        style =
            MaterialTheme.typography.titleMedium,
        fontWeight =
            FontWeight.SemiBold,
        modifier =
            Modifier.padding(
                bottom = 8.dp
            )
    )
}

@Composable
private fun DetailRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 5.dp
            )
    ) {

        Text(
            text = label,
            modifier =
                Modifier.weight(0.42f),
            style =
                MaterialTheme.typography.bodyMedium,
            color =
                MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,
            modifier =
                Modifier.weight(0.58f),
            style =
                MaterialTheme.typography.bodyMedium,
            fontWeight =
                FontWeight.Medium
        )
    }
}

private fun String?.toDisplayText(): String =
    if (isNullOrBlank()) {
        "Not available"
    } else {
        this
    }

private fun Int.toDisplayText(): String =
    if (this <= 0) {
        "Not available"
    } else {
        toString()
    }

private fun Int?.toCapacityText(): String =
    if (this == null || this <= 0) {
        "Not available"
    } else {
        NumberFormat
            .getIntegerInstance()
            .format(this)
    }

private fun formatAddress(
    address: String?,
    city: String?
): String {

    val parts =
        listOfNotNull(
            address?.takeIf {
                it.isNotBlank()
            },
            city?.takeIf {
                it.isNotBlank()
            }
        )

    return if (parts.isEmpty()) {
        "Not available"
    } else {
        parts.joinToString(", ")
    }
}

private sealed interface TeamScreenState {

    data object Loading : TeamScreenState

    data class Ready(
        val teamDetails: TeamDetails
    ) : TeamScreenState

    data class Error(
        val message: String
    ) : TeamScreenState
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/ClubsScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.example.footballapp.AppState
import com.example.footballapp.repositories.TeamsApiRepository
import com.example.footballapp.model.TeamRow


@Composable
fun TeamsScreen(
    onTeamClick: (Int) -> Unit
) {

    var teams by remember {
        mutableStateOf<List<TeamRow>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        teams =
            withContext(
                Dispatchers.IO
            ) {

                TeamsApiRepository()
                    .getTeams(
                        AppState.selectedLeagueId,
                        AppState.selectedSeason
                    )
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text =
                "${AppState.selectedLeagueName} Teams",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(teams) { team ->

                Button(
                    onClick = {
                        println(
                            "Clicked teamId = ${team.id}"
                        )

                        onTeamClick(
                            team.id
                        )
                    },
                    modifier =
                        Modifier.padding(8.dp)
                ) {

                    Text(
                        team.name
                    )
                }
            }
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/FixtureDetailsScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.model.FixtureRow
import com.example.footballapp.repositories.FixtureDetailsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun FixtureDetailsScreen(
    fixtureId: Long
) {

    var fixture by remember {

        mutableStateOf<FixtureRow?>(
            null
        )
    }

    LaunchedEffect(
        fixtureId
    ) {

        fixture =
            withContext(
                Dispatchers.IO
            ) {

                FixtureDetailsApiRepository()
                    .getFixture(
                        fixtureId
                    )
            }
    }

    fixture?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text =
                    "Fixture Details",
                style =
                    MaterialTheme.typography.headlineMedium
            )

            Text(
                text =
                    it.fixtureDate
            )

//            Text(
//                text =
//                    it.round ?: ""
//            )

            Text(
                text =
                    it.homeTeam
            )

            Text(
                text =
                    "${it.homeGoals} - ${it.awayGoals}"
            )

            Text(
                text =
                    it.awayTeam
            )
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/FixturesScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.AppState
import com.example.footballapp.model.FixtureRow
import com.example.footballapp.repositories.FixturesApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun FixturesScreen(
    onFixtureClick: (
        FixtureRow
    ) -> Unit
)
{

    var fixtures by remember {
        mutableStateOf<List<FixtureRow>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        fixtures =
            withContext(
                Dispatchers.IO
            ) {

                FixturesApiRepository()
                    .getFixtures(
                        AppState.selectedLeagueId,
                        AppState.selectedSeason
                    )
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text =
                "${AppState.selectedLeagueName} Fixtures",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(fixtures) { fixture ->

                Text(
                    text =
                        "${fixture.fixtureDate} ${fixture.fixtureTime}",
                    style =
                        MaterialTheme.typography.titleMedium
                )

                Button(
                    onClick = {

                        onFixtureClick(
                            fixture
                        )
                    }
                )
                {
                    Text(
                        "${fixture.homeTeam} " +
                                "${fixture.homeGoals} - " +
                                "${fixture.awayGoals} " +
                                fixture.awayTeam
                    )
                }

//                Text(
//                    text =
//                        fixture.round
//                )

                Spacer(
                    modifier =
                        Modifier.height(16.dp)
                )
            }
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/LeagueSelectionScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.model.LeagueUk
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LeagueSelectionScreen(
    onLeagueClick: (Int, String) -> Unit
) {

    var leagues by remember {
        mutableStateOf<List<LeagueUk>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        leagues =
            withContext(
                Dispatchers.IO
            ) {

                LeagueApiRepository()
                    .getLeagues()
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Choose your League",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn {

            items(leagues) { league ->

                Button(
                    onClick = {
                        onLeagueClick(
                            league.leagueId,
                            league.name
                        )
                    },
                    modifier = Modifier.padding(8.dp)
                ) {

                    Text(
                        league.name
                    )
                }
            }
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/LeagueTableScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballapp.AppState
import com.example.footballapp.model.TableRow
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LeagueTableScreen(
    onTeamClick: (Int) -> Unit
) {

    var tableState by remember {
        mutableStateOf<LeagueTableState>(
            LeagueTableState.Loading
        )
    }

    LaunchedEffect(
        AppState.selectedLeagueId,
        AppState.selectedSeason
    ) {

        tableState =
            LeagueTableState.Loading

        tableState =
            withContext(
                Dispatchers.IO
            ) {

                runCatching {
                    LeagueApiRepository()
                        .getLeagueTable(
                            AppState.selectedLeagueId,
                            AppState.selectedSeason
                        )
                }.fold(
                    onSuccess = { rows ->
                        LeagueTableState.Ready(rows)
                    },
                    onFailure = { error ->
                        LeagueTableState.Error(
                            error.message
                                ?: "Unable to load league table"
                        )
                    }
                )
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(16.dp)
    ) {

        Text(
            text =
                AppState.selectedLeagueName,
            style =
                MaterialTheme.typography.headlineSmall,
            fontWeight =
                FontWeight.SemiBold
        )

        Text(
            text =
                "Season ${AppState.selectedSeason}",
            style =
                MaterialTheme.typography.bodyMedium,
            color =
                MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier =
                Modifier.height(20.dp)
        )

        when (val state = tableState) {

            LeagueTableState.Loading -> {
                Text(
                    text = "Loading table...",
                    style =
                        MaterialTheme.typography.bodyMedium
                )
            }

            is LeagueTableState.Error -> {
                Text(
                    text = state.message,
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.error
                )
            }

            is LeagueTableState.Ready -> {
                LeagueTable(
                    table = state.table,
                    onTeamClick = onTeamClick
                )
            }
        }
    }
}

@Composable
private fun LeagueTable(
    table: List<TableRow>,
    onTeamClick: (Int) -> Unit
) {

    Surface(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(8.dp),
        color =
            MaterialTheme.colorScheme.surface,
        tonalElevation =
            1.dp
    ) {

        Column {

            LeagueTableHeader()

            HorizontalDivider(
                color =
                    MaterialTheme.colorScheme.outlineVariant
            )

            LazyColumn(
                modifier =
                    Modifier.fillMaxWidth()
            ) {

                itemsIndexed(
                    table,
                    key = { _, row ->
                        row.teamId
                    }
                ) { index, row ->

                    LeagueTableRowItem(
                        row = row,
                        isEvenRow = index % 2 == 0,
                        onTeamClick = onTeamClick
                    )

                    HorizontalDivider(
                        color =
                            MaterialTheme.colorScheme.outlineVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun LeagueTableHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant
            )
            .padding(
                horizontal = 10.dp,
                vertical = 10.dp
            ),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        TableHeaderCell(
            text = "#",
            modifier =
                Modifier.width(32.dp),
            textAlign =
                TextAlign.Start
        )

        TableHeaderCell(
            text = "Club",
            modifier =
                Modifier.weight(1f),
            textAlign =
                TextAlign.Start
        )

        TableHeaderCell("P")
        TableHeaderCell("W")
        TableHeaderCell("D")
        TableHeaderCell("L")
        TableHeaderCell("GD")
        TableHeaderCell("Pts")
    }
}

@Composable
private fun LeagueTableRowItem(
    row: TableRow,
    isEvenRow: Boolean,
    onTeamClick: (Int) -> Unit
) {

    val rowColor =
        if (isEvenRow) {
            MaterialTheme.colorScheme.surface
        } else {
            MaterialTheme.colorScheme.surfaceVariant.copy(
                alpha = 0.35f
            )
        }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(rowColor)
            .clickable {
                onTeamClick(row.teamId)
            }
            .padding(
                horizontal = 10.dp,
                vertical = 11.dp
            ),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(
            text =
                row.position.toString(),
            modifier =
                Modifier.width(32.dp),
            style =
                MaterialTheme.typography.bodyMedium,
            fontWeight =
                FontWeight.Medium
        )

        Column(
            modifier =
                Modifier.weight(1f),
            verticalArrangement =
                Arrangement.Center
        ) {

            Text(
                text =
                    row.teamName,
                style =
                    MaterialTheme.typography.bodyMedium,
                fontWeight =
                    FontWeight.SemiBold,
                maxLines =
                    1,
                overflow =
                    TextOverflow.Ellipsis
            )
        }

        TableValueCell(row.played.toString())
        TableValueCell(row.wins.toString())
        TableValueCell(row.draws.toString())
        TableValueCell(row.losses.toString())
        TableValueCell(
            row.goalDifference.toSignedText()
        )
        TableValueCell(
            text = row.points.toString(),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun TableHeaderCell(
    text: String,
    modifier: Modifier = Modifier.width(34.dp),
    textAlign: TextAlign = TextAlign.End
) {

    Text(
        text = text,
        modifier =
            modifier,
        style =
            MaterialTheme.typography.labelMedium,
        color =
            MaterialTheme.colorScheme.onSurfaceVariant,
        fontWeight =
            FontWeight.Bold,
        textAlign =
            textAlign,
        maxLines =
            1
    )
}

@Composable
private fun TableValueCell(
    text: String,
    fontWeight: FontWeight = FontWeight.Normal
) {

    Text(
        text = text,
        modifier =
            Modifier.width(34.dp),
        style =
            MaterialTheme.typography.bodyMedium,
        fontWeight =
            fontWeight,
        textAlign =
            TextAlign.End,
        maxLines =
            1,
        color =
            Color.Unspecified
    )
}

private fun Int.toSignedText(): String =
    if (this > 0) {
        "+$this"
    } else {
        toString()
    }

private sealed interface LeagueTableState {

    data object Loading : LeagueTableState

    data class Ready(
        val table: List<TableRow>
    ) : LeagueTableState

    data class Error(
        val message: String
    ) : LeagueTableState
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/PlayerDetailsScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.footballapp.AppState
import com.example.footballapp.model.PlayerDetails
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun PlayerDetailsScreen(
    playerId: Int
) {

    var player by remember {
        mutableStateOf<PlayerDetails?>(null)
    }

    LaunchedEffect(playerId) {

        player =
            withContext(Dispatchers.IO) {

                LeagueApiRepository()
                    .getPlayerDetails(
                        playerId,
                        AppState.selectedLeagueId,
                        AppState.selectedSeason
                    )
            }
    }

    player?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(16.dp)
        ) {

            PlayerCard(it)

            StatisticsCard(it)

            DisciplineCard(it)
        }

    } ?: Text(
        text = "Loading player..."
    )
}

@Composable
private fun PlayerCard(
    player: PlayerDetails
) {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
    ) {

        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text = "Player",

                style =
                    MaterialTheme.typography.titleLarge,

                fontWeight =
                    FontWeight.Bold
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            AsyncImage(
                model = player.photoUrl,
                contentDescription = player.displayName,

                modifier =
                    Modifier
                        .size(140.dp)
                        .clip(CircleShape)
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            Text(
                text = player.firstName + " " + player.lastName,

                style =
                    MaterialTheme.typography.headlineSmall,

                fontWeight =
                    FontWeight.Bold
            )

            Text(
                text = player.displayName,

                style =
                    MaterialTheme.typography.bodyMedium,

                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            DetailRow(
                "Nationality",
                player.nationality
            )

            DetailRow(
                "Age",
                player.age?.toString() ?: "-"
            )

            DetailRow(
                "Position",
                player.position
            )

            player.shirtNumber?.let {

                DetailRow(
                    "Shirt Number",
                    "#$it"
                )
            }
        }
    }
}

@Composable
private fun StatisticsCard(
    player: PlayerDetails
) {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            Text(
                text = "Season Statistics",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            DetailRow(
                "Team",
                player.teamName ?: "-"
            )

            DetailRow(
                "Competition",
                player.leagueName ?: "-"
            )

            DetailRow(
                "Season",
                player.season?.toString() ?: "-"
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )

            DetailRow(
                "Appearances",
                "${player.appearances ?: 0}"
            )
        }
    }
}

@Composable
private fun DisciplineCard(
    player: PlayerDetails
) {

    Card(
        modifier =
            Modifier.fillMaxWidth(),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            Text(
                text = "Cards",

                style =
                    MaterialTheme.typography.titleLarge
            )

            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )

            DetailRow(
                "Yellow Cards",
                "${player.yellowCards ?: 0}"
            )

            DetailRow(
                "Red Cards",
                "${player.redCards ?: 0}"
            )
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String
) {

    Column {

        androidx.compose.foundation.layout.Row(
            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text(
                text = label,

                modifier =
                    Modifier.weight(1f)
            )

            Text(
                text = value,

                fontWeight =
                    FontWeight.Bold
            )
        }

        HorizontalDivider(
            modifier =
                Modifier.padding(vertical = 6.dp)
        )
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/screens/SquadScreen.kt
```kotlin
package com.example.footballapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.footballapp.AppState
import com.example.footballapp.model.PlayerSummary
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip

@Composable
fun SquadScreen(
    teamId: Int,
    onPlayerClick: (Int) -> Unit = {}
) {

    var players by remember {
        mutableStateOf<List<PlayerSummary>>(
            emptyList()
        )
    }

    LaunchedEffect(teamId) {

        players =
            withContext(Dispatchers.IO) {

                LeagueApiRepository()
                    .getTeamPlayers(
                        teamId,
                        AppState.selectedLeagueId,
                        AppState.selectedSeason
                    )
            }
    }

    val groupedPlayers =
        players.groupBy {
            it.position
        }

    LazyColumn(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(16.dp)
    ) {

        groupedPlayers.forEach {

                (position, squad) ->

            val heading = when (position) {
                "Goalkeeper" -> "Goalkeepers"
                "Defender" -> "Defenders"
                "Midfielder" -> "Midfielders"
                "Attacker" -> "Attackers"
                else -> position
            }

            item {

                Text(
                    text = heading,

                    style =
                        MaterialTheme.typography.headlineSmall
                )
            }

            items(squad) { player ->

                Card(

                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .clickable {

                                onPlayerClick(
                                    player.playerId
                                )
                            },

                    elevation =
                        CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                ) {

                    Row(

                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(12.dp),

                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        AsyncImage(
                            model = player.photoUrl,
                            contentDescription = player.displayName,
                            modifier = Modifier.size(72.dp).clip(CircleShape)
                        )

                        Spacer(
                            modifier =
                                Modifier.width(16.dp)
                        )

                        Column {

                            Row(
                                verticalAlignment =
                                    Alignment.CenterVertically
                            ) {

                                Text(

                                    text =
                                        player.displayName,

                                    style =
                                        MaterialTheme
                                            .typography
                                            .titleMedium
                                )

                                if (player.captain) {

                                    Text(
                                        text = " (C)"
                                    )
                                }
                            }

                            Spacer(
                                modifier =
                                    Modifier.height(4.dp)
                            )

                            Text(
                                text =
                                    "${player.nationality} • Age ${
                                        player.age ?: "-"
                                    }"
                            )

                            Spacer(
                                modifier =
                                    Modifier.height(4.dp)
                            )

                            val stats =
                                buildString {

                                    append(
                                        "Apps ${
                                            player.appearances ?: 0
                                        }"
                                    )

                                    if ((player.goals ?: 0) > 0) {

                                        append(
                                            "   Goals ${player.goals}"
                                        )
                                    }

                                    if ((player.assists ?: 0) > 0) {

                                        append(
                                            "   Assists ${player.assists}"
                                        )
                                    }

                                    player.shirtNumber?.let {

                                        append(
                                            "   #$it"
                                        )
                                    }
                                }

                            Text(stats)
                        }
                    }
                }
            }
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/ClubBadge.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.footballapp.R
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun ClubBadge(

    logoUrl: String?,

    modifier: Modifier = Modifier

) {

    if (logoUrl.isNullOrBlank()) {

        Image(

            painter = painterResource(
                R.drawable.badge_rangers_257
            ),

            contentDescription = null,

            modifier = modifier

                .clip(CircleShape),

            contentScale = ContentScale.Fit

        )

    } else {

        AsyncImage(

            model = logoUrl,

            contentDescription = null,

            modifier = modifier

                .clip(CircleShape),

            contentScale = ContentScale.Fit

        )
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/ClubList.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun ClubList(

    clubs: List<ClubUiModel>,

    onClubClick: (ClubUiModel) -> Unit

) {

    clubs.forEach { club ->

        ClubRow(

            club = club,

            onClick = onClubClick

        )

    }

}

@Preview(showBackground = true)
@Composable
private fun ClubListPreview() {

    MaterialTheme {

        SectionCard {

            ClubList(

                clubs = PreviewData.ScottishPremiershipClubList,

                onClubClick = {}

            )

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/ClubRow.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun ClubRow(

    club: ClubUiModel,

    onClick: (ClubUiModel) -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick(club)

            }
            .padding(vertical = AppSpacing.Small),

        verticalAlignment = Alignment.CenterVertically

    ) {

        ClubBadge(

            logoUrl = club.badgeUrl,

            modifier = Modifier
                .size(AppDimensions.ImageMedium)
                .padding(end = AppSpacing.Medium)

        )

        Spacer(

            modifier = Modifier.width(
                AppSpacing.Medium
            )

        )

        Column(

            modifier = Modifier.weight(1f)

        ) {

            Text(

                text = club.shortName ?: club.name,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.SemiBold

            )

            club.stadium?.let {

                Text(

                    text = it,

                    modifier = Modifier.padding(
                        top = AppSpacing.ExtraSmall
                    ),

                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

        }

        Icon(

            imageVector = Icons.Default.ChevronRight,

            contentDescription = "Open Club",

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}

/**
 * Preview
 */
@Preview(showBackground = true)
@Composable
private fun ClubRowPreview() {

    MaterialTheme {

        SectionCard {

            ClubRow(

                club = PreviewData.Celtic,

                onClick = {}

            )

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/CompetitionList.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.runtime.Composable
import com.example.footballapp.ui.model.CompetitionUiModel

@Composable
fun CompetitionList(
    competitions: List<CompetitionUiModel>,
    onCompetitionSelected: (CompetitionUiModel) -> Unit
) {

    competitions.forEach { competition ->

        CompetitionRow(
            competition = competition,
            onClick = {
                onCompetitionSelected(competition)
            }
        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/CompetitionRow.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun CompetitionRow(

    competition: CompetitionUiModel,
    onClick: () -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable { onClick() }
            .padding(horizontal = AppSpacing.Medium),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Row(

            verticalAlignment = Alignment.CenterVertically

        ) {

            Box(

                modifier = Modifier.size(AppDimensions.CompetitionLogo),

                contentAlignment = Alignment.Center

            ) {

                AsyncImage(
                    model = competition.logoUrl,
                    contentDescription = competition.name
                )

            }

            Text(

                text = competition.name,

                style = AppTypography.Body,

                modifier = Modifier.padding(
                    start = AppSpacing.Medium
                )

            )

        }

        Icon(

            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )
    }
}
@Preview(showBackground = true)
@Composable
private fun CompetitionRowPreview() {

    CompetitionRow(

        competition = PreviewData.ScottishPremiership,

        onClick = {}

    )
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/FixtureCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun FixtureCard(

    fixture: FixtureUiModel,

    onClick: () -> Unit

) {

    SectionCard(

        modifier = Modifier.clickable {

            onClick()

        }

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = AppSpacing.Medium,
                    vertical = AppSpacing.Medium
                ),

            verticalAlignment = Alignment.Top

        ) {

            Column(

                modifier = Modifier.weight(1f)

            ) {

                Text(

                    text = fixture.homeTeamName,

                    style = MaterialTheme.typography.bodyMedium,

                    fontWeight = FontWeight.SemiBold,

                    maxLines = 1,

                    overflow = TextOverflow.Ellipsis

                )

                Text(

                    text = fixture.awayTeamName,

                    modifier = Modifier.padding(
                        top = AppSpacing.Small
                    ),

                    style = MaterialTheme.typography.bodyMedium,

                    fontWeight = FontWeight.SemiBold,

                    maxLines = 1,

                    overflow = TextOverflow.Ellipsis

                )

            }

            Spacer(

                modifier = Modifier.width(
                    AppSpacing.Medium
                )

            )

            FixtureCentre(

                fixture = fixture

            )

        }
    }
}

@Composable
private fun FixtureCentre(

    fixture: FixtureUiModel

) {

    Column(

        modifier = Modifier.width(
            AppDimensions.FixtureCentreWidth
        ),

        horizontalAlignment = Alignment.End

    ) {

        StatusChip(

            text = when (fixture.status) {

                FixtureStatus.SCHEDULED ->
                    fixture.kickOff

                FixtureStatus.LIVE ->
                    "LIVE"

                FixtureStatus.HALF_TIME ->
                    "HT"

                FixtureStatus.FINISHED ->
                    "FT"

                FixtureStatus.EXTRA_TIME ->
                    "ET"

                FixtureStatus.PENALTIES ->
                    "PEN"

                FixtureStatus.POSTPONED ->
                    "P/P"

                FixtureStatus.CANCELLED ->
                    "CAN"

            }

        )

        if (

            fixture.homeScore != null &&
            fixture.awayScore != null

        ) {

            Text(

                text = "${fixture.homeScore} - ${fixture.awayScore}",

                modifier = Modifier.padding(
                    top = AppSpacing.ExtraSmall
                ),

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

        }

    }

}

@Preview(name = "Scheduled", showBackground = true)
@Composable
private fun ScheduledPreview() {

    MaterialTheme {

        FixtureCard(

            fixture = PreviewData.CelticVsRangers,

            onClick = {}

        )

    }

}

@Preview(name = "Live", showBackground = true)
@Composable
private fun LivePreview() {

    MaterialTheme {

        FixtureCard(

            fixture = PreviewData.HeartsVsAberdeen,

            onClick = {}

        )

    }

}

@Preview(name = "Finished", showBackground = true)
@Composable
private fun FinishedPreview() {

    MaterialTheme {

        FixtureCard(

            fixture = PreviewData.HibernianVsDundeeUnited,

            onClick = {}

        )

    }

}

@Preview(name = "Postponed", showBackground = true)
@Composable
private fun PostponedPreview() {

    MaterialTheme {

        FixtureCard(

            fixture = PreviewData.RossCountyVsStJohnstone,

            onClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/InfoRow.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun InfoRow(

    label: String,

    value: String?,

    modifier: Modifier = Modifier

) {

    if (!value.isNullOrBlank()) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = AppSpacing.Small)
        ) {

            Text(

                text = label,

                style = MaterialTheme.typography.labelMedium,

                color = MaterialTheme.colorScheme.onSurfaceVariant

            )

            Text(

                text = value,

                modifier = Modifier.padding(
                    top = AppSpacing.ExtraSmall
                ),

                style = MaterialTheme.typography.bodyLarge,

                fontWeight = FontWeight.Medium

            )

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun InfoRowPreview() {

    MaterialTheme {

        SectionCard {

            InfoRow(

                label = "Founded",

                value = "1872"

            )

        }

    }
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/LeagueTableCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun LeagueTableCard(

    table: List<LeagueTableRowUiModel>,

    onTeamClick: (Int) -> Unit

) {

    SectionCard {

        LeagueTableHeader()

        Spacer(
            modifier = Modifier.height(AppSpacing.Small)
        )

        table.forEachIndexed { index, row ->

            LeagueTableRow(

                row = row,

                isEvenRow = false,

                onClubClick = onTeamClick

            )

            // Temporary location for Scottish Premiership
            if (index == 2) {

                TableDivider()

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun LeagueTableCardPreview() {

    LeagueTableCard(

        table = PreviewData.ScottishPremiershipTable,

        onTeamClick = {}

    )

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/LeagueTableHeader.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.AppSpacing.ExtraLarge

@Composable
fun LeagueTableHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(
                horizontal = AppSpacing.Medium,
                vertical = AppSpacing.Small
            )
    ) {

        Row(
            modifier = Modifier.weight(1f)
        ) {

            // Space for the position number
            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.width(22.dp)
            )

            // Space for the badge
            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.width(28.dp)
            )

            Text(
                text = Strings.TABLE_TEAM,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

        }

        HeaderCell(Strings.TABLE_PLAYED)
        HeaderCell(Strings.TABLE_WINS)
        HeaderCell(Strings.TABLE_DRAWS)
        HeaderCell(Strings.TABLE_LOSSES)
        HeaderCell(Strings.TABLE_POINTS)

    }

}

@Composable
private fun HeaderCell(

    text: String,

    modifier: Modifier = Modifier.width(ExtraLarge),

    textAlign: TextAlign = TextAlign.End

) {

    Text(

        text = text,

        modifier = modifier,

        textAlign = textAlign,

        style = MaterialTheme.typography.labelMedium,

        fontWeight = FontWeight.Bold,

        color = MaterialTheme.colorScheme.onSurfaceVariant

    )

}

@Preview(showBackground = true)
@Composable
private fun LeagueTableHeaderPreview() {

    MaterialTheme {

        LeagueTableHeader()

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/LeagueTableRow.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment

import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun LeagueTableRow(

    row: LeagueTableRowUiModel,

    isEvenRow: Boolean,

    onClubClick: (Int) -> Unit

) {

    val backgroundColor =
        row.qualification.backgroundColor(
            isEvenRow
        )

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.small
            )
            .clickable {
                onClubClick(row.teamId)
            }
            .padding(
                start = AppSpacing.Small,
                end = AppSpacing.Medium,
                top = AppSpacing.ExtraSmall,
                bottom = AppSpacing.ExtraSmall
            ),

        verticalAlignment = Alignment.CenterVertically

    ) {

        Text(
            text = row.position.toString(),
            modifier = Modifier.width(28.dp),
            fontWeight = FontWeight.SemiBold
        )

        ClubBadge(

            logoUrl = row.teamLogo,

            modifier = Modifier
                .size(AppDimensions.ImageSmall)
                .padding(
                    start = AppSpacing.ExtraSmall,
                    end = AppSpacing.Small
                )

        )

        Text(
            text = row.teamName,
            modifier = Modifier.weight(1f),
            maxLines = 1
        )

        ValueCell(row.played.toString())
        ValueCell(row.wins.toString())
        ValueCell(row.draws.toString())
        ValueCell(row.losses.toString())

        ValueCell(
            text = row.points.toString(),
            fontWeight = FontWeight.Bold
        )

    }
}
@Composable
private fun ValueCell(

    text: String,

    fontWeight: FontWeight = FontWeight.Normal

) {

    Text(

        text = text,

        modifier = Modifier.width(28.dp),

        textAlign = TextAlign.End,

        fontWeight = fontWeight

    )

}

@Preview(showBackground = true)
@Composable
private fun LeagueTableRowPreview() {

    MaterialTheme {

        LeagueTableRow(

            row = PreviewData.ScottishPremiershipTable.first(),

            isEvenRow = true,

            onClubClick = {}

        )
    }
}

@Composable
private fun QualificationType.backgroundColor(
    isEvenRow: Boolean
): Color {

    return when (this) {

        QualificationType.CHAMPION ->
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.18f)

        QualificationType.RELEGATION ->
            MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.18f)

        QualificationType.SAFE ->
            MaterialTheme.colorScheme.surface

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/NavigationCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun NavigationCard(

    title: String,

    subtitle: String,

    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Small
            )
            .clickable(onClick = onClick),

        shape = AppShapes.Card,

        elevation = CardDefaults.cardElevation(

            defaultElevation = AppElevation.Card

        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.Medium),

            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Column {

                Text(

                    text = title,

                    style = MaterialTheme.typography.titleMedium

                )

                Text(

                    text = subtitle,

                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

            Icon(

                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

                contentDescription = null

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun NavigationCardPreview() {

    MaterialTheme {

        NavigationCard(

            title = "League Table",

            subtitle = "View complete standings",

            onClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/PlayerList.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListScope
//import androidx.compose.foundation.lazy.item
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.PlayerUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing

private val PositionOrder = listOf(
    "Goalkeeper",
    "Defender",
    "Midfielder",
    "Forward"
)

private fun positionHeading(position: String): String =
    when (position) {
        "Goalkeeper" -> "Goalkeepers"
        "Defender" -> "Defenders"
        "Midfielder" -> "Midfielders"
        "Forward" -> "Forwards"
        else -> position
    }

fun LazyListScope.playerList(

    players: List<PlayerUiModel>,

    onPlayerClick: (PlayerUiModel) -> Unit

) {

    val groupedPlayers = players.groupBy { it.position }

    PositionOrder.forEach { position ->

        val squad = groupedPlayers[position]

        if (!squad.isNullOrEmpty()) {

            item {

                Column(

                    verticalArrangement = Arrangement.spacedBy(
                        AppSpacing.Small
                    )

                ) {

                    SectionHeading(
                        text = positionHeading(position)
                    )

                    SectionCard {

                        Column(

                            verticalArrangement = Arrangement.spacedBy(
                                AppSpacing.Small
                            )

                        ) {

                            squad.forEach { player ->

                                PlayerRow(
                                    player = player,
                                    onClick = onPlayerClick
                                )

                            }

                        }

                    }

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PlayerListPreview() {

    ScreenScaffold(

        title = "Rangers",

        subtitle = "Squad"

    ) {

        playerList(

            players = PreviewData.RangersSquad,

            onPlayerClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/PlayerPhoto.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun PlayerPhoto(

    photoUrl: String?,

    modifier: Modifier = Modifier

) {

    if (photoUrl.isNullOrBlank()) {

        PlaceholderPlayerPhoto(

            modifier = modifier

        )

    } else {

        AsyncImage(

            model = photoUrl,

            contentDescription = null,

            modifier = modifier
                .clip(CircleShape),

            contentScale = ContentScale.Crop

        )

    }

}

@Composable
private fun PlaceholderPlayerPhoto(

    modifier: Modifier = Modifier

) {

    Box(

        modifier = modifier
            .clip(CircleShape)
            .background(
                MaterialTheme.colorScheme.surfaceVariant
            )
            .border(

                width = AppDimensions.BadgeBorder,

                color = MaterialTheme.colorScheme.outlineVariant,

                shape = CircleShape

            ),

        contentAlignment = Alignment.Center

    ) {

        Icon(

            imageVector = Icons.Default.Person,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}

@Preview(showBackground = true)
@Composable
private fun PlayerPhotoPreview() {

    MaterialTheme {

        PlayerPhoto(

            photoUrl = null,

            modifier = Modifier.size(
                AppDimensions.ImageLarge
            )

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/PlayerRow.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.PlayerUiModel
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun PlayerRow(

    player: PlayerUiModel,

    onClick: (PlayerUiModel) -> Unit,

    modifier: Modifier = Modifier

) {

    Row(

        modifier = modifier
            .fillMaxWidth()
            .clickable {

                onClick(player)

            },

        verticalAlignment = Alignment.CenterVertically

    ) {

        Row(

            modifier = Modifier.weight(1f),

            verticalAlignment = Alignment.Top

        ) {

            Box(

                modifier = Modifier.width(
                    AppDimensions.ShirtNumberWidth
                ),

                contentAlignment = Alignment.TopEnd

            ) {

                Text(

                    text = player.shirtNumber?.toString() ?: "-",

                    style = MaterialTheme.typography.bodyLarge,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

            Spacer(

                modifier = Modifier.width(
                    AppSpacing.Small
                )

            )

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.ExtraSmall
                )

            ) {

                Text(

                    text = player.name,

                    style = MaterialTheme.typography.titleMedium

                )

                Text(

                    text = player.position,

                    //style = MaterialTheme.typography.bodyMedium,
                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

        }

        Icon(

            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}

@Preview(showBackground = true)
@Composable
private fun PlayerRowPreview() {

    MaterialTheme {

        SectionCard {

            PlayerRow(

                player = PlayerUiModel(

                    playerId = 1,

                    shirtNumber = 2,

                    name = "James Tavernier",

                    position = "Defender"

                ),

                onClick = {}

            )

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/ScreenHeader.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun ScreenHeader(

    title: String,

    subtitle: String? = null,

    showBackButton: Boolean = false,

    onBackClick: (() -> Unit)? = null

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Medium
            )

    ) {

        Row(

            verticalAlignment = Alignment.CenterVertically

        ) {

            if (showBackButton && onBackClick != null) {

                IconButton(

                    onClick = onBackClick

                ) {

                    Icon(

                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,

                        contentDescription = "Back"

                    )

                }

            }

            Text(

                text = title,

                style = AppTypography.ScreenTitle

            )

        }

        subtitle?.let {

            Text(

                text = it,

                style = AppTypography.ScreenSubtitle,

                color = MaterialTheme.colorScheme.onSurfaceVariant,

                modifier = Modifier.padding(
                    top = AppSpacing.Small
                )

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ScreenHeaderPreview() {

    MaterialTheme {

        ScreenHeader(

            title = "Competitions",

            subtitle = "Choose a competition to explore.",

            showBackButton = true,

            onBackClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/ScreenScaffold.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun ScreenScaffold(

    title: String,

    subtitle: String,

    modifier: Modifier = Modifier,

    showBackButton: Boolean = false,

    onBackClick: (() -> Unit)? = null,

    content: LazyListScope.() -> Unit

) {

    Surface(

        modifier = modifier.fillMaxSize(),

        color = MaterialTheme.colorScheme.background

    ) {

        LazyColumn(

            modifier = Modifier.fillMaxSize(),

            contentPadding = PaddingValues(

                vertical = AppSpacing.Medium

            )

        ) {

            item {

                ScreenHeader(

                    title = title,

                    subtitle = subtitle,

                    showBackButton = showBackButton,

                    onBackClick = onBackClick

                )

            }

            content()

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenScaffoldPreview() {

    ScreenScaffold(

        title = "Preview",

        subtitle = "Reusable screen scaffold"

    ) {

        item {

            SectionCard {

                SectionHeading(

                    text = "Example"

                )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/SectionCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun SectionCard(

    modifier: Modifier = Modifier,

    content: @Composable () -> Unit

) {

    Card(

        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Small
            ),

        shape = AppShapes.Card,

        elevation = CardDefaults.cardElevation(

            defaultElevation = AppElevation.Card

        ),

        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.surface

        )

    ) {

        Column(

            modifier = Modifier.padding(

                AppSpacing.Medium

            )

        ) {

            content()

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/SectionHeading.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun SectionHeading(

    text: String

) {

    Text(

        text = text,

        style = AppTypography.SectionHeading,

        color = MaterialTheme.colorScheme.onSurfaceVariant,

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = AppSpacing.Screen,
                end = AppSpacing.Screen,
                top = AppSpacing.Section,
                bottom = AppSpacing.Small
            )

    )

}

@Preview(showBackground = true)
@Composable
private fun SectionHeadingPreview() {

    MaterialTheme {

        SectionHeading(

            text = "Leagues"

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/StatusChip.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.design.AppSpacing
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment

@Composable
fun StatusChip(

    text: String,

    modifier: Modifier = Modifier

) {

    Card(

        modifier = modifier
            .width(AppDimensions.StatusChipWidth)
            .height(AppDimensions.StatusChipHeight),

        shape = AppShapes.Button,

        elevation = CardDefaults.cardElevation(
            defaultElevation = AppSpacing.ExtraSmall
        )

    ) {

        Box(

            modifier = Modifier.fillMaxSize(),

            contentAlignment = Alignment.Center

        ) {

            Text(

                text = text,

                style = MaterialTheme.typography.labelMedium,

                fontWeight = FontWeight.SemiBold

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ScheduledChipPreview() {

    MaterialTheme {

        StatusChip("15:00")

    }

}

@Preview(showBackground = true)
@Composable
private fun LiveChipPreview() {

    MaterialTheme {

        StatusChip("LIVE")

    }

}

@Preview(showBackground = true)
@Composable
private fun FinishedChipPreview() {

    MaterialTheme {

        StatusChip("FT")

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/TableDivider.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun TableDivider(

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = AppSpacing.Small
            ),

        verticalAlignment = Alignment.CenterVertically,

    ) {

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.outlineVariant
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.outlineVariant
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun EuropeQualificationDividerPreview() {

    MaterialTheme {

        TableDivider()

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/TopStandingsCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun TopStandingsCard(

    title: String = Strings.TOP_FIVE,
    //title = "Standings",

    standings: List<LeagueTableRowUiModel>,

    onTeamClick: (LeagueTableRowUiModel) -> Unit,

    onViewFullTable: () -> Unit,

    viewMoreText: String = Strings.VIEW_FULL_TABLE

) {

    SectionCard {

        SectionHeading(

            text = title

        )

        standings.forEach { standing ->

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                        onTeamClick(standing)

                    }
                    .padding(vertical = AppSpacing.Small),

                verticalAlignment = Alignment.CenterVertically

            ) {

                Text(

                    text = standing.position.toString(),

                    modifier = Modifier.width(AppSpacing.ExtraLarge),

                    fontWeight = FontWeight.Bold

                )

                Text(

                    text = standing.teamName,

                    modifier = Modifier.weight(1f)

                )

                Text(

                    text = "${standing.points} pts"

                )

            }

        }

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                    onViewFullTable()

                }
                .padding(top = AppSpacing.Medium),

            horizontalArrangement = Arrangement.End,

            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(

                text = viewMoreText,

                color = MaterialTheme.colorScheme.primary,

                style = MaterialTheme.typography.labelLarge

            )

            Icon(

                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

                contentDescription = null,

                tint = MaterialTheme.colorScheme.primary

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun TopStandingsCardPreview() {

    MaterialTheme {

        TopStandingsCard(

            standings = PreviewData.ScottishPremiershipTable,

            onTeamClick = {},

            onViewFullTable = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/design/Animation.kt
```kotlin
package com.example.footballapp.ui.design

class Animation {
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/design/AppConstants.kt
```kotlin
package com.example.footballapp.ui.design

object AppConstants {

    /**
     * Used for UI display.
     */
    const val CURRENT_SEASON = "2024/25"

    /**
     * Temporary development season used by backend requests.
     *
     * Remove once season selection becomes dynamic.
     */
    const val DEVELOPMENT_SEASON = 2024
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/design/AppSpacing.kt
```kotlin
package com.example.footballapp.ui.design

import androidx.compose.ui.unit.dp

object AppSpacing {

    val ExtraSmall = 4.dp

    val Small = 8.dp

    val Medium = 16.dp

    val Large = 24.dp

    val ExtraLarge = 32.dp

    val Screen = 24.dp

    val Section = 32.dp

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/design/Dimensions.kt
```kotlin
package com.example.footballapp.ui.design

class Dimensions {
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/design/Icons.kt
```kotlin
package com.example.footballapp.ui.design

class Icons {
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/design/Strings.kt
```kotlin
package com.example.footballapp.ui.design

object Strings {

    const val VIEW_FULL_TABLE = "View Full Table"
    const val LEAGUE_TABLE = "League Table"
    const val FIXTURES = "Fixtures"
    const val CLUBS = "Teams"
    const val TOP_FIVE = "Top 5"
    const val VIEW_COMPLETE_STANDINGS = "View complete standings"
    const val UPCOMING_FIXTURES = "Upcoming fixtures and results"
    const val BROWSE_ALL_CLUBS = "Browse all clubs"

    const val TABLE_POSITION = "#"

    const val TABLE_CLUB = "Club"
    const val TABLE_PLAYED = "P"
    const val TABLE_WINS = "W"
    const val TABLE_DRAWS = "D"
    const val TABLE_LOSSES = "L"
    const val TABLE_POINTS = "Pts"
    const val TABLE_TEAM = "Team"
    const val COMPETITIONS = "Competitions"
    const val CHOOSE_COMPETITION = "Choose a competition to explore."
    const val LEAGUES = "Leagues"
    const val DOMESTIC_CUPS = "Domestic Cups"
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/ClubDetailsUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class ClubDetailsUiModel(

    val clubId: Int,

    val name: String,

    val badgeUrl: String? = null,

    val league: String,

    val founded: Int? = null,

    val stadium: String? = null,

    val capacity: Int? = null,

    val manager: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/ClubUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class ClubUiModel(

    val clubId: Int,

    val name: String,

    val shortName: String? = null,

    val badgeUrl: String? = null,

    val stadium: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/CompetitionGroupUIModel.kt
```kotlin
package com.example.footballapp.ui.model

/**
 * Represents a group of competitions displayed on the
 * Competitions screen.
 *
 * Examples:
 * - Scotland
 * - England
 * - UEFA Competitions
 */
data class CompetitionGroupUiModel(

    /**
     * Section title.
     */
    val title: String,

    /**
     * Country flag emoji or future drawable/icon.
     */
    val headerIcon: String,

    /**
     * League competitions.
     */
    val leagues: List<CompetitionUiModel>,

    /**
     * Domestic cup competitions.
     *
     * Empty for UEFA.
     */
    val domesticCups: List<CompetitionUiModel>,

    /**
     * Allows groups to be displayed in a particular order.
     */
    val displayOrder: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/CompetitionType.kt
```kotlin
package com.example.footballapp.ui.model

/**
 * Type of competition displayed by the UI.
 */
enum class CompetitionType {

    LEAGUE,

    DOMESTIC_CUP,

    UEFA

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/CompetitionUiModel.kt
```kotlin
package com.example.footballapp.ui.model

import android.R

/**
 * Represents a football competition as displayed by the UI.
 *
 * This model is independent of the backend DTOs and exists purely
 * to provide the data required by the Compose components.
 */
data class CompetitionUiModel(

    /**
     * Unique competition identifier.
     */
    val id: Int,

    /**
     * Competition name displayed to the user.
     */
    val name: String,

    /**
     * URL of the competition logo.
     */
    val logoUrl: String

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/FixtureDayUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class FixtureDayUiModel(

    val heading: String,

    val fixtures: List<FixtureUiModel>

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/FixtureStatus.kt
```kotlin
package com.example.footballapp.ui.model

/**
 * Represents the presentation state of a fixture.
 *
 * The backend is responsible for mapping API-Football
 * status codes to these UI-friendly values.
 */
enum class FixtureStatus {

    /**
     * Match has not yet started.
     */
    SCHEDULED,

    /**
     * Match is currently being played.
     */
    LIVE,

    /**
     * Half-time interval.
     */
    HALF_TIME,

    /**
     * Match has finished.
     */
    FINISHED,

    /**
     * Match has gone to extra time.
     */
    EXTRA_TIME,

    /**
     * Match is being decided by penalties.
     */
    PENALTIES,

    /**
     * Match has been postponed.
     */
    POSTPONED,

    /**
     * Match has been cancelled.
     */
    CANCELLED

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/FixtureUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class FixtureUiModel(

    val fixtureId: Long,

    val fixtureDate: String,

    val homeTeamId: Int,
    val homeTeamName: String,
    val homeTeamLogo: String? = null,

    val awayTeamId: Int,
    val awayTeamName: String,
    val awayTeamLogo: String? = null,

    val kickOff: String,

    val status: FixtureStatus,

    val homeScore: Int? = null,
    val awayScore: Int? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/LeagueOverviewUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class LeagueOverviewUiModel(
    val leagueId: Int,
    val leagueName: String,
    val season: String,
    val teamCount: Int,
    val fixtureCount: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/LeagueTableRowUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class LeagueTableRowUiModel(

    val position: Int,

    val teamId: Int,

    val teamName: String,

    val teamLogo: String? =null,

    val played: Int,

    val wins: Int,

    val draws: Int,

    val losses: Int,

    val goalDifference: Int,

    val points: Int,

    val qualification: QualificationType,

    /**
     * Reserved for a future release.
     * Examples:
     * "WWDLW"
     * "LWWDW"
     */
    val form: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/PlayerDetailsUiModel.kt
```kotlin
package com.example.footballapp.ui.model

/**
 * UI model representing detailed player information.
 *
 * Used by:
 * - PlayerDetailsScreen
 */
data class PlayerDetailsUiModel(

    val playerId: Int,

    val name: String,

    val photoUrl: String?,

    val shirtNumber: Int?,

    val position: String,

    val nationality: String?,

    val dateOfBirth: String?,

    val age: Int?,

    val height: String?,

    val weight: String?,

    val preferredFoot: String?,

    val captain: Boolean,

    val appearances: Int?,

    val goals: Int?,

    val assists: Int?,

    val yellowCards: Int?,

    val redCards: Int?,

    val minutesPlayed: Int?

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/PlayerUiModel.kt
```kotlin
package com.example.footballapp.ui.model

/**
 * UI model representing a player in a club squad.
 *
 * Used by:
 * - PlayerRow
 * - PlayerList
 * - SquadScreen
 */
data class PlayerUiModel(

    val playerId: Int,

    val shirtNumber: Int?,

    val name: String,

    val position: String

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/QualificationType.kt
```kotlin
package com.example.footballapp.ui.model

enum class QualificationType {

    CHAMPION,

    SAFE,

    RELEGATION

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/StandingUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class StandingUiModel(

    val position: Int,

    val teamId: Int,

    val teamName: String,

    val points: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/navigation/DemoData.kt
```kotlin
package com.example.footballapp.ui.navigation

import com.example.footballapp.ui.previews.PreviewData

object DemoData {

    val competitionGroups = listOf(
        PreviewData.Scotland
    )

    val competition = PreviewData.ScottishPremiership

    val clubs = PreviewData.ScottishPremiershipClubList

    val club = PreviewData.RangersDetails

    val squad = PreviewData.RangersSquad

    val player = PreviewData.JamesTavernierDetails

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/navigation/FootballDestination.kt
```kotlin
package com.example.footballapp.ui.navigation

sealed class FootballDestination(
    val route: String
) {

    object Competitions :
        FootballDestination(
            "competitions"
        )

    // -------------------------------------------------------------------------
    // Competition
    // -------------------------------------------------------------------------

    object LeagueOverview :
        FootballDestination(
            "leagueOverview/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "leagueOverview/$leagueId"

    }

    object LeagueTable :
        FootballDestination(
            "leagueTable/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "leagueTable/$leagueId"

    }

    object Fixtures :
        FootballDestination(
            "fixtures/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "fixtures/$leagueId"

    }

    object Clubs :
        FootballDestination(
            "clubs/{leagueId}"
        ) {

        fun createRoute(
            leagueId: Int
        ) = "clubs/$leagueId"

    }

    // -------------------------------------------------------------------------
    // Club
    // -------------------------------------------------------------------------

    object Club :
        FootballDestination(
            "club/{clubId}"
        ) {

        fun createRoute(
            clubId: Int
        ) = "club/$clubId"

    }

    object Squad :
        FootballDestination(
            "squad/{clubId}"
        ) {

        fun createRoute(
            clubId: Int
        ) = "squad/$clubId"

    }

    // -------------------------------------------------------------------------
    // Player
    // -------------------------------------------------------------------------

    object PlayerDetails :
        FootballDestination(
            "player/{playerId}"
        ) {

        fun createRoute(
            playerId: Int
        ) = "player/$playerId"

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/navigation/FootballNavhost.kt
```kotlin
package com.example.footballapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.screens.CompetitionsScreen
import com.example.footballapp.ui.screens.club.ClubScreen
import com.example.footballapp.ui.screens.clubs.ClubsScreen
import com.example.footballapp.ui.screens.fixtures.FixturesScreen
import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
import com.example.footballapp.ui.screens.league.LeagueTableScreen
import com.example.footballapp.ui.screens.player.PlayerDetailsScreen
import com.example.footballapp.ui.screens.squad.SquadScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.ui.viewmodel.ClubsViewModel
import com.example.footballapp.ui.viewmodel.CompetitionViewModel
import com.example.footballapp.ui.viewmodel.FixturesViewModel
import com.example.footballapp.ui.viewmodel.LeagueOverviewViewModel
import com.example.footballapp.ui.viewmodel.LeagueTableViewModel


@Composable
fun FootballNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FootballDestination.Competitions.route
    ) {

        /**
         * Competitions
         */
        composable(
            FootballDestination.Competitions.route
        ) {

            val viewModel: CompetitionViewModel = viewModel()

            val uiState by
            viewModel.uiState.collectAsState()

            CompetitionsScreen(

                competitionGroups =
                    uiState.competitionGroups,

                onCompetitionSelected = { competition ->

                    navController.navigate(

                        FootballDestination
                            .LeagueOverview
                            .createRoute(
                                competition.id)

                    )

                }

            )

        }

        /**
         * League Overview
         */

        composable(
            route = FootballDestination.LeagueOverview.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

            }

            val uiState by
            overviewViewModel.uiState.collectAsState()

            uiState.overview?.let { overview ->

                LeagueOverviewScreen(

                    overview = overview,

                    topStandings = uiState.topStandings,

                    onLeagueTableClick = {

                        navController.navigate(
                            FootballDestination
                                .LeagueTable
                                .createRoute(leagueId)
                        )

                    },

                    onFixturesClick = {

                        navController.navigate(
                            FootballDestination
                                .Fixtures
                                .createRoute(leagueId)
                        )

                    },

                    onClubsClick = {

                        navController.navigate(
                            FootballDestination
                                .Clubs
                                .createRoute(leagueId)
                        )

                    },

                    onClubClick = { clubId ->

                        navController.navigate(
                            FootballDestination
                                .Club
                                .createRoute(clubId)
                        )

                    }

                )

            }

        }

        /**
         * League Table
         */

        composable(
            route = FootballDestination.LeagueTable.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()
            val tableViewModel: LeagueTableViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

                tableViewModel.loadLeagueTable(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val tableState by
            tableViewModel.uiState.collectAsState()

            overviewState.overview?.let { overview ->

                LeagueTableScreen(

                    overview = overview,

                    standings = tableState.table,

                    onClubClick = { clubId ->

                        navController.navigate(

                            FootballDestination
                                .Club
                                .createRoute(clubId)

                        )

                    }

                )

            }

        }

        /**
         * Fixtures
         */

        composable(
            route = FootballDestination.Fixtures.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()
            val fixturesViewModel: FixturesViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

                fixturesViewModel.loadFixtures(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val fixturesState by
            fixturesViewModel.uiState.collectAsState()

            overviewState.overview?.let { overview ->

                FixturesScreen(

                    competitionName = overview.leagueName,

                    season = overview.season,

                    fixtureDays = fixturesState.fixtureDays,

                    onFixtureSelected = { fixtureId ->

                        // We'll wire this up later
                    }

                )

            }

        }

        /**
         * Clubs
         */

        composable(
            route = FootballDestination.Clubs.route
        ) { backStackEntry ->

            val leagueId =
                backStackEntry.arguments
                    ?.getString("leagueId")
                    ?.toInt()
                    ?: return@composable

            val overviewViewModel: LeagueOverviewViewModel = viewModel()
            val clubsViewModel: ClubsViewModel = viewModel()

            LaunchedEffect(leagueId) {

                overviewViewModel.loadLeagueOverview(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

                clubsViewModel.loadClubs(
                    leagueId,
                    AppConstants.DEVELOPMENT_SEASON
                )

            }

            val overviewState by
            overviewViewModel.uiState.collectAsState()

            val clubsState by
            clubsViewModel.uiState.collectAsState()

            overviewState.overview?.let { overview ->

                ClubsScreen(

                    competitionName = overview.leagueName,

                    season = overview.season,

                    clubs = clubsState.clubs,

                    onClubClick = { clubId ->

                        navController.navigate(

                            FootballDestination
                                .Club
                                .createRoute(clubId)

                        )

                    }

                )

            }

        }

        /**
         * Club
         */

        composable(
            FootballDestination.Club.route
        ) {

            ClubScreen(

                club = DemoData.club,

                onFixturesClick = {

                    navController.navigate(
                        FootballDestination.Fixtures.route
                    )

                },

                onSquadClick = {

                    navController.navigate(
                        FootballDestination.Squad.route
                    )

                }

            )

        }

       /**
        * Squad
        */
        composable(
            FootballDestination.Squad.route
        ) {

            SquadScreen(

                clubName = DemoData.club.name,

                season = AppConstants.CURRENT_SEASON,

                players = DemoData.squad,

                onPlayerClick = { _ ->

                    navController.navigate(
                        FootballDestination.PlayerDetails.route
                    )

                }

            )

        }

        /**
         * Player Details
         */

        composable(
            FootballDestination.PlayerDetails.route
        ) {

            PlayerDetailsScreen(

                player = DemoData.player

            )

        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/previews/PreviewData.kt
```kotlin
package com.example.footballapp.ui.previews

import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType
import com.example.footballapp.ui.model.StandingUiModel
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.model.PlayerUiModel
import com.example.footballapp.ui.model.PlayerDetailsUiModel

object PreviewData {

    // -------------------------------------------------------------------------
    // Scotland - Leagues
    // -------------------------------------------------------------------------

    val ScottishPremiership = CompetitionUiModel(
        id = 179,
        name = "Scottish Premiership",
        //season = "2024/25",
        logoUrl = ""
    )

    val ScottishChampionship = CompetitionUiModel(
        id = 180,
        name = "Scottish Championship",
        //season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueOne = CompetitionUiModel(
        id = 181,
        name = "Scottish League One",
        //season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueTwo = CompetitionUiModel(
        id = 182,
        name = "Scottish League Two",
        //season = "2025/26",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Scotland - Domestic Cups
    // -------------------------------------------------------------------------

    val ScottishCup = CompetitionUiModel(
        id = 183,
        name = "Scottish Cup",
        //season = "2025/26",
        logoUrl = ""
    )

    val LeagueCup = CompetitionUiModel(
        id = 184,
        name = "League Cup",
        //season = "2025/26",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Competition Groups
    // -------------------------------------------------------------------------

    val Scotland = CompetitionGroupUiModel(

        displayOrder = 1,

        title = "Scotland",

        headerIcon = "🏴",

        leagues = listOf(
            ScottishPremiership,
            ScottishChampionship,
            ScottishLeagueOne,
            ScottishLeagueTwo
        ),

        domesticCups = listOf(
            ScottishCup,
            LeagueCup
        )

    )

    // ---------------------------------------------------------------------
    // Standings
    // ---------------------------------------------------------------------
    val ScottishPremiershipStandings = listOf(

        StandingUiModel(
            position = 1,
            teamId = 1,
            teamName = "Celtic",
            points = 86
        ),

        StandingUiModel(
            position = 2,
            teamId = 2,
            teamName = "Rangers",
            points = 82
        ),

        StandingUiModel(
            position = 3,
            teamId = 3,
            teamName = "Hibernian",
            points = 68
        ),

        StandingUiModel(
            position = 4,
            teamId = 4,
            teamName = "Aberdeen",
            points = 61
        ),

        StandingUiModel(
            position = 5,
            teamId = 5,
            teamName = "Hearts",
            points = 59
        ),

        StandingUiModel(
            position = 6,
            teamId = 11,
            teamName = "Ross County",
            points = 33
        ),

        StandingUiModel(
            position = 7,
            teamId = 12,
            teamName = "St Johnstone",
            points = 29
        )

    )

// -----------------------------------------------------------------------------
// League Table Preview Data
// -----------------------------------------------------------------------------

    val ScottishPremiershipTable = listOf(

        LeagueTableRowUiModel(
            position = 1,
            teamId = 1,
            teamName = "Celtic",
            played = 38,
            wins = 29,
            draws = 4,
            losses = 5,
            goalDifference = 42,
            points = 91,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 2,
            teamId = 2,
            teamName = "Rangers",
            played = 38,
            wins = 27,
            draws = 3,
            losses = 8,
            goalDifference = 42,
            points = 84,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 3,
            teamId = 3,
            teamName = "Hibernian",
            played = 38,
            wins = 18,
            draws = 11,
            losses = 9,
            goalDifference = 42,
            points = 65,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 4,
            teamId = 4,
            teamName = "Aberdeen",
            played = 38,
            wins = 17,
            draws = 10,
            losses = 11,
            goalDifference = 42,
            points = 61,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 5,
            teamId = 5,
            teamName = "Hearts",
            played = 38,
            wins = 16,
            draws = 8,
            losses = 14,
            goalDifference = 42,
            points = 56,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 6,
            teamId = 6,
            teamName = "Motherwell",
            played = 38,
            wins = 15,
            draws = 9,
            losses = 14,
            goalDifference = 42,
            points = 54,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 7,
            teamId = 7,
            teamName = "St Mirren",
            played = 38,
            wins = 13,
            draws = 11,
            losses = 14,
            goalDifference = 42,
            points = 50,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 8,
            teamId = 8,
            teamName = "Dundee United",
            played = 38,
            wins = 13,
            draws = 9,
            losses = 16,
            goalDifference = 42,
            points = 48,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 9,
            teamId = 9,
            teamName = "Kilmarnock",
            played = 38,
            wins = 11,
            draws = 10,
            losses = 17,
            goalDifference = 42,
            points = 43,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 10,
            teamId = 10,
            teamName = "Dundee",
            played = 38,
            wins = 10,
            draws = 8,
            losses = 20,
            goalDifference = 42,
            points = 38,
            qualification = QualificationType.SAFE
        ),

        LeagueTableRowUiModel(
            position = 11,
            teamId = 11,
            teamName = "Ross County",
            played = 38,
            wins = 8,
            draws = 9,
            losses = 21,
            goalDifference = 42,
            points = 33,
            qualification = QualificationType.RELEGATION
        ),

        LeagueTableRowUiModel(
            position = 12,
            teamId = 12,
            teamName = "St Johnstone",
            played = 38,
            wins = 7,
            draws = 8,
            losses = 23,
            goalDifference = 42,
            points = 29,
            qualification = QualificationType.RELEGATION
        )

    )

    // -----------------------------------------------------------------------------
// Fixture Preview Data
// -----------------------------------------------------------------------------

    val CelticVsRangers = FixtureUiModel(

        fixtureId = 1001L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",
        homeTeamLogo = null,

        awayTeamId = 2,
        awayTeamName = "Rangers",
        awayTeamLogo = null,

        kickOff = "15:00",

        status = FixtureStatus.SCHEDULED

    )

    val HeartsVsAberdeen = FixtureUiModel(

        fixtureId = 1002L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 5,
        homeTeamName = "Hearts",
        homeTeamLogo = null,

        awayTeamId = 4,
        awayTeamName = "Aberdeen",
        awayTeamLogo = null,

        kickOff = "15:00",

        status = FixtureStatus.SCHEDULED

    )

    val HibernianVsDundeeUnited = FixtureUiModel(

        fixtureId = 1003L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 3,
        homeTeamName = "Hibernian",
        homeTeamLogo = null,

        awayTeamId = 8,
        awayTeamName = "Dundee United",
        awayTeamLogo = null,

        kickOff = "17:30",

        status = FixtureStatus.SCHEDULED

    )

    /**
     * Postponed Game
     */
    val RossCountyVsStJohnstone = FixtureUiModel(

        fixtureId = 4,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 11,
        homeTeamName = "Ross County",

        awayTeamId = 12,
        awayTeamName = "St Johnstone",

        kickOff = "19:45",

        status = FixtureStatus.POSTPONED

    )

    // Fixtures Heading
    val ScottishPremiershipFixtures = FixtureDayUiModel(

        heading = "Today - Saturday 20th June",

        fixtures = listOf(

            CelticVsRangers,

            HeartsVsAberdeen,

            HibernianVsDundeeUnited,

            RossCountyVsStJohnstone

        )

    )

    /**
     * Today's Fixtures
     */
    val TodayFixtures = FixtureDayUiModel(

        heading = "Today • Saturday 20th June",

        fixtures = listOf(

            HeartsVsAberdeen,        // LIVE

            HibernianVsDundeeUnited  // FT

        )

    )

    /**
     * Tomorrow's Fixtures
     */
    val TomorrowFixtures = FixtureDayUiModel(

        heading = "Tomorrow • Sunday 21st June",

        fixtures = listOf(

            CelticVsRangers,

            RossCountyVsStJohnstone

        )

    )

    /**
     * Live Game
     */
    val CelticVsRangersLive = FixtureUiModel(

        fixtureId = 1004L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.LIVE,

        homeScore = 2,

        awayScore = 1

    )

    /**
     * Scheduled Game
     */
    val CelticVRangers = FixtureUiModel(

        fixtureId = 1,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.SCHEDULED

    )

    /**
     * Finished Game
     */
    val CelticVsRangersFinished = FixtureUiModel(

        fixtureId = 1005L,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.FINISHED,

        homeScore = 3,

        awayScore = 0

    )

    /**
     * Penalty Shoot-out
     */
    val ScottishCupFinal = FixtureUiModel(

        fixtureId = 5,

        fixtureDate = "Sat 03 Aug 2024",

        homeTeamId = 1,
        homeTeamName = "Celtic",

        awayTeamId = 2,
        awayTeamName = "Rangers",

        kickOff = "15:00",

        status = FixtureStatus.PENALTIES,

        homeScore = 4,

        awayScore = 4

    )

    /**
     * Initialise Clubs
     */
    val Celtic = ClubUiModel(

        clubId = 1,

        name = "Celtic",

        shortName = "Celtic",

        badgeUrl = null,

        stadium = "Celtic Park"

    )

    val Rangers = ClubUiModel(

        clubId = 2,

        name = "Rangers",

        shortName = "Rangers",

        badgeUrl = null,

        stadium = "Ibrox Stadium"

    )

    val Hibernian = ClubUiModel(

        clubId = 3,

        name = "Hibernian",

        shortName = "Hibernian",

        badgeUrl = null,

        stadium = "Easter Road"

    )

    val Hearts = ClubUiModel(

        clubId = 4,

        name = "Heart of Midlothian",

        shortName = "Hearts",

        badgeUrl = null,

        stadium = "Tynecastle Park"

    )

    val Aberdeen = ClubUiModel(

        clubId = 5,

        name = "Aberdeen",

        shortName = "Aberdeen",

        badgeUrl = null,

        stadium = "Pittodrie Stadium"

    )

    /**
     * Clubs List
     * Initialised above.
     */
    val ScottishPremiershipClubList = listOf(

        Celtic,

        Rangers,

        Hibernian,

        Hearts,

        Aberdeen

    )

    /**
     * Club Details
     */
    val CelticDetails = ClubDetailsUiModel(

        clubId = 1,

        name = "Celtic",

        badgeUrl = null,

        league = "Scottish Premiership",

        founded = 1887,

        stadium = "Celtic Park",

        capacity = 60411,

        manager = "Brendan Rodgers"

    )

    val RangersDetails = ClubDetailsUiModel(

        clubId = 2,

        name = "Rangers",

        badgeUrl = null,

        league = "Scottish Premiership",

        founded = 1872,

        stadium = "Ibrox Stadium",

        capacity = 50817,

        manager = "Russell Martin"

    )

    /**
     * Rangers Squad
     */
    val RangersSquad = listOf(

        // Goalkeepers

        PlayerUiModel(
            playerId = 1,
            shirtNumber = 1,
            name = "Jack Butland",
            position = "Goalkeeper"
        ),

        PlayerUiModel(
            playerId = 2,
            shirtNumber = 31,
            name = "Liam Kelly",
            position = "Goalkeeper"
        ),

        // Defenders

        PlayerUiModel(
            playerId = 3,
            shirtNumber = 2,
            name = "James Tavernier",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 4,
            shirtNumber = 4,
            name = "Robin Pröpper",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 5,
            shirtNumber = 5,
            name = "John Souttar",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 6,
            shirtNumber = 19,
            name = "Clinton Nsiala",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 7,
            shirtNumber = 22,
            name = "Jefte",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 8,
            shirtNumber = 27,
            name = "Dujon Sterling",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 9,
            shirtNumber = 33,
            name = "Ridvan Yılmaz",
            position = "Defender"
        ),

        PlayerUiModel(
            playerId = 10,
            shirtNumber = 45,
            name = "Leon King",
            position = "Defender"
        ),

        // Midfielders

        PlayerUiModel(
            playerId = 11,
            shirtNumber = 8,
            name = "Mohamed Diomande",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 12,
            shirtNumber = 10,
            name = "Nicolas Raskin",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 13,
            shirtNumber = 43,
            name = "Connor Barron",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 14,
            shirtNumber = 49,
            name = "Bailey Rice",
            position = "Midfielder"
        ),

        PlayerUiModel(
            playerId = 15,
            shirtNumber = 52,
            name = "Findlay Curtis",
            position = "Midfielder"
        ),

        // Forwards

        PlayerUiModel(
            playerId = 16,
            shirtNumber = 9,
            name = "Cyriel Dessers",
            position = "Forward"
        ),

        PlayerUiModel(
            playerId = 17,
            shirtNumber = 11,
            name = "Oscar Cortés",
            position = "Forward"
        ),

        PlayerUiModel(
            playerId = 18,
            shirtNumber = 18,
            name = "Vaclav Cerny",
            position = "Forward"
        ),

        PlayerUiModel(
            playerId = 19,
            shirtNumber = 29,
            name = "Hamza Igamane",
            position = "Forward"
        ),

        PlayerUiModel(
            playerId = 20,
            shirtNumber = 99,
            name = "Danilo",
            position = "Forward"
        )

    )

    /**
     * Player Details
     */
    val JamesTavernierDetails = PlayerDetailsUiModel(

        playerId = 1,

        name = "James Tavernier",

        photoUrl = null,

        shirtNumber = 2,

        position = "Defender",

        nationality = "England",

        dateOfBirth = "31 October 1991",

        age = 34,

        height = "182 cm",

        weight = "76 kg",

        preferredFoot = "Right",

        captain = true,

        appearances = 36,

        goals = 5,

        assists = 8,

        yellowCards = 4,

        redCards = 0,

        minutesPlayed = 3142

    )

    val JackButlandDetails = PlayerDetailsUiModel(

        playerId = 2,

        name = "Jack Butland",

        photoUrl = null,

        shirtNumber = 1,

        position = "Goalkeeper",

        nationality = "England",

        dateOfBirth = "10 March 1993",

        age = 33,

        height = "196 cm",

        weight = "95 kg",

        preferredFoot = "Right",

        captain = false,

        appearances = 34,

        goals = 0,

        assists = 0,

        yellowCards = 1,

        redCards = 0,

        minutesPlayed = 3060

    )


}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/club/ClubScreen.kt
```kotlin
package com.example.footballapp.ui.screens.club

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.ClubBadge
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun ClubScreen(

    club: ClubDetailsUiModel,

    onSquadClick: (Int) -> Unit,

    onFixturesClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = club.name,

        subtitle = club.league

    ) {

        item {

            Column(

                modifier = Modifier.fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally,

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Medium
                )

            ) {

                ClubBadge(

                    logoUrl = club.badgeUrl,

                    modifier = Modifier.size(
                        AppDimensions.ImageLarge
                    )

                )

            }

        }

        item {

            SectionCard {

                InfoRow(
                    label = "Founded",
                    value = club.founded?.toString()
                )

                InfoRow(
                    label = "Stadium",
                    value = club.stadium
                )

                InfoRow(
                    label = "Capacity",
                    value = club.capacity?.toString()
                )

                InfoRow(
                    label = "Manager",
                    value = club.manager
                )

            }

        }

        item {

            NavigationCard(

                title = "Squad",

                subtitle = "Browse players",

                onClick = {

                    onSquadClick(

                        club.clubId

                    )

                }

            )

        }

        item {

            NavigationCard(

                title = "Fixtures",

                subtitle = "View club fixtures",

                onClick = {

                    onFixturesClick(

                        club.clubId

                    )

                }

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ClubScreenPreview() {

    MaterialTheme {

        ClubScreen(

            club = PreviewData.RangersDetails,

            onSquadClick = {},

            onFixturesClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/clubs/ClubsScreen.kt
```kotlin
package com.example.footballapp.ui.screens.clubs

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.example.footballapp.ui.components.ClubList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun ClubsScreen(

    competitionName: String,

    season: String,

    clubs: List<ClubUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = competitionName,

        subtitle = season

    ) {

        item {

            SectionCard {

                ClubList(

                    clubs = clubs,

                    onClubClick = { club ->

                        onClubClick(

                            club.clubId

                        )

                    }

                )

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ClubsScreenPreview() {

    MaterialTheme {

        ClubsScreen(

            competitionName = "Scottish Premiership",

            season = "2025/26",

            clubs = PreviewData.ScottishPremiershipClubList,

            onClubClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/competitions/CompetitionsScreen.kt
```kotlin
package com.example.footballapp.ui.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

@Composable
fun CompetitionsScreen(

    competitionGroups: List<CompetitionGroupUiModel>,

    onCompetitionSelected: (CompetitionUiModel) -> Unit = {}

) {

    ScreenScaffold(

        title = Strings.COMPETITIONS,

        subtitle = Strings.CHOOSE_COMPETITION

    ) {

        items(competitionGroups) { group ->

            SectionCard {

                Text(

                    text = "${group.headerIcon} ${group.title}",

                    style = MaterialTheme.typography.titleLarge

                )

                if (group.leagues.isNotEmpty()) {

                    SectionHeading(

                        text = Strings.LEAGUES

                    )

                    CompetitionList(

                        competitions = group.leagues,

                        onCompetitionSelected = { competition ->

                            onCompetitionSelected(
                                competition
                            )

                        }

                    )

                }

                if (group.domesticCups.isNotEmpty()) {

                    SectionHeading(

                        text = Strings.DOMESTIC_CUPS

                    )

                    CompetitionList(

                        competitions = group.domesticCups,

                        onCompetitionSelected = { competition ->

                            onCompetitionSelected(
                                competition
                            )

                        }

                    )

                }

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/fixtures/FixturesScreen.kt
```kotlin
package com.example.footballapp.ui.screens.fixtures

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.example.footballapp.ui.components.FixtureCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.previews.PreviewData
import androidx.compose.foundation.lazy.items

@Composable
fun FixturesScreen(

    competitionName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long) -> Unit

) {

    ScreenScaffold(

        title = competitionName,

        subtitle = season

    ) {

        fixtureDays.forEach { day ->

            item {

                SectionHeading(

                    day.heading

                )

            }

            items(

                items = day.fixtures,

                key = { it.fixtureId }

            ) { fixture ->

                FixtureCard(

                    fixture = fixture,

                    onClick = {

                        onFixtureSelected(

                            fixture.fixtureId

                        )

                    }

                )

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun FixturesScreenPreview() {

    MaterialTheme {

        FixturesScreen(

            competitionName = "Scottish Premiership",

            season = "2025/26",

            fixtureDays = listOf(

                PreviewData.TodayFixtures,

                PreviewData.TomorrowFixtures

            ),

            onFixtureSelected = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/league/LeagueOverviewScreen.kt
```kotlin
package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.TopStandingsCard
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun LeagueOverviewScreen(

    overview: LeagueOverviewUiModel,

    onLeagueTableClick: () -> Unit = {},

    topStandings: List<LeagueTableRowUiModel>,

    onFixturesClick: () -> Unit = {},

    onClubsClick: () -> Unit = {},

    onClubClick: (Int) -> Unit = {}

) {

    ScreenScaffold(

        title = overview.leagueName,

        subtitle = "Season ${overview.season}"

    ) {

        item {

            TopStandingsCard(

                standings = topStandings,

                onTeamClick = {

                    onClubClick(it.teamId)

                },

                onViewFullTable = onLeagueTableClick

            )

        }

        item {

            NavigationCard(

                title = Strings.LEAGUE_TABLE,

                subtitle = Strings.VIEW_COMPLETE_STANDINGS,

                onClick = onLeagueTableClick

            )

        }

        item {

            NavigationCard(

                title = Strings.FIXTURES,

                subtitle = Strings.UPCOMING_FIXTURES,

                onClick = onFixturesClick

            )

        }

        item {

            NavigationCard(

                title = Strings.CLUBS,

                subtitle = Strings.BROWSE_ALL_CLUBS,

                onClick = onClubsClick

            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LeagueOverviewScreenPreview() {

    LeagueOverviewScreen(

        overview = LeagueOverviewUiModel(

            leagueId = 179,

            leagueName = "Scottish Premiership",

            season = AppConstants.CURRENT_SEASON,

            teamCount = 12,

            fixtureCount = 228

        ),
        topStandings =
            PreviewData
                .ScottishPremiershipTable
                .take(5)

    )

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/league/LeagueTableScreen.kt
```kotlin
package com.example.footballapp.ui.screens.league

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.FootballAppTheme

@Composable
fun LeagueTableScreen(

    overview: LeagueOverviewUiModel,

    standings: List<LeagueTableRowUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = overview.leagueName,

        subtitle = AppConstants.CURRENT_SEASON

    ) {

        item {

            LeagueTableCard(

                table = standings,

                onTeamClick = onClubClick

            )

        }

    }

}

//@Preview(showBackground = true)
//@Composable
//private fun LeagueTableScreenPreview() {
//
//    FootballAppTheme {
//
//        LeagueTableScreen(
//
//            competition = PreviewData.ScottishPremiership,
//
//            standings = PreviewData.ScottishPremiershipTable,
//
//            onClubClick = {}
//
//        )
//
//    }
//
//}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/player/PlayerDetailsSceen.kt
```kotlin
package com.example.footballapp.ui.screens.player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.PlayerPhoto
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.PlayerDetailsUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun PlayerDetailsScreen(

    player: PlayerDetailsUiModel

) {

    ScreenScaffold(

        title = player.name,

        subtitle = player.position

    ) {

        item {

            Column(

                modifier = Modifier.fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                PlayerPhoto(

                    photoUrl = player.photoUrl,

                    modifier = Modifier.size(
                        AppDimensions.ImageLarge
                    )

                )

            }

        }

        item {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Small
                )

            ) {

                SectionHeading(
                    text = "Player"
                )

                SectionCard {

                    InfoRow(
                        label = "Shirt Number",
                        value = player.shirtNumber?.toString()
                    )

                    InfoRow(
                        label = "Position",
                        value = player.position
                    )

                    InfoRow(
                        label = "Preferred Foot",
                        value = player.preferredFoot
                    )

                    InfoRow(
                        label = "Captain",
                        value = if (player.captain) "Yes" else "No"
                    )

                }

            }

        }

        item {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Small
                )

            ) {

                SectionHeading(
                    text = "Personal"
                )

                SectionCard {

                    InfoRow(
                        label = "Nationality",
                        value = player.nationality
                    )

                    InfoRow(
                        label = "Date of Birth",
                        value = player.dateOfBirth
                    )

                    InfoRow(
                        label = "Age",
                        value = player.age?.toString()
                    )

                    InfoRow(
                        label = "Height",
                        value = player.height
                    )

                    InfoRow(
                        label = "Weight",
                        value = player.weight
                    )

                }

            }

        }

        item {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.Small
                )

            ) {

                SectionHeading(
                    text = "Season Statistics"
                )

                SectionCard {

                    InfoRow(
                        label = "Appearances",
                        value = player.appearances?.toString()
                    )

                    InfoRow(
                        label = "Goals",
                        value = player.goals?.toString()
                    )

                    InfoRow(
                        label = "Assists",
                        value = player.assists?.toString()
                    )

                    InfoRow(
                        label = "Yellow Cards",
                        value = player.yellowCards?.toString()
                    )

                    InfoRow(
                        label = "Red Cards",
                        value = player.redCards?.toString()
                    )

                    InfoRow(
                        label = "Minutes Played",
                        value = player.minutesPlayed?.toString()
                    )

                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PlayerDetailsScreenPreview() {

    MaterialTheme {

        PlayerDetailsScreen(

            player = PreviewData.JamesTavernierDetails

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/squad/SquadScreen.kt
```kotlin
package com.example.footballapp.ui.screens.squad

import com.example.footballapp.ui.model.PlayerUiModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.playerList
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun SquadScreen(

    clubName: String,

    season: String,

    players: List<PlayerUiModel>,

    onPlayerClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = clubName,

        subtitle = season

    ) {

        playerList(

            players = players,

            onPlayerClick = { player ->

                onPlayerClick(

                    player.playerId

                )

            }

        )

    }

}

@Preview(showBackground = true)
@Composable
private fun SquadScreenPreview() {

    MaterialTheme {

        SquadScreen(

            clubName = "Rangers",

            season = "2025/26",

            players = PreviewData.RangersSquad,

            onPlayerClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/AppDimensions.kt
```kotlin
package com.example.footballapp.ui.theme

import androidx.compose.ui.unit.dp

object AppDimensions {

    val CompetitionLogo = 36.dp

    val ImageSmall = 24.dp
    val ImageMedium = 36.dp

    val ImageLarge = 56.dp

    val PlayerPhoto = 96.dp
    val StatusChipHeight = 28.dp
    val StatusChipWidth = 64.dp

    val CompetitionRowHeight = 64.dp

    val TablePositionWidth = 22.dp

    val TableStatWidth = 28.dp
    val BadgeBorder = 1.dp

    val FixtureCentreWidth = 80.dp

    val ShirtNumberWidth = 32.dp

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/AppElevation.kt
```kotlin
package com.example.footballapp.ui.theme

import androidx.compose.ui.unit.dp

object AppElevation {

    val Card = 4.dp

    val Dialog = 8.dp

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/AppShapes.kt
```kotlin
package com.example.footballapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object AppShapes {

    val Card = RoundedCornerShape(20.dp)

    val Button = RoundedCornerShape(12.dp)

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/AppTypography.kt
```kotlin
package com.example.footballapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

object AppTypography {

    val ScreenTitle: TextStyle
        @Composable
        get() = MaterialTheme.typography.headlineLarge

    val ScreenSubtitle: TextStyle
        @Composable
        get() = MaterialTheme.typography.bodyLarge

    val SectionHeading: TextStyle
        @Composable
        get() = MaterialTheme.typography.titleMedium

    val Body: TextStyle
        @Composable
        get() = MaterialTheme.typography.bodyLarge

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/Color.kt
```kotlin
package com.example.footballapp.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/Theme.kt
```kotlin
package com.example.footballapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun FootballAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/Type.kt
```kotlin
package com.example.footballapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubsUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.ClubUiModel

data class ClubsUiState(

    val isLoading: Boolean = true,

    val clubs: List<ClubUiModel> = emptyList(),

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubsViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.TeamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubsViewModel : ViewModel() {

    private val repository =
        TeamRepository()

    private val _uiState =
        MutableStateFlow(
            ClubsUiState()
        )

    val uiState: StateFlow<ClubsUiState> =
        _uiState.asStateFlow()

    fun loadClubs(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            try {

                val clubs =
                    repository
                        .getTeams(
                            leagueId,
                            season
                        )
                        .map {
                            it.toUiModel()
                        }

                _uiState.value =
                    ClubsUiState(

                        isLoading = false,

                        clubs = clubs

                    )

            } catch (e: Exception) {

                _uiState.value =
                    ClubsUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/CompetitionUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

data class CompetitionUiState(

    val isLoading: Boolean = true,

    val competitionGroups: List<CompetitionGroupUiModel> = emptyList(),

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/CompetitionViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toCompetitionGroups
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.CompetitionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CompetitionViewModel : ViewModel() {

    private val repository = CompetitionRepository()

    private val _uiState =
        MutableStateFlow(CompetitionUiState())

    val uiState: StateFlow<CompetitionUiState> =
        _uiState.asStateFlow()

    init {
        loadCompetitions()
    }

    private fun loadCompetitions() {

        viewModelScope.launch {

            try {

                val competitionGroups =
                    repository
                        .getCompetitions()
                        .map { it.toUiModel() }
                        .toCompetitionGroups()

                _uiState.value =
                    CompetitionUiState(
                        isLoading = false,
                        competitionGroups = competitionGroups
                    )

            } catch (e: Exception) {

                _uiState.value =
                    CompetitionUiState(
                        isLoading = false,
                        error = e.message
                    )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixturesUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDayUiModel

data class FixturesUiState(

    val isLoading: Boolean = true,

    val fixtureDays: List<FixtureDayUiModel> = emptyList(),

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixturesViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.FixtureRepository
import com.example.footballapp.ui.model.FixtureDayUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FixturesViewModel : ViewModel() {

    private val repository =
        FixtureRepository()

    private val _uiState =
        MutableStateFlow(
            FixturesUiState()
        )

    val uiState: StateFlow<FixturesUiState> =
        _uiState.asStateFlow()

    fun loadFixtures(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            try {

                val fixtureDays =
                    repository
                        .getFixtures(
                            leagueId,
                            season
                        )
                        .map {
                            it.toUiModel()
                        }
                        .groupBy {

                            /*
                             * Group fixtures by the date
                             * supplied by the backend.
                             */
                            it.fixtureDate // temporary placeholder

                        }

                        .map { (date, fixtures) ->

                            FixtureDayUiModel(

                                heading = date,

                                fixtures = fixtures

                            )

                        }

                _uiState.value =
                    FixturesUiState(

                        isLoading = false,

                        fixtureDays = fixtureDays

                    )

            } catch (e: Exception) {

                _uiState.value =
                    FixturesUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueOverviewUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel

/**
 * UI state for the League Overview screen.
 */
data class LeagueOverviewUiState(

    /**
     * True while loading data.
     */
    val isLoading: Boolean = true,

    /**
     * League overview returned from the backend.
     */
    val overview: LeagueOverviewUiModel? = null,

    /**
     * List of Top 5(?) Clubs in the League
     */

    val topStandings: List<LeagueTableRowUiModel> = emptyList(),

    /**
     * Error message displayed if loading fails.
     */
    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueOverviewViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.LeagueOverviewRepository
import com.example.footballapp.data.repository.LeagueTableRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeagueOverviewViewModel : ViewModel() {

    private val repository = LeagueOverviewRepository()

    private val tableRepository = LeagueTableRepository()

    private val _uiState =
        MutableStateFlow(LeagueOverviewUiState())

    val uiState: StateFlow<LeagueOverviewUiState> =
        _uiState.asStateFlow()

    fun loadLeagueOverview(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            _uiState.value =
                LeagueOverviewUiState(isLoading = true)

            try {

                val overview =
                    repository.getLeagueOverview(
                        leagueId,
                        season
                    )

                val topStandings =
                    tableRepository
                        .getLeagueTable(
                            leagueId,
                            season
                        )
                        .map {
                            it.toUiModel()
                        }
                        .take(5)

                _uiState.value =
                    LeagueOverviewUiState(

                        isLoading = false,

                        overview = overview,

                        topStandings = topStandings

                    )

            } catch (e: Exception) {

                _uiState.value =
                    LeagueOverviewUiState(
                        isLoading = false,
                        error = e.message
                    )
            }
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueTableUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.LeagueTableRowUiModel

/**
 * UI state for the League Table screen.
 */
data class LeagueTableUiState(

    val isLoading: Boolean = true,

    val table: List<LeagueTableRowUiModel> = emptyList(),

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueTableViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.LeagueTableRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeagueTableViewModel : ViewModel() {

    private val repository =
        LeagueTableRepository()

    private val _uiState =
        MutableStateFlow(
            LeagueTableUiState()
        )

    val uiState: StateFlow<LeagueTableUiState> =
        _uiState.asStateFlow()

    fun loadLeagueTable(
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            try {

                val table = repository
                    .getLeagueTable(
                        leagueId,
                        season
                    )
                    .map {
                        it.toUiModel()
                    }

                _uiState.value =
                    LeagueTableUiState(

                        isLoading = false,

                        table = table

                    )
                //println("League table size = ${table.size}")

            } catch (e: Exception) {

                _uiState.value =
                    LeagueTableUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ApiConfig.kt
```kotlin
package com.example.footballapp

object ApiConfig {

    const val BASE_URL =
        "http://10.0.2.2:8081"
}
```

## File: android/app/src/main/java/com/example/footballapp/AppState.kt
```kotlin
package com.example.footballapp

import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.model.CompetitionUiModel

object AppState {

    // -------------------------------------------------------------------------
    // New Architecture
    // -------------------------------------------------------------------------

    var selectedCompetition: CompetitionUiModel =
        PreviewData.ScottishPremiership

    // -------------------------------------------------------------------------
    // Legacy (remove later)
    // -------------------------------------------------------------------------

    var selectedLeagueId: Int = 179

    var selectedLeagueName: String =
        "Scottish Premiership"

    var selectedSeason: Int = 2024

}
```

## File: android/app/src/main/java/com/example/footballapp/MainActivity.kt
```kotlin
package com.example.footballapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.navigation.FootballNavHost
import com.example.footballapp.ui.theme.FootballAppTheme
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FootballAppTheme {

                FootballNavHost()
            }
        }
    }
}

@Composable
fun MainScreen(
    onLeagueSelectionClick: () -> Unit,
    onLeagueTableClick: () -> Unit,
    onFixturesClick: () -> Unit,
    onTeamsClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = "Football App",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text =
                "League: " +
                        AppState.selectedLeagueName,
            modifier =
                Modifier.padding(top = 8.dp)
        )

        Button(
            onClick = onLeagueSelectionClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Leagues")
        }

        Button(
            onClick = onLeagueTableClick,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("League Table")
        }

        Button(
            onClick = onTeamsClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Teams")
        }

        Button(
            onClick = onFixturesClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Fixtures")
        }
    }
}
```
