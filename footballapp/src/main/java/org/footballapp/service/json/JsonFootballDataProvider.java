package org.footballapp.service.json;

import org.footballapp.config.AppConfig;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.service.FootballDataProvider;
import org.footballapp.service.json.JsonLoader;
import org.footballapp.util.MockApiPaths;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("json")
public class JsonFootballDataProvider implements FootballDataProvider {

    private final JsonLoader jsonLoader;

    public JsonFootballDataProvider(JsonLoader jsonLoader) {
        this.jsonLoader = jsonLoader;
    }

    @Override
    public StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.standings(
                        leagueId,
                        season
                ),
                StandingsApiResponse.class
        );
    }

    /**
     * League Section
     */

    @Override
    public LeaguesApiResponse getLeague(
            int leagueId
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.league(
                        leagueId
                ),
                LeaguesApiResponse.class
        );

    }


    /**
     ********* TEAMS SECTION *********
     */

    @Override
    public TeamsApiResponse getTeams(
            int leagueId,
            int season
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.teams(
                        leagueId,
                        season
                ),
                TeamsApiResponse.class
        );
    }

    @Override
    public TeamsApiResponse getTeam(
            int teamId
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.team(
                        teamId
                ),
                TeamsApiResponse.class
        );
    }

    @Override
    public TeamStatisticsApiResponse getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.teamStatistics(
                        teamId,
                        leagueId,
                        season
                ),
                TeamStatisticsApiResponse.class
        );
    }

    /**
     ********* FIXTURES SECTION *********
     */

    @Override
    public FixturesApiResponse getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.fixtures(
                        leagueId,
                        season
                ),
                FixturesApiResponse.class
        );
    }

    @Override
    public FixturesApiResponse getFixture(
            long fixtureId
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.fixture(
                        fixtureId
                ),
                FixturesApiResponse.class
        );
    }

    @Override
    public FixturesApiResponse getTeamFixtures(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.teamFixtures(
                        teamId,
                        leagueId,
                        season
                ),
                FixturesApiResponse.class
        );
    }

    @Override
    public FixturesApiResponse getRecentTeamFixtures(
            int teamId,
            int last
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.teamFixtures(
                        teamId,
                        AppConfig.DEVELOPMENT_LEAGUE,
                        AppConfig.DEVELOPMENT_SEASON
                ),
                FixturesApiResponse.class
        );
    }


    /**
     ********* PLAYERS SECTION ********
     */

    @Override
    public PlayersApiResponse getTeamPlayers(
            int leagueId,
            int teamId,
            int season
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.teamPlayers(
                        leagueId,
                        teamId,
                        season
                ),
                PlayersApiResponse.class
        );
    }

    @Override
    public PlayersApiResponse getPlayer(
            int playerId,
            int season
    ) throws Exception {

        return jsonLoader.load(
                MockApiPaths.player(
                        playerId,
                        season
                ),
                PlayersApiResponse.class
        );
    }
}