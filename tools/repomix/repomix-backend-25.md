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
- Only files matching these patterns are included: footballapp/src/main/java/org/footballapp/**/*.java
- Files matching patterns in .gitignore are excluded
- Files matching default ignore patterns are excluded
- Files are sorted by Git change count (files with more changes are at the bottom)

# Directory Structure
```
footballapp/src/main/java/org/footballapp/api/ApiFootballClient.java
footballapp/src/main/java/org/footballapp/api/ApiFootballService.java
footballapp/src/main/java/org/footballapp/api/dto/events/EventAssist.java
footballapp/src/main/java/org/footballapp/api/dto/events/EventPlayer.java
footballapp/src/main/java/org/footballapp/api/dto/events/EventTeam.java
footballapp/src/main/java/org/footballapp/api/dto/events/EventTime.java
footballapp/src/main/java/org/footballapp/api/dto/events/FixtureEventResponse.java
footballapp/src/main/java/org/footballapp/api/dto/events/FixtureEventsResponse.java
footballapp/src/main/java/org/footballapp/api/dto/fixtures/FixtureStatisticsResponse.java
footballapp/src/main/java/org/footballapp/api/dto/fixtures/FixtureTeamStatistics.java
footballapp/src/main/java/org/footballapp/api/dto/fixtures/Statistic.java
footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureCoach.java
footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureLineupResponse.java
footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureLineupsResponse.java
footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureLineupTeam.java
footballapp/src/main/java/org/footballapp/api/dto/lineups/FixturePlayer.java
footballapp/src/main/java/org/footballapp/api/dto/lineups/FixturePlayerWrapper.java
footballapp/src/main/java/org/footballapp/api/response/lineups/FixtureLineupMapper.java
footballapp/src/main/java/org/footballapp/api/response/lineups/FixtureLineupResponse.java
footballapp/src/main/java/org/footballapp/api/response/lineups/FixtureTeamLineupResponse.java
footballapp/src/main/java/org/footballapp/api/response/lineups/PlayerLineupResponse.java
footballapp/src/main/java/org/footballapp/config/ApiConfig.java
footballapp/src/main/java/org/footballapp/config/competitions/CompetitionType.java
footballapp/src/main/java/org/footballapp/config/competitions/SupportedCompetition.java
footballapp/src/main/java/org/footballapp/config/competitions/SupportedCompetitionGroup.java
footballapp/src/main/java/org/footballapp/controller/ApiExplorerController.java
footballapp/src/main/java/org/footballapp/controller/ClubController.java
footballapp/src/main/java/org/footballapp/controller/FixtureLineupController.java
footballapp/src/main/java/org/footballapp/controller/FixturesController.java
footballapp/src/main/java/org/footballapp/controller/LeagueController.java
footballapp/src/main/java/org/footballapp/controller/LeagueOverviewController.java
footballapp/src/main/java/org/footballapp/controller/LeagueTableController.java
footballapp/src/main/java/org/footballapp/controller/PlayerController.java
footballapp/src/main/java/org/footballapp/controller/TeamDetailsController.java
footballapp/src/main/java/org/footballapp/controller/TeamFixturesController.java
footballapp/src/main/java/org/footballapp/controller/TeamsController.java
footballapp/src/main/java/org/footballapp/FootballApplication.java
footballapp/src/main/java/org/footballapp/Main.java
footballapp/src/main/java/org/footballapp/model/club/ClubDetails.java
footballapp/src/main/java/org/footballapp/model/fixtures/Fixture.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureDetails.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureEvent.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureGoals.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureLeague.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureResponse.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureRow.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixturesApiResponse.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureStatistic.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeam.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureTeams.java
footballapp/src/main/java/org/footballapp/model/fixtures/FixtureVenue.java
footballapp/src/main/java/org/footballapp/model/league/CountryInfo.java
footballapp/src/main/java/org/footballapp/model/league/League.java
footballapp/src/main/java/org/footballapp/model/league/LeagueApiInfo.java
footballapp/src/main/java/org/footballapp/model/league/LeagueApiResponse.java
footballapp/src/main/java/org/footballapp/model/league/LeagueOverview.java
footballapp/src/main/java/org/footballapp/model/league/LeagueResponse.java
footballapp/src/main/java/org/footballapp/model/league/LeaguesApiResponse.java
footballapp/src/main/java/org/footballapp/model/league/LeagueTeam.java
footballapp/src/main/java/org/footballapp/model/league/LeagueUk.java
footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineup.java
footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineupPlayer.java
footballapp/src/main/java/org/footballapp/model/player/Paging.java
footballapp/src/main/java/org/footballapp/model/player/Player.java
footballapp/src/main/java/org/footballapp/model/player/PlayerBirth.java
footballapp/src/main/java/org/footballapp/model/player/PlayerResponse.java
footballapp/src/main/java/org/footballapp/model/player/PlayersApiResponse.java
footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerDetails.java
footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerSummary.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerCards.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGames.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerGoals.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerLeague.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerStatistics.java
footballapp/src/main/java/org/footballapp/model/playerstatistics/PlayerTeam.java
footballapp/src/main/java/org/footballapp/model/standings/LeagueTableRow.java
footballapp/src/main/java/org/footballapp/model/standings/Standing.java
footballapp/src/main/java/org/footballapp/model/standings/StandingAll.java
footballapp/src/main/java/org/footballapp/model/standings/StandingGoals.java
footballapp/src/main/java/org/footballapp/model/standings/StandingLeague.java
footballapp/src/main/java/org/footballapp/model/standings/StandingRecord.java
footballapp/src/main/java/org/footballapp/model/standings/StandingsApiResponse.java
footballapp/src/main/java/org/footballapp/model/standings/StandingsResponse.java
footballapp/src/main/java/org/footballapp/model/standings/StandingTeam.java
footballapp/src/main/java/org/footballapp/model/teamdetails/TeamDetails.java
footballapp/src/main/java/org/footballapp/model/teams/ID.java
footballapp/src/main/java/org/footballapp/model/teams/Team.java
footballapp/src/main/java/org/footballapp/model/teams/TeamResponse.java
footballapp/src/main/java/org/footballapp/model/teams/TeamsApiResponse.java
footballapp/src/main/java/org/footballapp/model/teams/Venue.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/CardColour.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/CardMinute.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Cards.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/CleanSheet.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/FailedToScore.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Fixtures.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/FixturesTotals.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Goals.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/GoalsTotals.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/League.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/Team.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatistics.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsApiResponse.java
footballapp/src/main/java/org/footballapp/model/teamstatistics/TeamStatisticsResponse.java
footballapp/src/main/java/org/footballapp/repository/BaseRepository.java
footballapp/src/main/java/org/footballapp/repository/FixtureEventRepository.java
footballapp/src/main/java/org/footballapp/repository/FixtureLineupRepository.java
footballapp/src/main/java/org/footballapp/repository/FixtureRepository.java
footballapp/src/main/java/org/footballapp/repository/FixtureStatisticRepository.java
footballapp/src/main/java/org/footballapp/repository/LeagueRepository.java
footballapp/src/main/java/org/footballapp/repository/LeagueTeamRepository.java
footballapp/src/main/java/org/footballapp/repository/PlayerRepository.java
footballapp/src/main/java/org/footballapp/repository/PlayerStatisticsRepository.java
footballapp/src/main/java/org/footballapp/repository/StandingRepository.java
footballapp/src/main/java/org/footballapp/repository/TeamRepository.java
footballapp/src/main/java/org/footballapp/repository/TeamStatisticsRepository.java
footballapp/src/main/java/org/footballapp/repository/VenueRepository.java
footballapp/src/main/java/org/footballapp/service/FixtureImportService.java
footballapp/src/main/java/org/footballapp/service/FixtureService.java
footballapp/src/main/java/org/footballapp/service/importer/FixtureEventImportService.java
footballapp/src/main/java/org/footballapp/service/importer/FixtureLineupImportService.java
footballapp/src/main/java/org/footballapp/service/importer/FixtureStatisticImportService.java
footballapp/src/main/java/org/footballapp/service/LeagueDataService.java
footballapp/src/main/java/org/footballapp/service/LeagueImportService.java
footballapp/src/main/java/org/footballapp/service/PlayerImportService.java
footballapp/src/main/java/org/footballapp/service/StandingService.java
footballapp/src/main/java/org/footballapp/service/StandingsImportService.java
footballapp/src/main/java/org/footballapp/service/SupportedCompetitionsService.java
footballapp/src/main/java/org/footballapp/service/TeamImportService.java
footballapp/src/main/java/org/footballapp/service/TeamService.java
footballapp/src/main/java/org/footballapp/service/TeamStatisticsImportService.java
footballapp/src/main/java/org/footballapp/tools/ApiTester.java
footballapp/src/main/java/org/footballapp/tools/ApiTestResult.java
footballapp/src/main/java/org/footballapp/tools/AppConstants.java
footballapp/src/main/java/org/footballapp/tools/development/ApiExplorerRunner.java
footballapp/src/main/java/org/footballapp/tools/development/ApiExplorerService.java
footballapp/src/main/java/org/footballapp/tools/FixtureStatisticImportRunner.java
footballapp/src/main/java/org/footballapp/tools/ImportRunner.java
footballapp/src/main/java/org/footballapp/util/DateUtils.java
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
import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
import org.footballapp.api.dto.events.FixtureEventsResponse;
import org.footballapp.api.dto.fixtures.FixtureStatisticsResponse;


public class ApiFootballService {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;

    /**
     * Move this to ApiFootballClient:
    private static final String BASE_URL =
            "https://v3.football.api-sports.io";
     */

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
     * Gets a single team by its API-Football team id.
     */
    public TeamsApiResponse getTeam(
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/teams?id="
                        + teamId;

        String json =
                apiClient.get(url);

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
            int season,
            int page
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?team="
                        + teamId
                        + "&season="
                        + season
                        + "&page="
                        + page;

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

    /**
     * Retrieves the lineups for a fixture.
     */
    public FixtureLineupsResponse getFixtureLineups(

            long fixtureId

    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures/lineups?fixture="
                        + fixtureId;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                FixtureLineupsResponse.class
        );
    }

    /**
     * Get Fixture Events
     */

    public FixtureEventsResponse getFixtureEvents(

            long fixtureId

    ) throws Exception {

        String url =

                "https://v3.football.api-sports.io/fixtures/events?fixture="
                        + fixtureId;

        String json =

                apiClient.get(url);

        return mapper.readValue(

                json,

                FixtureEventsResponse.class

        );

    }

    /***
     * Get Fixture Statistics
     */

    public FixtureStatisticsResponse getFixtureStatistics(
            long fixtureId,
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures/statistics?fixture="
                        + fixtureId
                        + "&team="
                        + teamId;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                FixtureStatisticsResponse.class
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/events/EventAssist.java
```java
package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventAssist {

    private Integer id;
    private String name;

    public Integer getId() {

        return id;

    }

    public void setId(

            Integer id

    ) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(

            String name

    ) {

        this.name = name;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/events/EventPlayer.java
```java
package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventPlayer {

    private Integer id;
    private String name;

    public Integer getId() {

        return id;

    }

    public void setId(

            Integer id

    ) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(

            String name

    ) {

        this.name = name;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/events/EventTeam.java
```java
package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTeam {

    private int id;
    private String name;

    public int getId() {

        return id;

    }

    public void setId(

            int id

    ) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(

            String name

    ) {

        this.name = name;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/events/EventTime.java
```java
package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTime {

    private Integer elapsed;
    private Integer extra;

    public Integer getElapsed() {

        return elapsed;

    }

    public void setElapsed(

            Integer elapsed

    ) {

        this.elapsed = elapsed;

    }

    public Integer getExtra() {

        return extra;

    }

    public void setExtra(

            Integer extra

    ) {

        this.extra = extra;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/events/FixtureEventResponse.java
```java
package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureEventResponse {

    private EventTime time;
    private EventTeam team;
    private EventPlayer player;
    private EventAssist assist;

    private String type;
    private String detail;
    private String comments;

    public EventTime getTime() {
        return time;
    }

    public void setTime(EventTime time) {
        this.time = time;
    }

    public EventTeam getTeam() {
        return team;
    }

    public void setTeam(EventTeam team) {
        this.team = team;
    }

    public EventPlayer getPlayer() {
        return player;
    }

    public void setPlayer(EventPlayer player) {
        this.player = player;
    }

    public EventAssist getAssist() {
        return assist;
    }

    public void setAssist(EventAssist assist) {
        this.assist = assist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/events/FixtureEventsResponse.java
```java
package org.footballapp.api.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureEventsResponse {

    private List<FixtureEventResponse> response;

    public List<FixtureEventResponse> getResponse() {

        return response;

    }

    public void setResponse(

            List<FixtureEventResponse> response

    ) {

        this.response = response;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/fixtures/FixtureStatisticsResponse.java
```java
package org.footballapp.api.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureStatisticsResponse {

    private List<FixtureTeamStatistics> response;

    public FixtureStatisticsResponse() {
    }

    public List<FixtureTeamStatistics> getResponse() {
        return response;
    }

    public void setResponse(
            List<FixtureTeamStatistics> response
    ) {
        this.response = response;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/fixtures/FixtureTeamStatistics.java
```java
package org.footballapp.api.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.footballapp.model.teams.Team;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeamStatistics {

    private Team team;

    private List<Statistic> statistics;

    public FixtureTeamStatistics() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(
            Team team
    ) {
        this.team = team;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(
            List<Statistic> statistics
    ) {
        this.statistics = statistics;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/fixtures/Statistic.java
```java
package org.footballapp.api.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistic {

    private String type;
    private Object value;

    public Statistic() {
    }

    public String getType() {
        return type;
    }

    public void setType(
            String type
    ) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(
            Object value
    ) {
        this.value = value;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureCoach.java
```java
package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Coach information returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureCoach {

    private int id;

    private String name;

    private String photo;

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(
            String photo
    ) {
        this.photo = photo;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureLineupResponse.java
```java
package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * One team's lineup returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLineupResponse {

    private FixtureLineupTeam team;

    private FixtureCoach coach;

    private String formation;

    private List<FixturePlayerWrapper> startXI;

    private List<FixturePlayerWrapper> substitutes;

    public FixtureLineupTeam getTeam() {
        return team;
    }

    public void setTeam(
            FixtureLineupTeam team
    ) {
        this.team = team;
    }

    public FixtureCoach getCoach() {
        return coach;
    }

    public void setCoach(
            FixtureCoach coach
    ) {
        this.coach = coach;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(
            String formation
    ) {
        this.formation = formation;
    }

    public List<FixturePlayerWrapper> getStartXI() {
        return startXI;
    }

    public void setStartXI(
            List<FixturePlayerWrapper> startXI
    ) {
        this.startXI = startXI;
    }

    public List<FixturePlayerWrapper> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(
            List<FixturePlayerWrapper> substitutes
    ) {
        this.substitutes = substitutes;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureLineupsResponse.java
```java
package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Root response returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLineupsResponse {

    private List<FixtureLineupResponse> response;

    public List<FixtureLineupResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<FixtureLineupResponse> response
    ) {
        this.response = response;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/lineups/FixtureLineupTeam.java
```java
package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Team information returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureLineupTeam {

    private int id;

    private String name;

    private String logo;

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(
            String logo
    ) {
        this.logo = logo;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/lineups/FixturePlayer.java
```java
package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Player information returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturePlayer {

    private int id;

    private String name;

    private int number;

    private String pos;

    private String grid;

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(
            int number
    ) {
        this.number = number;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(
            String pos
    ) {
        this.pos = pos;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(
            String grid
    ) {
        this.grid = grid;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/dto/lineups/FixturePlayerWrapper.java
```java
package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Wrapper around a player returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturePlayerWrapper {

    private FixturePlayer player;

    public FixturePlayer getPlayer() {
        return player;
    }

    public void setPlayer(
            FixturePlayer player
    ) {
        this.player = player;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/response/lineups/FixtureLineupMapper.java
```java
package org.footballapp.api.response.lineups;

import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.footballapp.model.teams.Team;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FixtureLineupMapper {

    /**
     * Creates the top-level response for a fixture.
     */
    public FixtureLineupResponse createResponse(
            long fixtureId
    ) {

        FixtureLineupResponse response =
                new FixtureLineupResponse();

        response.setFixtureId(
                fixtureId
        );

        return response;

    }

    /**
     * Maps a team lineup.
     */
    public FixtureTeamLineupResponse mapTeamLineup(

            FixtureLineup lineup,

            Team team,

            List<PlayerLineupResponse> players

    ) {

        FixtureTeamLineupResponse response =
                new FixtureTeamLineupResponse();

        response.setTeamId(
                lineup.getTeamId()
        );

        if (team != null) {

            response.setTeamName(
                    team.getName()
            );

        }

        response.setCoachId(
                lineup.getCoachId()
        );

        response.setCoachName(
                lineup.getCoachName()
        );

        response.setFormation(
                lineup.getFormation()
        );

        response.setPlayers(
                players
        );

        return response;

    }

    /**
     * Maps a lineup player.
     */
    public PlayerLineupResponse mapPlayer(

            FixtureLineupPlayer player,

            String playerName

    ) {

        PlayerLineupResponse response =
                new PlayerLineupResponse();

        response.setPlayerId(
                player.getPlayerId()
        );

        response.setPlayerName(
                playerName
        );

        response.setShirtNumber(
                player.getShirtNumber()
        );

        response.setPosition(
                player.getPosition()
        );

        response.setGrid(
                player.getGrid()
        );

        response.setStarting(
                player.isStarting()
        );

        response.setDisplayOrder(
                player.getDisplayOrder()
        );

        return response;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/response/lineups/FixtureLineupResponse.java
```java
package org.footballapp.api.response.lineups;

import java.util.ArrayList;
import java.util.List;

public class FixtureLineupResponse {

    private long fixtureId;

    private List<FixtureTeamLineupResponse> teams =
            new ArrayList<>();

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public List<FixtureTeamLineupResponse> getTeams() {
        return teams;
    }

    public void setTeams(
            List<FixtureTeamLineupResponse> teams
    ) {
        this.teams = teams;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/response/lineups/FixtureTeamLineupResponse.java
```java
package org.footballapp.api.response.lineups;

import java.util.ArrayList;
import java.util.List;

public class FixtureTeamLineupResponse {

    private int teamId;
    private String teamName;
    private int coachId;
    private String coachName;
    private String formation;

    private List<PlayerLineupResponse> players =
            new ArrayList<>();

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {return teamName;}

    public void setTeamName(String teamName) {this.teamName = teamName;}

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public List<PlayerLineupResponse> getPlayers() {
        return players;
    }

    public void setPlayers(
            List<PlayerLineupResponse> players
    ) {
        this.players = players;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/api/response/lineups/PlayerLineupResponse.java
```java
package org.footballapp.api.response.lineups;

public class PlayerLineupResponse {

    private int playerId;
    private String playerName;
    private String photo;
    private int shirtNumber;
    private String position;
    private String grid;
    private boolean starting;
    private int displayOrder;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
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

## File: footballapp/src/main/java/org/footballapp/config/competitions/CompetitionType.java
```java
package org.footballapp.config.competitions;

public enum CompetitionType {
    LEAGUE,
    CUP
}
```

## File: footballapp/src/main/java/org/footballapp/config/competitions/SupportedCompetition.java
```java
package org.footballapp.config.competitions;

public class SupportedCompetition {

    private int competitionId;
    private String name;
    private CompetitionType type;
    private boolean enabled;
    private String logoUrl;

    public SupportedCompetition() {
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompetitionType getType() {
        return type;
    }

    public void setType(CompetitionType type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLogoUrl() {return logoUrl;}

    public void setLogoUrl(String logoUrl) {this.logoUrl = logoUrl;}

}
```

## File: footballapp/src/main/java/org/footballapp/config/competitions/SupportedCompetitionGroup.java
```java
package org.footballapp.config.competitions;

import java.util.List;

public class SupportedCompetitionGroup {

    private String country;
    private int displayOrder;
    private String headerIcon;
    private List<SupportedCompetition> competitions;

    public SupportedCompetitionGroup() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getHeaderIcon() {
        return headerIcon;
    }

    public void setHeaderIcon(String headerIcon) {
        this.headerIcon = headerIcon;
    }

    public List<SupportedCompetition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<SupportedCompetition> competitions) {
        this.competitions = competitions;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/controller/ApiExplorerController.java
```java
package org.footballapp.controller;

import org.footballapp.tools.development.ApiExplorerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiExplorerController {

    private final ApiExplorerService explorer;

    public ApiExplorerController(
            ApiExplorerService explorer
    ) {
        this.explorer = explorer;
    }

    @GetMapping("/tools/explore")
    public String explore(

            @RequestParam String endpoint,

            @RequestParam(required = false)
            String query,

            @RequestParam String output

    ) throws Exception {

        explorer.download(

                endpoint,

                query,

                output

        );

        return "Download complete.";

    }

}
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

## File: footballapp/src/main/java/org/footballapp/controller/FixtureLineupController.java
```java
package org.footballapp.controller;

import org.footballapp.api.response.lineups.FixtureLineupResponse;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FixtureLineupController {

    private final LeagueDataService leagueDataService;

    public FixtureLineupController(
            LeagueDataService leagueDataService
    ) {

        this.leagueDataService =
                leagueDataService;

    }

    @GetMapping("/fixtureLineup")
    public FixtureLineupResponse getFixtureLineup(

            @RequestParam long fixtureId

    ) throws Exception {

        return leagueDataService.getFixtureLineupResponse(
                fixtureId
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/FixturesController.java
```java
package org.footballapp.controller;

import org.footballapp.model.fixtures.FixtureDetails;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoints for fixture data.
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

    /**
     * Returns details for a single fixture.
     */
    @GetMapping("/fixtureDetails")
    public FixtureDetails getFixtureDetails(

            @RequestParam long fixtureId

    ) throws Exception {

        return leagueDataService.getFixtureDetails(
                fixtureId
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/controller/LeagueController.java
```java
package org.footballapp.controller;

import org.footballapp.config.competitions.SupportedCompetitionGroup;
import org.footballapp.service.SupportedCompetitionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeagueController {

    private final SupportedCompetitionsService
            supportedCompetitionsService;

    public LeagueController(
            SupportedCompetitionsService supportedCompetitionsService
    ) {
        this.supportedCompetitionsService =
                supportedCompetitionsService;
    }

    @GetMapping("/leagues")
    public List<SupportedCompetitionGroup> getLeagues() {

        return supportedCompetitionsService.getCompetitionGroups();
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

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureDetails.java
```java
package org.footballapp.model.fixtures;

public class FixtureDetails {

    private long fixtureId;

    private String fixtureDate;

    private int homeTeamId;
    private String homeTeam;

    private int awayTeamId;
    private String awayTeam;

    private Integer homeGoals;
    private Integer awayGoals;

    private String venueName;

    private int leagueId;
    private String leagueName;

    private int season;


    /**
     * Fixture Details Getters.
     */

    public long getFixtureId() {
        return fixtureId;
    }

    public String getFixtureDate() {
        return fixtureDate;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public int getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    private String round;

    /**
     * Fixture Details Setters
     */

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureEvent.java
```java
package org.footballapp.model.fixtures;

public class FixtureEvent {

    private int id;

    private long fixtureId;

    private Integer elapsed;

    private Integer extraTime;

    private int teamId;

    private Integer playerId;

    private Integer assistPlayerId;

    private String eventType;

    private String eventDetail;

    private String comments;

    public FixtureEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Integer getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Integer extraTime) {
        this.extraTime = extraTime;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getAssistPlayerId() {
        return assistPlayerId;
    }

    public void setAssistPlayerId(Integer assistPlayerId) {
        this.assistPlayerId = assistPlayerId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

## File: footballapp/src/main/java/org/footballapp/model/fixtures/FixtureStatistic.java
```java
package org.footballapp.model.fixtures;

import java.math.BigDecimal;

public class FixtureStatistic {

    private long fixtureId;
    private int teamId;

    private Integer shotsOnGoal;
    private Integer shotsOffGoal;
    private Integer totalShots;
    private Integer blockedShots;
    private Integer shotsInsideBox;
    private Integer shotsOutsideBox;
    private Integer fouls;
    private Integer cornerKicks;
    private Integer offsides;
    private String ballPossession;
    private Integer yellowCards;
    private Integer redCards;
    private Integer goalkeeperSaves;
    private Integer totalPasses;
    private Integer accuratePasses;
    private String passPercentage;
    private BigDecimal expectedGoals;
    private BigDecimal goalsPrevented;

    public FixtureStatistic() {
    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getShotsOnGoal() {
        return shotsOnGoal;
    }

    public void setShotsOnGoal(Integer shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public Integer getShotsOffGoal() {
        return shotsOffGoal;
    }

    public void setShotsOffGoal(Integer shotsOffGoal) {
        this.shotsOffGoal = shotsOffGoal;
    }

    public Integer getTotalShots() {
        return totalShots;
    }

    public void setTotalShots(Integer totalShots) {
        this.totalShots = totalShots;
    }

    public Integer getBlockedShots() {
        return blockedShots;
    }

    public void setBlockedShots(Integer blockedShots) {
        this.blockedShots = blockedShots;
    }

    public Integer getShotsInsideBox() {
        return shotsInsideBox;
    }

    public void setShotsInsideBox(Integer shotsInsideBox) {
        this.shotsInsideBox = shotsInsideBox;
    }

    public Integer getShotsOutsideBox() {
        return shotsOutsideBox;
    }

    public void setShotsOutsideBox(Integer shotsOutsideBox) {
        this.shotsOutsideBox = shotsOutsideBox;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getCornerKicks() {
        return cornerKicks;
    }

    public void setCornerKicks(Integer cornerKicks) {
        this.cornerKicks = cornerKicks;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public String getBallPossession() {
        return ballPossession;
    }

    public void setBallPossession(String ballPossession) {
        this.ballPossession = ballPossession;
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

    public Integer getGoalkeeperSaves() {
        return goalkeeperSaves;
    }

    public void setGoalkeeperSaves(Integer goalkeeperSaves) {
        this.goalkeeperSaves = goalkeeperSaves;
    }

    public Integer getTotalPasses() {
        return totalPasses;
    }

    public void setTotalPasses(Integer totalPasses) {
        this.totalPasses = totalPasses;
    }

    public Integer getAccuratePasses() {
        return accuratePasses;
    }

    public void setAccuratePasses(Integer accuratePasses) {
        this.accuratePasses = accuratePasses;
    }

    public String getPassPercentage() {
        return passPercentage;
    }

    public void setPassPercentage(String passPercentage) {
        this.passPercentage = passPercentage;
    }

    public BigDecimal getExpectedGoals() {
        return expectedGoals;
    }

    public void setExpectedGoals(BigDecimal expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public BigDecimal getGoalsPrevented() {
        return goalsPrevented;
    }

    public void setGoalsPrevented(BigDecimal goalsPrevented) {
        this.goalsPrevented = goalsPrevented;
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

## File: footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineup.java
```java
package org.footballapp.model.lineups;

/**
 * Represents a team's lineup for a fixture.
 *
 * One record exists per team per fixture.
 */
public class FixtureLineup {

    private long fixtureId;

    private int teamId;

    private int coachId;

    private String coachName;

    private String formation;

    public FixtureLineup() {
    }

    public FixtureLineup(

            long fixtureId,

            int teamId,

            int coachId,

            String coachName,

            String formation

    ) {

        this.fixtureId = fixtureId;
        this.teamId = teamId;
        this.coachId = coachId;
        this.coachName = coachName;
        this.formation = formation;

    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(
            long fixtureId
    ) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(
            int teamId
    ) {
        this.teamId = teamId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(
            int coachId
    ) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(
            String coachName
    ) {
        this.coachName = coachName;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(
            String formation
    ) {
        this.formation = formation;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/lineups/FixtureLineupPlayer.java
```java
package org.footballapp.model.lineups;

/**
 * Represents a player in a fixture lineup.
 *
 * One record exists per player per fixture.
 */
public class FixtureLineupPlayer {

    private long fixtureId;

    private int teamId;

    private int playerId;

    private int shirtNumber;

    private String position;

    private String grid;

    private boolean starting;

    private int displayOrder;

    public FixtureLineupPlayer() {
    }

    public FixtureLineupPlayer(

            long fixtureId,

            int teamId,

            int playerId,

            int shirtNumber,

            String position,

            String grid,

            boolean starting,

            int displayOrder

    ) {

        this.fixtureId = fixtureId;
        this.teamId = teamId;
        this.playerId = playerId;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.grid = grid;
        this.starting = starting;
        this.displayOrder = displayOrder;

    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(
            long fixtureId
    ) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(
            int teamId
    ) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(
            int playerId
    ) {
        this.playerId = playerId;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(
            int shirtNumber
    ) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(
            String position
    ) {
        this.position = position;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(
            String grid
    ) {
        this.grid = grid;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(
            boolean starting
    ) {
        this.starting = starting;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(
            int displayOrder
    ) {
        this.displayOrder = displayOrder;
    }

}
```

## File: footballapp/src/main/java/org/footballapp/model/player/Paging.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents API-Football paging information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {

    private int current;
    private int total;

    public Paging() {
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

## File: footballapp/src/main/java/org/footballapp/model/player/PlayerBirth.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a player's birth information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerBirth {

    private String date;
    private String place;
    private String country;

    public PlayerBirth() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/player/PlayerResponse.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.footballapp.model.playerstatistics.PlayerStatistics;

import java.util.List;

/**
 * Represents a single player returned by API-Football.
 *
 * The API also returns a statistics array, which will
 * be mapped later when player statistics are implemented.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponse {

    private Player player;

    private List<PlayerStatistics> statistics;

    public PlayerResponse() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<PlayerStatistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(
            List<PlayerStatistics> statistics
    ) {
        this.statistics = statistics;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/player/PlayersApiResponse.java
```java
package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Root API-Football response for player requests.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayersApiResponse {

    private Paging paging;

    private List<PlayerResponse> response;

    public PlayersApiResponse() {
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<PlayerResponse> getResponse() {
        return response;
    }

    public void setResponse(
            List<PlayerResponse> response
    ) {
        this.response = response;
    }
}
```

## File: footballapp/src/main/java/org/footballapp/model/playerdetails/PlayerDetails.java
```java
package org.footballapp.model.playerdetails;

import java.sql.Date;

public class PlayerDetails {

    private int playerId;

    private String displayName;

    private String firstName;

    private String lastName;

    private java.sql.Date birthDate;

    private Integer age;

    private String height;

    private String weight;

    private String nationality;

    private String photoUrl;

    private String position;

    private Integer shirtNumber;

    private Boolean captain;

    private Integer starts;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
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

## File: footballapp/src/main/java/org/footballapp/repository/BaseRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Base class for all repositories.
 *
 * Provides access to the Spring-managed DataSource.
 * Concrete repositories are responsible for their own SQL.
 */
public abstract class BaseRepository {

    protected final DataSource dataSource;

    protected BaseRepository(
            DataSource dataSource
    ) {

        this.dataSource = dataSource;

    }

    protected Connection getConnection()
            throws SQLException {

        return dataSource.getConnection();

    }

}
```

## File: footballapp/src/main/java/org/footballapp/repository/FixtureEventRepository.java
```java
package org.footballapp.repository;

import org.footballapp.model.fixtures.FixtureEvent;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class FixtureEventRepository extends BaseRepository {

    public void deleteFixtureEvents(
            long fixtureId
    ) throws SQLException {

        String sql =
                """
                DELETE FROM fixture_events
                WHERE fixture_id = ?
                """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(
                    1,
                    fixtureId
            );

            stmt.executeUpdate();

        }

    }

    public FixtureEventRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveFixtureEvent(

            FixtureEvent event

    ) throws Exception {

        String sql = """

                INSERT INTO fixture_events
                (
                    fixture_id,
                    elapsed,
                    extra_time,
                    team_id,
                    player_id,
                    assist_player_id,
                    event_type,
                    event_detail,
                    comments
                )
                VALUES
                (?, ?, ?, ?, ?, ?, ?, ?, ?)

                """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    event.getFixtureId()
            );

            statement.setObject(
                    2,
                    event.getElapsed()
            );

            statement.setObject(
                    3,
                    event.getExtraTime()
            );

            statement.setInt(
                    4,
                    event.getTeamId()
            );

            statement.setObject(
                    5,
                    event.getPlayerId()
            );

            statement.setObject(
                    6,
                    event.getAssistPlayerId()
            );

            statement.setString(
                    7,
                    event.getEventType()
            );

            statement.setString(
                    8,
                    event.getEventDetail()
            );

            statement.setString(
                    9,
                    event.getComments()
            );

            statement.executeUpdate();

        }

    }

}
```

## File: footballapp/src/main/java/org/footballapp/repository/FixtureLineupRepository.java
```java
package org.footballapp.repository;

import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FixtureLineupRepository extends BaseRepository {


    public FixtureLineupRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    /**
     * Maps a fixture lineup row.
     */
    private FixtureLineup mapFixtureLineup(
            ResultSet rs
    ) throws SQLException {

        FixtureLineup lineup =
                new FixtureLineup();

        lineup.setFixtureId(
                rs.getLong("fixture_id")
        );

        lineup.setTeamId(
                rs.getInt("team_id")
        );

        lineup.setCoachId(
                rs.getInt("coach_id")
        );

        lineup.setCoachName(
                rs.getString("coach_name")
        );

        lineup.setFormation(
                rs.getString("formation")
        );

        return lineup;

    }

    /**
     * Maps a fixture lineup player row.
     */
    private FixtureLineupPlayer mapFixtureLineupPlayer(
            ResultSet rs
    ) throws SQLException {

        FixtureLineupPlayer player =
                new FixtureLineupPlayer();

        player.setFixtureId(
                rs.getLong("fixture_id")
        );

        player.setTeamId(
                rs.getInt("team_id")
        );

        player.setPlayerId(
                rs.getInt("player_id")
        );

        player.setShirtNumber(
                rs.getInt("shirt_number")
        );

        player.setPosition(
                rs.getString("position")
        );

        player.setGrid(
                rs.getString("grid")
        );

        player.setStarting(
                rs.getBoolean("is_starting")
        );

        player.setDisplayOrder(
                rs.getInt("display_order")
        );

        return player;

    }

    /**
     * Saves a team's lineup for a fixture.
     */
    public void saveFixtureLineup(
            FixtureLineup lineup
    ) throws SQLException {

        String sql = """

            INSERT INTO fixture_lineups (

                fixture_id,
                team_id,
                coach_id,
                coach_name,
                formation

            )

            VALUES (?, ?, ?, ?, ?)

            ON CONFLICT (

                fixture_id,
                team_id

            )

            DO UPDATE SET

                coach_id = EXCLUDED.coach_id,
                coach_name = EXCLUDED.coach_name,
                formation = EXCLUDED.formation

            """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    lineup.getFixtureId()
            );

            statement.setInt(
                    2,
                    lineup.getTeamId()
            );

            statement.setInt(
                    3,
                    lineup.getCoachId()
            );

            statement.setString(
                    4,
                    lineup.getCoachName()
            );

            statement.setString(
                    5,
                    lineup.getFormation()
            );

            statement.executeUpdate();

        }

    }

    /**
     * Saves a player in a fixture lineup.
     */
    public void saveFixtureLineupPlayer(
            FixtureLineupPlayer player
    ) throws SQLException {

        String sql = """

            INSERT INTO fixture_lineup_players (

                fixture_id,
                team_id,
                player_id,
                shirt_number,
                position,
                grid,
                is_starting,
                display_order

            )

            VALUES (?, ?, ?, ?, ?, ?, ?, ?)

            ON CONFLICT (

                fixture_id,
                team_id,
                player_id

            )

            DO UPDATE SET

                shirt_number = EXCLUDED.shirt_number,
                position = EXCLUDED.position,
                grid = EXCLUDED.grid,
                is_starting = EXCLUDED.is_starting,
                display_order = EXCLUDED.display_order

            """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    player.getFixtureId()
            );

            statement.setInt(
                    2,
                    player.getTeamId()
            );

            statement.setInt(
                    3,
                    player.getPlayerId()
            );

            statement.setInt(
                    4,
                    player.getShirtNumber()
            );

            statement.setString(
                    5,
                    player.getPosition()
            );

            statement.setString(
                    6,
                    player.getGrid()
            );

            statement.setBoolean(
                    7,
                    player.isStarting()
            );

            statement.setInt(
                    8,
                    player.getDisplayOrder()
            );

            statement.executeUpdate();

        }

    }

    /**
     * Retrieves the lineups for a fixture.
     */
    public List<FixtureLineup> getFixtureLineups(
            long fixtureId
    ) throws Exception {

        String sql = """

            SELECT *
            FROM fixture_lineups
            WHERE fixture_id = ?
            ORDER BY team_id

            """;

        List<FixtureLineup> lineups =
                new ArrayList<>();

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    fixtureId
            );

            ResultSet rs =
                    statement.executeQuery();

            while (rs.next()) {

                lineups.add(
                        mapFixtureLineup(rs)
                );

            }

            rs.close();

        }

        return lineups;

    }

    /**
     * Retrieves the players for a team's lineup.
     */
    public List<FixtureLineupPlayer> getFixtureLineupPlayers(

            long fixtureId,

            int teamId

    ) throws Exception {

        String sql = """

            SELECT *
            FROM fixture_lineup_players
            WHERE fixture_id = ?
            AND team_id = ?
            ORDER BY display_order

            """;

        List<FixtureLineupPlayer> players =
                new ArrayList<>();

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    fixtureId
            );

            statement.setInt(
                    2,
                    teamId
            );

            ResultSet rs =
                    statement.executeQuery();

            while (rs.next()) {

                players.add(
                        mapFixtureLineupPlayer(rs)
                );

            }

            rs.close();

        }

        return players;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/repository/FixtureRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
import org.footballapp.model.fixtures.FixtureDetails;
import org.springframework.stereotype.Repository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixtureRow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Repository
public class FixtureRepository extends BaseRepository {

    public FixtureRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveFixture(FixtureResponse fixtureResponse)
            throws Exception {

        Connection conn =
                getConnection();

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
                getConnection();

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
                getConnection();

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
                getConnection();

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
                getConnection();

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
                getConnection();

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

    /**
     * Get Fixture Details
     */

    public FixtureDetails getFixtureDetails(
            long fixtureId
    ) throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
    
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
    
                            f.home_team_id,
                            home.name AS home_team,
    
                            f.away_team_id,
                            away.name AS away_team,
    
                            f.home_goals,
                            f.away_goals,
    
                            f.league_id,
                            l.name AS league_name,
    
                            f.season,
    
                            f.venue_id,
                            v.name AS venue_name
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON home.id = f.home_team_id
    
                        JOIN teams away
                            ON away.id = f.away_team_id
    
                        JOIN leagues l
                            ON l.league_id = f.league_id
    
                        LEFT JOIN venues v
                            ON v.id = f.venue_id
    
                        WHERE f.fixture_id = ?
                        """
                );

        stmt.setLong(
                1,
                fixtureId
        );

        ResultSet rs =
                stmt.executeQuery();

        FixtureDetails details = null;

        if (rs.next()) {

            details =
                    new FixtureDetails();

            details.setFixtureId(
                    rs.getLong("fixture_id")
            );

            details.setFixtureDate(
                    rs.getString("fixture_date")
            );

            details.setRound(
                    rs.getString("round")
            );

            details.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            details.setHomeTeam(
                    rs.getString("home_team")
            );

            details.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            details.setAwayTeam(
                    rs.getString("away_team")
            );

            details.setHomeGoals(
                    (Integer) rs.getObject("home_goals")
            );

            details.setAwayGoals(
                    (Integer) rs.getObject("away_goals")
            );

            details.setLeagueId(
                    rs.getInt("league_id")
            );

            details.setLeagueName(
                    rs.getString("league_name")
            );

            details.setSeason(
                    rs.getInt("season")
            );

            details.setVenueName(
                    rs.getString("venue_name")
            );

        }

        rs.close();
        stmt.close();
        conn.close();

        return details;

    }

    public List<Long> getFixtureIds(
            int leagueId,
            int season
    ) throws SQLException {

        String sql = """
            SELECT fixture_id
            FROM fixtures
            WHERE league_id = ?
              AND season = ?
            ORDER BY fixture_date
            """;

        List<Long> fixtureIds = new ArrayList<>();

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, leagueId);
            statement.setInt(2, season);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    fixtureIds.add(
                            rs.getLong("fixture_id")
                    );

                }
            }
        }

        return fixtureIds;
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

## File: footballapp/src/main/java/org/footballapp/repository/FixtureStatisticRepository.java
```java
package org.footballapp.repository;

import org.footballapp.model.fixtures.FixtureStatistic;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

@Repository
public class FixtureStatisticRepository extends BaseRepository {

    public FixtureStatisticRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveFixtureStatistic(
            FixtureStatistic statistic
    ) throws SQLException {

        String sql =
                """
                INSERT INTO fixture_statistics (
                    fixture_id,
                    team_id,
                    shots_on_goal,
                    shots_off_goal,
                    total_shots,
                    blocked_shots,
                    shots_inside_box,
                    shots_outside_box,
                    fouls,
                    corner_kicks,
                    offsides,
                    ball_possession,
                    yellow_cards,
                    red_cards,
                    goalkeeper_saves,
                    total_passes,
                    accurate_passes,
                    pass_percentage,
                    expected_goals,
                    goals_prevented
                )
                VALUES (
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
                )
                """;

        try (

                Connection conn = getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(1, statistic.getFixtureId());
            stmt.setInt(2, statistic.getTeamId());

            stmt.setObject(3, statistic.getShotsOnGoal());
            stmt.setObject(4, statistic.getShotsOffGoal());
            stmt.setObject(5, statistic.getTotalShots());
            stmt.setObject(6, statistic.getBlockedShots());
            stmt.setObject(7, statistic.getShotsInsideBox());
            stmt.setObject(8, statistic.getShotsOutsideBox());
            stmt.setObject(9, statistic.getFouls());
            stmt.setObject(10, statistic.getCornerKicks());
            stmt.setObject(11, statistic.getOffsides());
            stmt.setString(12, statistic.getBallPossession());
            stmt.setObject(13, statistic.getYellowCards());
            stmt.setObject(14, statistic.getRedCards());
            stmt.setObject(15, statistic.getGoalkeeperSaves());
            stmt.setObject(16, statistic.getTotalPasses());
            stmt.setObject(17, statistic.getAccuratePasses());
            stmt.setString(18, statistic.getPassPercentage());
            stmt.setBigDecimal(19, statistic.getExpectedGoals());
            stmt.setBigDecimal(20, statistic.getGoalsPrevented());

            stmt.executeUpdate();

        }

    }

    public FixtureStatistic getFixtureStatistic(
            long fixtureId,
            int teamId
    ) throws SQLException {

        String sql =
                """
                SELECT *
                FROM fixture_statistics
                WHERE fixture_id = ?
                  AND team_id = ?
                """;

        try (

                Connection conn = getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(1, fixtureId);
            stmt.setInt(2, teamId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return mapRow(rs);

            }

        }

        return null;

    }

    public List<FixtureStatistic> getFixtureStatistics(
            long fixtureId
    ) throws SQLException {

        List<FixtureStatistic> statistics =
                new ArrayList<>();

        String sql =
                """
                SELECT *
                FROM fixture_statistics
                WHERE fixture_id = ?
                ORDER BY team_id
                """;

        try (

                Connection conn = getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(1, fixtureId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                statistics.add(
                        mapRow(rs)
                );

            }

        }

        return statistics;

    }

    private FixtureStatistic mapRow(
            ResultSet rs
    ) throws SQLException {

        FixtureStatistic statistic =
                new FixtureStatistic();

        statistic.setFixtureId(
                rs.getLong("fixture_id"));

        statistic.setTeamId(
                rs.getInt("team_id"));

        statistic.setShotsOnGoal(
                (Integer) rs.getObject("shots_on_goal"));

        statistic.setShotsOffGoal(
                (Integer) rs.getObject("shots_off_goal"));

        statistic.setTotalShots(
                (Integer) rs.getObject("total_shots"));

        statistic.setBlockedShots(
                (Integer) rs.getObject("blocked_shots"));

        statistic.setShotsInsideBox(
                (Integer) rs.getObject("shots_inside_box"));

        statistic.setShotsOutsideBox(
                (Integer) rs.getObject("shots_outside_box"));

        statistic.setFouls(
                (Integer) rs.getObject("fouls"));

        statistic.setCornerKicks(
                (Integer) rs.getObject("corner_kicks"));

        statistic.setOffsides(
                (Integer) rs.getObject("offsides"));

        statistic.setBallPossession(
                rs.getString("ball_possession"));

        statistic.setYellowCards(
                (Integer) rs.getObject("yellow_cards"));

        statistic.setRedCards(
                (Integer) rs.getObject("red_cards"));

        statistic.setGoalkeeperSaves(
                (Integer) rs.getObject("goalkeeper_saves"));

        statistic.setTotalPasses(
                (Integer) rs.getObject("total_passes"));

        statistic.setAccuratePasses(
                (Integer) rs.getObject("accurate_passes"));

        statistic.setPassPercentage(
                rs.getString("pass_percentage"));

        statistic.setExpectedGoals(
                rs.getBigDecimal("expected_goals"));

        statistic.setGoalsPrevented(
                rs.getBigDecimal("goals_prevented"));

        return statistic;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/repository/LeagueRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
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
public class LeagueRepository
        extends BaseRepository {

    public LeagueRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    /**
     * Saves a league to the database.
     *
     * If the league already exists, updates the existing record.
     */
    public void saveLeague(League league)
            throws Exception {
        Connection conn =
                getConnection();

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

## File: footballapp/src/main/java/org/footballapp/repository/LeagueTeamRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class LeagueTeamRepository
        extends BaseRepository {

    public LeagueTeamRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveLeagueTeam(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        Connection conn =
                getConnection();

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
                getConnection();

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

## File: footballapp/src/main/java/org/footballapp/repository/PlayerRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import org.footballapp.model.player.Player;
import org.footballapp.model.playerdetails.PlayerDetails;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Repository for storing player identity information.
 *
 * This repository only stores player details.
 * Season statistics are stored separately.
 */
@Repository
public class PlayerRepository extends BaseRepository {

    public PlayerRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    /**
     * Maps a player row.
     */
    private Player mapPlayer(
            ResultSet rs
    ) throws SQLException {

        Player player = new Player();

        player.setPlayerId(
                rs.getInt("player_id")
        );

        player.setFirstname(
                rs.getString("firstname")
        );

        player.setLastname(
                rs.getString("lastname")
        );

        player.setName(
                rs.getString("display_name")
        );

        player.setNationality(
                rs.getString("nationality")
        );

        player.setHeight(
                rs.getString("height")
        );

        player.setWeight(
                rs.getString("weight")
        );

        player.setAge(
                (Integer) rs.getObject("age")
        );

        player.setInjured(
                rs.getBoolean("injured")
        );

        player.setPhotoUrl(
                rs.getString("photo_url")
        );

        return player;

    }



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
                        getConnection();

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
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
    
                            p.player_id,
                            p.display_name,
                            p.firstname,
                            p.lastname,
                            p.birth_date,
                            p.age,
                            p.nationality,
                            p.height,
                            p.weight,
                            p.photo_url,
    
                            ps.position,
                            ps.shirt_number,
                            ps.captain,
                            ps.starts,
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

            details.setBirthDate(
                    rs.getDate("birth_date")
            );

            details.setHeight(
                    rs.getString("height")
            );

            details.setWeight(
                    rs.getString("weight")
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

            details.setStarts(
                    (Integer) rs.getObject("starts")
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

            BigDecimal rating = rs.getBigDecimal("rating");

            details.setRating(
                    rating != null
                            ? rating.doubleValue()
                            : null
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

    /**
     * Retrieves a player by ID.
     */
    public Player getPlayerById(
            int playerId
    ) throws Exception {

        String sql = """

        SELECT *

        FROM players

        WHERE player_id = ?

        """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setInt(
                    1,
                    playerId
            );

            ResultSet rs =
                    stmt.executeQuery();

            if (!rs.next()) {

                rs.close();

                return null;

            }

            Player player = mapPlayer(rs);

            rs.close();

            return player;

        }

    }
}
```

## File: footballapp/src/main/java/org/footballapp/repository/PlayerStatisticsRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
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
public class PlayerStatisticsRepository
        extends BaseRepository {

    public PlayerStatisticsRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

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
                        getConnection();

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
                getConnection();

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

## File: footballapp/src/main/java/org/footballapp/repository/StandingRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.LeagueTableRow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StandingRepository
        extends BaseRepository  {

    public StandingRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveStanding(
            int leagueId,
            int season,
            Standing standing
    ) throws Exception {

        Connection conn =
                getConnection();

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

//    public List<LeagueTableRow> getLeagueTable(
//            int leagueId,
//            int season
//    )
//            throws Exception {
//
//        Connection conn =
//                getConnection();
//
//        PreparedStatement stmt =
//                conn.prepareStatement(
//                        """
//                        SELECT
//                            s.position,
//                            s.team_id,
//                            t.name,
//                            s.played,
//                            s.wins,
//                            s.draws,
//                            s.losses,
//                            s.goal_difference,
//                            s.points
//                        FROM standings s
//                        JOIN teams t
//                            ON s.team_id = t.id
//                        WHERE s.league_id = ?
//                        AND s.season = ?
//                        ORDER BY s.position
//                        """
//                );
//
//        stmt.setInt(1, leagueId);
//        stmt.setInt(2, season);
//
//        ResultSet rs =
//                stmt.executeQuery();
//
//        List<LeagueTableRow> table =
//                new ArrayList<>();
//
//        while (rs.next()) {
//
//            LeagueTableRow row =
//                    new LeagueTableRow();
//
//            row.setPosition(
//                    rs.getInt("position")
//            );
//
//            row.setTeamId(
//                    rs.getInt("team_id")
//            );
//
//            row.setTeamName(
//                    rs.getString("name")
//            );
//
//            row.setPlayed(
//                    rs.getInt("played")
//            );
//
//            row.setWins(
//                    rs.getInt("wins")
//            );
//
//            row.setDraws(
//                    rs.getInt("draws")
//            );
//
//            row.setLosses(
//                    rs.getInt("losses")
//            );
//
//            row.setGoalDifference(
//                    rs.getInt("goal_difference")
//            );
//
//            row.setPoints(
//                    rs.getInt("points")
//            );
//
//            table.add(row);
//        }
//
//        rs.close();
//        stmt.close();
//        conn.close();
//
//        return table;
//    }

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
                getConnection();

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
                getConnection();

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

## File: footballapp/src/main/java/org/footballapp/repository/TeamRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teams.Team;
import org.footballapp.model.club.ClubDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles persistence of team data.
 *
 * Responsible for inserting and updating records
 * in the teams table.
 */
@Repository
public class TeamRepository
        extends BaseRepository {

    protected TeamRepository(DataSource dataSource) {
        super(dataSource);
    }

    private Team mapTeam(ResultSet rs) throws SQLException {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setName(rs.getString("name"));
        team.setCountry(rs.getString("country"));
        team.setFounded(rs.getInt("founded"));
        team.setVenueId(rs.getInt("venue_id"));
        return team;
    }

    /**
     * Saves a team to the database.
     *
     * If the team already exists, updates the existing record.
     */
    public void saveTeam(Team team) throws Exception {

        Connection conn =
                getConnection();

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
                getConnection();

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

            team.setVenueId(
                    rs.getInt("venue_id")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return team;
    }

    /** GET League, Season & Venue to JOIN with Team */
    public List<Team> getTeamsForLeague(
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            t.id,
                            t.name,
                            t.country,
                            t.founded,
                            t.venue_id
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

            team.setVenueId(
                    rs.getInt("venue_id")
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
                getConnection();

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

## File: footballapp/src/main/java/org/footballapp/repository/TeamStatisticsRepository.java
```java
package org.footballapp.repository;


import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teamstatistics.CardColour;
import org.footballapp.model.teamstatistics.CardMinute;
import org.footballapp.model.teamstatistics.TeamStatistics;
import org.footballapp.model.teamstatistics.TeamStatisticsResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class TeamStatisticsRepository
        extends BaseRepository {

    public TeamStatisticsRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

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
                        getConnection();

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
                getConnection();

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

## File: footballapp/src/main/java/org/footballapp/repository/VenueRepository.java
```java
package org.footballapp.repository;

import javax.sql.DataSource;
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
public class VenueRepository
        extends BaseRepository {

    public VenueRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    /**
     * Saves a venue to the database.
     *
     * If the venue already exists, updates the existing record.
     */
    public void saveVenue(Venue venues) throws Exception {

        Connection conn =
                getConnection();

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
                getConnection();

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

## File: footballapp/src/main/java/org/footballapp/service/FixtureImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.repository.FixtureRepository;
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

## File: footballapp/src/main/java/org/footballapp/service/importer/FixtureEventImportService.java
```java
package org.footballapp.service.importer;

import org.footballapp.api.ApiFootballService;
import org.footballapp.api.dto.events.FixtureEventResponse;
import org.footballapp.api.dto.events.FixtureEventsResponse;
import org.footballapp.repository.FixtureEventRepository;
import org.footballapp.model.fixtures.FixtureEvent;
import org.springframework.stereotype.Service;

@Service
public class FixtureEventImportService {

    public void replaceFixtureEvents(
            long fixtureId
    ) throws Exception {

        repository.deleteFixtureEvents(
                fixtureId
        );

        importFixtureEvents(
                fixtureId
        );

    }

    private final ApiFootballService apiFootballService;

    private final FixtureEventRepository repository;

    public FixtureEventImportService(

            ApiFootballService apiFootballService,

            FixtureEventRepository repository

    ) {

        this.apiFootballService = apiFootballService;
        this.repository = repository;

    }

    public void importFixtureEvents(

            long fixtureId

    ) throws Exception {

        FixtureEventsResponse response =
                apiFootballService.getFixtureEvents(
                        fixtureId
                );

        if (response == null ||
                response.getResponse() == null) {

            return;

        }

        for (FixtureEventResponse event :

                response.getResponse()) {

            saveEvent(

                    fixtureId,

                    event

            );

        }

    }

    private void saveEvent(

            long fixtureId,

            FixtureEventResponse dto

    ) throws Exception {

        FixtureEvent event =
                new FixtureEvent();

        event.setFixtureId(
                fixtureId
        );

        if (dto.getTime() != null) {

            event.setElapsed(
                    dto.getTime().getElapsed()
            );

            event.setExtraTime(
                    dto.getTime().getExtra()
            );

        }

        if (dto.getTeam() != null) {

            event.setTeamId(
                    dto.getTeam().getId()
            );

        }

        if (dto.getPlayer() != null) {

            event.setPlayerId(
                    dto.getPlayer().getId()
            );

        }

        if (dto.getAssist() != null) {

            event.setAssistPlayerId(
                    dto.getAssist().getId()
            );

        }

        event.setEventType(
                dto.getType()
        );

        event.setEventDetail(
                dto.getDetail()
        );

        event.setComments(
                dto.getComments()
        );

        repository.saveFixtureEvent(
                event
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/service/importer/FixtureLineupImportService.java
```java
package org.footballapp.service.importer;

import org.footballapp.api.ApiFootballService;
import org.footballapp.api.dto.lineups.FixtureLineupResponse;
import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
import org.footballapp.api.dto.lineups.FixturePlayer;
import org.footballapp.api.dto.lineups.FixturePlayerWrapper;
import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.footballapp.repository.FixtureLineupRepository;
import org.footballapp.repository.FixtureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixtureLineupImportService {

    private final ApiFootballService apiFootballService;
    private final FixtureLineupRepository repository;
    private final FixtureRepository fixtureRepository;

    public FixtureLineupImportService(
            ApiFootballService apiFootballService,
            FixtureLineupRepository repository,
            FixtureRepository fixtureRepository
    ) {
        this.apiFootballService = apiFootballService;
        this.repository = repository;
        this.fixtureRepository = fixtureRepository;
    }

    public void importLeagueFixtureLineups(
            int leagueId,
            int season
    ) throws Exception {

        List<Long> fixtureIds =
                fixtureRepository.getFixtureIds(
                        leagueId,
                        season
                );

        int total = fixtureIds.size();
        int current = 1;

        for (Long fixtureId : fixtureIds) {

            try {

                System.out.printf(
                        "[%d/%d] Importing fixture %d%n",
                        current,
                        total,
                        fixtureId
                );

                importFixtureLineups(
                        fixtureId
                );

            } catch (Exception ex) {

                System.err.printf(
                        "Failed to import fixture %d%n",
                        fixtureId
                );

                ex.printStackTrace();

            }

            current++;

        }

    }

    public void importFixtureLineups(
            long fixtureId
    ) throws Exception {

        FixtureLineupsResponse response =
                apiFootballService.getFixtureLineups(
                        fixtureId
                );

        if (response == null ||
                response.getResponse() == null) {

            return;

        }

        for (FixtureLineupResponse lineup :
                response.getResponse()) {

            saveLineup(
                    fixtureId,
                    lineup
            );

        }

    }

    private void saveLineup(
            long fixtureId,
            FixtureLineupResponse lineup
    ) throws Exception {

        if (lineup == null ||
                lineup.getTeam() == null) {

            return;

        }

        int teamId = lineup.getTeam().getId();

        FixtureLineup fixtureLineup =
                new FixtureLineup();

        fixtureLineup.setFixtureId(
                fixtureId
        );

        fixtureLineup.setTeamId(
                teamId
        );

        if (lineup.getCoach() != null) {

            fixtureLineup.setCoachId(
                    lineup.getCoach().getId()
            );

            fixtureLineup.setCoachName(
                    lineup.getCoach().getName()
            );

        }

        fixtureLineup.setFormation(
                lineup.getFormation()
        );

        repository.saveFixtureLineup(
                fixtureLineup
        );

        int displayOrder = 1;

        displayOrder = savePlayerList(
                fixtureId,
                teamId,
                lineup.getStartXI(),
                true,
                displayOrder
        );

        savePlayerList(
                fixtureId,
                teamId,
                lineup.getSubstitutes(),
                false,
                displayOrder
        );

    }

    private int savePlayerList(
            long fixtureId,
            int teamId,
            List<FixturePlayerWrapper> players,
            boolean starting,
            int displayOrder
    ) throws Exception {

        if (players == null) {

            return displayOrder;

        }

        for (FixturePlayerWrapper wrapper : players) {

            if (wrapper == null ||
                    wrapper.getPlayer() == null) {

                continue;

            }

            FixturePlayer dto =
                    wrapper.getPlayer();

            FixtureLineupPlayer player =
                    new FixtureLineupPlayer();

            player.setFixtureId(
                    fixtureId
            );

            player.setTeamId(
                    teamId
            );

            player.setPlayerId(
                    dto.getId()
            );

            player.setShirtNumber(
                    dto.getNumber()
            );

            player.setPosition(
                    dto.getPos()
            );

            player.setGrid(
                    dto.getGrid()
            );

            player.setStarting(
                    starting
            );

            player.setDisplayOrder(
                    displayOrder++
            );

            repository.saveFixtureLineupPlayer(
                    player
            );

        }

        return displayOrder;

    }

}
```

## File: footballapp/src/main/java/org/footballapp/service/importer/FixtureStatisticImportService.java
```java
package org.footballapp.service.importer;

import org.footballapp.api.ApiFootballService;
import org.footballapp.api.dto.fixtures.FixtureStatisticsResponse;
import org.footballapp.api.dto.fixtures.FixtureTeamStatistics;
import org.footballapp.api.dto.fixtures.Statistic;
import org.footballapp.repository.FixtureStatisticRepository;
import org.footballapp.model.fixtures.FixtureStatistic;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.postgresql.jdbc.PgResultSet.toBigDecimal;

@Service
public class FixtureStatisticImportService {

    private final ApiFootballService apiFootballService;

    private final FixtureStatisticRepository repository;

    public FixtureStatisticImportService(

            ApiFootballService apiFootballService,

            FixtureStatisticRepository repository

    ) {

        this.apiFootballService =
                apiFootballService;

        this.repository =
                repository;

    }

    public void importFixtureStatistics(

            long fixtureId,

            int teamId

    ) throws Exception {

        FixtureStatisticsResponse response =
                apiFootballService
                        .getFixtureStatistics(

                                fixtureId,

                                teamId

                        );

        if (response == null ||
                response.getResponse() == null ||
                response.getResponse().isEmpty()) {

            return;

        }

        for (FixtureTeamStatistics teamStatistics
                : response.getResponse()) {

            FixtureStatistic statistic =
                    new FixtureStatistic();

            statistic.setFixtureId(
                    fixtureId
            );

            statistic.setTeamId(
                    teamStatistics
                            .getTeam()
                            .getId()
            );

            mapStatistics(

                    statistic,

                    teamStatistics

            );

            repository.saveFixtureStatistic(

                    statistic

            );

        }



    }

    private void mapStatistics(

            FixtureStatistic statistic,

            FixtureTeamStatistics teamStatistics

    ) {

        if (teamStatistics.getStatistics() == null) {
            return;
        }

        for (Statistic item :
                teamStatistics.getStatistics()) {

            String type =
                    item.getType();

            Object value =
                    item.getValue();

            switch (type) {

                case "Shots on Goal":
                    statistic.setShotsOnGoal(
                            toInteger(value)
                    );
                    break;

                case "Shots off Goal":
                    statistic.setShotsOffGoal(
                            toInteger(value)
                    );
                    break;

                case "Total Shots":
                    statistic.setTotalShots(
                            toInteger(value)
                    );
                    break;

                case "Blocked Shots":
                    statistic.setBlockedShots(
                            toInteger(value)
                    );
                    break;

                case "Shots insidebox":
                    statistic.setShotsInsideBox(
                            toInteger(value)
                    );
                    break;

                case "Shots outsidebox":
                    statistic.setShotsOutsideBox(
                            toInteger(value)
                    );
                    break;

                case "Fouls":
                    statistic.setFouls(
                            toInteger(value)
                    );
                    break;

                case "Corner Kicks":
                    statistic.setCornerKicks(
                            toInteger(value)
                    );
                    break;

                case "Offsides":
                    statistic.setOffsides(
                            toInteger(value)
                    );
                    break;

                case "Ball Possession":
                    statistic.setBallPossession(
                            value == null
                                    ? null
                                    : value.toString()
                    );
                    break;

                case "Yellow Cards":
                    statistic.setYellowCards(
                            toInteger(value)
                    );
                    break;

                case "Red Cards":
                    statistic.setRedCards(
                            toInteger(value)
                    );
                    break;

                case "Goalkeeper Saves":
                    statistic.setGoalkeeperSaves(
                            toInteger(value)
                    );
                    break;

                case "Total passes":
                    statistic.setTotalPasses(
                            toInteger(value)
                    );
                    break;

                case "Passes accurate":
                    statistic.setAccuratePasses(
                            toInteger(value)
                    );
                    break;

                case "Passes %":
                    statistic.setPassPercentage(
                            value == null
                                    ? null
                                    : value.toString()
                    );
                    break;

                case "expected_goals":
                    statistic.setExpectedGoals(
                            toBigDecimal(value)
                    );
                    break;

                case "goals_prevented":
                    statistic.setGoalsPrevented(
                            toBigDecimal(value)
                    );
                    break;
            }

        }

    }
    private Integer toInteger(Object value) {

        if (value == null) {
            return null;
        }

        if (value instanceof Number number) {
            return number.intValue();
        }

        return Integer.parseInt(
                value.toString()
        );

    }

    private BigDecimal toBigDecimal(Object value) {

        if (value == null) {
            return null;
        }

        if (value instanceof BigDecimal decimal) {
            return decimal;
        }

        return new BigDecimal(
                value.toString()
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
import org.footballapp.api.response.lineups.FixtureLineupMapper;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.teams.TeamResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**Import repositories*/
import org.footballapp.repository.FixtureRepository;
import org.footballapp.repository.FixtureLineupRepository;
import org.footballapp.repository.StandingRepository;
import org.footballapp.repository.TeamRepository;
import org.footballapp.repository.TeamStatisticsRepository;
import org.footballapp.repository.VenueRepository;
import org.footballapp.repository.PlayerStatisticsRepository;
import org.footballapp.repository.PlayerRepository;
import org.footballapp.model.club.ClubDetails;

/**Import models*/
import org.footballapp.model.fixtures.FixtureDetails;
import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.footballapp.api.response.lineups.FixtureLineupResponse;
import org.footballapp.api.response.lineups.FixtureTeamLineupResponse;
import org.footballapp.api.response.lineups.PlayerLineupResponse;
import org.footballapp.model.player.Player;
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

@Service
public class LeagueDataService {

    private final TeamRepository teamRepository;
    private final TeamStatisticsRepository teamStatisticsRepository;
    private final VenueRepository venueRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;
    private final PlayerRepository playerRepository;
    private final FixtureLineupRepository fixtureLineupRepository;
    private final FixtureLineupMapper fixtureLineupMapper;
    private final SupportedCompetitionsService supportedCompetitionsService;
    private final StandingService standingService;
    private final TeamService teamService;

    /**
     * Contructors
     */
    public LeagueDataService(
            TeamRepository teamRepository,
            TeamService teamService,
            TeamStatisticsRepository teamStatisticsRepository,
            VenueRepository venueRepository,
            StandingRepository standingRepository,
            StandingService standingService,
            FixtureRepository fixtureRepository,
            FixtureLineupRepository fixtureLineupRepository,
            FixtureLineupMapper fixtureLineupMapper,
            PlayerStatisticsRepository playerStatisticsRepository,
            PlayerRepository playerRepository,
            SupportedCompetitionsService supportedCompetitionsService
    ) {
        this.teamRepository = teamRepository;
        this.teamService = teamService;
        this.teamStatisticsRepository = teamStatisticsRepository;
        this.venueRepository = venueRepository;
        this.standingRepository = standingRepository;
        this.standingService = standingService;
        this.fixtureRepository = fixtureRepository;
        this.fixtureLineupRepository = fixtureLineupRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;
        this.playerRepository = playerRepository;
        this.fixtureLineupMapper = fixtureLineupMapper;
        this.supportedCompetitionsService = supportedCompetitionsService;
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

        StandingsApiResponse response =
                standingService.getStandings(
                        leagueId,
                        season
                );

        List<LeagueTableRow> table =
                new ArrayList<>();

        for (Standing standing :
                response.getResponse()
                        .getFirst()
                        .getLeague()
                        .getStandings()
                        .getFirst()) {

            LeagueTableRow row =
                    new LeagueTableRow();

            row.setPosition(
                    standing.getRank()
            );

            row.setTeamId(
                    standing.getTeam().getId()
            );

            row.setTeamName(
                    standing.getTeam().getName()
            );

            row.setPlayed(
                    standing.getAll().getPlayed()
            );

            row.setWins(
                    standing.getAll().getWin()
            );

            row.setDraws(
                    standing.getAll().getDraw()
            );

            row.setLosses(
                    standing.getAll().getLose()
            );

            row.setGoalDifference(
                    standing.getGoalsDiff()
            );

            row.setPoints(
                    standing.getPoints()
            );

            table.add(row);
        }

        return table;
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
     * Get Fixture Details
     */

    public FixtureDetails getFixtureDetails(
            long fixtureId
    ) throws Exception {

        return fixtureRepository.getFixtureDetails(
                fixtureId
        );

    }

    /**
     * Retrieves the lineups for a fixture.
     */
    public List<FixtureLineup> getFixtureLineups(

            long fixtureId

    ) throws Exception {

        return fixtureLineupRepository.getFixtureLineups(
                fixtureId
        );

    }

    /**
     * Retrieves the players for a team's lineup.
     */
    public List<FixtureLineupPlayer> getFixtureLineupPlayers(

            long fixtureId,

            int teamId

    ) throws Exception {

        return fixtureLineupRepository.getFixtureLineupPlayers(

                fixtureId,

                teamId

        );

    }

    /**
     * Retrieves the complete lineup for a fixture.
     */
    public FixtureLineupResponse getFixtureLineupResponse(

            long fixtureId

    ) throws Exception {

        FixtureLineupResponse response =
                fixtureLineupMapper.createResponse(
                        fixtureId
                );

        List<FixtureLineup> lineups =
                fixtureLineupRepository.getFixtureLineups(
                        fixtureId
                );

        for (FixtureLineup lineup : lineups) {

            Team team =
                    teamRepository.getTeamById(
                            lineup.getTeamId()
                    );

            List<FixtureLineupPlayer> lineupPlayers =
                    fixtureLineupRepository.getFixtureLineupPlayers(

                            fixtureId,

                            lineup.getTeamId()

                    );

            List<PlayerLineupResponse> playerResponses =
                    new ArrayList<>();

            for (FixtureLineupPlayer lineupPlayer : lineupPlayers) {

                Player player =
                        playerRepository.getPlayerById(

                                lineupPlayer.getPlayerId()

                        );

                String playerName = "";
                String photo = "";

                if (player != null) {

                    playerName =
                            player.getName();

                    photo =
                            player.getPhotoUrl();

                }

                PlayerLineupResponse playerResponse =
                        fixtureLineupMapper.mapPlayer(

                                lineupPlayer,

                                playerName

                        );

                playerResponse.setPhoto(
                        photo
                );

                playerResponses.add(
                        playerResponse
                );

            }

            FixtureTeamLineupResponse teamResponse =
                    fixtureLineupMapper.mapTeamLineup(

                            lineup,

                            team,

                            playerResponses

                    );

            response.getTeams().add(
                    teamResponse
            );

        }

        return response;

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

        TeamResponse teamResponse =
                teamService.getTeam(
                        teamId
                );

        details.setTeam(
                teamResponse.getTeam()
        );

        details.setVenue(
                teamResponse.getVenue()
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
     * Get League Overview
     */
    public LeagueOverview getLeagueOverview(
            int leagueId,
            int season
    ) throws Exception {

        LeagueOverview overview =
                new LeagueOverview();

        overview.setLeagueId(
                leagueId
        );

        overview.setLeagueName(
                supportedCompetitionsService
                        .getCompetitionById(leagueId)
                        .getName()
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

## File: footballapp/src/main/java/org/footballapp/service/PlayerImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.repository.PlayerRepository;
import org.footballapp.repository.PlayerStatisticsRepository;
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
                            season,
                            page
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
import org.footballapp.repository.StandingRepository;
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

## File: footballapp/src/main/java/org/footballapp/service/SupportedCompetitionsService.java
```java
package org.footballapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.config.competitions.SupportedCompetition;
import org.footballapp.config.competitions.SupportedCompetitionGroup;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SupportedCompetitionsService {

    private static final String LOGO_BASE_URL =
            "https://media.api-sports.io/football/leagues/";

    private final List<SupportedCompetitionGroup> competitionGroups;

    public SupportedCompetitionsService(ObjectMapper objectMapper)
            throws IOException {

        competitionGroups = objectMapper.readValue(
                new ClassPathResource("supported-competitions.json").getInputStream(),
                new TypeReference<List<SupportedCompetitionGroup>>() {}
        );

        populateLogoUrls();
    }

    public List<SupportedCompetitionGroup> getCompetitionGroups() {
        return competitionGroups;
    }

    private void populateLogoUrls() {

        for (SupportedCompetitionGroup group : competitionGroups) {

            for (SupportedCompetition competition : group.getCompetitions()) {

                competition.setLogoUrl(
                        LOGO_BASE_URL
                                + competition.getCompetitionId()
                                + ".png"
                );
            }
        }
    }

    public SupportedCompetition getCompetitionById(int competitionId) {

        for (SupportedCompetitionGroup group : competitionGroups) {

            for (SupportedCompetition competition : group.getCompetitions()) {

                if (competition.getCompetitionId() == competitionId) {
                    return competition;
                }
            }
        }

        throw new IllegalArgumentException(
                "Unsupported competition: " + competitionId
        );
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/TeamImportService.java
```java
package org.footballapp.service;

//import org.footballapp.repository.LeagueRepository;
import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.repository.LeagueTeamRepository;
import org.footballapp.repository.TeamRepository;
import org.footballapp.repository.VenueRepository;
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

import org.footballapp.api.ApiFootballService;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final ApiFootballService apiFootballService;

    public TeamService(
            ApiFootballService apiFootballService
    ) {
        this.apiFootballService = apiFootballService;
    }

    /**
     * Retrieves a single team from API-Football.
     */
    public TeamResponse getTeam(
            int teamId
    ) throws Exception {

        TeamsApiResponse response =
                apiFootballService.getTeam(teamId);

        if (response.getResponse() == null
                || response.getResponse().isEmpty()) {

            throw new RuntimeException(
                    "Team not found: " + teamId
            );
        }

        return response
                .getResponse()
                .get(0);
    }
}
```

## File: footballapp/src/main/java/org/footballapp/service/TeamStatisticsImportService.java
```java
package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.repository.StandingRepository;
import org.footballapp.repository.TeamStatisticsRepository;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;

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

## File: footballapp/src/main/java/org/footballapp/tools/AppConstants.java
```java
package org.footballapp.tools;

public final class AppConstants {

    private AppConstants() {
    }

    /**
     * Development League (Scottish Premiership)
     */
    public static final int DEVELOPMENT_LEAGUE = 179;

    /**
     * Development Season
     */
    public static final int DEVELOPMENT_SEASON = 2024;

    /**
     * Development Team (Rangers)
     */
    public static final int DEVELOPMENT_TEAM = 257;

    /**
     * Development Player J. Hogarth - Rangers Goalkeeper.
     */
    public static final int DEVELOPMENT_PLAYER = 162283;

    /**
     * Development Fixture
     */
    public static final long DEVELOPMENT_FIXTURE = 1220118L;

    /**
     * Development Venue (Ibrox)
     */
    public static final int DEVELOPMENT_VENUE = 1401;
}
```

## File: footballapp/src/main/java/org/footballapp/tools/development/ApiExplorerRunner.java
```java
package org.footballapp.tools.development;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.footballapp.tools.AppConstants.*;

@Component
public class ApiExplorerRunner implements CommandLineRunner {

    private static final boolean DOWNLOAD_ENABLED = false;

    private final ApiExplorerService apiExplorerService;

    public ApiExplorerRunner(
            ApiExplorerService apiExplorerService
    ) {

        this.apiExplorerService = apiExplorerService;

    }

    @Override
    public void run(
            String... args
    ) throws Exception {

        if (!DOWNLOAD_ENABLED) {
            return;
        }

//        System.out.println("========================================");
//        System.out.println("FootballApp API Explorer");
//        System.out.println("========================================");
//        System.out.println();

        // ====================================
        // Competitions
        // ====================================

        //downloadLeagues();

        // ====================================
        // League
        // ====================================

        //downloadStandings();
        //downloadFixtures();
        //apiExplorerService.downloadLeagueData(39, 2022);
        //downloadTeams();


        /**
         * Club
         */
        //printSectionHeader("Downloading Club Data");

//        apiExplorerService.downloadClubDetails();
//        apiExplorerService.downloadPlayers();
//        apiExplorerService.downloadTeamStatistics();

        //printSectionFooter("Club Data");


        /**
         * Players
         */
        //printSectionHeader("Downloading Player Data");

//        apiExplorerService.downloadPlayerDetails();
//
//        apiExplorerService.downloadPlayerStatistics();
//
//        apiExplorerService.downloadPlayerTransfers();

          //apiExplorerService.downloadPlayerData(162283, 2024);

        //printSectionFooter("Player Data download");



        // ====================================
        // Fixture
        // ====================================

        //apiExplorerService.downloadFixtureStatistics();
        //apiExplorerService.downloadFixtureData(1220118L)
        apiExplorerService.downloadFixtureLineups();

//        System.out.println();
//        System.out.println("========================================");
//        System.out.println("API Explorer Complete");
//        System.out.println("========================================");

    }

}
```

## File: footballapp/src/main/java/org/footballapp/tools/development/ApiExplorerService.java
```java
package org.footballapp.tools.development;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.springframework.stereotype.Service;
import static org.footballapp.tools.AppConstants.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApiExplorerService {

    private static final String API_BASE =
            "https://v3.football.api-sports.io/";

    private static final String OUTPUT_DIRECTORY =
            "docs/api/";

    private final ApiFootballClient client;

    private final ObjectMapper objectMapper;

    public ApiExplorerService(

            ApiFootballClient client,

            ObjectMapper objectMapper

    ) {

        this.client = client;
        this.objectMapper = objectMapper;

    }

    /********************************************************************************
     * Download Club Details
     */

    public void downloadClubDetails() throws Exception {

        downloadClubDetails(DEVELOPMENT_TEAM);

    }

    public void downloadClubDetails(int teamId) throws Exception {

        download(

                "teams",

                "id="
                        + teamId,

                "club/details/team_"
                        + teamId
                        + ".json"

        );

    }

    /**
     * Download Players
     */

    public void downloadPlayers() throws Exception {

        downloadPlayers(
                DEVELOPMENT_TEAM,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadPlayers(
            int teamId,
            int season
    ) throws Exception {

        download(

                "players",

                "team="
                        + teamId
                        + "&season="
                        + season,

                "club/players/team_"
                        + teamId
                        + "_"
                        + season
                        + ".json"

        );

    }

    /**
     * Download Team Statistics
     */

    public void downloadTeamStatistics() throws Exception {

        downloadTeamStatistics(
                DEVELOPMENT_TEAM,
                DEVELOPMENT_LEAGUE,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        download(

                "teams/statistics",

                "team="
                        + teamId
                        + "&league="
                        + leagueId
                        + "&season="
                        + season,

                "club/statistics/team_"
                        + teamId
                        + "_"
                        + leagueId
                        + "_"
                        + season
                        + ".json"

        );

    }

    /**
     * Downloads the data required
     * for club development.
     *
     * Includes:
     * - Club Details
     * - Players
     * - Team Statistics
     */

    public void downloadClubData() throws Exception {

        downloadClubData(
                DEVELOPMENT_TEAM,
                DEVELOPMENT_LEAGUE,
                DEVELOPMENT_SEASON
        );

    }


    public void downloadClubData(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        printSectionHeader("Downloading Club Data");

        downloadClubDetails(teamId);

        downloadPlayers(teamId, season);

        downloadTeamStatistics(teamId, leagueId, season);

        printSectionFooter("Club Data");

    }
    /**** End of Club Data *************************************************************




    /******* Fixtures *****************************************************************
     *
     * Downloads Fixtures for the current season
     */

    public void downloadFixtures() throws Exception {

        downloadFixtures(
                DEVELOPMENT_LEAGUE,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadFixtures(
            int leagueId,
            int season
    ) throws Exception {

        download(

                "fixtures",

                "league="
                        + leagueId
                        + "&season="
                        + season,

                "league/fixtures/league_"
                        + leagueId
                        + "_"
                        + season
                        + ".json"

        );

    }// End of Download Fixtures.


    /**
     * Downloads Fixture Events for current Fixture.
     */

    public void downloadFixtureEvents() throws Exception {

                downloadFixtureEvents(DEVELOPMENT_FIXTURE);

    }

    public void downloadFixtureEvents(
            long fixtureId
    ) throws Exception {

        download(

                "fixtures/events",

                "fixture=" + fixtureId,

                "fixture/events/fixture_"
                        + fixtureId
                        + ".json"

        );

    }// End of Fixture Events.


    /**
     * Downloads Fixture Lineups for current fixture.
     */

    public void downloadFixtureLineups() throws Exception {

        downloadFixtureLineups(DEVELOPMENT_FIXTURE);

    }

    public void downloadFixtureLineups(
            long fixtureId
    ) throws Exception {

        download(

                "fixtures/lineups",

                "fixture=" + fixtureId,

                "fixture/lineups/fixture_"
                        + fixtureId
                        + ".json"

        );

    }


    /**
     * Downloads fixture statistics for the current
     * development fixture.
     */
    public void downloadFixtureStatistics(
            long fixtureId
    ) throws Exception {

        download(

                "fixtures/statistics",

                "fixture=" + fixtureId,

                "fixture/statistics/fixture_"
                        + fixtureId
                        + ".json"

        );

    }
    /********* End of Fixtures ************************************************************




    /**
     * Downloads Standings for current League and Season.
     */

    public void downloadStandings() throws Exception {

        downloadStandings(
                DEVELOPMENT_LEAGUE,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadStandings(
            int leagueId,
            int season
    ) throws Exception {

        download(

                "standings",

                "league="
                        + leagueId
                        + "&season="
                        + season,

                "league/standings/league_"
                        + leagueId
                        + "_"
                        + season
                        + ".json"

        );

    }// End of Download Standings.


    /**
     * Downloads Teams from current League and Season.
     */

    public void downloadTeams() throws Exception {

        downloadTeams(
                DEVELOPMENT_LEAGUE,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadTeams(
            int leagueId,
            int season
    ) throws Exception {

        download(

                "teams",

                "league="
                        + leagueId
                        + "&season="
                        + season,

                "league/teams/league_"
                        + leagueId
                        + "_"
                        + season
                        + ".json"

        );

    }// End of Download Teams.

    /**
     * Downloads the core league data required
     * for league development.
     *
     * Includes:
     * - Standings
     * - Fixtures
     * - Teams
     */
    public void downloadLeagueData() throws Exception {

        downloadLeagueData(
                DEVELOPMENT_LEAGUE,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadLeagueData(
            int leagueId,
            int season
    ) throws Exception {

        printSectionHeader("Downloading League Data");

        downloadStandings(leagueId, season);

        downloadFixtures(leagueId, season);

        downloadTeams(leagueId, season);

        printSectionFooter("League Data");

    }

    /**
     * Downloads the data required for
     * fixture development.
     *
     * Includes:
     * - Fixture Events
     * - Fixture Lineups
     * - Fixture Statistics
     */

    public void downloadFixtureData() throws Exception {

        downloadFixtureData(DEVELOPMENT_FIXTURE);

    }

    public void downloadFixtureData(
            long fixtureId
    ) throws Exception {

        printSectionHeader("Downloading Fixture Data");

        downloadFixtureEvents(fixtureId);

        downloadFixtureLineups(fixtureId);

        downloadFixtureStatistics(fixtureId);

        printSectionFooter("Fixture Data");

    }// End of Download fixture Data.



    /**
     * Downloads Player Details
     */

    public void downloadPlayerDetails() throws Exception {

        downloadPlayerDetails(
                DEVELOPMENT_PLAYER,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadPlayerDetails(
            int playerId,
            int season
    ) throws Exception {

        download(

                "players",

                "id="
                        + playerId
                        + "&season="
                        + season,

                "player/details/player_"
                        + playerId
                        + "_"
                        + season
                        + ".json"

        );

    }

    /**
     * Downloads Player Statistics
     */

    public void downloadPlayerStatistics() throws Exception {

        downloadPlayerStatistics(
                DEVELOPMENT_PLAYER,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadPlayerStatistics(
            int playerId,
            int season
    ) throws Exception {

        download(

                "players",

                "id="
                        + playerId
                        + "&season="
                        + season,

                "player/statistics/player_"
                        + playerId
                        + "_"
                        + season
                        + ".json"

        );

    }

    /**
     * Downloads Player Transfers.
     */

    public void downloadPlayerTransfers() throws Exception {

        downloadPlayerTransfers(DEVELOPMENT_PLAYER);

    }

    public void downloadPlayerTransfers(
            int playerId
    ) throws Exception {

        download(

                "transfers",

                "player=" + playerId,

                "player/transfers/player_"
                        + playerId
                        + ".json"

        );

    }

    /**
     * Downloads the data for Player development
     * Includes:
     * Player Details
     * Player Statistics
     * Player Transfers*/

    public void downloadPlayerData() throws Exception {

        downloadPlayerData(
                DEVELOPMENT_PLAYER,
                DEVELOPMENT_SEASON
        );

    }

    public void downloadPlayerData(
            int playerId,
            int season
    ) throws Exception {

        printSectionHeader("Downloading Player Data");

        downloadPlayerDetails(playerId, season);

        downloadPlayerStatistics(playerId, season);

        downloadPlayerTransfers(playerId);

        printSectionFooter("Player Data");

    }



    /*********************************************************************************************

    /**
     * Downloads an API-Football endpoint and saves
     * the formatted JSON and request information.
     */
    public void download(

            String endpoint,

            String query,

            String outputFile

    ) throws Exception {

        String url =
                API_BASE + endpoint;

        if (query != null &&
                !query.isBlank()) {

            url += "?" + query;

        }

        String json =
                client.get(url);

        saveJson(

                json,

                outputFile

        );

        saveRequest(

                url,

                outputFile

        );

    }

    /**
     * Pretty-prints JSON and writes it to disk.
     */
    private void saveJson(

            String json,

            String outputFile

    ) throws Exception {

        Object parsed =
                objectMapper.readValue(

                        json,

                        Object.class

                );

        File file =
                new File(

                        OUTPUT_DIRECTORY,

                        outputFile

                );

        File parent =
                file.getParentFile();

        if (parent != null) {

            parent.mkdirs();

        }

        objectMapper

                .writerWithDefaultPrettyPrinter()

                .writeValue(

                        file,

                        parsed

                );

    }

    /**
     * Saves the request URL used to generate
     * the JSON response.
     */
    private void saveRequest(

            String url,

            String outputFile

    ) throws Exception {

        Path jsonPath =
                Path.of(

                        OUTPUT_DIRECTORY,

                        outputFile

                );

        String fileName =
                jsonPath.getFileName()
                        .toString();

        String requestFileName =
                fileName.replace(

                        ".json",

                        "_request.txt"

                );

        Path requestPath =
                jsonPath.resolveSibling(

                        requestFileName

                );

        Files.createDirectories(

                requestPath.getParent()

        );

        Files.writeString(

                requestPath,

                "GET\n\n" + url

        );

    }

    /***** HELPERS*****/

    private void printSectionHeader(String title) {

        System.out.println();
        System.out.println("========================================");
        System.out.println(title);
        System.out.println("========================================");

    }

    private void printSectionFooter(String title) {

        System.out.println();
        System.out.println("========================================");
        System.out.println(title + " Complete");
        System.out.println("========================================");

    }

}
```

## File: footballapp/src/main/java/org/footballapp/tools/FixtureStatisticImportRunner.java
```java
package org.footballapp.tools;

import org.footballapp.service.importer.FixtureStatisticImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FixtureStatisticImportRunner
        implements CommandLineRunner {

    private static final boolean IMPORT_ENABLED = false;

    private static final long FIXTURE_ID = 1220118L;

    /**
     * Change this to the home or away team
     * participating in the fixture.
     */
    private static final int TEAM_ID = 257;

    private final FixtureStatisticImportService
            fixtureStatisticImportService;

    public FixtureStatisticImportRunner(

            FixtureStatisticImportService
                    fixtureStatisticImportService

    ) {

        this.fixtureStatisticImportService =
                fixtureStatisticImportService;

    }

    @Override
    public void run(
            String... args
    ) throws Exception {

        if (!IMPORT_ENABLED) {
            return;
        }

        System.out.println(
                "========================================"
        );
        System.out.println(
                "Importing Fixture Statistics"
        );
        System.out.println(
                "========================================"
        );
        System.out.println();

        System.out.println(
                "Fixture ID: "
                        + FIXTURE_ID
        );

        System.out.println(
                "Team ID: "
                        + TEAM_ID
        );

        fixtureStatisticImportService
                .importFixtureStatistics(

                        FIXTURE_ID,

                        TEAM_ID

                );

        System.out.println();

        System.out.println(
                "========================================"
        );
        System.out.println(
                "Fixture Statistics Import Complete"
        );
        System.out.println(
                "========================================"
        );

    }

}
```

## File: footballapp/src/main/java/org/footballapp/tools/ImportRunner.java
```java
package org.footballapp.tools;

import org.footballapp.service.importer.FixtureLineupImportService;
import org.footballapp.service.importer.FixtureEventImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import static org.footballapp.tools.AppConstants.DEVELOPMENT_LEAGUE;
//import static org.footballapp.tools.AppConstants.DEVELOPMENT_SEASON;

@Component
public class ImportRunner implements CommandLineRunner {

    private static final boolean IMPORT_ENABLED = false;

    private static final long FIXTURE_ID = 1220118L;

    //private final FixtureLineupImportService fixtureLineupImportService;

    private final FixtureEventImportService fixtureEventImportService;

    public ImportRunner(

            //FixtureLineupImportService fixtureLineupImportService,

            FixtureEventImportService fixtureEventImportService
    ) {

//        this.fixtureLineupImportService =
//                fixtureLineupImportService;

        this.fixtureEventImportService =
                fixtureEventImportService;

    }

    @Override
    public void run(
            String... args
    ) throws Exception {

        if (!IMPORT_ENABLED) {
            return;
        }

        System.out.println("========================================");
        System.out.println("Importing Fixture Events");
        System.out.println("========================================");
        System.out.println();

        System.out.println(
                "Fixture ID: "
                        + FIXTURE_ID
        );

        fixtureEventImportService.replaceFixtureEvents(
                FIXTURE_ID
        );

        System.out.println();

        System.out.println("========================================");
        System.out.println("Fixture Events Import Complete");
        System.out.println("========================================");

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
