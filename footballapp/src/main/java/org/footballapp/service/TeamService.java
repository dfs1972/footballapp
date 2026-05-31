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
     * Retrieves all teams associated with the Scottish Premiership
     * for season 2024 and maps the JSON response to
     * TeamsApiResponse.
     */
    public TeamsApiResponse getScottishPremiershipTeams() throws Exception {

        String url = "https://v3.football.api-sports.io//teams?league=179&season=2024";

        String json = apiClient.get(url);

        return mapper.readValue(json, TeamsApiResponse.class);
    }

    // retrieves team by id and sends data to TeamResponse.
    public TeamResponse getTeamById(int teamId) throws Exception {

        TeamsApiResponse response =
                getScottishPremiershipTeams();

        for (TeamResponse teamResponse : response.getResponse()) {

            if (teamResponse.getTeam().getId() == teamId) {
                return teamResponse;
            }
        }

        return null;
    }
}