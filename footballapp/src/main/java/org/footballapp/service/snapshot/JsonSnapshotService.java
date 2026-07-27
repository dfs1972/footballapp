package org.footballapp.service.snapshot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.util.MockApiPaths;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class JsonSnapshotService {

    private static final String API_BASE =
            "https://v3.football.api-sports.io/";

    private static final String OUTPUT_DIRECTORY =
            "mockapi/";

    private final ApiFootballClient apiFootballClient;
    private final ObjectMapper objectMapper;

    public JsonSnapshotService(
            ApiFootballClient apiFootballClient,
            ObjectMapper objectMapper
    ) {

        this.apiFootballClient =
                apiFootballClient;

        this.objectMapper =
                objectMapper;
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
                MockApiPaths.standings(
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
                MockApiPaths.standings(
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
            int last
    ) throws Exception {

        save(
                "fixtures?team=" + teamId
                        + "&last=" + last,
                MockApiPaths.teamFixtures(teamId, last)
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

}























