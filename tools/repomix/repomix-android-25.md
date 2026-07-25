This file is a merged representation of a subset of the codebase, containing specifically included files, combined into a single document by Repomix.

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
- Files are sorted by Git change count (files with more changes are at the bottom)

# Directory Structure
```
android/app/src/main/java/com/example/footballapp/AppState.kt
android/app/src/main/java/com/example/footballapp/data/mapper/ClubMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/CompetitionGrouping.kt
android/app/src/main/java/com/example/footballapp/data/mapper/CompetitionMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/FixtureDetailsMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/FixtureLineupMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/FixtureMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/LeagueOverviewMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/LeagueTableMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/PlayerDetailsMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/PlayerMapper.kt
android/app/src/main/java/com/example/footballapp/data/mapper/TeamMapper.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/ClubDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/CompetitionDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/CompetitiongroupDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureDetailsDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureLineupDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureTeamLineupDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/LeagueOverviewDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/LeagueTableRowDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/PlayerDetailsDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/PlayerDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/PlayerLineupDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/SupportedCompetitionDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/dto/TeamDto.kt
android/app/src/main/java/com/example/footballapp/data/remote/FootballApiClient.kt
android/app/src/main/java/com/example/footballapp/data/remote/FootballApiService.kt
android/app/src/main/java/com/example/footballapp/data/repository/ClubRepository.kt
android/app/src/main/java/com/example/footballapp/data/repository/CompetitionRepository.kt
android/app/src/main/java/com/example/footballapp/data/repository/FixtureRepository.kt
android/app/src/main/java/com/example/footballapp/data/repository/LeagueOverviewRepository.kt
android/app/src/main/java/com/example/footballapp/data/repository/LeagueTableRepository.kt
android/app/src/main/java/com/example/footballapp/data/repository/PlayerDetailsRepository.kt
android/app/src/main/java/com/example/footballapp/data/repository/SquadRepository.kt
android/app/src/main/java/com/example/footballapp/data/repository/TeamRepository.kt
android/app/src/main/java/com/example/footballapp/MainActivity.kt
android/app/src/main/java/com/example/footballapp/ui/components/AccountMenuButton.kt
android/app/src/main/java/com/example/footballapp/ui/components/AppHeader.kt
android/app/src/main/java/com/example/footballapp/ui/components/ClubBadge.kt
android/app/src/main/java/com/example/footballapp/ui/components/ClubList.kt
android/app/src/main/java/com/example/footballapp/ui/components/ClubRow.kt
android/app/src/main/java/com/example/footballapp/ui/components/CompetitionCard.kt
android/app/src/main/java/com/example/footballapp/ui/components/CompetitionList.kt
android/app/src/main/java/com/example/footballapp/ui/components/CompetitionRow.kt
android/app/src/main/java/com/example/footballapp/ui/components/CountryCard.kt
android/app/src/main/java/com/example/footballapp/ui/components/FixtureCard.kt
android/app/src/main/java/com/example/footballapp/ui/components/FixtureLineupCard.kt
android/app/src/main/java/com/example/footballapp/ui/components/InfoRow.kt
android/app/src/main/java/com/example/footballapp/ui/components/LeagueTableCard.kt
android/app/src/main/java/com/example/footballapp/ui/components/LeagueTableHeader.kt
android/app/src/main/java/com/example/footballapp/ui/components/LeagueTableRow.kt
android/app/src/main/java/com/example/footballapp/ui/components/LogoPlaceholder.kt
android/app/src/main/java/com/example/footballapp/ui/components/NavigationCard.kt
android/app/src/main/java/com/example/footballapp/ui/components/PlayerLineupRow.kt
android/app/src/main/java/com/example/footballapp/ui/components/PlayerList.kt
android/app/src/main/java/com/example/footballapp/ui/components/PlayerPhoto.kt
android/app/src/main/java/com/example/footballapp/ui/components/PlayerRow.kt
android/app/src/main/java/com/example/footballapp/ui/components/ScreenScaffold.kt
android/app/src/main/java/com/example/footballapp/ui/components/SearchBarPlaceholder.kt
android/app/src/main/java/com/example/footballapp/ui/components/SectionCard.kt
android/app/src/main/java/com/example/footballapp/ui/components/SectionHeading.kt
android/app/src/main/java/com/example/footballapp/ui/components/StatusChip.kt
android/app/src/main/java/com/example/footballapp/ui/components/TableDivider.kt
android/app/src/main/java/com/example/footballapp/ui/components/TopStandingsCard.kt
android/app/src/main/java/com/example/footballapp/ui/design/Animation.kt
android/app/src/main/java/com/example/footballapp/ui/design/AppConstants.kt
android/app/src/main/java/com/example/footballapp/ui/design/AppSpacing.kt
android/app/src/main/java/com/example/footballapp/ui/design/Dimensions.kt
android/app/src/main/java/com/example/footballapp/ui/design/Icons.kt
android/app/src/main/java/com/example/footballapp/ui/design/Strings.kt
android/app/src/main/java/com/example/footballapp/ui/model/ClubDetailsUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/ClubUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/CompetitionGroupUIModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/CompetitionType.kt
android/app/src/main/java/com/example/footballapp/ui/model/CompetitionUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/extensions/FixtureExtensions.kt
android/app/src/main/java/com/example/footballapp/ui/model/FixtureDayUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/FixtureDetailsUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/FixtureLineupUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/FixtureStatus.kt
android/app/src/main/java/com/example/footballapp/ui/model/FixtureTeamLineupUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/FixtureUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/LeagueOverviewUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/LeagueTableRowUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/PlayerDetailsUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/PlayerLineupUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/PlayerUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/model/QualificationType.kt
android/app/src/main/java/com/example/footballapp/ui/model/StandingUiModel.kt
android/app/src/main/java/com/example/footballapp/ui/navigation/DemoData.kt
android/app/src/main/java/com/example/footballapp/ui/navigation/FootballDestination.kt
android/app/src/main/java/com/example/footballapp/ui/navigation/FootballNavhost.kt
android/app/src/main/java/com/example/footballapp/ui/previews/PreviewData.kt
android/app/src/main/java/com/example/footballapp/ui/screens/club/ClubScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/clubs/ClubsScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/competitions/CompetitionsScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/fixtures/FixtureDetailsScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/fixtures/FixturesScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/fixtures/TeamFixturesScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/league/LeagueOverviewScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/league/LeagueTableScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/player/PlayerDetailsScreen.kt
android/app/src/main/java/com/example/footballapp/ui/screens/squad/SquadScreen.kt
android/app/src/main/java/com/example/footballapp/ui/theme/AppDimensions.kt
android/app/src/main/java/com/example/footballapp/ui/theme/AppElevation.kt
android/app/src/main/java/com/example/footballapp/ui/theme/AppShapes.kt
android/app/src/main/java/com/example/footballapp/ui/theme/AppTypography.kt
android/app/src/main/java/com/example/footballapp/ui/theme/Color.kt
android/app/src/main/java/com/example/footballapp/ui/theme/Theme.kt
android/app/src/main/java/com/example/footballapp/ui/theme/Type.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubsUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubsViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/CompetitionUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/CompetitionViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixtureDetailsUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixtureDetailsViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixturesUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixturesViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueOverviewUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueOverviewViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueTableUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/LeagueTableViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/PlayerDetailsUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/PlayerDetailsViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/SquadUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/SquadViewModel.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/TeamFixturesUiState.kt
android/app/src/main/java/com/example/footballapp/ui/viewmodel/TeamFixturesViewModel.kt
android/app/src/main/java/com/example/footballapp/util/DateFormatter.kt
```

