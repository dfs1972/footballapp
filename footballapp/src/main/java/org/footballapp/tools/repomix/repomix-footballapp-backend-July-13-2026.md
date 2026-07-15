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
- Only files matching these patterns are included: footballapp/src/main/java/org/footballapp/**/*.java
- Files matching patterns in .gitignore are excluded
- Files matching default ignore patterns are excluded
- Security check has been disabled - content may contain sensitive information
- Files are sorted by Git change count (files with more changes are at the bottom)

# Directory Structure
```
footballapp/
  src/
    main/
      java/
        org/
          footballapp/
            api/
              ApiFootballClient.java
              ApiFootballService.java
            config/
              ApiConfig.java
              AppConfig.java
            controller/
              ClubController.java
              FixtureDetailsController.java
              FixturesController.java
              LeagueOverviewController.java
              LeaguesController.java
              LeagueTableController.java
              PlayerController.java
              TeamDetailsController.java
              TeamFixturesController.java
              TeamsController.java
              TeamStatisticsController.java
            database/
              DatabaseConnection.java
            databaserepository/
              FixtureRepository.java
              LeagueRepository.java
              LeagueTeamRepository.java
              LeagueUkRepository.java
              PlayerRepository.java
              PlayerStatisticsRepository.java
              StandingRepository.java
              TeamRepository.java
              TeamStatisticsRepository.java
              VenueRepository.java
            model/
              club/
                ClubDetails.java
              fixtures/
                Fixture.java
                FixtureGoals.java
                FixtureLeague.java
                FixtureResponse.java
                FixtureRow.java
                FixturesApiResponse.java
                FixtureTeam.java
                FixtureTeams.java
                FixtureVenue.java
              league/
                CountryInfo.java
                League.java
                LeagueApiInfo.java
                LeagueApiResponse.java
                LeagueOverview.java
                LeagueResponse.java
                LeaguesApiResponse.java
                LeagueTeam.java
                LeagueUk.java
              player/
                Player.java
              playerdetails/
                PlayerDetails.java
                PlayerSummary.java
              playerstatistics/
                PlayerCards.java
                PlayerGames.java
                PlayerGoals.java
                PlayerLeague.java
                PlayerStatistics.java
                PlayerTeam.java
              standings/
                LeagueTableRow.java
                Standing.java
                StandingAll.java
                StandingGoals.java
                StandingLeague.java
                StandingRecord.java
                StandingsApiResponse.java
                StandingsResponse.java
                StandingTeam.java
              teamdetails/
                TeamDetails.java
              teams/
                ID.java
                Team.java
                TeamResponse.java
                TeamsApiResponse.java
                Venue.java
              teamstatistics/
                CardColour.java
                CardMinute.java
                Cards.java
                CleanSheet.java
                FailedToScore.java
                Fixtures.java
                FixturesTotals.java
                Goals.java
                GoalsTotals.java
                League.java
                Team.java
                TeamStatistics.java
                TeamStatisticsApiResponse.java
                TeamStatisticsResponse.java
            service/
              FixtureImportService.java
              FixtureService.java
              LeagueDataService.java
              LeagueImportService.java
              LeagueUkImportService.java
              PlayerImportService.java
              StandingService.java
              StandingsImportService.java
              TeamImportService.java
              TeamService.java
              TeamStatisticsImportService.java
            tools/
              ApiTester.java
              ApiTestResult.java
              ImportRunner.java
            util/
              DateUtils.java
            FootballApplication.java
            Main.java
```

# Files

## File: footballapp/src/main/java/org/footballapp/api/ApiFootballClient.java
```java
package org.footballapp.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

/*
 * Handles all HTTP communication with API-Football.
 *
 * Sends requests to API-Football endpoints and returns
 * the raw JSON response to the service layer.
 */

public class ApiFootballClient {

    private final String apiKey;
    private final HttpClient client;

    public ApiFootballClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
    }

    /*
     * Sends a GET request to the specified API-Football endpoint
     * and returns the response body as a JSON string.
     */

    public String get(String url) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", apiKey)
                .header("x-rapidapi-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }
}
```

