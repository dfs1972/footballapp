package org.footballapp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.coaches.CoachApiResponse;
import org.footballapp.model.country.CountriesApiResponse;
import org.footballapp.model.fixtures.FixtureRoundsApiResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.model.squad.SquadApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
//import org.footballapp.api.dto.events.FixtureEventsResponse;
import org.footballapp.api.dto.fixtures.FixtureStatisticsResponse;
import org.footballapp.service.FootballDataProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@Profile("live")
public class ApiFootballService implements FootballDataProvider {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;

    public ApiFootballService(
            ApiFootballClient apiClient,
            ObjectMapper mapper
    ) {
        this.apiClient = apiClient;
        this.mapper = mapper;

    }


    /********** Countries ******************/

    @Override
    public CountriesApiResponse getCountries()
            throws Exception {

        String url =
                "https://v3.football.api-sports.io/countries";

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                CountriesApiResponse.class
        );
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
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues?id="
                        + leagueId
                        + "&season="
                        + season;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                LeaguesApiResponse.class
        );
    }

    /**
     * Get Leagues Details
     */

    @Override
    public LeaguesApiResponse getLeagues(
            String country,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues?country="
                        + URLEncoder.encode(
                        country,
                        StandardCharsets.UTF_8
                )
                        + "&season="
                        + season;

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
     * Get Teams & Coaches from a league & season
     */

    @Override
    public CoachApiResponse getCoach(
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/coachs?team="
                        + teamId;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                CoachApiResponse.class
        );

    }

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
    public SquadApiResponse getTeamSquad(
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players/squads?team="
                        + teamId;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                SquadApiResponse.class
        );
    }

    @Override
    public PlayersApiResponse getTeamPlayers(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        String json =
                getPlayersJson(
                        teamId,
                        season
                );

        return mapper.readValue(
                json,
                PlayersApiResponse.class
        );
    }

    @Override
    public PlayersApiResponse getPlayer(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        String json =
                getPlayerJson(
                        playerId,
                        leagueId,
                        season
                );

        return mapper.readValue(
                json,
                PlayersApiResponse.class
        );
    }

    @Override
    public PlayersApiResponse getPlayer(
            int playerId,
            int season
    ) throws Exception {

        String json =
                getPlayerJson(
                        playerId,
                        season
                );

        return mapper.readValue(
                json,
                PlayersApiResponse.class
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

    public String getPlayerJson(
            int playerId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?id="
                        + playerId
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
    public FixtureRoundsApiResponse getFixtureRounds(
            int leagueId,
            int season,
            boolean current
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures/rounds"
                        + "?league=" + leagueId
                        + "&season=" + season
                        + "&current=" + current;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                FixtureRoundsApiResponse.class
        );
    }


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
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures?id="
                        + fixtureId;

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                FixturesApiResponse.class
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
}

