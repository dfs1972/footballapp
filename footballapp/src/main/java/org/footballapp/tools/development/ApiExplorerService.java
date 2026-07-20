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