## File: footballapp/src/main/java/org/footballapp/api/ApiFootballService.java
```java
package org.footballapp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;

public class ApiFootballService {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;

    public ApiFootballService(ApiFootballClient apiClient) {
        this.apiClient = apiClient;
        this.mapper = new ObjectMapper();
    }

    public LeaguesApiResponse getLeagues()
            throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues";

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                LeaguesApiResponse.class
        );
    }

    /**
     * Gets all teams from a league in requested season
     */
    public TeamsApiResponse getLeagueTeams(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/teams?league="
                        + leagueId
                        + "&season="
                        + season;

        String json = apiClient.get(url);

        return mapper.readValue(
                json,
                TeamsApiResponse.class
        );
    }

    /**
     * Retrieves all players for a team in a season.
     */
    public PlayersApiResponse getPlayers(
            int teamId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?team="
                        + teamId
                        + "&season="
                        + season;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                PlayersApiResponse.class
        );
    }

    /**
     * gets league standings from a specified season
     */
    public StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/standings?league="
                        + leagueId
                        + "&season="
                        + season;

        String json = apiClient.get(url);

        return mapper.readValue(
                json,
                StandingsApiResponse.class
        );
    }

    /**
     * Gets all fixtures from a league in specified season
     */
    public FixturesApiResponse getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures?league="
                        + leagueId
                        + "&season="
                        + season;

        String json = apiClient.get(url);

        return mapper.readValue(
                json,
                FixturesApiResponse.class
        );
    }

    /**
     * Gets raw data for a league in specified season
     */
    public String getLeagueInfoRaw(
            int leagueId,
            String country
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues?id="
                        + leagueId
                        + "&country="
                        + country;

        return apiClient.get(url);
    }

    /**
     * Get Players details from API-Football
     */
    public String getPlayersJson(
            int teamId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?team="
                        + teamId
                        + "&season="
                        + season;

        return apiClient.get(url);
    }

    /**
     * Gets the raw JSON for a single player in a league and season.
     */
    public String getPlayerJson(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?id="
                        + playerId
                        + "&league="
                        + leagueId
                        + "&season="
                        + season;

        return apiClient.get(url);
    }

    /**
     * Gets team statistics for a league and season.
     */
    public TeamStatisticsApiResponse getTeamStatistics(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/teams/statistics?league="
                        + leagueId
                        + "&season="
                        + season
                        + "&team="
                        + teamId;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                TeamStatisticsApiResponse.class
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/config/ApiConfig.java
```java
package org.footballapp.config;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.api.ApiFootballService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ApiFootballClient apiFootballClient() {

        String apiKey =
                System.getenv("API_FOOTBALL_KEY");

        if (apiKey == null || apiKey.isBlank()) {

            throw new IllegalStateException(
                    "API_FOOTBALL_KEY environment variable is not configured."
            );

        }

        return new ApiFootballClient(apiKey);

    }

    @Bean
    public ApiFootballService apiFootballService(
            ApiFootballClient apiFootballClient
    ) {

        return new ApiFootballService(
                apiFootballClient
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/config/AppConfig.java
```java
//package org.footballapp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.footballapp.api.ApiFootballClient;
//import org.footballapp.api.ApiFootballService;
//import org.footballapp.databaserepository.*;
//import org.footballapp.model.teamstatistics.TeamStatistics;
//import org.footballapp.service.*;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public ApiFootballClient apiFootballClient() {
//
//        String apiKey =
//                System.getenv("API_FOOTBALL_KEY");
//
//        if (apiKey == null || apiKey.isBlank()) {
//
//            throw new IllegalStateException(
//                    "API_FOOTBALL_KEY environment variable is not configured."
//            );
//
//        }
//
//        return new ApiFootballClient(
//                apiKey
//        );
//
//    }
//
//    @Bean
//    public ApiFootballService apiFootballService(
//            ApiFootballClient apiFootballClient
//    ) {
//
//        return new ApiFootballService(
//                apiFootballClient
//        );
//
//    }
//
//    /**
//     * Database repositories
//     */
//    private final LeagueUkRepository leagueUkRepository;
//    private final TeamRepository teamRepository;
//    private final TeamStatisticsRepository teamStatisticsRepository;
//    private final VenueRepository venueRepository;
//    //private final LeagueRepository leagueRepository;
//    private final LeagueTeamRepository leagueTeamRepository;
//    private final StandingRepository standingRepository;
//    private final FixtureRepository fixtureRepository;
//
//    private final TeamStatisticsImportService teamStatisticsImportService;
//    private final TeamImportService teamImportService;
//    private final StandingsImportService standingsImportService;
//    private final FixtureImportService fixtureImportService;
//
//    private final LeagueImportService leagueImportService;
//    private final LeagueUkImportService leagueUkImportService;
//    private final LeagueDataService leagueDataService;
//
//    private final PlayerRepository playerRepository;
//    private final PlayerImportService playerImportService;
//    private final PlayerStatisticsRepository playerStatisticsRepository;
//
//    public AppConfig() {
//
//        /**
//         * Repository Layer
//         */
//
//        playerRepository =
//                new PlayerRepository();
//
//        playerStatisticsRepository =
//                new PlayerStatisticsRepository();
//
//        leagueUkRepository =
//                new LeagueUkRepository();
//
//        teamRepository =
//                new TeamRepository();
//
//        teamStatisticsRepository =
//                new TeamStatisticsRepository();
//
//        venueRepository =
//                new VenueRepository();
//
////        leagueRepository =
////                new LeagueRepository();
//
//        leagueTeamRepository =
//                new LeagueTeamRepository();
//
//        standingRepository =
//                new StandingRepository();
//
//        fixtureRepository =
//                new FixtureRepository();
//
//        /**
//         * Import Layer
//         */
//
//        playerImportService =
//                new PlayerImportService(
//                        apiFootballService,
//                        playerRepository,
//                        playerStatisticsRepository
//                );
//
////        teamImportService =
////                new TeamImportService(
////                        apiFootballService,
////                        teamRepository,
////                        venueRepository,
////                        leagueTeamRepository
////                );
//
//        teamStatisticsImportService =
//                new TeamStatisticsImportService(
//                        apiFootballService,
//                        teamStatisticsRepository,
//                        standingRepository
//                );
//
////        standingsImportService =
////                new StandingsImportService(
////                        apiFootballService,
////                        standingRepository
////                );
//
////        fixtureImportService =
////                new FixtureImportService(
////                        apiFootballService,
////                        fixtureRepository
////                );
//
//        leagueUkImportService =
//                new LeagueUkImportService(
//                        apiFootballService,
//                        leagueUkRepository
//                );
//
//        leagueImportService =
//                new LeagueImportService(
//                        teamImportService,
//                        standingsImportService,
//                        fixtureImportService,
//                        teamStatisticsImportService
//                );
//
//        /**
//         * Application Services
//         */
////        leagueDataService =
////                new LeagueDataService(
////                        leagueUkRepository,
////                        teamRepository,
////                        teamStatisticsRepository,
////                        venueRepository,
////                        standingRepository,
////                        fixtureRepository,
////                        playerStatisticsRepository,
////                        playerRepository
////                );
////    }
//
////    public TeamStatisticsImportService getTeamStatisticsImportService() {
////        return teamStatisticsImportService;
////    }
//
//    public LeagueUkImportService getLeagueUkImportService() {return leagueUkImportService;}
//
////    public LeagueImportService getLeagueImportService() {
////        return leagueImportService;
////    }
//
//    public LeagueDataService getLeagueDataService() {
//        return leagueDataService;
//    }
//
//    public StandingsImportService getStandingsImportService() {return standingsImportService;}
//
//    public PlayerImportService getPlayerImportService() {return playerImportService;}
//
//}// End of AppConfig Class.
```

## File: footballapp/src/main/java/org/footballapp/controller/ClubController.java
```java
package org.footballapp.controller;

import org.footballapp.model.club.ClubDetails;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for club information.
 */
@RestController
public class ClubController {

    private final LeagueDataService leagueDataService;

    public ClubController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService = leagueDataService;
    }

    /**
     * Returns details for a single club.
     */
    @GetMapping("/club")
    public ClubDetails getClub(

            @RequestParam int clubId

    ) throws Exception {

        return leagueDataService.getClubDetails(
                clubId
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/FixtureDetailsController.java
```java
package org.footballapp.controller;

import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Returns data from a single fixture.
 */
@RestController
public class FixtureDetailsController {

    private final LeagueDataService
            leagueDataService;

    public FixtureDetailsController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/fixture")
    public Object getFixture(

            @RequestParam long fixtureId

    ) throws Exception {

        return leagueDataService.getFixtureDetails(
                fixtureId
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/FixturesController.java
```java
package org.footballapp.controller;

import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoints for league fixtures.
 */
@RestController
public class FixturesController {

    private final LeagueDataService
            leagueDataService;

    public FixturesController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    /**
     * Returns all fixtures for a league and season.
     */
    @GetMapping("/fixtures")
    public List<FixtureRow> getFixtures(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getFixtures(
                leagueId,
                season
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/LeagueOverviewController.java
```java
package org.footballapp.controller;

import org.footballapp.model.league.LeagueOverview;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for league overview information.
 */
@RestController
public class LeagueOverviewController {

    private final LeagueDataService
            leagueDataService;

    public LeagueOverviewController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    /**
     * Returns overview information for a league.
     */
    @GetMapping("/leagueOverview")
    public LeagueOverview getLeagueOverview(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getLeagueOverview(
                leagueId,
                season
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/LeaguesController.java
```java
package org.footballapp.controller;

//import org.footballapp.config.AppConfig;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaguesController {

    private final LeagueDataService
            leagueDataService;

    public LeaguesController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/leagues")
    public Object getEnabledLeagues()
            throws Exception {

        return leagueDataService
                .getEnabledLeagues();
    }
}
```

## File: footballapp/src/main/java/org/footballapp/controller/LeagueTableController.java
```java
package org.footballapp.controller;

import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoints for league standings.
 */
@RestController
public class LeagueTableController {

    private final LeagueDataService
            leagueDataService;

    public LeagueTableController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    /**
     * Returns the league table for a competition.
     */
    @GetMapping("/leagueTable")
    public List<LeagueTableRow> getLeagueTable(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getLeagueTable(
                leagueId,
                season
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/PlayerController.java
```java
package org.footballapp.controller;

import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for player information.
 */
@RestController
public class PlayerController {

    private final LeagueDataService
            leagueDataService;

    public PlayerController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/teamPlayers")
    public Object getPlayersForTeam(

            @RequestParam int teamId,

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getPlayersForTeam(
                teamId,
                leagueId,
                season
        );

    }

    /**
     * Returns detailed information for a player.
     */
    @GetMapping("/playerDetails")
    public PlayerDetails getPlayerDetails(

            @RequestParam int playerId,

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getPlayerDetails(
                playerId,
                leagueId,
                season
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/TeamDetailsController.java
```java
package org.footballapp.controller;

import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for team details.
 */
@RestController
public class TeamDetailsController {

    private final LeagueDataService
            leagueDataService;

    public TeamDetailsController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/teamDetails")
    public Object getTeamDetails(

            @RequestParam int leagueId,

            @RequestParam int season,

            @RequestParam int teamId

    ) throws Exception {

        return leagueDataService.getTeamDetails(
                leagueId,
                season,
                teamId
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/TeamFixturesController.java
```java
package org.footballapp.controller;

import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoints for a team's fixtures.
 */
@RestController
public class TeamFixturesController {

    private final LeagueDataService
            leagueDataService;

    public TeamFixturesController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/teamFixtures")
    public List<FixtureRow> getFixturesByTeam(

            @RequestParam int teamId

    ) throws Exception {

        return leagueDataService.getFixturesByTeam(
                teamId
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/TeamsController.java
```java
package org.footballapp.controller;

import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for league teams.
 */
@RestController
public class TeamsController {

    private final LeagueDataService
            leagueDataService;

    public TeamsController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/teams")
    public Object getTeamsForLeague(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getTeamsForLeague(
                leagueId,
                season
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/TeamStatisticsController.java
```java
//package org.footballapp.controller;
//
//import org.footballapp.config.AppConfig;
//import org.footballapp.model.teamstatistics.TeamStatistics;
//import org.footballapp.service.LeagueDataService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * REST endpoints for team statistics.
// */
//@RestController
//public class TeamStatisticsController {
//
//    private final LeagueDataService leagueDataService;
//
//    public TeamStatisticsController() {
//
//        AppConfig config =
//                new AppConfig();
//
//        leagueDataService =
//                config.getLeagueDataService();
//    }
//
//    /**
//     * Returns statistics for a team.
//     */
//    @GetMapping(
//            "/api/teams/{teamId}/statistics"
//    )
//    public TeamStatistics getTeamStatistics(
//
//            @PathVariable
//            int teamId,
//
//            @RequestParam
//            int leagueId,
//
//            @RequestParam
//            int season
//
//    ) throws Exception {
//
//        return leagueDataService
//                .getTeamStatistics(
//
//                        teamId,
//
//                        leagueId,
//
//                        season
//                );
//    }
//}
```

## File: footballapp/src/main/java/org/footballapp/database/DatabaseConnection.java
```java
package org.footballapp.database;

import java.sql.*;

/*
 * Creates JDBC connections to the PostgreSQL database.
 *
 * Connection details are supplied through environment variables.
 */
public class DatabaseConnection {

    private static final String URL =
            System.getenv("FOOTBALLAPP_DB_URL");

    private static final String USER =
            System.getenv("FOOTBALLAPP_DB_USER");

    private static final String PASSWORD =
            System.getenv("FOOTBALLAPP_DB_PASSWORD");

    /*
     * Opens a connection to the configured PostgreSQL database.
     */
    public static Connection connect() throws SQLException {

        System.out.println("DB_URL  = " + URL);
        System.out.println("DB_USER = " + USER);
        System.out.println("DB_PASS = " + (PASSWORD == null ? "null" : "***"));

        if (URL == null || USER == null || PASSWORD == null) {

            throw new IllegalStateException(
                    "FootballApp database environment variables are not configured."
            );

        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/FixtureRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixtureRow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Repository
public class FixtureRepository {

    public void saveFixture(FixtureResponse fixtureResponse)
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        
                                INSERT INTO fixtures
                        (
                            fixture_id,
                            league_id,
                            season,
                            round,
                            fixture_date,
                            venue_id,
                            home_team_id,
                            away_team_id,
                            home_goals,
                            away_goals
                        )
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                        ON CONFLICT (fixture_id)
                        DO UPDATE SET
                            home_goals = EXCLUDED.home_goals,
                            away_goals = EXCLUDED.away_goals
                        """
                );

        /**Setters*/
        stmt.setLong(
                1,
                fixtureResponse.getFixture().getId()
        );

        stmt.setInt(
                2,
                fixtureResponse.getLeague().getId()
        );

        stmt.setInt(
                3,
                fixtureResponse.getLeague().getSeason()
        );

        stmt.setString(
                4,
                fixtureResponse.getLeague().getRound()
        );

        stmt.setString(
                5,
                fixtureResponse.getFixture().getDate()
        );

        stmt.setInt(
                6,
                fixtureResponse.getFixture().getVenue().getId()
        );

        stmt.setInt(
                7,
                fixtureResponse.getTeams().getHome().getId()
        );

        stmt.setInt(
                8,
                fixtureResponse.getTeams().getAway().getId()
        );

        stmt.setObject(
                9,
                fixtureResponse.getGoals().getHome()
        );

        stmt.setObject(
                10,
                fixtureResponse.getGoals().getAway()
        );


        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**
     * Get fixtures from a particular season
     */
    public List<FixtureRow> getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.league_id = ?
                        AND f.season = ?
    
                        ORDER BY f.fixture_date
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> fixtures =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString(
                            "fixture_date"
                    )
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            fixtures.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return fixtures;
    }

    /**
     * Get fixtures for a team from a particular season
     */
    public List<FixtureRow> getLeagueFixtures(
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.league_id = ?
                        AND f.season = ?
    
                        ORDER BY f.fixture_date
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> fixtures =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString(
                            "fixture_date"
                    )
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            fixtures.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return fixtures;
    }
    /**
     * Get fixtures for a particular team.
     */
    public List<FixtureRow> getFixturesByTeam(
            int teamId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.home_team_id = ?
                           OR f.away_team_id = ?
    
                        ORDER BY f.fixture_date
                        """
                );

        stmt.setInt(1, teamId);
        stmt.setInt(2, teamId);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> fixtures =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString("fixture_date")
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            fixtures.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return fixtures;
    }

    /**
     * Get a particular team's recent results.
     */
    public List<FixtureRow> getRecentResults(
            int leagueId,
            int season,
            int limit
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.league_id = ?
                        AND f.season = ?
    
                        ORDER BY f.fixture_date DESC
    
                        LIMIT ?
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, limit);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> results =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString("fixture_date")
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            results.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return results;
    }
    /**
     * Get recent fixtures by Team.
     */
    public List<FixtureRow> getRecentFixturesByTeam(
            int teamId,
            int limit
    ) throws Exception {
        Connection conn =
                DatabaseConnection.connect();
                PreparedStatement stmt =
                        conn.prepareStatement(
                        """
              
                                SELECT
                                    f.fixture_id,
                                    f.fixture_date,
                                    home.name AS home_team,
                                    away.name AS away_team,
                                    f.home_team_id,
                                    f.away_team_id,
                                    f.home_goals,
                                    f.away_goals
              
                                FROM fixtures f
              
                                JOIN teams home
                                ON f.home_team_id = home.id
              
                                JOIN teams away
                                ON f.away_team_id = away.id
              
                                WHERE f.home_team_id = ?
                                OR f.away_team_id = ?
              
                                ORDER BY f.fixture_date DESC
              
              LIMIT ?
                    """
                );
        stmt.setInt(1, teamId);
        stmt.setInt(2, teamId);
        stmt.setInt(3, limit);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> results =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString("fixture_date")
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );
            row.setHomeGoals(
                    rs.getInt("home_goals")
            );
            row.setAwayGoals(
                    rs.getInt("away_goals")
            );
            results.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return results;
    }

    public FixtureRow getFixtureDetails(
            long fixtureId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.fixture_id = ?
                        """
                );

        stmt.setLong(
                1,
                fixtureId
        );

        ResultSet rs =
                stmt.executeQuery();

        FixtureRow row =
                new FixtureRow();

        if (rs.next()) {

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

            populateFixtureDateTime(
                    row,
                    rs.getString(
                            "fixture_date"
                    )
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return row;
    }

    /**
     * Date & Time helper method for UK style format
     */
    private void populateFixtureDateTime(
            FixtureRow row,
            String rawDate
    ) {

        OffsetDateTime fixtureDate =
                OffsetDateTime.parse(
                        rawDate
                );

        ZonedDateTime ukDateTime =
                fixtureDate
                        .atZoneSameInstant(
                                ZoneId.of(
                                        "Europe/London"
                                )
                        );

        row.setFixtureDate(
                ukDateTime.format(
                        DateTimeFormatter.ofPattern(
                                "EEE dd MMM yyyy"
                        )
                )
        );

        row.setFixtureTime(
                ukDateTime.format(
                        DateTimeFormatter.ofPattern(
                                "HH:mm"
                        )
                )
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/LeagueRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.league.League;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Handles persistence of league data.
 *
 * Responsible for inserting and updating records
 * in the leagues table.
 */
@Repository
public class LeagueRepository {

    /**
     * Saves a league to the database.
     *
     * If the league already exists, updates the existing record.
     */
    public void saveLeague(League league)
            throws Exception {
        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                       INSERT INTO leagues
                       (league_id, name, country, season)
                       VALUES (?, ?, ?, ?)
                       ON CONFLICT (league_id, season)
                       DO UPDATE SET
                           name = EXCLUDED.name,
                           country = EXCLUDED.country
                       """
                );

        stmt.setInt(1, league.getId());
        stmt.setString(2, league.getName());
        stmt.setString(3, league.getCountry());
        stmt.setInt(4, league.getSeason());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/LeagueTeamRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class LeagueTeamRepository {

    public void saveLeagueTeam(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO league_teams
                        (
                            league_id,
                            season,
                            team_id
                        )
                        VALUES (?, ?, ?)

                        ON CONFLICT
                        (
                            league_id,
                            season,
                            team_id
                        )
                        DO NOTHING
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, teamId);

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**
     * Returns all team IDs for a league and season.
     */
    public List<Integer> getTeamIds(
            int leagueId,
            int season
    ) throws Exception {

        List<Integer> teamIds =
                new ArrayList<>();

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT team_id
    
                        FROM league_teams
    
                        WHERE league_id = ?
                          AND season = ?
    
                        ORDER BY team_id
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        while (rs.next()) {

            teamIds.add(
                    rs.getInt("team_id")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return teamIds;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/LeagueUkRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.league.LeagueUk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeagueUkRepository {

    /**
     * Save league metadata
     */
    public void saveLeague(
            LeagueUk league
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO leagues_uk
                        (
                            league_id,
                            name,
                            country,
                            logo_url
                        )
                        VALUES (?, ?, ?, ?)

                        ON CONFLICT (league_id)
                        DO UPDATE SET

                            name =
                                EXCLUDED.name,

                            country =
                                EXCLUDED.country,

                            logo_url =
                                EXCLUDED.logo_url
                        """
                );

        stmt.setInt(
                1,
                league.getLeagueId()
        );

        stmt.setString(
                2,
                league.getName()
        );

        stmt.setString(
                3,
                league.getCountry()
        );

        stmt.setString(
                4,
                league.getLogoUrl()
        );

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**
     * Get all leagues in leagues_uk table in DB.
     */
    public List<LeagueUk> getLeagues()
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            league_id,
                            name,
                            country,
                            logo_url
                        FROM leagues_uk
                        ORDER BY country,
                                 name
                        """
                );

        ResultSet rs =
                stmt.executeQuery();

        List<LeagueUk> leagues =
                new ArrayList<>();

        while (rs.next()) {

            LeagueUk league =
                    new LeagueUk();

            league.setLeagueId(
                    rs.getInt(
                            "league_id"
                    )
            );

            league.setName(
                    rs.getString(
                            "name"
                    )
            );

            league.setCountry(
                    rs.getString(
                            "country"
                    )
            );

            league.setLogoUrl(
                    rs.getString(
                            "logo_url"
                    )
            );

            leagues.add(
                    league
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return leagues;
    } // End of get all leagues in league_uk table in DB.

    /**
     *Get specified leagues in league_uk table in DB.
     */
    public List<LeagueUk> getEnabledLeagues()
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            league_id,
                            name,
                            country,
                            logo_url
                        FROM leagues_uk
                        WHERE enabled = TRUE
                        ORDER BY country,
                                 name
                        """
                );

        ResultSet rs =
                stmt.executeQuery();

        List<LeagueUk> leagues =
                new ArrayList<>();

        while (rs.next()) {

            LeagueUk league =
                    new LeagueUk();

            league.setLeagueId(
                    rs.getInt("league_id")
            );

            league.setName(
                    rs.getString("name")
            );

            league.setCountry(
                    rs.getString("country")
            );

            league.setLogoUrl(
                    rs.getString("logo_url")
            );

            leagues.add(league);
        }

        rs.close();
        stmt.close();
        conn.close();

        return leagues;
    } // End of getEnabledLeagues().

    /**
     * Get league by id
     */
    public LeagueUk getLeagueById(
            int leagueId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            league_id,
                            name,
                            country,
                            logo_url
                        FROM leagues_uk
                        WHERE league_id = ?
                        """
                );

        stmt.setInt(
                1,
                leagueId
        );

        ResultSet rs =
                stmt.executeQuery();

        LeagueUk league = null;

        if (rs.next()) {

            league =
                    new LeagueUk();

            league.setLeagueId(
                    rs.getInt(
                            "league_id"
                    )
            );

            league.setName(
                    rs.getString(
                            "name"
                    )
            );

            league.setCountry(
                    rs.getString(
                            "country"
                    )
            );

            league.setLogoUrl(
                    rs.getString(
                            "logo_url"
                    )
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return league;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/PlayerRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.player.Player;
import org.footballapp.model.playerdetails.PlayerDetails;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

/**
 * Repository for storing player identity information.
 *
 * This repository only stores player details.
 * Season statistics are stored separately.
 */
@Repository
public class PlayerRepository {

    /**
     * Inserts or updates a player.
     */
    public void savePlayer(
            Player player
    ) throws Exception {

        String sql =
                """
                INSERT INTO players (
                    player_id,
                    firstname,
                    lastname,
                    display_name,
                    birth_date,
                    birth_place,
                    birth_country,
                    nationality,
                    age,
                    height,
                    weight,
                    injured,
                    photo_url
                )
                VALUES (
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
                )

                ON CONFLICT (player_id)

                DO UPDATE SET

                    firstname = EXCLUDED.firstname,
                    lastname = EXCLUDED.lastname,
                    display_name = EXCLUDED.display_name,
                    birth_date = EXCLUDED.birth_date,
                    birth_place = EXCLUDED.birth_place,
                    birth_country = EXCLUDED.birth_country,
                    nationality = EXCLUDED.nationality,
                    age = EXCLUDED.age,
                    height = EXCLUDED.height,
                    weight = EXCLUDED.weight,
                    injured = EXCLUDED.injured,
                    photo_url = EXCLUDED.photo_url
                """;

        try (

                Connection conn =
                        DatabaseConnection.connect();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setInt(
                    1,
                    player.getPlayerId()
            );

            stmt.setString(
                    2,
                    player.getFirstname()
            );

            stmt.setString(
                    3,
                    player.getLastname()
            );

            stmt.setString(
                    4,
                    player.getName()
            );

            /*
             * Birth information
             */
            if (player.getBirth() != null &&
                    player.getBirth().getDate() != null) {

                stmt.setDate(
                        5,
                        java.sql.Date.valueOf(
                                player.getBirth().getDate()
                        )
                );

            } else {

                stmt.setNull(
                        5,
                        Types.DATE
                );
            }

            stmt.setString(
                    6,
                    player.getBirth() != null
                            ? player.getBirth().getPlace()
                            : null
            );

            stmt.setString(
                    7,
                    player.getBirth() != null
                            ? player.getBirth().getCountry()
                            : null
            );

            stmt.setString(
                    8,
                    player.getNationality()
            );

            /*
             * Age
             */
            if (player.getAge() != null) {

                stmt.setInt(
                        9,
                        player.getAge()
                );

            } else {

                stmt.setNull(
                        9,
                        Types.INTEGER
                );
            }

            stmt.setString(
                    10,
                    player.getHeight()
            );

            stmt.setString(
                    11,
                    player.getWeight()
            );

            stmt.setBoolean(
                    12,
                    player.isInjured()
            );

            stmt.setString(
                    13,
                    player.getPhotoUrl()
            );

            stmt.executeUpdate();
        }
    } // End of savePlayer

    /**
     * Get player Details
     * Including Name, age, nationality, photo,
     * position, shirt number, appearances, goals, assists, cards
     */
    public PlayerDetails getPlayerDetails(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
    
                            p.player_id,
                            p.display_name,
                            p.firstname,
                            p.lastname,
                            p.age,
                            p.nationality,
                            p.photo_url,
    
                            ps.position,
                            ps.shirt_number,
                            ps.captain,
                            ps.appearances,
                            ps.minutes,
                            ps.goals,
                            ps.assists,
                            ps.yellow_cards,
                            ps.red_cards,
                            ps.rating,
                            ps.team_id,
                            t.name AS team_name,
                            ps.league_id,
                            l.name AS league_name,
                            ps.season
    
                        FROM players p
    
                        JOIN player_statistics ps
                          ON p.player_id = ps.player_id
                        
                        JOIN teams t
                          ON ps.team_id = t.id
                        
                        JOIN leagues l
                          ON ps.league_id = l.league_id
    
                        WHERE p.player_id = ?
                          AND ps.league_id = ?
                          AND ps.season = ?
                        """
                );

        stmt.setInt(1, playerId);
        stmt.setInt(2, leagueId);
        stmt.setInt(3, season);

        ResultSet rs =
                stmt.executeQuery();

        PlayerDetails details =
                new PlayerDetails();

        if (rs.next()) {

            details.setPlayerId(
                    rs.getInt("player_id")
            );

            details.setDisplayName(
                    rs.getString("display_name")
            );

            details.setFirstName(
                    rs.getString("firstname")
            );

            details.setLastName(
                    rs.getString("lastname")
            );

            details.setAge(
                    (Integer) rs.getObject("age")
            );

            details.setNationality(
                    rs.getString("nationality")
            );

            details.setPhotoUrl(
                    rs.getString("photo_url")
            );

            details.setPosition(
                    rs.getString("position")
            );

            details.setShirtNumber(
                    (Integer) rs.getObject("shirt_number")
            );

            details.setCaptain(
                    (Boolean) rs.getObject("captain")
            );

            details.setAppearances(
                    (Integer) rs.getObject("appearances")
            );

            details.setMinutes(
                    (Integer) rs.getObject("minutes")
            );

            details.setGoals(
                    (Integer) rs.getObject("goals")
            );

            details.setAssists(
                    rs.getObject("assists") == null
                            ? 0
                            : rs.getInt("assists")
            );

            details.setYellowCards(
                    (Integer) rs.getObject("yellow_cards")
            );

            details.setRedCards(
                    (Integer) rs.getObject("red_cards")
            );

            details.setRating(
                    (Double) rs.getObject("rating")
            );

            details.setTeamId(
                    (Integer) rs.getObject("team_id")
            );

            details.setTeamName(
                    rs.getString("team_name")
            );

            details.setLeagueId(
                    (Integer) rs.getObject("league_id")
            );

            details.setLeagueName(
                    rs.getString("league_name")
            );

            details.setSeason(
                    (Integer) rs.getObject("season")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return details;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/PlayerStatisticsRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.playerstatistics.PlayerStatistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for storing player statistics.
 */
@Repository
public class PlayerStatisticsRepository {

    public void savePlayerStatistics(
            int playerId,
            int season,
            PlayerStatistics statistics
    ) throws Exception {

        String sql =
                """
                INSERT INTO player_statistics (

                    player_id,
                    team_id,
                    league_id,
                    season,

                    position,
                    shirt_number,
                    captain,

                    appearances,
                    starts,
                    minutes,

                    goals,
                    assists,

                    yellow_cards,
                    red_cards,

                    rating

                )

                VALUES (

                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?

                )

                ON CONFLICT (

                    player_id,
                    league_id,
                    season

                )

                DO UPDATE SET

                    team_id = EXCLUDED.team_id,

                    position = EXCLUDED.position,
                    shirt_number = EXCLUDED.shirt_number,
                    captain = EXCLUDED.captain,

                    appearances = EXCLUDED.appearances,
                    starts = EXCLUDED.starts,
                    minutes = EXCLUDED.minutes,

                    goals = EXCLUDED.goals,
                    assists = EXCLUDED.assists,

                    yellow_cards = EXCLUDED.yellow_cards,
                    red_cards = EXCLUDED.red_cards,

                    rating = EXCLUDED.rating
                """;

        try (

                Connection conn =
                        DatabaseConnection.connect();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setInt(
                    1,
                    playerId
            );

            stmt.setInt(
                    2,
                    statistics.getTeam()
                            .getTeamId()
            );

            stmt.setInt(
                    3,
                    statistics.getLeague()
                            .getLeagueId()
            );

            stmt.setInt(
                    4,
                    season
            );

            /*
             * Games
             */

            stmt.setString(
                    5,
                    statistics.getGames()
                            .getPosition()
            );

            if (statistics.getGames()
                    .getNumber() != null) {

                stmt.setInt(
                        6,
                        statistics.getGames()
                                .getNumber()
                );

            } else {

                stmt.setNull(
                        6,
                        Types.INTEGER
                );
            }

            if (statistics.getGames()
                    .getCaptain() != null) {

                stmt.setBoolean(
                        7,
                        statistics.getGames()
                                .getCaptain()
                );

            } else {

                stmt.setNull(
                        7,
                        Types.BOOLEAN
                );
            }

            /*
             * Appearances
             */

            if (statistics.getGames()
                    .getAppearances() != null) {

                stmt.setInt(
                        8,
                        statistics.getGames()
                                .getAppearances()
                );

            } else {

                stmt.setNull(
                        8,
                        Types.INTEGER
                );
            }

            if (statistics.getGames()
                    .getLineups() != null) {

                stmt.setInt(
                        9,
                        statistics.getGames()
                                .getLineups()
                );

            } else {

                stmt.setNull(
                        9,
                        Types.INTEGER
                );
            }

            if (statistics.getGames()
                    .getMinutes() != null) {

                stmt.setInt(
                        10,
                        statistics.getGames()
                                .getMinutes()
                );

            } else {

                stmt.setNull(
                        10,
                        Types.INTEGER
                );
            }

            /*
             * Goals
             */

            if (statistics.getGoals()
                    .getTotal() != null) {

                stmt.setInt(
                        11,
                        statistics.getGoals()
                                .getTotal()
                );

            } else {

                stmt.setNull(
                        11,
                        Types.INTEGER
                );
            }

            if (statistics.getGoals()
                    .getAssists() != null) {

                stmt.setInt(
                        12,
                        statistics.getGoals()
                                .getAssists()
                );

            } else {

                stmt.setNull(
                        12,
                        Types.INTEGER
                );
            }

            /*
             * Cards
             */

            if (statistics.getCards()
                    .getYellow() != null) {

                stmt.setInt(
                        13,
                        statistics.getCards()
                                .getYellow()
                );

            } else {

                stmt.setNull(
                        13,
                        Types.INTEGER
                );
            }

            if (statistics.getCards()
                    .getRed() != null) {

                stmt.setInt(
                        14,
                        statistics.getCards()
                                .getRed()
                );

            } else {

                stmt.setNull(
                        14,
                        Types.INTEGER
                );
            }

            /*
             * Rating
             */

            if (statistics.getGames()
                    .getRating() != null &&
                    !statistics.getGames()
                            .getRating()
                            .isBlank()) {

                stmt.setBigDecimal(
                        15,
                        new java.math.BigDecimal(
                                statistics.getGames()
                                        .getRating()
                        )
                );

            } else {

                stmt.setNull(
                        15,
                        Types.DECIMAL
                );
            }

            stmt.executeUpdate();
        }
    }

    /**
     * Get Player line up from a game
     */

    public List<PlayerSummary> getPlayersForTeam(
            int teamId,
            int leagueId,
            int season
    )throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
    
                            p.player_id,
                            p.display_name,
                            p.photo_url,
                            p.nationality,
                            p.age,
    
                            ps.position,
                            ps.shirt_number,
                            ps.captain,
                            ps.appearances,
                            ps.goals,
                            ps.assists
    
                        FROM players p
    
                        JOIN player_statistics ps
                          ON p.player_id = ps.player_id
    
                        WHERE ps.team_id = ?
                          AND ps.league_id = ?
                          AND ps.season = ?
    
                        ORDER BY
                        CASE ps.position
                            
                            WHEN 'Goalkeeper' THEN 1
                            WHEN 'Defender'   THEN 2
                            WHEN 'Midfielder' THEN 3
                            WHEN 'Attacker'   THEN 4
                        
                            ELSE 5
                        END,
                            
                        p.display_name;
                            
                        """
                );

        stmt.setInt(1, teamId);
        stmt.setInt(2, leagueId);
        stmt.setInt(3, season);

        ResultSet rs =
                stmt.executeQuery();

        List<PlayerSummary> players =
                new ArrayList<>();

        while (rs.next()) {

            PlayerSummary player =
                    new PlayerSummary();

            player.setPlayerId(
                    rs.getInt("player_id")
            );

            player.setDisplayName(
                    rs.getString("display_name")
            );

            player.setPhotoUrl(
                    rs.getString("photo_url")
            );

            player.setNationality(
                    rs.getString("nationality")
            );

            player.setAge(
                    (Integer) rs.getObject("age")
            );

            player.setPosition(
                    rs.getString("position")
            );

            if (!rs.wasNull()) {
                player.setShirtNumber(
                        (Integer) rs.getObject(
                                "shirt_number"
                        )
                );
            }

            player.setCaptain(
                    (Boolean) rs.getObject(
                            "captain"
                    )
            );

            player.setAppearances(
                    (Integer) rs.getObject(
                            "appearances"
                    )
            );

            player.setGoals(
                    (Integer) rs.getObject(
                            "goals"
                    )
            );

            player.setAssists(
                    (Integer) rs.getObject(
                            "assists"
                    )
            );

            players.add(player);
        }

        rs.close();
        stmt.close();
        conn.close();

        return players;
    }

} // End of Class.
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/StandingRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.LeagueTableRow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StandingRepository {

    public void saveStanding(
            int leagueId,
            int season,
            Standing standing
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO standings
                        (
                            league_id,
                            season,
                            team_id,
                            position,
                            points,
                            goal_difference,
                            played,
                            wins,
                            draws,
                            losses,
                            goals_for,
                            goals_against
                        )
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

                        ON CONFLICT
                        (
                            league_id,
                            season,
                            team_id
                        )
                        DO UPDATE SET

                            position =
                                EXCLUDED.position,

                            points =
                                EXCLUDED.points,

                            goal_difference =
                                EXCLUDED.goal_difference,

                            played =
                                EXCLUDED.played,

                            wins =
                                EXCLUDED.wins,

                            draws =
                                EXCLUDED.draws,

                            losses =
                                EXCLUDED.losses,

                            goals_for =
                                EXCLUDED.goals_for,

                            goals_against =
                                EXCLUDED.goals_against
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        stmt.setInt(
                3,
                standing.getTeam().getId()
        );

        stmt.setInt(
                4,
                standing.getRank()
        );

        stmt.setInt(
                5,
                standing.getPoints()
        );

        stmt.setInt(
                6,
                standing.getGoalsDiff()
        );

        stmt.setInt(
                7,
                standing.getAll().getPlayed()
        );

        stmt.setInt(
                8,
                standing.getAll().getWin()
        );

        stmt.setInt(
                9,
                standing.getAll().getDraw()
        );

        stmt.setInt(
                10,
                standing.getAll().getLose()
        );

        stmt.setInt(
                11,
                standing.getAll()
                        .getGoals()
                        .getForGoals()
        );

        stmt.setInt(
                12,
                standing.getAll()
                        .getGoals()
                        .getAgainst()
        );

        System.out.println(
                standing.getTeam().getId()
                        + " Played="
                        + standing.getAll().getPlayed()
        );

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    public List<LeagueTableRow> getLeagueTable(
            int leagueId,
            int season
    )
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            s.position,
                            s.team_id,
                            t.name,
                            s.played,
                            s.wins,
                            s.draws,
                            s.losses,
                            s.goal_difference,
                            s.points
                        FROM standings s
                        JOIN teams t
                            ON s.team_id = t.id
                        WHERE s.league_id = ?
                        AND s.season = ?
                        ORDER BY s.position
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<LeagueTableRow> table =
                new ArrayList<>();

        while (rs.next()) {

            LeagueTableRow row =
                    new LeagueTableRow();

            row.setPosition(
                    rs.getInt("position")
            );

            row.setTeamId(
                    rs.getInt("team_id")
            );

            row.setTeamName(
                    rs.getString("name")
            );

            row.setPlayed(
                    rs.getInt("played")
            );

            row.setWins(
                    rs.getInt("wins")
            );

            row.setDraws(
                    rs.getInt("draws")
            );

            row.setLosses(
                    rs.getInt("losses")
            );

            row.setGoalDifference(
                    rs.getInt("goal_difference")
            );

            row.setPoints(
                    rs.getInt("points")
            );

            table.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return table;
    }

    /**
     * Returns a team's league standing
     */
    public LeagueTableRow getTeamStanding(
            int leagueId,
            int season,
            int teamId
    )
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            s.position,
                            t.name,
                            s.points
                        FROM standings s
                        JOIN teams t
                            ON s.team_id = t.id
                        WHERE s.league_id = ?
                        AND s.season = ?
                        AND s.team_id = ?
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, teamId);

        ResultSet rs =
                stmt.executeQuery();

        LeagueTableRow row = null;

        if (rs.next()) {

            row = new LeagueTableRow();

            row.setPosition(
                    rs.getInt("position")
            );

            row.setTeamName(
                    rs.getString("name")
            );

            row.setPoints(
                    rs.getInt("points")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return row;
    }

    /**
     * Get team id
     */
    public List<Integer> getTeamIds(
            int leagueId,
            int season
    ) throws Exception {

        List<Integer> teamIds =
                new ArrayList<>();

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT team_id
        
                        FROM standings
        
                        WHERE league_id = ?
                          AND season = ?
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        while (rs.next()) {

            teamIds.add(
                    rs.getInt("team_id")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return teamIds;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/TeamRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teams.Team;
import org.footballapp.model.club.ClubDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles persistence of team data.
 *
 * Responsible for inserting and updating records
 * in the teams table.
 */
@Repository
public class TeamRepository {

    /**
     * Saves a team to the database.
     *
     * If the team already exists, updates the existing record.
     */
    public void saveTeam(Team team) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(

                        """
                       INSERT INTO teams
                       (id, name, country, founded, venue_id)
                       VALUES (?, ?, ?, ?, ?)
                       ON CONFLICT (id)
                       DO UPDATE SET
                          name = EXCLUDED.name,
                          country = EXCLUDED.country,
                          founded = EXCLUDED.founded,
                          venue_id = EXCLUDED.venue_id
                       """
                );

        stmt.setInt(1, team.getId());
        stmt.setString(2, team.getName());
        stmt.setString(3, team.getCountry());
        stmt.setInt(4, team.getFounded());
        stmt.setInt(5, team.getVenueId());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**Test GET Team By ID.*/
    public Team getTeamById(int teamId)
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT *
                        FROM teams
                        WHERE id = ?
                        """
                );

        stmt.setInt(1, teamId);

        ResultSet rs =
                stmt.executeQuery();

        Team team = null;

        if (rs.next()) {

            team = new Team();

            team.setId(
                    rs.getInt("id")
            );

            team.setName(
                    rs.getString("name")
            );

            team.setCountry(
                    rs.getString("country")
            );

            team.setFounded(
                    rs.getInt("founded")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return team;
    }

    /** GET League & Season to JOIN with Team */
    public List<Team> getTeamsForLeague(
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            t.id,
                            t.name,
                            t.country,
                            t.founded
                        FROM teams t
    
                        JOIN standings lt
                            ON t.id = lt.team_id
    
                        WHERE lt.league_id = ?
                        AND lt.season = ?
    
                        ORDER BY t.name
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<Team> teams =
                new ArrayList<>();

        while (rs.next()) {

            Team team =
                    new Team();

            team.setId(
                    rs.getInt("id")
            );

            team.setName(
                    rs.getString("name")
            );

            team.setCountry(
                    rs.getString("country")
            );

            team.setFounded(
                    rs.getInt("founded")
            );

            teams.add(team);
        }

        rs.close();
        stmt.close();
        conn.close();

        return teams;
    }

    /**
     * Get Club Details - Retrieves full club details including venue information.
     */
    public ClubDetails getClubDetails(
            int clubId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            t.id,
                            t.name,
                            t.country,
                            t.founded,
                            v.name AS stadium,
                            v.city,
                            v.capacity
    
                        FROM teams t
    
                        LEFT JOIN venues v
                            ON t.venue_id = v.id
    
                        WHERE t.id = ?
                        """
                );

        stmt.setInt(1, clubId);

        ResultSet rs =
                stmt.executeQuery();

        ClubDetails club = null;

        if (rs.next()) {

            club = new ClubDetails();

            club.setClubId(
                    rs.getInt("id")
            );

            club.setName(
                    rs.getString("name")
            );

            club.setCountry(
                    rs.getString("country")
            );

            club.setFounded(
                    rs.getInt("founded")
            );

            club.setStadium(
                    rs.getString("stadium")
            );

            club.setCity(
                    rs.getString("city")
            );

            club.setCapacity(
                    rs.getInt("capacity")
            );

        }

        rs.close();
        stmt.close();
        conn.close();

        return club;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/TeamStatisticsRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teamstatistics.CardColour;
import org.footballapp.model.teamstatistics.CardMinute;
import org.footballapp.model.teamstatistics.TeamStatistics;
import org.footballapp.model.teamstatistics.TeamStatisticsResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.apache.logging.log4j.util.Lazy.value;

@Repository
public class TeamStatisticsRepository {

    /**
     * Saves team statistics to PostgreSQL.
     */
    public void save(
            TeamStatisticsResponse stats
    ) throws Exception {

        String sql = """
                INSERT INTO team_statistics (

                    team_id,
                    league_id,
                    season,

                    played,
                    wins,
                    draws,
                    losses,

                    goals_for,
                    goals_against,

                    clean_sheets,
                    failed_to_score,

                    yellow_cards,
                    red_cards

                )
                VALUES (

                    ?, ?, ?,
                    ?, ?, ?, ?,
                    ?, ?,
                    ?, ?,
                    ?, ?

                )

                ON CONFLICT (
                    team_id,
                    league_id,
                    season
                )

                DO UPDATE SET

                    played = EXCLUDED.played,
                    wins = EXCLUDED.wins,
                    draws = EXCLUDED.draws,
                    losses = EXCLUDED.losses,

                    goals_for = EXCLUDED.goals_for,
                    goals_against = EXCLUDED.goals_against,

                    clean_sheets = EXCLUDED.clean_sheets,
                    failed_to_score = EXCLUDED.failed_to_score,

                    yellow_cards = EXCLUDED.yellow_cards,
                    red_cards = EXCLUDED.red_cards
                """;

        try (

                Connection conn =
                        DatabaseConnection.connect();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setInt(
                    1,
                    stats.getTeam().getId()
            );

            statement.setInt(
                    2,
                    stats.getLeague().getId()
            );

            statement.setInt(
                    3,
                    stats.getLeague().getSeason()
            );

            statement.setInt(
                    4,
                    stats.getFixtures()
                            .getPlayed()
                            .getTotal()
            );

            statement.setInt(
                    5,
                    stats.getFixtures()
                            .getWins()
                            .getTotal()
            );

            statement.setInt(
                    6,
                    stats.getFixtures()
                            .getDraws()
                            .getTotal()
            );

            statement.setInt(
                    7,
                    stats.getFixtures()
                            .getLoses()
                            .getTotal()
            );

            statement.setInt(
                    8,
                    stats.getGoals()
                            .getForGoals()
                            .getTotal()
                            .getTotal()
            );

            statement.setInt(
                    9,
                    stats.getGoals()
                            .getAgainst()
                            .getTotal()
                            .getTotal()
            );

            statement.setInt(
                    10,
                    stats.getClean_sheet()
                            .getTotal()
            );

            statement.setInt(
                    11,
                    stats.getFailed_to_score()
                            .getTotal()
            );

            statement.setInt(
                    12,
                    getYellowCards(stats)
            );

            statement.setInt(
                    13,
                    getRedCards(stats)
            );

            statement.executeUpdate();
        }
    }// End of save.
    private int getYellowCards(
            TeamStatisticsResponse stats
    ) {

        return sumCards(
                stats.getCards().getYellow()
        );
    }

    private int getRedCards(
            TeamStatisticsResponse stats
    ) {

        return sumCards(
                stats.getCards().getRed()
        );
    }

    private int sumCards(
            CardColour colour
    ) {

        return value(colour.getMinute0to15())
                + value(colour.getMinute16to30())
                + value(colour.getMinute31to45())
                + value(colour.getMinute46to60())
                + value(colour.getMinute61to75())
                + value(colour.getMinute76to90())
                + value(colour.getMinute91to105())
                + value(colour.getMinute106to120());
    }

    private int value(
            CardMinute minute
    ) {

        if (minute == null) {
            return 0;
        }

        return minute.getTotal() == null
                ? 0
                : minute.getTotal();
    }

    /**
     * Returns statistics for a team in a league season.
     */
    public TeamStatistics getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT *
    
                        FROM team_statistics
    
                        WHERE team_id = ?
                          AND league_id = ?
                          AND season = ?
                        """
                );

        stmt.setInt(1, teamId);
        stmt.setInt(2, leagueId);
        stmt.setInt(3, season);

        ResultSet rs =
                stmt.executeQuery();

        TeamStatistics statistics = null;

        if (rs.next()) {

            statistics =
                    new TeamStatistics();

            statistics.setTeamId(
                    rs.getInt("team_id")
            );

            statistics.setLeagueId(
                    rs.getInt("league_id")
            );

            statistics.setSeason(
                    rs.getInt("season")
            );

            statistics.setPlayed(
                    rs.getInt("played")
            );

            statistics.setWins(
                    rs.getInt("wins")
            );

            statistics.setDraws(
                    rs.getInt("draws")
            );

            statistics.setLosses(
                    rs.getInt("losses")
            );

            statistics.setGoalsFor(
                    rs.getInt("goals_for")
            );

            statistics.setGoalsAgainst(
                    rs.getInt("goals_against")
            );

            statistics.setCleanSheets(
                    rs.getInt("clean_sheets")
            );

            statistics.setFailedToScore(
                    rs.getInt("failed_to_score")
            );

            statistics.setYellowCards(
                    rs.getInt("yellow_cards")
            );

            statistics.setRedCards(
                    rs.getInt("red_cards")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return statistics;
    }
} // End of Class.
```

## File: footballapp/src/main/java/org/footballapp/databaserepository/VenueRepository.java
```java
package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teams.Venue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Handles persistence of venue data.
 *
 * Responsible for inserting and updating records
 * in the venue table.
 */
@Repository
public class VenueRepository {

    /**
     * Saves a venue to the database.
     *
     * If the venue already exists, updates the existing record.
     */
    public void saveVenue(Venue venues) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(

                        """
                        INSERT INTO venues
                        (id, name, address, city, capacity, surface)
                        VALUES (?, ?, ?, ?, ?, ?)
                        ON CONFLICT (id)
                        DO UPDATE SET
                           city = EXCLUDED.city,
                           capacity = EXCLUDED.capacity,
                           name = EXCLUDED.name,
                           address = EXCLUDED.address,
                           surface = EXCLUDED.surface
                        """
                );

        stmt.setInt(1, venues.getId());
        stmt.setString(2, venues.getName());
        stmt.setString(3, venues.getAddress());
        stmt.setString(4, venues.getCity());
        stmt.setInt(5, venues.getCapacity());
        stmt.setString(6, venues.getSurface());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    public Venue getVenueForTeam(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT DISTINCT
                            v.id,
                            v.name,
                            v.address,
                            v.city,
                            v.capacity,
                            v.surface
                        FROM venues v
                        JOIN fixtures f
                            ON v.id = f.venue_id
                        WHERE f.league_id = ?
                        AND f.season = ?
                        AND f.home_team_id = ?
                        LIMIT 1
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, teamId);

        ResultSet rs =
                stmt.executeQuery();

        Venue venue = null;

        if (rs.next()) {

            venue =
                    new Venue();

            venue.setId(
                    rs.getInt("id")
            );

            venue.setName(
                    rs.getString("name")
            );

            venue.setAddress(
                    rs.getString("address")
            );

            venue.setCity(
                    rs.getString("city")
            );

            venue.setCapacity(
                    rs.getInt("capacity")
            );

            venue.setSurface(
                    rs.getString("surface")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return venue;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/club/ClubDetails.java
```java
package org.footballapp.model.club;

public class ClubDetails {

    private int clubId;
    private String name;
    private String country;
    private int founded;

    private String stadium;
    private String city;
    private int capacity;

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/Fixture.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {

    private long id;
    private String date;
    private FixtureVenue venue;

    public Fixture() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FixtureVenue getVenue() {
        return venue;
    }

    public void setVenue(FixtureVenue venue) {
        this.venue = venue;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureGoals.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureGoals {

    private Integer home;
    private Integer away;

    public FixtureGoals() {
    }

    /**Getters and Setters*/
    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Integer getAway() {
        return away;
    }

    public void setAway(Integer away) {
        this.away = away;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureLeague.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLeague {
    private int id;
    private int season;
    private String round;

    public FixtureLeague() {
    }

    /** Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureResponse.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureResponse {

    private Fixture fixture;
    private FixtureLeague league;
    private FixtureTeams teams;
    private FixtureGoals goals;

    public FixtureResponse() {
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public FixtureLeague getLeague() {
        return league;
    }

    public void setLeague(FixtureLeague league) {
        this.league = league;
    }

    public FixtureTeams getTeams() {
        return teams;
    }

    public void setTeams(FixtureTeams teams) {
        this.teams = teams;
    }

    public FixtureGoals getGoals() {
        return goals;
    }

    public void setGoals(FixtureGoals goals) {
        this.goals = goals;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureRow.java
```java
package org.footballapp.model.fixtures;

public class FixtureRow {

    private long fixtureId;
    private String fixtureDate;
    private String fixtureTime;
    private int homeTeamId;
    private int awayTeamId;
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    //private String round;

    /**Getters and Setters*/
    public long getFixtureId() {return fixtureId;}

    public void setFixtureId(long fixtureId) {this.fixtureId = fixtureId;}

    public String getFixtureDate() {return fixtureDate;}

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public String getFixtureTime() {return fixtureTime;}
    public void setFixtureTime(String fixtureTime) {this.fixtureTime = fixtureTime;}

    public int getHomeTeamId() {return homeTeamId;}

    public void setHomeTeamId(int homeTeamId) {this.homeTeamId = homeTeamId;}

    public int getAwayTeamId() {return awayTeamId;}

    public void setAwayTeamId(int awayTeamId) {this.awayTeamId = awayTeamId;}

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

//    public String getRound() {
//        return round;
//    }
//
//    public void setRound(String round) {
//        this.round = round;
//    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixturesApiResponse.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesApiResponse {

    private List<FixtureResponse> response;

    public FixturesApiResponse() {
    }

    public List<FixtureResponse> getResponse() {
        return response;
    }

    public void setResponse(List<FixtureResponse> response) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeam.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeam {
    private int id;
    private String name;

    public FixtureTeam() {

    }

    /**Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeams.java
```java
package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeams {

    private FixtureTeam home;
    private FixtureTeam away;

    public FixtureTeam getHome() {
        return home;
    }

    public void setHome(FixtureTeam home) {
        this.home = home;
    }

    /**Getters and Setters*/
    public FixtureTeam getAway() {
        return away;
    }

    public void setAway(FixtureTeam away) {
        this.away = away;
    }

    public FixtureTeams() {
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureVenue.java
```java
package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureVenue {

    private int id;
    private String name;
    private String city;

    public FixtureVenue() {
    }

    /**Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/CountryInfo.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInfo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/League.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a football league & season returned by API-Football.
 *
 * Mapped from the JSON "team" object.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    private int id;
    private String name;
    private String country;
    private int season;

    public League() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueApiInfo.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueApiInfo {

    private int id;
    private String name;
    private String logo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueApiResponse.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueApiResponse {

    private LeagueApiInfo league;
    private CountryInfo country;

    public LeagueApiInfo getLeague() {
        return league;
    }

    public void setLeague(
            LeagueApiInfo league
    ) {
        this.league = league;
    }

    public CountryInfo getCountry() {
        return country;
    }

    public void setCountry(
            CountryInfo country
    ) {
        this.country = country;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueOverview.java
```java
package org.footballapp.model.league;

public class LeagueOverview {

    private int leagueId;
    private String leagueName;
    private int season;
    private int teamCount;
    private int fixtureCount;

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }

    public int getFixtureCount() {
        return fixtureCount;
    }

    public void setFixtureCount(int fixtureCount) {
        this.fixtureCount = fixtureCount;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueResponse.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a single entry within the API-Football
 * response array.
 *
 * Each response contains:
 * - League information
 * - Country information
 * - Season information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueResponse {
    private int id;
    private String name;
    private String country;
    private int season;

    public LeagueResponse() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeaguesApiResponse.java
```java
package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguesApiResponse {

    private List<LeagueApiResponse> response;

    public List<LeagueApiResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<LeagueApiResponse> response
    ) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueTeam.java
```java
package org.footballapp.model.league;

public class LeagueTeam {

    private int leagueId;
    private int season;
    private int teamId;

    public LeagueTeam() {
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/league/LeagueUk.java
```java
package org.footballapp.model.league;

public class LeagueUk {

    private int leagueId;
    private String name;
    private String country;
    private String logoUrl;

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/player/Player.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a football player returned by API-Football.
 *
 * This model contains player identity information only.
 * Season statistics are stored separately.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @JsonProperty("id")
    private int playerId;

    private String name;
    private String firstname;
    private String lastname;

    private Integer age;

    private String nationality;

    private String height;
    private String weight;

    private boolean injured;

    @JsonProperty("photo")
    private String photoUrl;

    private PlayerBirth birth;

    public Player() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public PlayerBirth getBirth() {
        return birth;
    }

    public void setBirth(PlayerBirth birth) {
        this.birth = birth;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerDetails.java
```java
package org.footballapp.model.playerdetails;

public class PlayerDetails {

    private int playerId;

    private String displayName;

    private String firstName;

    private String lastName;

    private Integer age;

    private String nationality;

    private String photoUrl;

    private String position;

    private Integer shirtNumber;

    private Boolean captain;

    private Integer appearances;

    private Integer minutes;

    private Integer goals;

    private Integer assists;

    private Integer yellowCards;

    private Integer redCards;

    private Double rating;

    private Integer teamId;

    private String teamName;

    private Integer leagueId;

    private String leagueName;

    private Integer season;

    /**
     * Constructor
     */
    public PlayerDetails() {
    }

    /**
     * getters and Setters
     */
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearances) {
        this.appearances = appearances;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerSummary.java
```java
package org.footballapp.model.playerdetails;

/**
 * Summary information about a player for the Team Squad screen.
 */
public class PlayerSummary {

    private int playerId;

    private Integer age;

    private String nationality;

    private String displayName;

    private String photoUrl;

    private String position;

    private Integer shirtNumber;

    private Boolean captain;

    private Integer appearances;

    private Integer goals;

    private Integer assists;

    public PlayerSummary() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearances) {
        this.appearances = appearances;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerCards.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerCards {

    private Integer yellow;
    private Integer red;

    public PlayerCards() {
    }

    public Integer getYellow() {
        return yellow;
    }

    public void setYellow(Integer yellow) {
        this.yellow = yellow;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGames.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerGames {

    @JsonProperty("appearences")
    private Integer appearances;
    private Integer lineups;
    private Integer minutes;

    private String position;

    private Integer number;

    private Boolean captain;

    private String rating;

    public PlayerGames() {
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearences) {
        this.appearances = appearences;
    }

    public Integer getLineups() {
        return lineups;
    }

    public void setLineups(Integer lineups) {
        this.lineups = lineups;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGoals.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerGoals {

    private Integer total;
    private Integer assists;

    public PlayerGoals() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerLeague.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * League information contained within a player's statistics.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerLeague {

    @JsonProperty("id")
    private int leagueId;

    private String name;

    private int season;

    public PlayerLeague() {
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerStatistics.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatistics {

    private PlayerTeam team;

    private PlayerLeague league;

    private PlayerGames games;

    private PlayerGoals goals;

    private PlayerCards cards;

    public PlayerStatistics() {
    }

    public PlayerTeam getTeam() {
        return team;
    }

    public void setTeam(PlayerTeam team) {
        this.team = team;
    }

    public PlayerLeague getLeague() {
        return league;
    }

    public void setLeague(PlayerLeague league) {
        this.league = league;
    }

    public PlayerGames getGames() {
        return games;
    }

    public void setGames(PlayerGames games) {
        this.games = games;
    }

    public PlayerGoals getGoals() {
        return goals;
    }

    public void setGoals(PlayerGoals goals) {
        this.goals = goals;
    }

    public PlayerCards getCards() {
        return cards;
    }

    public void setCards(PlayerCards cards) {
        this.cards = cards;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerTeam.java
```java
package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Team information contained within a player's statistics.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerTeam {

    @JsonProperty("id")
    private int teamId;

    private String name;

    @JsonProperty("logo")
    private String logoUrl;

    public PlayerTeam() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/LeagueTableRow.java
```java
package org.footballapp.model.standings;


public class LeagueTableRow {

    private int position;
    private int teamId;
    private String teamName;
    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int goalDifference;
    private int points;

    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}

    public int getTeamId() {return teamId;}

    public void setTeamId(int teamId) {this.teamId = teamId;}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayed() {return played;}

    public void setPlayed(int played) {this.played = played;}

    public int getWins() {return wins;}

    public void setWins(int wins) {this.wins = wins;}

    public int getDraws() {return draws;}

    public void setDraws(int draws) {this.draws = draws;}

    public int getLosses() {return losses;}

    public void setLosses(int losses) {this.losses = losses;}

    public int getGoalDifference() {return goalDifference;}

    public void setGoalDifference(int goalDifference) {this.goalDifference = goalDifference;}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/Standing.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Standing {

    private int rank;

    private StandingTeam team;

    private int points;

    private int goalsDiff;

    private StandingRecord all;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public StandingTeam getTeam() {
        return team;
    }

    public void setTeam(StandingTeam team) {this.team = team;}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public StandingRecord getAll() {
        return all;
    }

    public void setAll(StandingRecord all) {this.all = all;}
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingAll.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingAll {

    private int played;
    private int win;
    private int draw;
    private int lose;

    /**Getters and Setters*/
    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingGoals.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingGoals {

    private int forGoals;
    private int against;

    @JsonProperty("for")
    public void setForGoals(int forGoals) {
        this.forGoals = forGoals;
    }

    public int getForGoals() {
        return forGoals;
    }

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingLeague.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingLeague {

    private int id;
    private int season;

    private List<List<Standing>> standings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public List<List<Standing>> getStandings() {
        return standings;
    }

    public void setStandings(
            List<List<Standing>> standings
    ) {
        this.standings = standings;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingRecord.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingRecord {

    private int played;
    private int win;
    private int draw;
    private int lose;

    private StandingGoals goals;

    /**Getters and Setters*/
    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public StandingGoals getGoals() {
        return goals;
    }

    public void setGoals(StandingGoals goals) {
        this.goals = goals;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingsApiResponse.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsApiResponse {

    private List<StandingsResponse> response;

    public List<StandingsResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<StandingsResponse> response
    ) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingsResponse.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsResponse {

    private StandingLeague league;

    public StandingLeague getLeague() {
        return league;
    }

    public void setLeague(
            StandingLeague league
    ) {
        this.league = league;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/standings/StandingTeam.java
```java
package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingTeam {

    private int id;
    private String name;

    /**Getters and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamdetails/TeamDetails.java
```java
package org.footballapp.model.teamdetails;

import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.teams.Team;
import org.footballapp.model.teams.Venue;

import java.util.List;

/**
 * Returns team, league position, points, form and recent fixtures.
 */
public class TeamDetails {

    private Team team;

    private Venue venue;

    private int leaguePosition;

    private int points;

    private String form;

    private List<FixtureRow> recentFixtures;

    public TeamDetails() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public List<FixtureRow> getRecentFixtures() {
        return recentFixtures;
    }

    public void setRecentFixtures(
            List<FixtureRow> recentFixtures
    ) {
        this.recentFixtures = recentFixtures;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/ID.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Returns the ID received from TeamResponse.
@JsonIgnoreProperties(ignoreUnknown = true)
public class ID {

    private int id;

    public ID() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/Team.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a football club returned by API-Football.
 *
 * Mapped from the JSON "team" object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private int id;
    private String name;
    private String country;
    private int founded;
    private int venueId;

    public Team() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public int getFounded() {return founded;}
    public void setFounded(int founded) {this.founded = founded;}

    public int getVenueId() {return venueId;}
    public void setVenueId(int venueId) {this.venueId = venueId;}

}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/TeamResponse.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a single entry within the API-Football
 * response array.
 *
 * Each response contains:
 * - Team information
 * - Venue information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamResponse {

    private Team team;
    private Venue venue;

    public TeamResponse() {
    }

    public Team getTeam() {return team;}

    public void setTeam(Team team) {
        this.team = team;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/TeamsApiResponse.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Represents the root JSON response returned by
 * API-Football's teams endpoint.
 *
 * Example:
 * {
 *   "response": [...]
 * }
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamsApiResponse {

    private List<TeamResponse> response;

    public TeamsApiResponse() {
    }

    public List<TeamResponse> getResponse() {
        return response;
    }

    public void setResponse(List<TeamResponse> response) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teams/Venue.java
```java
package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a stadium/venue returned by API-Football.
 *
 * Mapped from the JSON "venue" object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

    private int id;
    private String name;
    private String address;
    private String city;
    private int capacity;
    private String surface;

    public Venue() {
    }

    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public String getSurface() {return surface;}
    public void setSurface(String surface) {this.surface = surface;}
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/CardColour.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardColour {

    @JsonProperty("0-15")
    private CardMinute minute0to15;

    @JsonProperty("16-30")
    private CardMinute minute16to30;

    @JsonProperty("31-45")
    private CardMinute minute31to45;

    @JsonProperty("46-60")
    private CardMinute minute46to60;

    @JsonProperty("61-75")
    private CardMinute minute61to75;

    @JsonProperty("76-90")
    private CardMinute minute76to90;

    @JsonProperty("91-105")
    private CardMinute minute91to105;

    @JsonProperty("106-120")
    private CardMinute minute106to120;

    /**
     * Getters and Setters
     */
    public CardMinute getMinute0to15() {
        return minute0to15;
    }

    public void setMinute0to15(CardMinute minute0to15) {
        this.minute0to15 = minute0to15;
    }

    public CardMinute getMinute16to30() {
        return minute16to30;
    }

    public void setMinute16to30(CardMinute minute16to30) {
        this.minute16to30 = minute16to30;
    }

    public CardMinute getMinute31to45() {
        return minute31to45;
    }

    public void setMinute31to45(CardMinute minute31to45) {
        this.minute31to45 = minute31to45;
    }

    public CardMinute getMinute46to60() {
        return minute46to60;
    }

    public void setMinute46to60(CardMinute minute46to60) {
        this.minute46to60 = minute46to60;
    }

    public CardMinute getMinute61to75() {
        return minute61to75;
    }

    public void setMinute61to75(CardMinute minute61to75) {
        this.minute61to75 = minute61to75;
    }

    public CardMinute getMinute76to90() {
        return minute76to90;
    }

    public void setMinute76to90(CardMinute minute76to90) {
        this.minute76to90 = minute76to90;
    }

    public CardMinute getMinute91to105() {
        return minute91to105;
    }

    public void setMinute91to105(CardMinute minute91to105) {
        this.minute91to105 = minute91to105;
    }

    public CardMinute getMinute106to120() {
        return minute106to120;
    }

    public void setMinute106to120(CardMinute minute106to120) {
        this.minute106to120 = minute106to120;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/CardMinute.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardMinute {

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Cards.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cards {

    private CardColour yellow;
    private CardColour red;

    public CardColour getYellow() {
        return yellow;
    }

    public void setYellow(CardColour yellow) {
        this.yellow = yellow;
    }

    public CardColour getRed() {
        return red;
    }

    public void setRed(CardColour red) {
        this.red = red;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/CleanSheet.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CleanSheet {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/FailedToScore.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FailedToScore {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Fixtures.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixtures {

    private FixturesTotals played;
    private FixturesTotals wins;
    private FixturesTotals draws;
    private FixturesTotals loses;

    public FixturesTotals getPlayed() {
        return played;
    }

    public void setPlayed(FixturesTotals played) {
        this.played = played;
    }

    public FixturesTotals getWins() {
        return wins;
    }

    public void setWins(FixturesTotals wins) {
        this.wins = wins;
    }

    public FixturesTotals getDraws() {
        return draws;
    }

    public void setDraws(FixturesTotals draws) {
        this.draws = draws;
    }

    public FixturesTotals getLoses() {
        return loses;
    }

    public void setLoses(FixturesTotals loses) {
        this.loses = loses;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/FixturesTotals.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesTotals {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Goals.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Goals {

    private GoalsTotals forGoals;
    private GoalsTotals against;

    @JsonProperty("for")
    public GoalsTotals getForGoals() {
        return forGoals;
    }

    public void setForGoals(GoalsTotals forGoals) {
        this.forGoals = forGoals;
    }

    public GoalsTotals getAgainst() {
        return against;
    }

    public void setAgainst(GoalsTotals against) {
        this.against = against;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/GoalsTotals.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoalsTotals {

    private FixturesTotals total;

    public FixturesTotals getTotal() {
        return total;
    }

    public void setTotal(FixturesTotals total) {
        this.total = total;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/League.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    private int id;
    private int season;

    // getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/Team.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatistics.java
```java
package org.footballapp.model.teamstatistics;

/**
 * Team statistics stored in PostgreSQL.
 */
public class TeamStatistics {

    private int teamId;
    private int leagueId;
    private int season;

    private int played;
    private int wins;
    private int draws;
    private int losses;

    private int goalsFor;
    private int goalsAgainst;

    private int cleanSheets;
    private int failedToScore;

    private int yellowCards;
    private int redCards;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public int getFailedToScore() {
        return failedToScore;
    }

    public void setFailedToScore(int failedToScore) {
        this.failedToScore = failedToScore;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsApiResponse.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatisticsApiResponse {

    private TeamStatisticsResponse response;

    public TeamStatisticsResponse getResponse() {
        return response;
    }

    public void setResponse(TeamStatisticsResponse response) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsResponse.java
```java
package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatisticsResponse {

    private League league;
    private Team team;
    private Fixtures fixtures;
    private Goals goals;

    private CleanSheet clean_sheet;
    private FailedToScore failed_to_score;

    private Cards cards;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Fixtures getFixtures() {
        return fixtures;
    }

    public void setFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public CleanSheet getClean_sheet() {
        return clean_sheet;
    }

    public void setClean_sheet(CleanSheet clean_sheet) {
        this.clean_sheet = clean_sheet;
    }

    public FailedToScore getFailed_to_score() {
        return failed_to_score;
    }

    public void setFailed_to_score(FailedToScore failed_to_score) {
        this.failed_to_score = failed_to_score;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/FixtureImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.databaserepository.FixtureRepository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.api.ApiFootballService;

/**
 * Imports fixtures for a given league and season
 * from API-Football into the PostgreSQL database.
 */
@Service
public class FixtureImportService {

    private final ApiFootballService apiFootballService;
    private final FixtureRepository fixtureRepository;

    public FixtureImportService(
            ApiFootballService apiFootballService,
            FixtureRepository fixtureRepository
    ) {
        this.apiFootballService =
                apiFootballService;

        this.fixtureRepository =
                fixtureRepository;
    }

    /**
     * Fetches fixtures from API and stores them in DB.
     */
    public void importLeagueFixtures(
            int leagueId,
            int season
    ) throws Exception {

        FixturesApiResponse response =
                apiFootballService.getFixtures(
                        leagueId,
                        season
                );

        for (FixtureResponse fixtureResponse
                : response.getResponse()) {

            fixtureRepository.saveFixture(
                    fixtureResponse
            );
        }
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/FixtureService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.fixtures.FixturesApiResponse;

@Service
public class FixtureService {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;

    public FixtureService(ApiFootballClient apiClient) {
        this.apiClient = apiClient;
        this.mapper = new ObjectMapper();
    }

    public FixturesApiResponse getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures?league="
                        + leagueId
                        + "&season="
                        + season;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                FixturesApiResponse.class
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/LeagueDataService.java
```java
package org.footballapp.service;

/**
 * Spring Boot Service
 */
import org.springframework.stereotype.Service;


/**Import repositories*/
import org.footballapp.databaserepository.FixtureRepository;
import org.footballapp.databaserepository.LeagueUkRepository;
import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.databaserepository.TeamStatisticsRepository;
import org.footballapp.databaserepository.VenueRepository;
import org.footballapp.databaserepository.PlayerStatisticsRepository;
import org.footballapp.databaserepository.PlayerRepository;
import org.footballapp.model.club.ClubDetails;

/**Import models*/
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.league.LeagueUk;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.teamdetails.TeamDetails;
import org.footballapp.model.teams.Team;
import org.footballapp.model.teams.Venue;
import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.model.league.LeagueOverview;
import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.model.teamstatistics.TeamStatistics;

import java.util.List;

@Service
public class LeagueDataService {

    private final LeagueUkRepository leagueUkRepository;
    private final TeamRepository teamRepository;
    private final TeamStatisticsRepository teamStatisticsRepository;
    private final VenueRepository venueRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;
    private final PlayerRepository playerRepository;

    /**
     * Contructors
     */
    public LeagueDataService(
            LeagueUkRepository leagueUkRepository,
            TeamRepository teamRepository,
            TeamStatisticsRepository teamStatisticsRepository,
            VenueRepository venueRepository,
            StandingRepository standingRepository,
            FixtureRepository fixtureRepository,
            PlayerStatisticsRepository playerStatisticsRepository,
            PlayerRepository playerRepository
    ) {
        this.leagueUkRepository = leagueUkRepository;
        this.teamRepository = teamRepository;
        this.teamStatisticsRepository = teamStatisticsRepository;
        this.venueRepository = venueRepository;
        this.standingRepository = standingRepository;
        this.fixtureRepository = fixtureRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;
        this.playerRepository = playerRepository;
    }

    /**
     * Get Leagues
     */
    public List<LeagueUk> getLeagues()
            throws Exception {

        return leagueUkRepository
                .getLeagues();
    }

    /**
     * Get Enabled Leagues
     */
    public List<LeagueUk> getEnabledLeagues()
            throws Exception {

        return leagueUkRepository
                .getEnabledLeagues();
    }

    /**
     *  Get team by ID method
     */
    public Team getTeam(
            int teamId
    ) throws Exception {

        return teamRepository.getTeamById(
                teamId
        );
    }

    /**
     * Get team lineup from a game
     */
    public List<PlayerSummary> getPlayersForTeam(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        return playerStatisticsRepository
                .getPlayersForTeam(
                        teamId,
                        leagueId,
                        season
                );
    }

    /**
     * Returns detailed information for a player.
     */
    public PlayerDetails getPlayerDetails(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        return playerRepository.getPlayerDetails(
                playerId,
                leagueId,
                season
        );
    }

    /**
     * Get league table by season
     */
    public List<LeagueTableRow> getLeagueTable(
            int leagueId,
            int season
    ) throws Exception {

        return standingRepository.getLeagueTable(
                leagueId,
                season
        );
    }

    /**
     * Retrieves details for a single club.
     */
    public ClubDetails getClubDetails(
            int clubId
    ) throws Exception {

        return teamRepository.getClubDetails(
                clubId
        );

    }

    /**
     *  Get Fixtures for that season.
     */
    public List<FixtureRow> getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        return fixtureRepository.getFixtures(
                leagueId,
                season
        );
    }

    /**
     *  Get a particular team's fixtures for that season.
     */
    public List<FixtureRow> getLeagueFixtures(
            int leagueId,
            int season
    ) throws Exception {

        return fixtureRepository.getLeagueFixtures(
                leagueId,
                season
        );
    }
    /** Get a list of all teams playing in a particular league in that season. */
    public List<Team> getTeamsForLeague(
            int leagueId,
            int season
    ) throws Exception {

        return teamRepository.getTeamsForLeague(
                leagueId,
                season
        );
    }
    /**
     * Get a list of a team's fixtures for a season.
     */
    public List<FixtureRow> getFixturesByTeam(
            int teamId
    ) throws Exception {

        return fixtureRepository.getFixturesByTeam(teamId);
    }
    /**
     * Get a list of a team's recent results.
     */
    public List<FixtureRow> getRecentResults(
            int leagueId,
            int season,
            int limit
    ) throws Exception {

        return fixtureRepository.getRecentResults(
                leagueId,
                season,
                limit
        );
    }
    /**
     * Get team's form from last 5 matches.
     */
    public String getTeamForm(
            int teamId
    ) throws Exception {

        List<FixtureRow> fixtures =
                fixtureRepository
                        .getRecentFixturesByTeam(
                                teamId,
                                5
                        );

        StringBuilder form =
                new StringBuilder();

        for (FixtureRow fixture : fixtures) {

            boolean homeTeam =
                    fixture.getHomeTeamId()
                            == teamId;

            int goalsFor =
                    homeTeam
                            ? fixture.getHomeGoals()
                            : fixture.getAwayGoals();

            int goalsAgainst =
                    homeTeam
                            ? fixture.getAwayGoals()
                            : fixture.getHomeGoals();

            if (goalsFor > goalsAgainst) {

                form.append("W");

            } else if (goalsFor < goalsAgainst) {

                form.append("L");

            } else {

                form.append("D");
            }
        }

        return form.toString();
    }

    /**
     * Get a team's stats
     */
    public TeamStatistics getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        return teamStatisticsRepository
                .getTeamStatistics(
                        teamId,
                        leagueId,
                        season
                );
    }

    /**
     * Returns a team's league standing
     */
    public TeamDetails getTeamDetails(
            int leagueId,
            int season,
            int teamId
    )
            throws Exception {

        TeamDetails details =
                new TeamDetails();

        Team team =
                teamRepository.getTeamById(
                        teamId
                );

        details.setTeam(team);

        Venue venue =
                venueRepository.getVenueForTeam(
                        leagueId,
                        season,
                        teamId
                );

        details.setVenue(venue);

        System.out.println(
                "leagueId=" + leagueId +
                        ", season=" + season +
                        ", teamId=" + teamId
        );

        LeagueTableRow standing =
                standingRepository
                        .getTeamStanding(
                                leagueId,
                                season,
                                teamId
                        );

        details.setLeaguePosition(
                standing.getPosition()
        );

        details.setPoints(
                standing.getPoints()
        );

        details.setForm(
                getTeamForm(teamId)
        );

        details.setRecentFixtures(
                fixtureRepository
                        .getRecentFixturesByTeam(
                                teamId,
                                5
                        )
        );

        return details;
    }

    /**
     *  Get a single fixture from league.
     */
    public FixtureRow getFixtureDetails(
            long fixtureId
    ) throws Exception {

        return fixtureRepository
                .getFixtureDetails(
                        fixtureId
                );
    } // End of getFixturesDetails

    /**
     * Get League Overview
     */
    public LeagueOverview getLeagueOverview(
            int leagueId,
            int season
    ) throws Exception {

        LeagueOverview overview =
                new LeagueOverview();

        LeagueUk league =
                leagueUkRepository
                        .getLeagueById(
                                leagueId
                        );

        overview.setLeagueId(
                leagueId
        );

        overview.setLeagueName(
                league.getName()
        );

        overview.setSeason(
                season
        );

        overview.setTeamCount(
                teamRepository
                        .getTeamsForLeague(
                                leagueId,
                                season
                        )
                        .size()
        );

        overview.setFixtureCount(
                fixtureRepository
                        .getLeagueFixtures(
                                leagueId,
                                season
                        )
                        .size()
        );

        return overview;
    } // End of getLeagueOverview()
}
```

## File: footballapp/src/main/java/org/footballapp/service/LeagueImportService.java
```java
package org.footballapp.service;

import org.footballapp.databaserepository.LeagueRepository;
import org.springframework.stereotype.Service;
import org.footballapp.model.league.League;

/**
 * Data Flow
 * =========
 *
 * API-Football
 *      ↓
 * Service Layer
 *      ↓
 * Import Services
 *      ↓
 * Repository Layer
 *      ↓
 * PostgreSQL
 *
 * The database becomes the primary source of data
 * for the application, reducing API usage and allowing
 * historical data to be stored locally.
 */

/**
 * Coordinates the import of league-related data.
 *
 * This service acts as the entry point for league imports
 * and delegates work to specialised import services.
 *
 Current responsibilities:
 - Teams
 - Venues
 - League standings
 - Fixtures
 - Team statistics

 Future responsibilities:
 - Players
 - Squads
 - Transfers
 - Injuries
 - Match events
 - Line-ups
 */
@Service
public class LeagueImportService {

    //private final LeagueRepository leagueRepository;
    private final TeamImportService teamImportService;
    private final StandingsImportService standingsImportService;
    private final FixtureImportService fixtureImportService;
    private final TeamStatisticsImportService teamStatisticsImportService;

    public LeagueImportService(
            //LeagueRepository leagueRepository,
            TeamImportService teamImportService,
            StandingsImportService standingsImportService,
            FixtureImportService fixtureImportService,
            TeamStatisticsImportService teamStatisticsImportService
    ) {
        //this.leagueRepository = leagueRepository;
        this.teamImportService = teamImportService;
        this.standingsImportService = standingsImportService;
        this.fixtureImportService = fixtureImportService;
        this.teamStatisticsImportService = teamStatisticsImportService;
    }

    /**
     * Imports all available data for a league.
     */
    public void importLeague(
            int leagueId,
            int season
    ) throws Exception {

        League league = new League();

        league.setId(leagueId);
        league.setSeason(season);

        // Temporary hard-coded values.
        // Later these will come from API-Football.
        league.setName("Scottish Premiership");
        league.setCountry("Scotland");

        //leagueRepository.saveLeague(league);

        System.out.println(
                "Importing teams..."
        );

        teamImportService.importLeagueTeams(
                leagueId,
                season
        );

        System.out.println(
                "Importing standings..."
        );

        standingsImportService.importLeagueStandings(
                leagueId,
                season
        );

        System.out.println(
                "Importing fixtures..."
        );

        fixtureImportService.importLeagueFixtures(
                leagueId,
                season
        );

        System.out.println(
                "Importing team statistics..."
        );

        teamStatisticsImportService.importLeagueStatistics(
                leagueId,
                season
        );

        System.out.println(
                "League import complete."
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/LeagueUkImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.LeagueUkRepository;
import org.footballapp.model.league.LeagueApiResponse;
import org.footballapp.model.league.LeagueUk;
import org.footballapp.model.league.LeaguesApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LeagueUkImportService {

    private final ApiFootballService apiFootballService;
    private final LeagueUkRepository leagueUkRepository;

    public LeagueUkImportService(
            ApiFootballService apiFootballService,
            LeagueUkRepository leagueUkRepository
    ) {
        this.apiFootballService =
                apiFootballService;

        this.leagueUkRepository =
                leagueUkRepository;
    }



    public void importUkLeagues()
            throws Exception {

        LeaguesApiResponse response =
                apiFootballService.getLeagues();

        int importedCount = 0;

        for (LeagueApiResponse item :
                response.getResponse()) {

            String country =
                    item.getCountry()
                            .getName();

            if (!isUkCountry(country)) {
                continue;
            }

            LeagueUk league =
                    new LeagueUk();

            league.setLeagueId(
                    item.getLeague()
                            .getId()
            );

            league.setName(
                    item.getLeague()
                            .getName()
            );

            league.setCountry(
                    country
            );

            league.setLogoUrl(
                    item.getLeague()
                            .getLogo()
            );

            leagueUkRepository.saveLeague(
                    league
            );

            importedCount++;
            logger.info(
                    "Imported {} leagues",
                    importedCount
            );
        }
    }

    private static final Logger logger =
            LoggerFactory.getLogger(
                    LeagueUkImportService.class
            );


    private boolean isUkCountry(
            String country
    ) {

        return country.equals(
                "England"
        )
                || country.equals(
                "Scotland"
        )
                || country.equals(
                "Wales"
        )
                || country.equals(
                "Northern Ireland"
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/PlayerImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.PlayerRepository;
import org.footballapp.databaserepository.PlayerStatisticsRepository;
import org.footballapp.model.player.Player;
import org.footballapp.model.player.PlayerResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.playerstatistics.PlayerStatistics;

/**
 * Imports player identity information from API-Football.
 *
 * Phase 1 imports player identity only.
 * Season statistics will be imported separately.
 */
@Service
public class PlayerImportService {

    private final ApiFootballService apiFootballService;
    private final PlayerRepository playerRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerImportService(
            ApiFootballService apiFootballService,
            PlayerRepository playerRepository,
            PlayerStatisticsRepository playerStatisticsRepository
    ) {

        this.apiFootballService =
                apiFootballService;

        this.playerRepository =
                playerRepository;

        this.playerStatisticsRepository =
                playerStatisticsRepository;
    }

    /**
     * Imports all players for a team and season.
     */
    public void importPlayers(
            int teamId,
            int season
    ) throws Exception {

        int page = 1;
        int imported = 0;

        while (true) {

            PlayersApiResponse response =
                    apiFootballService.getPlayers(
                            teamId,
                            season
                    );

            for (PlayerResponse playerResponse
                    : response.getResponse()) {

                Player player =
                        playerResponse.getPlayer();

                playerRepository.savePlayer(
                        player
                );

                if (playerResponse.getStatistics() != null) {

                    for (PlayerStatistics statistics
                            : playerResponse.getStatistics()) {

                        playerStatisticsRepository
                                .savePlayerStatistics(

                                        player.getPlayerId(),

                                        season,

                                        statistics
                                );
                    }
                }

                imported++;

                System.out.println(
                        "Page " + page +
                                " - " +
                                player.getPlayerId() +
                                " - " +
                                player.getName()
                );

//                System.out.println(
//                        "Saved player "
//                                + player.getPlayerId()
//                                + " : "
//                                + player.getName()
//                );
            }

            if (page >= response
                    .getPaging()
                    .getTotal()) {

                break;
            }

            page++;
        }

        System.out.println();

//        System.out.println(
//                "Imported "
//                        + imported
//                        + " players."
//        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/StandingService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.standings.StandingsApiResponse;

@Service
public class StandingService {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;

    public StandingService(ApiFootballClient apiClient) {
        this.apiClient = apiClient;
        this.mapper = new ObjectMapper();
    }

    public StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/standings?league="
                        + leagueId
                        + "&season="
                        + season;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                StandingsApiResponse.class
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/StandingsImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingLeague;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.api.ApiFootballService;

@Service
public class StandingsImportService {

    private final ApiFootballService apiFootballService;
    private final StandingRepository standingRepository;

    public StandingsImportService(
            ApiFootballService apiFootballService,
            StandingRepository standingRepository
    ) {
        this.apiFootballService =
                apiFootballService;

        this.standingRepository =
                standingRepository;
    }
    public void importLeagueStandings(
            int leagueId,
            int season
    ) throws Exception {

        StandingsApiResponse response =
                apiFootballService.getStandings(
                        leagueId,
                        season
                );

        StandingLeague league =
                response.getResponse()
                        .get(0)
                        .getLeague();
        /*
         * Scottish Premiership split league handling.
         *
         * Group 0 = Phase 1 (33 games)
         * Group 1 = Championship Group (positions 1-6)
         * Group 2 = Relegation Group (positions 7-12)
         *
         * Import final standings from Groups 1 and 2
         * and renumber positions 1-12.
         */

        int finalPosition = 1;

        // Championship Group (positions 1-6)
        for (Standing standing :
                league.getStandings().get(1)) {

            standing.setRank(
                    finalPosition++
            );

            standingRepository.saveStanding(
                    league.getId(),
                    league.getSeason(),
                    standing
            );
        }

        // Relegation Group (positions 7-12)
        for (Standing standing :
                league.getStandings().get(2)) {

            standing.setRank(
                    finalPosition++
            );

            standingRepository.saveStanding(
                    league.getId(),
                    league.getSeason(),
                    standing
            );
        }
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/TeamImportService.java
```java
package org.footballapp.service;

//import org.footballapp.databaserepository.LeagueRepository;
import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.LeagueTeamRepository;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.databaserepository.VenueRepository;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;

/**
 * Imports team and venue data from API-Football
 * into the PostgreSQL database.
 *
 * Uses TeamService to retrieve data and repositories
 * to persist it in footballapp_db.
 */
@Service
public class TeamImportService {

    private final ApiFootballService apiService;
    //private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final VenueRepository venueRepository;
    private final LeagueTeamRepository
            leagueTeamRepository;

    public TeamImportService(
            ApiFootballService apiService,
            //TeamService teamService,
            TeamRepository teamRepository,
            VenueRepository venueRepository,
            LeagueTeamRepository leagueTeamRepository
    ) {
        this.apiService = apiService;
        //this.teamService = teamService;
        this.teamRepository = teamRepository;
        this.venueRepository = venueRepository;
        this.leagueTeamRepository =
                leagueTeamRepository;
    }

    public void importLeagueTeams(
            int leagueId,
            int season
    ) throws Exception {

        TeamsApiResponse response =
                apiService.getLeagueTeams(
                        leagueId,
                        season
                );

        for (TeamResponse teamResponse : response.getResponse()) {

            teamResponse.getTeam().setVenueId(

                    teamResponse
                            .getVenue()
                            .getId()

            );

            teamRepository.saveTeam(
                    teamResponse.getTeam()
            );

            venueRepository.saveVenue(
                    teamResponse.getVenue()
            );

            leagueTeamRepository.saveLeagueTeam(
                    leagueId,
                    season,
                    teamResponse.getTeam().getId()
            );
        }
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/TeamService.java
```java
package org.footballapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;

/**
 * @deprecated Use ApiFootballService instead
 */
public class TeamService {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;

    public TeamService(ApiFootballClient apiClient) {
        this.apiClient = apiClient;
        this.mapper = new ObjectMapper();
    }

    /**
     * Retrieves all teams associated with a league
     * and season from API-Football and maps the
     * response to TeamsApiResponse.
     */
    public TeamsApiResponse getLeagueTeams(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/teams?league="
                        + leagueId
                        + "&season="
                        + season;

        String json = apiClient.get(url);

        return mapper.readValue(
                json,
                TeamsApiResponse.class
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/TeamStatisticsImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.databaserepository.TeamStatisticsRepository;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.databaserepository.LeagueTeamRepository;
import org.footballapp.model.teamstatistics.TeamStatisticsResponse;

import java.util.List;

@Service
public class TeamStatisticsImportService {

    private final ApiFootballService apiFootballService;
    private final TeamStatisticsRepository repository;
    private final StandingRepository standingRepository;

    public TeamStatisticsImportService(
            ApiFootballService apiFootballService,
            TeamStatisticsRepository repository,
            StandingRepository standingRepository
    ) {

        this.apiFootballService = apiFootballService;
        this.repository = repository;
        this.standingRepository = standingRepository;
    }

    /**
     * Imports statistics for one team in one league season.
     */
    public void importLeagueStatistics(
            int leagueId,
            int season
    ) throws Exception {

        List<Integer> teamIds =
                standingRepository.getTeamIds(
                        leagueId,
                        season
                );

        for (Integer teamId : teamIds) {

            importTeamStatistics(
                    leagueId,
                    season,
                    teamId
            );
        }
    }

    private void importTeamStatistics(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        TeamStatisticsApiResponse response =
                apiFootballService.getTeamStatistics(
                        leagueId,
                        season,
                        teamId
                );

        if (response.getResponse() != null) {

            repository.save(
                    response.getResponse()
            );
        }
    }
}
```

## File: footballapp/src/main/java/org/footballapp/tools/ApiTester.java
```java
package org.footballapp.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.footballapp.api.ApiFootballClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Developer utility for inspecting API-Football endpoints.
 *
 * ApiTester allows endpoints to be tested independently
 * of the import services and repositories.
 *
 * Version 1.0
 */
public class ApiTester {

    /**
     * API base URL.
     */
    private static final String BASE_URL =
            "https://v3.football.api-sports.io/";

    /**
     * Console separator.
     */
    private static final String SEPARATOR =
            "============================================================";


    /**
     * API client.
     */
    private final ApiFootballClient client;

    /**
     * Jackson mapper used for pretty-printing JSON.
     */
    private final ObjectMapper mapper;

    /**
     * Root folder for saved API responses.
     */
    private static final String OUTPUT_FOLDER =
            "api-tests";

    /**
     * Creates a new ApiTester instance.
     */
    public ApiTester() {

        String apiKey =
                System.getenv("API_FOOTBALL_KEY");

        client =
                new ApiFootballClient(apiKey);

        mapper =
                new ObjectMapper();

        mapper.enable(
                SerializationFeature.INDENT_OUTPUT
        );
    }

    /**
     * Validates an endpoint against
     * a model class.
     *
     * @param endpoint API endpoint
     * @param clazz Model class
     * @return Validation result
     */
    public <T> ApiTestResult validate(

            String endpoint,

            Class<T> clazz

    ) {

        ApiTestResult result;

        try {

            result =
                    execute(
                            endpoint
                    );

            T object =
                    mapper.readValue(
                            result.getJson(),
                            clazz
                    );

            result.setValid(
                    true
            );

            result.setValidatedClass(
                    clazz.getSimpleName()
            );

            result.setValidationMessage(
                    "Validation successful."
            );

            result.setExceptionMessage(
                    null
            );

        }
        catch (Exception ex) {

            result =
                    new ApiTestResult();

            result.setEndpoint(
                    endpoint
            );

            result.setTimestamp(
                    getTimestamp()
            );

            result.setValid(
                    false
            );

            result.setValidatedClass(
                    clazz.getSimpleName()
            );

            result.setValidationMessage(
                    "Validation failed."
            );

            result.setExceptionMessage(
                    ex.getMessage()
            );
        }

        printValidationReport(
                result
        );

        return result;
    }

    /**
     * Prints validation results.
     */
    private void printValidationReport(

            ApiTestResult result

    ) {

        printBanner();

        System.out.println();

        System.out.println(
                "Validation Report"
        );

        printSeparator();

        System.out.println(
                "Endpoint : "
                        + result.getEndpoint()
        );

        System.out.println(
                "Model    : "
                        + result.getValidatedClass()
        );

        System.out.println(
                "Time     : "
                        + result.getElapsedTime()
                        + " ms"
        );

        System.out.println(
                "Size     : "
                        + result.getResponseSize()
                        + " bytes"
        );

        System.out.println();

        if (result.isValid()) {

            System.out.println(
                    "Status   : PASSED"
            );
        }
        else {

            System.out.println(
                    "Status   : FAILED"
            );

            System.out.println();

            System.out.println(
                    "Reason"
            );

            System.out.println(
                    result.getExceptionMessage()
            );
        }

        printSeparator();
    }

    /**
     * Downloads raw JSON from an endpoint.
     *
     * @param endpoint API endpoint
     * @return Raw JSON
     */
    protected String getJson(
            String endpoint
    ) throws Exception {

        String url =
                BASE_URL + endpoint;

        return client.get(url);
    }

    /**
     * Converts raw JSON into a Java object.
     */
    protected Object readJson(
            String json
    ) throws Exception {

        return mapper.readValue(
                json,
                Object.class
        );
    }

    /**
     * Converts a Java object into
     * formatted JSON.
     */
    protected String formatJson(
            Object jsonObject
    ) throws Exception {

        return mapper.writeValueAsString(
                jsonObject
        );
    }

    /**
     * Returns the response size in bytes.
     */
    protected int getResponseSize(
            String json
    ) {

        return json.getBytes().length;
    }

    /**
     * Prints a response summary.
     */
    protected void printSummary(

            String endpoint,

            long elapsedTime,

            int responseSize

    ) {

        System.out.println();

        System.out.println(
                "Endpoint : " + endpoint
        );

        System.out.println(
                "Time     : "
                        + elapsedTime
                        + " ms"
        );

        System.out.println(
                "Size     : "
                        + responseSize
                        + " bytes"
        );

        printSeparator();
    }

    /**
     * Prints formatted JSON
     * returned by an endpoint.
     */
    /**
     * Prints formatted JSON returned by an endpoint.
     */
    public void print(
            String endpoint
    ) throws Exception {

        ApiTestResult result =
                execute(
                        endpoint
                );

        printBanner();

        printSummary(

                result.getEndpoint(),

                result.getElapsedTime(),

                result.getResponseSize()

        );

        System.out.println();

        System.out.println(
                result.getFormattedJson()
        );

        printSeparator();
    }

    /**
     * Prints the ApiTester banner.
     */
    protected void printBanner() {

        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("FootballApp API Tester");
        System.out.println(SEPARATOR);
    }

    /**
     * Prints a separator.
     */
    protected void printSeparator() {

        System.out.println(SEPARATOR);
    }

    /**
     * Returns the current timestamp.
     */
    protected String getTimestamp() {

        return LocalDateTime.now()
                .format(
                        DateTimeFormatter.ofPattern(
                                "yyyy-MM-dd HH:mm:ss"
                        )
                );
    }

    /**
     * Executes an API request and returns the result.
     *
     * @param endpoint API endpoint
     * @return Test result
     */
    private ApiTestResult execute(
            String endpoint
    ) throws Exception {

        long start =
                System.currentTimeMillis();

        String json =
                getJson(
                        endpoint
                );

        long elapsed =
                System.currentTimeMillis()
                        - start;

        Object jsonObject =
                readJson(
                        json
                );

        String formatted =
                formatJson(
                        jsonObject
                );

        ApiTestResult result =
                new ApiTestResult();

        result.setEndpoint(
                endpoint
        );

        result.setJson(
                json
        );

        result.setFormattedJson(
                formatted
        );

        result.setElapsedTime(
                elapsed
        );

        result.setResponseSize(
                getResponseSize(
                        json
                )
        );

        result.setTimestamp(
                getTimestamp()
        );

        result.setValid(
                false
        );

        result.setValidationMessage(
                "Not validated"
        );

        return result;
    }

    /**
     * Builds the relative output path.
     */
    private String buildRelativePath(
            String endpoint,
            String filename
    ) {

        String endpointGroup =
                endpoint.split("\\?")[0]
                        .replace("/", "-");

        return "OUTPUT_FOLDER"
                + File.separator
                + endpointGroup
                + File.separator
                + LocalDate.now()
                + File.separator
                + filename;
    }

    /**
     * Creates the output folder for an endpoint.
     *
     * Folder structure:
     *
     * api-tests/
     *      teams/
     *          2026-06-29/
     *
     *      players/
     *          2026-06-29/
     */
    private File buildOutputFolder(
            String endpoint
    ) {

        String endpointGroup =
                endpoint.split("\\?")[0]
                        .replace("/", "-");

        File folder =
                new File(
                        "OUTPUT_FOLDER"
                                + File.separator
                                + endpointGroup
                                + File.separator
                                + LocalDate.now()
                );

        if (!folder.exists()) {

            folder.mkdirs();
        }

        return folder;
    }

    /**
     * Builds a timestamped filename.
     */
    private String buildFilename(
            String endpoint
    ) {

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "yyyyMMdd_HHmmss"
                                )
                        );

        String parameters = "";

        if (endpoint.contains("?")) {

            parameters =
                    endpoint.substring(
                                    endpoint.indexOf('?') + 1
                            )
                            .replace("=", "")
                            .replace("&", "_")
                            .replace("/", "_");
        }

        if (!parameters.isEmpty()) {

            return timestamp
                    + "_"
                    + parameters
                    + ".json";
        }

        return timestamp + ".json";
    }

    /**
     * Builds the output file.
     */
    private File buildOutputFile(
            String endpoint
    ) {

        return new File(

                buildOutputFolder(
                        endpoint
                ),

                buildFilename(
                        endpoint
                )
        );
    }

    /**
     * Saves formatted JSON to disk.
     */
    private void saveResult(
            ApiTestResult result
    ) throws Exception {

        File output =
                buildOutputFile(
                        result.getEndpoint()
                );

        mapper.writeValue(

                output,

                readJson(
                        result.getJson()
                )
        );

        result.setOutputFile(

                buildRelativePath(

                        result.getEndpoint(),

                        output.getName()

                )
        );
    }

    /**
     * Saves and prints an endpoint.
     */
    public void saveAndPrint(
            String endpoint
    ) throws Exception {

        ApiTestResult result =
                execute(
                        endpoint
                );

        saveResult(
                result
        );

        printBanner();

        printSummary(

                result.getEndpoint(),

                result.getElapsedTime(),

                result.getResponseSize()

        );

        System.out.println();

        System.out.println(
                result.getFormattedJson()
        );

        System.out.println();

        System.out.println(
                "Saved:"
        );

        System.out.println(
                result.getOutputFile()
        );

        printSeparator();
    }

}
```

## File: footballapp/src/main/java/org/footballapp/tools/ApiTestResult.java
```java
package org.footballapp.tools;

/**
 * Represents the result of an API endpoint test.
 *
 * This model is shared by ApiTester methods and
 * contains all information about a single request.
 */
public class ApiTestResult {

    /**
     * API endpoint that was requested.
     */
    private String endpoint;

    /**
     * Raw JSON returned by the API.
     */
    private String json;

    /**
     * Pretty formatted JSON.
     */
    private String formattedJson;

    /**
     * Time taken to complete the request.
     */
    private long elapsedTime;

    /**
     * Response size in bytes.
     */
    private int responseSize;

    /**
     * Timestamp of the request.
     */
    private String timestamp;

    /**
     * Output file location.
     *
     * Null if the response has not been saved.
     */
    private String outputFile;

    /**
     * Indicates whether validation succeeded.
     */
    private boolean valid;

    /**
     * Model class used for validation.
     */
    private String validatedClass;

    /**
     * Exception message if validation fails.
     */
    private String exceptionMessage;

    /**
     * Validation message.
     */
    private String validationMessage;

    public String getValidatedClass() {
        return validatedClass;
    }

    public void setValidatedClass(String validatedClass) {
        this.validatedClass = validatedClass;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * Getters and Setters
     */
    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getFormattedJson() {
        return formattedJson;
    }

    public void setFormattedJson(String formattedJson) {
        this.formattedJson = formattedJson;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(
            String validationMessage
    ) {
        this.validationMessage =
                validationMessage;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/tools/ImportRunner.java
```java
package org.footballapp.tools;

import org.footballapp.config.AppConfig;
import org.footballapp.service.LeagueImportService;

/**
 * Imports updated data from Database
 */
public class ImportRunner {

    private static final int LEAGUE_ID = 179;
    private static final int SEASON = 2024;

    public static void main(String[] args)

            throws Exception {
        System.out.println(
                "API KEY = " +
                        System.getenv("API_FOOTBALL_KEY")
        );

        AppConfig config =
                new AppConfig();

        LeagueImportService importer =
                config.getLeagueImportService();

        importer.importLeague(
                LEAGUE_ID,
                SEASON
        );

        System.out.println(
                "Import complete."
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/util/DateUtils.java
```java
package org.footballapp.util;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final ZoneId UK_ZONE =
            ZoneId.of("Europe/London");

    private static final DateTimeFormatter DISPLAY_FORMAT =
            DateTimeFormatter.ofPattern(
                    "dd/MM/yyyy HH:mm"
            );

    /**
     * Converts API-Football UTC datetime
     * into UK local time.
     *
     * Example:
     * 2024-08-03T11:30:00+00:00
     *
     * becomes:
     * 03/08/2024 12:30
     */
    public static String formatFixtureDate(
            String utcDateTime
    ) {

        OffsetDateTime utc =
                OffsetDateTime.parse(
                        utcDateTime
                );

        ZonedDateTime ukTime =
                utc.atZoneSameInstant(
                        UK_ZONE
                );

        return ukTime.format(
                DISPLAY_FORMAT
        );
    }

    /**
     * Returns the UK ZonedDateTime object
     * if further processing is required.
     */
    public static ZonedDateTime toUkTime(
            String utcDateTime
    ) {

        OffsetDateTime utc =
                OffsetDateTime.parse(
                        utcDateTime
                );

        return utc.atZoneSameInstant(
                UK_ZONE
        );
    }

    private DateUtils() {
        // Utility class
    }
}
```

## File: footballapp/src/main/java/org/footballapp/FootballApplication.java
```java
package org.footballapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootballApplication {

    public static void main(
            String[] args
    ) {

        SpringApplication.run(
                FootballApplication.class,
                args
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/Main.java
```java
package org.footballapp;

//import org.footballapp.config.AppConfig;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.tools.ApiTester;

public class Main {

    public static void main(String[] args)
            throws Exception {
//        AppConfig config = new AppConfig();
//
//        config.getLeagueImportService()
//                .importLeague(179, 2024);

//            ApiTester tester =
//                    new ApiTester();
//
//
//        tester.validate(
//
//                "teams/statistics?league=179&season=2024&team=257",
//
//                TeamStatisticsApiResponse.class);
        } // End of main()


} // End of Main Class.
```