# Files

## File: android/app/src/main/java/com/example/footballapp/AppState.kt
```kotlin
package com.example.footballapp

import com.example.footballapp.ui.model.CompetitionUiModel

object AppState {

    // -------------------------------------------------------------------------
    // New Architecture
    // -------------------------------------------------------------------------

//    var selectedCompetition: CompetitionUiModel =
//        PreviewData.ScottishPremiership

}
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/ClubMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.ClubDto
import com.example.footballapp.ui.model.ClubDetailsUiModel

fun ClubDto.toDetailsUiModel() =

    ClubDetailsUiModel(

        clubId = clubId,

        name = name,

        badgeUrl = null,

        league = "Scottish Premiership",

        founded = founded,

        stadium = stadium,

        capacity = capacity,

        manager = null

    )
```

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

import com.example.footballapp.data.remote.dto.CompetitionGroupDto
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

fun CompetitionGroupDto.toUiModel() =

    CompetitionGroupUiModel(

        title = country,

        headerIcon = headerIcon,

        displayOrder = displayOrder,

        leagues =

            competitions
                .filter { it.type == "LEAGUE" }
                .map {

                    CompetitionUiModel(

                        id = it.competitionId,

                        name = it.name,

                        country = country,

                        logoUrl = it.logoUrl

                    )

                },

        domesticCups =

            competitions
                .filter { it.type == "CUP" }
                .map {

                    CompetitionUiModel(

                        id = it.competitionId,

                        name = it.name,

                        country = country,

                        logoUrl = it.logoUrl

                    )

                }

    )
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/FixtureDetailsMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureDetailsDto
import com.example.footballapp.ui.model.FixtureDetailsUiModel

fun FixtureDetailsDto.toUiModel() =
    FixtureDetailsUiModel(

        fixtureId = fixtureId,

        fixtureDate = fixtureDate,

        homeTeam = homeTeam,

        awayTeam = awayTeam,

        homeGoals = homeGoals,

        awayGoals = awayGoals,

        venueName = venueName,

        leagueName = leagueName,

        season = season.toString(),

        round = round

    )
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/FixtureLineupMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.FixtureLineupDto
import com.example.footballapp.ui.model.FixtureLineupUiModel
import com.example.footballapp.ui.model.FixtureTeamLineupUiModel
import com.example.footballapp.ui.model.PlayerLineupUiModel

