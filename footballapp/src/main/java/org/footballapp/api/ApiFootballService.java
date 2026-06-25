package org.footballapp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;

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
}

