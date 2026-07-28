package org.footballapp.service.snapshot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.util.MockApiPaths;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.footballapp.service.json.JsonLoader;
import org.footballapp.service.snapshot.SnapshotLoader;

@Service
public class JsonSnapshotService {

    private static final String API_BASE =
            "https://v3.football.api-sports.io/";

    private static final String OUTPUT_DIRECTORY =
            "mockapi/";

    private final ApiFootballClient apiFootballClient;
    private final ObjectMapper objectMapper;
    private final JsonLoader jsonLoader;
    private final SnapshotLoader snapshotLoader;



    public JsonSnapshotService(
            ApiFootballClient apiFootballClient,
            ObjectMapper objectMapper,
            JsonLoader jsonLoader,
            SnapshotLoader snapshotLoader
    ) {

        this.apiFootballClient =
                apiFootballClient;

        this.objectMapper =
                objectMapper;

        this.jsonLoader =
                jsonLoader;

        this.snapshotLoader =
                snapshotLoader;
    }


    /** ******************************
     *  SAVE SECTION
     *  ******************************
     */

    private void save(
            String endpoint,
            String outputFile
    ) throws Exception {

        String url =
                API_BASE + endpoint;

        String json =
                apiFootballClient.get(url);

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

        System.out.println(
                "Saved " + file.getPath()
        );

        System.out.printf(
                "Snapshot created: %s%n",
                file.getPath()
        );
    }

    /**
     * Save League
     */

    public void saveLeague(
            int leagueId
    ) throws Exception {

        save(
                "leagues?id=" + leagueId,
                MockApiPaths.league(leagueId)
        );
    }

    /**
     * Save Standings
     */

    public void saveStandings(
            int leagueId,
            int season
    ) throws Exception {

        save(
                "standings?league=" + leagueId
                        + "&season=" + season,
                MockApiPaths.standings(
                        leagueId,
                        season
                )
        );
    }

    /**
     * Save Teams
     */

    public void saveTeams(
            int leagueId,
            int season
    ) throws Exception {

        save(
                "teams?league=" + leagueId
                        + "&season=" + season,
                MockApiPaths.teams(
                        leagueId,
                        season
                )
        );
    }

    /**
     * Save Team
     */

    public void saveTeam(
            int teamId
    ) throws Exception {

        save(
                "teams?id=" + teamId,
                MockApiPaths.team(teamId)
        );
    }

    /**
     * Save Fixtures
     */

    public void saveFixtures(
            int leagueId,
            int season
    ) throws Exception {

        save(
                "fixtures?league=" + leagueId
                        + "&season=" + season,
                MockApiPaths.fixtures(
                        leagueId,
                        season
                )
        );
    }

    /**
     * Save Fixture
     */

    public void saveFixture(
            long fixtureId
    ) throws Exception {

        save(
                "fixtures?id=" + fixtureId,
                MockApiPaths.fixture(fixtureId)
        );
    }

    /**
     * Save Team Fixture
     */

    public void saveTeamFixtures(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        save(
                "fixtures?team=" + teamId
                        + "&league=" + leagueId
                        + "&season=" + season,
                MockApiPaths.teamFixtures(
                        teamId,
                        leagueId,
                        season
                )
        );
    }

    /**
     * Save Fixture Events
     */
    public void saveFixtureEvents(
            long fixtureId
    ) throws Exception {

        save(
                "fixtures/events?fixture=" + fixtureId,
                MockApiPaths.fixtureEvents(fixtureId)
        );
    }

    /**
     * Save Fixture Lineups
     */
    public void saveFixtureLineups(
            long fixtureId
    ) throws Exception {

        save(
                "fixtures/lineups?fixture=" + fixtureId,
                MockApiPaths.fixtureLineups(fixtureId)
        );
    }

    /**
     * Save Fixture Statistics
     */
    public void saveFixtureStatistics(
            long fixtureId
    ) throws Exception {

        save(
                "fixtures/statistics?fixture=" + fixtureId,
                MockApiPaths.fixtureStatistics(fixtureId)
        );
    }

    /**
     * Save Players
     */

    public void savePlayers(
            int teamId,
            int season
    ) throws Exception {

        save(
                "players?team=" + teamId
                        + "&season=" + season,
                MockApiPaths.players(teamId, season)
        );
    }

    /**
     * Save Player
     */

    public void savePlayer(
            int playerId,
            int season
    ) throws Exception {

        save(
                "players?id=" + playerId
                        + "&season=" + season,
                MockApiPaths.players(playerId, season)
        );
    }

    /**
     * Save Statistics
     */

    public void saveStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        save(
                "teams/statistics?team=" + teamId
                        + "&league=" + leagueId
                        + "&season=" + season,
                MockApiPaths.statistics(teamId, leagueId, season)
        );
    }

    /**
     * Generates a complete league snapshot package.
     *
     * This downloads all league-level resources required
     * for offline development.
     */
    public void saveLeaguePackage(
            int leagueId,
            int season
    ) throws Exception {

        saveLeague(
                leagueId
        );

        saveStandings(
                leagueId,
                season
        );

        saveTeams(
                leagueId,
                season
        );

        saveFixtures(
                leagueId,
                season
        );

        List<Integer> teamIds =
                getTeamIds(
                        leagueId,
                        season
                );

        for (int teamId : teamIds) {

            saveTeam(teamId);

        }

    }

    /**
     * Save Team Package
     */

    public void saveTeamPackage(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        saveTeam(teamId);

        savePlayers(
                teamId,
                season
        );

        saveTeamFixtures(
                teamId,
                leagueId,
                season
        );

        saveStatistics(
                teamId,
                leagueId,
                season
        );
    }

    /**
     * Save Fixture Package
     */
    public void saveFixturePackage(
            long fixtureId
    ) throws Exception {

        saveFixture(fixtureId);

        saveFixtureEvents(fixtureId);

        saveFixtureLineups(fixtureId);

        saveFixtureStatistics(fixtureId);
    }


    /**
     * Get Team IDs
     */

    private List<Integer> getTeamIds(
            int leagueId,
            int season
    ) throws IOException {

        TeamsApiResponse teams =
                snapshotLoader.load(
                        MockApiPaths.teams(
                                leagueId,
                                season
                        ),
                        TeamsApiResponse.class
                );

        return teams.getResponse()
                .stream()
                .map(team ->
                        team.getTeam().getId()
                )
                .toList();
    }

}























