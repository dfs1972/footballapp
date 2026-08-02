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
import org.footballapp.service.FootballDataProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("live")
public class ApiFootballService implements FootballDataProvider {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;

    public ApiFootballService(
            ApiFootballClient apiClient,
            ObjectMapper mapper
    )
    {
        this.apiClient = apiClient;
        this.mapper = mapper;

    }


    /**************************************************+************************************************

     LEAGUES SECTION

     *************************************************************************************************
     */

    /**
     * Get league details
     */

    @Override
    public LeaguesApiResponse getLeague(
            int leagueId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues?id="
                        + leagueId;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                LeaguesApiResponse.class
        );
    }

    /**
     * gets league standings from a specified season
     */
    @Override
    public StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/standings?league="
                        + leagueId
                        + "&season="
                        + season;

        System.out.println(url);

        String json = apiClient.get(url);

        System.out.println(json);

        return mapper.readValue(
                json,
                StandingsApiResponse.class
        );
    }


    /**************************************************+************************************************

     TEAMS SECTION

     *************************************************************************************************
     */


    /**
     * Get Teams from a league & season
     */

    @Override
    public TeamsApiResponse getTeams(
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

    @Override
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
     * Gets team statistics for a league and season.
     */

    @Override
    public TeamStatisticsApiResponse getTeamStatistics(
            int teamId,
            int leagueId,
            int season
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


    /**************************************************+************************************************

     PLAYERS SECTION

     *************************************************************************************************
     */


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

    @Override
    public PlayersApiResponse getTeamPlayers(
            int teamId,
            int season
    ) throws Exception {

        return getTeamPlayers(
                teamId,
                season
        );
    }

    @Override
    public PlayersApiResponse getPlayer(
            int playerId,
            int season
    ) {
        throw new UnsupportedOperationException(
                "getPlayer() not implemented yet."
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


    /**************************************************************************************************

      FIXTURES SECTION

      *************************************************************************************************
     */


    /**
     * Gets all fixtures from a league in specified season
     */


    @Override
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

    @Override
    public FixturesApiResponse getFixture(
            long fixtureId
    ) {
        throw new UnsupportedOperationException(
                "getFixture() not implemented yet."
        );
    }

    /**
     * Get a team's fixtures
     */

    @Override
    public FixturesApiResponse getTeamFixtures(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures?team="
                        + teamId
                        + "&league="
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
    /**
     * Get team's last N fixtures
     */

    @Override
    public FixturesApiResponse getRecentTeamFixtures(
            int teamId,
            int last
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures?team="
                        + teamId
                        + "&last="
                        + last;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                FixturesApiResponse.class
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

