package org.footballapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;

/**
 * Retrieves team data from API-Football and converts
 * JSON responses into Java objects using Jackson.
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
                "https://v3.football.api-sports.io/standings?league="
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