fun FixtureLineupDto.toUiModel(): FixtureLineupUiModel =
    FixtureLineupUiModel(
        fixtureId = fixtureId,
        teams = teams.map { team ->
            FixtureTeamLineupUiModel(
                teamId = team.teamId,
                teamName = team.teamName,
                coachId = team.coachId,
                coachName = team.coachName,
                formation = team.formation,
                players = team.players.map { player ->
                    PlayerLineupUiModel(
                        playerId = player.playerId,
                        playerName = player.playerName,
                        photo = player.photo,
                        shirtNumber = player.shirtNumber,
                        position = player.position,
                        grid = player.grid,
                        starting = player.starting,
                        displayOrder = player.displayOrder
                    )
                }
            )
        }
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

## File: android/app/src/main/java/com/example/footballapp/data/mapper/PlayerDetailsMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.PlayerDetailsDto
import com.example.footballapp.ui.model.PlayerDetailsUiModel

fun PlayerDetailsDto.toUiModel() =
    PlayerDetailsUiModel(

        playerId = playerId,

        name = displayName,

        photoUrl = photoUrl,

        shirtNumber = shirtNumber,

        position = position,

        nationality = nationality,

        dateOfBirth = birthDate,

        age = age,

        height = height,

        weight = weight,

        preferredFoot = null,

        captain = captain,

        starts = starts,

        appearances = appearances,

        goals = goals,

        assists = assists,

        yellowCards = yellowCards,

        redCards = redCards,

        minutesPlayed = minutes

    )
```

## File: android/app/src/main/java/com/example/footballapp/data/mapper/PlayerMapper.kt
```kotlin
package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.PlayerDto
import com.example.footballapp.ui.model.PlayerUiModel

fun PlayerDto.toUiModel() =

    PlayerUiModel(

        playerId = playerId,

        shirtNumber = shirtNumber,

        name = displayName,

        position = position

    )
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

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/ClubDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class ClubDto(

    val clubId: Int,

    val name: String,

    val country: String,

    val founded: Int,

    val stadium: String,

    val city: String,

    val capacity: Int

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

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/CompetitiongroupDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class CompetitionGroupDto(

    val country: String,

    val displayOrder: Int,

    val headerIcon: String,

    val competitions: List<SupportedCompetitionDto>

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureDetailsDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class FixtureDetailsDto(

    val fixtureId: Long,

    val fixtureDate: String,

    val homeTeamId: Int,
    val homeTeam: String,

    val awayTeamId: Int,
    val awayTeam: String,

    val homeGoals: Int?,
    val awayGoals: Int?,

    val venueName: String?,

    val leagueId: Int,
    val leagueName: String,

    val season: Int,

    val round: String

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

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureLineupDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class FixtureLineupDto(

    val fixtureId: Long,

    val teams: List<FixtureTeamLineupDto>

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/FixtureTeamLineupDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class FixtureTeamLineupDto(

    val teamId: Int,

    val teamName: String,

    val coachId: Int?,

    val coachName: String?,

    val formation: String?,

    val players: List<PlayerLineupDto>

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

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/PlayerDetailsDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class PlayerDetailsDto(

    val playerId: Int,

    val displayName: String,

    val firstName: String?,

    val lastName: String?,

    val birthDate: String?,

    val age: Int?,

    val height: String?,

    val weight: String?,

    val nationality: String?,

    val photoUrl: String?,

    val position: String,

    val shirtNumber: Int?,

    val captain: Boolean,

    val starts: Int?,

    val appearances: Int?,

    val minutes: Int?,

    val goals: Int?,

    val assists: Int?,

    val yellowCards: Int?,

    val redCards: Int?,

    val rating: String?,

    val teamId: Int,

    val teamName: String,

    val leagueId: Int,

    val leagueName: String,

    val season: Int

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/PlayerDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class PlayerDto(

    val playerId: Int,

    val age: Int,

    val nationality: String,

    val displayName: String,

    val photoUrl: String?,

    val position: String,

    val shirtNumber: Int?,

    val captain: Boolean,

    val appearances: Int?,

    val goals: Int?,

    val assists: Int?

)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/PlayerLineupDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class PlayerLineupDto(

    val playerId: Int,
    val playerName: String,
    val photo: String?,
    val shirtNumber: Int?,
    val position: String,
    val grid: String?,
    val starting: Boolean,
    val displayOrder: Int
)
```

## File: android/app/src/main/java/com/example/footballapp/data/remote/dto/SupportedCompetitionDto.kt
```kotlin
package com.example.footballapp.data.remote.dto

data class SupportedCompetitionDto(

    val competitionId: Int,

    val name: String,

    val type: String,

    val enabled: Boolean,

    val logoUrl: String

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
        //"http://192.168.1.65:8081/"
        "http://10.0.2.2:8081/"

    private const val LAN =
        "http://192.168.1.65:8081/"

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

import com.example.footballapp.data.remote.dto.ClubDto
import com.example.footballapp.data.remote.dto.CompetitionGroupDto
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
    suspend fun getLeagues(): Response<List<CompetitionGroupDto>>

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
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/ClubRepository.kt
```kotlin
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
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/CompetitionRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.data.remote.dto.CompetitionGroupDto

class CompetitionRepository {

    suspend fun getCompetitions(): List<CompetitionGroupDto> {

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
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel

/**
 * Repository for retrieving league standings.
 */
class LeagueTableRepository {

    private val service =
        FootballApiClient.service

    suspend fun getLeagueTable(
        leagueId: Int,
        season: Int
    ): List<LeagueTableRowUiModel> {

        return service
            .getLeagueTable(
                leagueId = leagueId,
                season = season
            )
            .map {
                it.toUiModel()
            }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/PlayerDetailsRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.PlayerDetailsUiModel

/**
 * Repository for retrieving player details.
 */
class PlayerDetailsRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get details for a single player.
     */
    suspend fun getPlayerDetails(
        playerId: Int,
        leagueId: Int,
        season: Int
    ): PlayerDetailsUiModel {

        return service
            .getPlayerDetails(
                playerId,
                leagueId,
                season
            )
            .toUiModel()

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/SquadRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.PlayerUiModel

/**
 * Repository for retrieving squad data.
 */
class SquadRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get all players for a club in a league season.
     */
    suspend fun getPlayers(
        teamId: Int,
        leagueId: Int,
        season: Int
    ): List<PlayerUiModel> {

        return service
            .getTeamPlayers(
                teamId,
                leagueId,
                season
            )
            .map {
                it.toUiModel()
            }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/data/repository/TeamRepository.kt
```kotlin
package com.example.footballapp.data.repository

import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.remote.FootballApiClient
import com.example.footballapp.ui.model.ClubUiModel

/**
 * Repository for retrieving club data.
 */
class TeamRepository {

    private val service =
        FootballApiClient.service

    /**
     * Get all clubs for a league season.
     */
    suspend fun getTeams(
        leagueId: Int,
        season: Int
    ): List<ClubUiModel> {

        return service
            .getTeams(
                leagueId,
                season
            )
            .map {
                it.toUiModel()
            }

    }

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
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/AccountMenuButton.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun AccountMenuButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.size(48.dp),
        shape = CircleShape,
        color = Color.White,
        shadowElevation = 2.dp,
        onClick = onClick
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Account",
                tint = HeaderBlue,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/AppHeader.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.design.AppSpacing
import androidx.compose.ui.graphics.Color
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun AppHeader(

    modifier: Modifier = Modifier,

    backgroundColor: Color = HeaderBlue

) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(backgroundColor)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = AppSpacing.Large),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoPlaceholder()

            Spacer(Modifier.width(AppSpacing.Large))

            SearchBarPlaceholder(
                modifier = Modifier.weight(1f)
            )

            Spacer(Modifier.width(AppSpacing.Large))

            AccountMenuButton()
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
//import com.example.footballapp.ui.previews.PreviewData

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

//@Preview(showBackground = true)
//@Composable
//private fun ClubListPreview() {
//
//    MaterialTheme {
//
//        SectionCard {
//
//            ClubList(
//
//                clubs = PreviewData.ScottishPremiershipClubList,
//
//                onClubClick = {}
//
//            )
//
//        }
//
//    }
//
//}
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
//import com.example.footballapp.ui.previews.PreviewData
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
//@Preview(showBackground = true)
//@Composable
//private fun ClubRowPreview() {
//
//    MaterialTheme {
//
//        SectionCard {
//
//            ClubRow(
//
//                club = PreviewData.Celtic,
//
//                onClick = {}
//
//            )
//
//        }
//
//    }
//
//}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/CompetitionCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.AsyncImage
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionUiModel
//import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun CompetitionCard(

    competition: CompetitionUiModel,

    onClick: (CompetitionUiModel) -> Unit

) {

    SectionCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(competition)
            }
    ) {

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.ExtraLarge),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            AsyncImage(

                model = competition.logoUrl,

                contentDescription = competition.name,

                modifier = Modifier.size(AppDimensions.ImageExtraLarge)

            )

            Spacer(
                modifier = Modifier.height(AppSpacing.Medium)
            )

            Text(

                text = competition.name,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.SemiBold

            )

        }

    }

}

//@Preview(showBackground = true)
//@Composable
//private fun CompetitionCardPreview() {
//
//    MaterialTheme {
//
//        CompetitionCard(
//
//            competition = PreviewData.ScottishPremiership,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/CompetitionList.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.footballapp.ui.model.CompetitionUiModel

@Composable
fun CompetitionList(
    competitions: List<CompetitionUiModel>,
    onCompetitionSelected: (CompetitionUiModel) -> Unit
) {

    competitions.forEach { competition ->

        CompetitionCard(

            competition = competition,

            onClick = onCompetitionSelected

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
//import com.example.footballapp.ui.previews.PreviewData
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
//@Preview(showBackground = true)
//@Composable
//private fun CompetitionRowPreview() {
//
//    CompetitionRow(
//
//        competition = PreviewData.ScottishPremiership,
//
//        onClick = {}
//
//    )
//}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/CountryCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppElevation

@Composable
fun CountryCard(
    countryName: String,
    competitionCount: Int,
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = "CountryExpandRotation"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppElevation.Card
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.Medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = countryName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "$competitionCount competitions",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ExpandMore,
                contentDescription = if (expanded) {
                    "Collapse $countryName"
                } else {
                    "Expand $countryName"
                },
                modifier = Modifier.rotate(rotation),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
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
//import com.example.footballapp.ui.previews.PreviewData
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

//@Preview(name = "Scheduled", showBackground = true)
//@Composable
//private fun ScheduledPreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.CelticVsRangers,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
//
//@Preview(name = "Live", showBackground = true)
//@Composable
//private fun LivePreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.HeartsVsAberdeen,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
//
//@Preview(name = "Finished", showBackground = true)
//@Composable
//private fun FinishedPreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.HibernianVsDundeeUnited,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
//
//@Preview(name = "Postponed", showBackground = true)
//@Composable
//private fun PostponedPreview() {
//
//    MaterialTheme {
//
//        FixtureCard(
//
//            fixture = PreviewData.RossCountyVsStJohnstone,
//
//            onClick = {}
//
//        )
//
//    }
//
//}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/FixtureLineupCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureLineupUiModel

@Composable
fun FixtureLineupCard(

    lineup: FixtureLineupUiModel,

    onPlayerClick: (Int) -> Unit

) {

    SectionCard {

        lineup.teams.forEach { team ->

            Column(

                verticalArrangement =
                    Arrangement.spacedBy(
                        AppSpacing.Small
                    )

            ) {

                Spacer(

                    modifier = Modifier.height(
                        AppSpacing.ExtraLarge
                    )

                )


                Text(
                    text = team.teamName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                InfoRow(

                    label = "Coach",

                    value = team.coachName

                )

                InfoRow(

                    label = "Formation",

                    value = team.formation

                )

                Spacer(

                    modifier = Modifier.height(
                        AppSpacing.ExtraSmall
                    )

                )


                Text(

                    text = "Players",

                    style =
                        MaterialTheme.typography.titleMedium,

                    fontWeight =
                        FontWeight.Bold

                )

                Spacer(

                    modifier = Modifier.height(
                        AppSpacing.ExtraSmall
                    )

                )


                val groupedPlayers = team.players.groupBy { player ->
                    when (player.position) {
                        "G" -> "Goalkeeper"
                        "D" -> "Defenders"
                        "M" -> "Midfielders"
                        "F" -> "Forwards"
                        else -> "Other"
                    }
                }

                groupedPlayers.forEach { (position, players) ->

                    Text(
                        text = position,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold
                    )

                    players.forEach { player ->

                        PlayerLineupRow(

                            player = player,

                            onClick = {

                                onPlayerClick(player.playerId)

                            }

                        )

                    }

                }

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/InfoRow.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.Strings

@Composable
fun InfoRow(

    label: String,

    value: String?,

    modifier: Modifier = Modifier,

    emptyText: String = Strings.NOT_AVAILABLE

) {

    val displayValue =
        value
            ?.takeIf { it.isNotBlank() }
            ?: emptyText

    Row(

        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppSpacing.ExtraSmall),

        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Text(

            text = label,

            style = MaterialTheme.typography.bodySmall,

            color = MaterialTheme.colorScheme.onSurfaceVariant

        )

        Text(

            text = displayValue,

            modifier = Modifier.weight(1f),

            textAlign = TextAlign.End,

            maxLines = 2,

            style = MaterialTheme.typography.bodyLarge,

            fontWeight = FontWeight.Medium

        )

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

            InfoRow(

                label = "Manager",

                value = "Philippe Clement"

            )

            InfoRow(

                label = "Capacity",

                value = "50,817"

            )

            InfoRow(

                label = "Stadium",

                value = "Ibrox Stadium"

            )

            InfoRow(

                label = "Unavailable",

                value = null

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
//import com.example.footballapp.ui.previews.PreviewData
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
//
//@Preview(showBackground = true)
//@Composable
//private fun LeagueTableCardPreview() {
//
//    LeagueTableCard(
//
//        table = PreviewData.ScottishPremiershipTable,
//
//        onTeamClick = {}
//
//    )
//
//}
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
//import com.example.footballapp.ui.previews.PreviewData
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

//@Preview(showBackground = true)
//@Composable
//private fun LeagueTableRowPreview() {
//
//    MaterialTheme {
//
//        LeagueTableRow(
//
//            row = PreviewData.ScottishPremiershipTable.first(),
//
//            isEvenRow = true,
//
//            onClubClick = {}
//
//        )
//    }
//}
//
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

## File: android/app/src/main/java/com/example/footballapp/ui/components/LogoPlaceholder.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.test.espresso.base.Default
import com.example.footballapp.ui.design.AppSpacing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsSoccer
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun LogoPlaceholder(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.SportsSoccer,
            contentDescription = "Match Day",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(32.dp)
        )

        Spacer(
            modifier = Modifier.width(AppSpacing.Small)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LogoPlaceholderPreview() {

    Box(
        modifier = Modifier
            .background(HeaderBlue)
            .padding(16.dp)
    ) {
        LogoPlaceholder()
    }
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/NavigationCard.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes

@Composable
fun NavigationCard(

    title: String,

    subtitle: String,

    onClick: () -> Unit

) {

    Card(

        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Small
            ),

        shape = AppShapes.Card,

        elevation = CardDefaults.cardElevation(
            defaultElevation = AppElevation.Card
        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = AppSpacing.Large,
                    vertical = AppSpacing.Medium
                ),

            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Column(

                modifier = Modifier.weight(1f)

            ) {

                Text(

                    text = title,

                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.SemiBold

                )

                Spacer(

                    modifier = Modifier.height(
                        AppSpacing.ExtraSmall
                    )

                )

                Text(

                    text = subtitle,

                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant,

                    maxLines = 2,

                    overflow = TextOverflow.Ellipsis

                )

            }

            Icon(

                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

                contentDescription = null,

                tint = MaterialTheme.colorScheme.onSurfaceVariant

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

            subtitle = "Current standings after every match",

            onClick = {}

        )

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/PlayerLineupRow.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import com.example.footballapp.ui.model.PlayerLineupUiModel

@Composable
fun PlayerLineupRow(

    player: PlayerLineupUiModel,

    onClick: () -> Unit

) {

    Row(

        modifier = Modifier.clickable {

            onClick()

        },

        horizontalArrangement =
            Arrangement.spacedBy(8.dp),

        verticalAlignment =
            Alignment.CenterVertically

    )  {

        Text(

            text =
                player.shirtNumber?.toString() ?: "-",

            modifier =
                Modifier.width(32.dp),

            style =
                MaterialTheme.typography.bodyMedium,

            fontWeight =
                FontWeight.Bold

        )

        Text(

            text = player.playerName,

            style =
                MaterialTheme.typography.bodyMedium

        )

        Spacer(

            modifier = Modifier.weight(1f)

        )

        Icon(

            imageVector = Icons.Default.ChevronRight,

            contentDescription = "Player details"

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
//import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.design.AppSpacing

private val PositionOrder = listOf(
    "Goalkeeper",
    "Defender",
    "Midfielder",
    "Attacker"
)

private fun positionHeading(position: String): String =
    when (position) {
        "Goalkeeper" -> "Goalkeepers"
        "Defender" -> "Defenders"
        "Midfielder" -> "Midfielders"
        "Attacker" -> "Attackers"
        else -> position
    }

fun LazyListScope.PlayerList(

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

//@Preview(showBackground = true)
//@Composable
//private fun PlayerListPreview() {
//
//    ScreenScaffold(
//
//        title = "Rangers",
//
//        subtitle = "Squad"
//
//    ) {
//
//        PlayerList(
//
//            players = PreviewData.RangersSquad,
//
//            onPlayerClick = {}
//
//        )
//
//    }
//
//}
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
//import androidx.compose.ui.tooling.preview.Preview
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

//@Preview(showBackground = true)
//@Composable
//private fun PlayerRowPreview() {
//
//    MaterialTheme {
//
//        SectionCard {
//
//            PlayerRow(
//
//                player = PlayerUiModel(
//
//                    playerId = 1,
//
//                    shirtNumber = 2,
//
//                    name = "James Tavernier",
//
//                    position = "Defender"
//
//                ),
//
//                onClick = {}
//
//            )
//
//        }
//
//    }
//
//}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/ScreenScaffold.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScreenScaffold(

    title: String? = null,

    subtitle: String? = null,

    modifier: Modifier = Modifier,

    showBackButton: Boolean = false,

    onBackClick: (() -> Unit)? = null,

    backgroundContent: (@Composable BoxScope.() -> Unit)? = null,

    content: LazyListScope.() -> Unit

) {

    val listState = rememberLazyListState()

    Box(

        modifier = modifier
            .fillMaxSize()

    ) {

        /*
         * Decorative background.
         *
         * This is completely outside the LazyColumn,
         * so it never affects measurement or spacing.
         */

        backgroundContent?.invoke(this)

        /*
         * Foreground content.
         */

        LazyColumn(

            state = listState,

            modifier = Modifier.fillMaxSize()

        ) {

            if (title != null || subtitle != null) {

                item {

                    if (title != null) {

                        Text(
                            text = title,
                            style = MaterialTheme.typography.headlineMedium
                        )

                    }

                    if (subtitle != null) {

                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodyMedium
                        )

                    }

                }

            }

            content()

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/components/SearchBarPlaceholder.kt
```kotlin
package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun SearchBarPlaceholder(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(24.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = AppSpacing.Medium),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray
            )

            Spacer(
                modifier = Modifier.width(AppSpacing.Small)
            )

            Text(
                text = "Search competitions, clubs, players...",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPlaceholderPreview() {

    Box(
        modifier = Modifier
            .background(HeaderBlue)
            .padding(16.dp)
    ) {
        SearchBarPlaceholder(
            modifier = Modifier.width(320.dp)
        )
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
import androidx.compose.ui.graphics.Color
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
                vertical = AppSpacing.Twelve
            ),

        shape = AppShapes.Card,

        elevation = CardDefaults.cardElevation(

            defaultElevation = AppElevation.Card

        ),

        colors = CardDefaults.cardColors(

            containerColor = Color.White

        )

    ) {

        Column(

            modifier = Modifier.padding(

                AppSpacing.Twenty

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

    text: String,

) {

    Text(

        text = text,

        style = AppTypography.SectionHeading,

        color = MaterialTheme.colorScheme.onSurface,

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
//import com.example.footballapp.ui.previews.PreviewData
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

//@Preview(showBackground = true)
//@Composable
//private fun TopStandingsCardPreview() {
//
//    MaterialTheme {
//
//        TopStandingsCard(
//
//            standings = PreviewData.ScottishPremiershipTable,
//
//            onTeamClick = {},
//
//            onViewFullTable = {}
//
//        )
//
//    }
//
//}
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
    const val DEVELOPMENT_SEASON_TEXT = "2024/25"

    /**
     * Temporary development season used by backend requests.
     *
     * Remove once season selection becomes dynamic.
     */
    const val DEVELOPMENT_SEASON = 2024

    /**
     * Temporary development League
     */
    const val DEVELOPMENT_LEAGUE = 179
}
```

## File: android/app/src/main/java/com/example/footballapp/ui/design/AppSpacing.kt
```kotlin
package com.example.footballapp.ui.design

import androidx.compose.ui.unit.dp

object AppSpacing {

    val ExtraSmall = 4.dp

    val Small = 8.dp

    val Twelve = 12.dp

    val Medium = 16.dp

    val Twenty = 20.dp

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
    const val SEASON_PREFIX = ""
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

    const val NOT_AVAILABLE = "N/A"
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
     * Competition Country
     */
    val country: String,

    /**
     * URL of the competition logo.
     */
    val logoUrl: String

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/extensions/FixtureExtensions.kt
```kotlin
package com.example.footballapp.ui.model.extensions

import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.FixtureUiModel

/**
 * Groups fixtures into day sections for display.
 */
fun List<FixtureUiModel>.groupByDay(): List<FixtureDayUiModel> =

    groupBy {

        it.fixtureDate

    }.map { (date, fixtures) ->

        FixtureDayUiModel(

            heading = date,

            fixtures = fixtures

        )

    }
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/FixtureDayUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class FixtureDayUiModel(

    val heading: String,

    val fixtures: List<FixtureUiModel>

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/FixtureDetailsUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class FixtureDetailsUiModel(

    val fixtureId: Long,

    val fixtureDate: String,

    val homeTeam: String,
    val awayTeam: String,

    val homeGoals: Int?,
    val awayGoals: Int?,

    val venueName: String?,

    val leagueName: String,

    val season: String,

    val round: String

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/FixtureLineupUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class FixtureLineupUiModel(

    val fixtureId: Long,
    val teams: List<FixtureTeamLineupUiModel>
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

## File: android/app/src/main/java/com/example/footballapp/ui/model/FixtureTeamLineupUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class FixtureTeamLineupUiModel(

    val teamId: Int,
    val teamName: String,
    val coachId: Int?,
    val coachName: String?,
    val formation: String?,
    val players: List<PlayerLineupUiModel>
)
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

    val starts: Int?,

    val goals: Int?,

    val assists: Int?,

    val yellowCards: Int?,

    val redCards: Int?,

    val minutesPlayed: Int?

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/model/PlayerLineupUiModel.kt
```kotlin
package com.example.footballapp.ui.model

data class PlayerLineupUiModel(

    val playerId: Int,
    val playerName: String,
    val photo: String?,
    val shirtNumber: Int?,
    val position: String,
    val grid: String?,
    val starting: Boolean,
    val displayOrder: Int
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

    RELEGATION;


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

    //
    // Squad
    //
    object Squad :
        FootballDestination(
            "squad/{clubId}"
        ) {

        fun createRoute(
            clubId: Int
        ) = "squad/$clubId"

    }

    //
    // Team Fixtures
    //
    object TeamFixtures :
        FootballDestination(
            "teamFixtures/{teamId}"
        ) {

        fun createRoute(
            teamId: Int
        ) = "teamFixtures/$teamId"

    }

    /**
     * Fixture Details
     */

    object FixtureDetails : FootballDestination(
        "fixtureDetails/{fixtureId}"
    ) {

        fun createRoute(
            fixtureId: Long
        ) = "fixtureDetails/$fixtureId"

    }

    // -------------------------------------------------------------------------
    // Player Details
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
import com.example.footballapp.ui.screens.CompetitionsScreen
import com.example.footballapp.ui.screens.club.ClubScreen
import com.example.footballapp.ui.screens.clubs.ClubsScreen
import com.example.footballapp.ui.screens.fixtures.FixturesScreen
import com.example.footballapp.ui.screens.league.LeagueOverviewScreen
import com.example.footballapp.ui.screens.league.LeagueTableScreen
import com.example.footballapp.ui.screens.player.PlayerDetailsScreen
import com.example.footballapp.ui.screens.squad.SquadScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.footballapp.ui.screens.fixtures.FixtureDetailsScreen
import com.example.footballapp.ui.screens.fixtures.TeamFixturesScreen
import com.example.footballapp.ui.viewmodel.ClubViewModel
import com.example.footballapp.ui.viewmodel.ClubsViewModel
import com.example.footballapp.ui.viewmodel.CompetitionViewModel
import com.example.footballapp.ui.viewmodel.FixtureDetailsViewModel
import com.example.footballapp.ui.viewmodel.FixturesViewModel
import com.example.footballapp.ui.viewmodel.LeagueOverviewViewModel
import com.example.footballapp.ui.viewmodel.LeagueTableViewModel
import com.example.footballapp.ui.viewmodel.PlayerDetailsViewModel
import com.example.footballapp.ui.viewmodel.SquadViewModel
import com.example.footballapp.ui.viewmodel.TeamFixturesViewModel


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
                                competition.id
                            )

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

                        navController.navigate(

                            FootballDestination
                                .FixtureDetails
                                .createRoute(fixtureId)

                        )

                    }

                )

            }

        }

        /**
         * Team Fixtures
         */

        composable(
            route = FootballDestination.TeamFixtures.route
        ) { backStackEntry ->

            val teamId =
                backStackEntry.arguments
                    ?.getString("teamId")
                    ?.toInt()
                    ?: return@composable

            /*
             * Club
             */
            val clubViewModel: ClubViewModel = viewModel()

            LaunchedEffect(teamId) {

                clubViewModel.loadClub(teamId)

            }

            val clubUiState by
            clubViewModel.uiState.collectAsState()

            /*
             * Fixtures
             */
            val teamFixturesViewModel: TeamFixturesViewModel = viewModel()

            val fixturesUiState by
            teamFixturesViewModel.uiState.collectAsState()

            LaunchedEffect(teamId) {

                teamFixturesViewModel.loadFixtures(

                    teamId = teamId,

                    leagueId = AppConstants.DEVELOPMENT_LEAGUE,

                    season = AppConstants.DEVELOPMENT_SEASON

                )

            }

            clubUiState.club?.let { club ->

                TeamFixturesScreen(

                    clubName = club.name,

                    season = AppConstants.DEVELOPMENT_SEASON_TEXT,

                    fixtureDays = fixturesUiState.fixtureDays,

                    onFixtureSelected = { fixtureId ->

                        navController.navigate(

                            FootballDestination
                                .FixtureDetails
                                .createRoute(fixtureId)

                        )

                    }

                )
            }
        }


        /**
         * Fixture Details
         */

        composable(
            route = FootballDestination.FixtureDetails.route
        ) { backStackEntry ->

            val fixtureId =
                backStackEntry.arguments
                    ?.getString("fixtureId")
                    ?.toLong()
                    ?: return@composable

            val fixtureDetailsViewModel:
                    FixtureDetailsViewModel = viewModel()

            val uiState by fixtureDetailsViewModel
                .uiState
                .collectAsState()

            LaunchedEffect(fixtureId) {

                fixtureDetailsViewModel.loadFixture(
                    fixtureId
                )

            }

            uiState.fixture?.let { fixture ->

                FixtureDetailsScreen(

                    fixture = fixture,

                    lineup = uiState.lineup,

                    onPlayerClick = { playerId ->

                        navController.navigate(
                            FootballDestination.PlayerDetails.createRoute(playerId)
                        )

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
         * Club Screen
         */

        composable(
            route = FootballDestination.Club.route
        ) { backStackEntry ->

            val clubId =
                backStackEntry.arguments
                    ?.getString("clubId")
                    ?.toInt()
                    ?: return@composable

            val clubViewModel: ClubViewModel = viewModel()

            LaunchedEffect(clubId) {

                clubViewModel.loadClub(clubId)

            }

            val uiState by
            clubViewModel.uiState.collectAsState()

            uiState.club?.let { club ->

                ClubScreen(

                    club = club,

                    onFixturesClick = { selectedClubId ->

                        navController.navigate(

                            FootballDestination.TeamFixtures
                                .createRoute(selectedClubId)

                        )

                    },

                    onSquadClick = { selectedClubId ->

                        navController.navigate(

                            FootballDestination
                                .Squad
                                .createRoute(
                                    selectedClubId
                                )

                        )

                    }

                )

            }

        }

        /**
         * Squad
         */
        composable(
            route = FootballDestination.Squad.route
        ) { backStackEntry ->

            val clubId =
                backStackEntry.arguments
                    ?.getString("clubId")
                    ?.toInt()
                    ?: return@composable

            val clubViewModel: ClubViewModel = viewModel()
            val squadViewModel: SquadViewModel = viewModel()

            LaunchedEffect(clubId) {

                clubViewModel.loadClub(clubId)

                squadViewModel.loadPlayers(

                    teamId = clubId,

                    leagueId = AppConstants.DEVELOPMENT_LEAGUE,

                    season = AppConstants.DEVELOPMENT_SEASON

                )

            }

            val clubState by
            clubViewModel.uiState.collectAsState()

            val squadState by
            squadViewModel.uiState.collectAsState()

            clubState.club?.let { club ->

                SquadScreen(

                    clubName = club.name,

                    season = AppConstants.DEVELOPMENT_SEASON_TEXT,

                    players = squadState.players,

                    onPlayerClick = { playerId ->

                        navController.navigate(

                            FootballDestination
                                .PlayerDetails
                                .createRoute(playerId)

                        )

                    }

                )

            }

        }

        /**
         * Player Details
         */
        composable(
            route = FootballDestination.PlayerDetails.route
        ) { backStackEntry ->

            val playerId =
                backStackEntry.arguments
                    ?.getString("playerId")
                    ?.toInt()
                    ?: return@composable

            val playerDetailsViewModel: PlayerDetailsViewModel = viewModel()

            LaunchedEffect(playerId) {

                playerDetailsViewModel.loadPlayerDetails(

                    playerId = playerId,

                    leagueId = AppConstants.DEVELOPMENT_LEAGUE,

                    season = AppConstants.DEVELOPMENT_SEASON

                )

            }

            val playerState by
            playerDetailsViewModel
                .uiState
                .collectAsState()

            playerState.player?.let { player ->

                PlayerDetailsScreen(

                    player = player

                )

            }

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
import com.example.footballapp.ui.design.AppConstants

object PreviewData {

    // -------------------------------------------------------------------------
    // Scotland - Leagues
    // -------------------------------------------------------------------------

    val ScottishPremiership = CompetitionUiModel(
        id = AppConstants.DEVELOPMENT_LEAGUE,
        name = "Scottish Premiership",
        country = "Scotland",
        //season = "2024/25",
        logoUrl = ""
    )

    val ScottishChampionship = CompetitionUiModel(
        id = 180,
        name = "Scottish Championship",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueOne = CompetitionUiModel(
        id = 181,
        name = "Scottish League One",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    val ScottishLeagueTwo = CompetitionUiModel(
        id = 182,
        name = "Scottish League Two",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    // -------------------------------------------------------------------------
    // Scotland - Domestic Cups
    // -------------------------------------------------------------------------

    val ScottishCup = CompetitionUiModel(
        id = 183,
        name = "Scottish Cup",
        country = "Scotland",
        //season = "2025/26",
        logoUrl = ""
    )

    val LeagueCup = CompetitionUiModel(
        id = 184,
        name = "League Cup",
        country = "Scotland",
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
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 17,
            shirtNumber = 11,
            name = "Oscar Cortés",
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 18,
            shirtNumber = 18,
            name = "Vaclav Cerny",
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 19,
            shirtNumber = 29,
            name = "Hamza Igamane",
            position = "Attacker"
        ),

        PlayerUiModel(
            playerId = 20,
            shirtNumber = 99,
            name = "Danilo",
            position = "Attacker"
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

        starts = 36,

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

        starts = 34,

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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.components.ClubBadge
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun ClubScreen(

    club: ClubDetailsUiModel,

    onSquadClick: (Int) -> Unit,

    onFixturesClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = club.name,

        subtitle = club.league,

        backgroundContent = {

            ClubBadge(

                logoUrl = club.badgeUrl,

                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = (-24).dp, y = (-24).dp)
                    .size(AppDimensions.ImageLarge *8.5f)
                    .alpha(0.04f)

            )

        }

    ) {

        /*
         * Club Information
         */

        item {

            SectionHeading(

                text = "Club Information"

            )

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

        /*
         * Navigation
         */

        item {

            NavigationCard(

                title = "Squad",

                subtitle = "View first-team squad",

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

                subtitle = "Current and upcoming matches",

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

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.components.AppHeader
import com.example.footballapp.ui.components.CompetitionList
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.theme.HeaderBlue
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.footballapp.ui.components.CountryCard

@Composable
fun CompetitionsScreen(

    competitionGroups: List<CompetitionGroupUiModel>,

    onCompetitionSelected: (CompetitionUiModel) -> Unit = {}

) {

    var expandedCountry by rememberSaveable {
        mutableStateOf<String?>(competitionGroups.firstOrNull()?.title)
    }

    ScreenScaffold {

        item {

            AppHeader(

                backgroundColor = HeaderBlue

            )

        }

        item {

            Spacer(
                modifier = Modifier.height(AppSpacing.ExtraLarge)
            )

        }

        items(competitionGroups) { group ->


            CountryCard(
                countryName = group.title,
                competitionCount = group.leagues.size + group.domesticCups.size,
                expanded = expandedCountry == group.title,
                onClick = {
                    expandedCountry =
                        if (expandedCountry == group.title)
                            null
                        else
                            group.title
                }
            )

            AnimatedVisibility(

                visible = expandedCountry == group.title

            ) {

                androidx.compose.foundation.layout.Column {

                    if (group.leagues.isNotEmpty()) {

                        CompetitionList(

                            competitions = group.leagues,

                            onCompetitionSelected = onCompetitionSelected

                        )

                    }

                    if (group.domesticCups.isNotEmpty()) {

                        CompetitionList(

                            competitions = group.domesticCups,

                            onCompetitionSelected = onCompetitionSelected

                        )

                    }

                }

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/screens/fixtures/FixtureDetailsScreen.kt
```kotlin
package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.footballapp.ui.components.FixtureLineupCard
import com.example.footballapp.ui.components.InfoRow
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.model.FixtureLineupUiModel
import com.example.footballapp.util.DateFormatter

@Composable
fun FixtureDetailsScreen(

    fixture: FixtureDetailsUiModel,

    lineup: FixtureLineupUiModel? = null,

    onPlayerClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = fixture.leagueName,

        subtitle = fixture.season

    ) {

        /*
         * Match
         */

        item {

            SectionCard {

                Column(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalAlignment = Alignment.CenterHorizontally,

                    verticalArrangement = Arrangement.spacedBy(
                        AppSpacing.Medium
                    )

                ) {

                    Text(

                        text = fixture.homeTeam,

                        style = MaterialTheme.typography.titleLarge

                    )

                    Text(

                        text = "${fixture.homeGoals ?: "-"} – ${fixture.awayGoals ?: "-"}",

                        style = MaterialTheme.typography.headlineLarge,

                        fontWeight = FontWeight.Bold

                    )

                    Text(

                        text = fixture.awayTeam,

                        style = MaterialTheme.typography.titleLarge

                    )

                }

            }

        }

        /*
         * Match Information
         */

        item {

            SectionHeading(

                text = "Match Information"

            )

        }

        item {

            SectionCard {

                InfoRow(

                    label = "Competition",

                    value = fixture.leagueName

                )

                InfoRow(

                    label = "Round",

                    value = fixture.round

                )

                InfoRow(

                    label = "Date",

                    value = DateFormatter.formatFixtureDateOnly(

                        fixture.fixtureDate

                    )

                )

                InfoRow(

                    label = "Kick-off",

                    value = DateFormatter.formatFixtureTime(

                        fixture.fixtureDate

                    )

                )

                InfoRow(

                    label = "Venue",

                    value = fixture.venueName ?: "N/A"

                )

            }

        }

        /*
         * Fixture Lineup
         */

        item {

            lineup?.let {

                FixtureLineupCard(

                    lineup = it,

                    onPlayerClick = onPlayerClick

                )

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

## File: android/app/src/main/java/com/example/footballapp/ui/screens/fixtures/TeamFixturesScreen.kt
```kotlin
package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.components.FixtureCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionHeading
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.previews.PreviewData

@Composable
fun TeamFixturesScreen(

    clubName: String,

    season: String,

    fixtureDays: List<FixtureDayUiModel>,

    onFixtureSelected: (Long) -> Unit

) {

    ScreenScaffold(

        title = clubName,

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
private fun TeamFixturesScreenPreview() {

    MaterialTheme {

        TeamFixturesScreen(

            clubName = "Rangers",

            season = "2024/25",

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

            leagueId = AppConstants.DEVELOPMENT_LEAGUE,

            leagueName = "Scottish Premiership",

            season = AppConstants.DEVELOPMENT_SEASON_TEXT,

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
import com.example.footballapp.ui.components.LeagueTableCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppConstants
import com.example.footballapp.ui.model.LeagueOverviewUiModel
import com.example.footballapp.ui.model.LeagueTableRowUiModel

@Composable
fun LeagueTableScreen(

    overview: LeagueOverviewUiModel,

    standings: List<LeagueTableRowUiModel>,

    onClubClick: (Int) -> Unit

) {

    ScreenScaffold(

        title = overview.leagueName,

        subtitle = AppConstants.DEVELOPMENT_SEASON_TEXT

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

## File: android/app/src/main/java/com/example/footballapp/ui/screens/player/PlayerDetailsScreen.kt
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
import com.example.footballapp.util.DateFormatter

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
                        value = DateFormatter.formatDate(
                            player.dateOfBirth
                        )
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
                        label = "Starts",
                        value = player.starts?.toString()
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
import com.example.footballapp.ui.components.PlayerList
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

        PlayerList(

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

    val ImageExtraLarge = 76.dp

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

    val Card = 3.dp

    val Dialog = 8.dp

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/theme/AppShapes.kt
```kotlin
package com.example.footballapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object AppShapes {

    val Card = RoundedCornerShape(16.dp)

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

val HeaderBlue = Color(0xFF0088F3)
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

            _uiState.value =
                ClubsUiState(
                    isLoading = true
                )

            try {

                val clubs =
                    repository.getTeams(
                        leagueId,
                        season
                    )

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

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.ClubDetailsUiModel

data class ClubUiState(

    val isLoading: Boolean = true,

    val club: ClubDetailsUiModel? = null,

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/ClubViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.ClubRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubViewModel : ViewModel() {

    private val repository =
        ClubRepository()

    private val _uiState =
        MutableStateFlow(
            ClubUiState()
        )

    val uiState: StateFlow<ClubUiState> =
        _uiState.asStateFlow()

    fun loadClub(
        clubId: Int
    ) {

        viewModelScope.launch {

            _uiState.value =
                ClubUiState(
                    isLoading = true
                )

            try {

                val club =
                    repository.getClub(
                        clubId
                    )

                _uiState.value =
                    ClubUiState(

                        isLoading = false,

                        club = club

                    )

            } catch (e: Exception) {

                _uiState.value =
                    ClubUiState(

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

import android.util.Log
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

                Log.d("CompetitionVM", "Loaded ${competitionGroups.size} groups")

                _uiState.value = CompetitionUiState(
                    isLoading = false,
                    competitionGroups = competitionGroups
                )

            } catch (e: Exception) {
                Log.e("CompetitionVM", "Failed to load competitions", e)
            }
        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixtureDetailsUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.model.FixtureLineupUiModel

data class FixtureDetailsUiState(

    val isLoading: Boolean = true,

    val fixture: FixtureDetailsUiModel? = null,

    val lineup: FixtureLineupUiModel? = null,

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/FixtureDetailsViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.mapper.toUiModel
import com.example.footballapp.data.repository.FixtureRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FixtureDetailsViewModel : ViewModel() {

    private val repository =
        FixtureRepository()

    private val _uiState =
        MutableStateFlow(
            FixtureDetailsUiState()
        )

    val uiState: StateFlow<FixtureDetailsUiState> =
        _uiState.asStateFlow()

    fun loadFixture(
        fixtureId: Long
    ) {

        viewModelScope.launch {

            try {

                val fixture =
                    repository
                        .getFixtureDetails(
                            fixtureId
                        )
                        .toUiModel()

                val lineup =
                    repository
                        .getFixtureLineup(
                            fixtureId
                        )

                _uiState.value =
                    FixtureDetailsUiState(

                        isLoading = false,

                        fixture = fixture,

                        lineup = lineup

                    )

            } catch (e: Exception) {

                _uiState.value =
                    FixtureDetailsUiState(

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
import com.example.footballapp.data.repository.FixtureRepository
import com.example.footballapp.ui.model.FixtureDayUiModel
import com.example.footballapp.ui.model.extensions.groupByDay
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

            _uiState.value =
                FixturesUiState(
                    isLoading = true
                )

            try {

                val fixtureDays =
                    repository
                        .getFixtures(
                            leagueId,
                            season
                        )
                        .groupByDay()

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
     * Standings displayed on the League Overview screen.
     *
     * Currently the top five clubs are shown, although
     * the UI decides how many rows to display.
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

            _uiState.value =
                LeagueTableUiState(
                    isLoading = true
                )

            try {

                val table =
                    repository.getLeagueTable(
                        leagueId,
                        season
                    )

                _uiState.value =
                    LeagueTableUiState(

                        isLoading = false,

                        table = table

                    )

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

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/PlayerDetailsUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.PlayerDetailsUiModel

data class PlayerDetailsUiState(

    val isLoading: Boolean = true,

    val player: PlayerDetailsUiModel? = null,

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/PlayerDetailsViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.PlayerDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerDetailsViewModel : ViewModel() {

    private val repository =
        PlayerDetailsRepository()

    private val _uiState =
        MutableStateFlow(
            PlayerDetailsUiState()
        )

    val uiState: StateFlow<PlayerDetailsUiState> =
        _uiState.asStateFlow()

    fun loadPlayerDetails(

        playerId: Int,

        leagueId: Int,

        season: Int

    ) {

        viewModelScope.launch {

            _uiState.value =
                PlayerDetailsUiState(
                    isLoading = true
                )

            try {

                val player =
                    repository.getPlayerDetails(
                        playerId,
                        leagueId,
                        season
                    )

                _uiState.value =

                    PlayerDetailsUiState(

                        isLoading = false,

                        player = player

                    )

            } catch (e: Exception) {

                _uiState.value =

                    PlayerDetailsUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/SquadUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.PlayerUiModel

data class SquadUiState(

    val isLoading: Boolean = true,

    val players: List<PlayerUiModel> = emptyList(),

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/SquadViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.SquadRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SquadViewModel : ViewModel() {

    private val repository =
        SquadRepository()

    private val _uiState =
        MutableStateFlow(
            SquadUiState()
        )

    val uiState: StateFlow<SquadUiState> =
        _uiState.asStateFlow()

    fun loadPlayers(
        teamId: Int,
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            _uiState.value =
                SquadUiState(
                    isLoading = true
                )

            try {

                val players =
                    repository
                        .getPlayers(
                            teamId,
                            leagueId,
                            season
                        )

                _uiState.value =
                    SquadUiState(

                        isLoading = false,

                        players = players

                    )

            } catch (e: Exception) {

                _uiState.value =
                    SquadUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/TeamFixturesUiState.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import com.example.footballapp.ui.model.FixtureDayUiModel

data class TeamFixturesUiState(

    val isLoading: Boolean = true,

    val fixtureDays: List<FixtureDayUiModel> = emptyList(),

    val error: String? = null

)
```

## File: android/app/src/main/java/com/example/footballapp/ui/viewmodel/TeamFixturesViewModel.kt
```kotlin
package com.example.footballapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.repository.FixtureRepository
import com.example.footballapp.ui.model.extensions.groupByDay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TeamFixturesViewModel : ViewModel() {

    private val repository =
        FixtureRepository()

    private val _uiState =
        MutableStateFlow(
            TeamFixturesUiState()
        )

    val uiState: StateFlow<TeamFixturesUiState> =
        _uiState.asStateFlow()

    fun loadFixtures(
        teamId: Int,
        leagueId: Int,
        season: Int
    ) {

        viewModelScope.launch {

            try {

                val fixtureDays =
                    repository
                        .getTeamFixtures(
                            teamId,
                            leagueId,
                            season
                        )
                        .groupByDay()

                _uiState.value =
                    TeamFixturesUiState(

                        isLoading = false,

                        fixtureDays = fixtureDays

                    )

            } catch (e: Exception) {

                _uiState.value =
                    TeamFixturesUiState(

                        isLoading = false,

                        error = e.message

                    )

            }

        }

    }

}
```

## File: android/app/src/main/java/com/example/footballapp/util/DateFormatter.kt
```kotlin
package com.example.footballapp.util

import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Formats dates for display within the FootballApp UI.
 */
object DateFormatter {

    private val ukZone =
        ZoneId.of("Europe/London")

    private val fixtureFormatter =
        DateTimeFormatter.ofPattern(
            "dd/MM/yyyy HH:mm",
            Locale.UK
        )

    private val shortFixtureFormatter =
        DateTimeFormatter.ofPattern(
            "EEE d MMM HH:mm",
            Locale.UK
        )

    private val dateFormatter =
        DateTimeFormatter.ofPattern(
            "d MMMM yyyy",
            Locale.UK
        )

    private val fixtureDateOnlyFormatter =
        DateTimeFormatter.ofPattern(
            "d MMMM yyyy",
            Locale.UK
        )

    private val fixtureTimeFormatter =
        DateTimeFormatter.ofPattern(
            "HH:mm",
            Locale.UK
        )

    /**
     * Example:
     * 2024-08-03T14:00:00+00:00
     *
     * becomes
     *
     * 03/08/2024 15:00
     */
    fun formatFixtureDate(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(fixtureFormatter)

    }

    /**
     * Example:
     *
     * Sat 3 Aug 15:00
     */
    fun formatFixtureDateShort(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(shortFixtureFormatter)

    }

    /**
     * Example:
     *
     * 1999-03-12
     *
     * becomes
     *
     * 12 March 1999
     */
    fun formatDate(
        date: String?
    ): String {

        if (date.isNullOrBlank()) {
            return ""
        }

        return java.time.LocalDate
            .parse(date)
            .format(dateFormatter)

    }

    /**
     * Returns- 3 August 2024 for example.
     */

    fun formatFixtureDateOnly(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(fixtureDateOnlyFormatter)

    }

    /**
     * Returns- 12:30 for example..
     */

    fun formatFixtureTime(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(fixtureTimeFormatter)

    }

}
```
