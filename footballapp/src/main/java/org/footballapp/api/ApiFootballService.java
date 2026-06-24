package org.footballapp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
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
}

