package org.footballapp.service;

import org.footballapp.api.ApiFootballService;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final FootballDataProvider footballDataProvider;

    public TeamService(
            FootballDataProvider footballDataProvider
    ) {
        this.footballDataProvider = footballDataProvider;
    }

    /**
     * Retrieves a single team from API-Football.
     */
    public TeamResponse getTeam(
            int teamId
    ) throws Exception {

        TeamsApiResponse response =
                footballDataProvider.getTeam(teamId);

        if (response.getResponse() == null
                || response.getResponse().isEmpty()) {

            throw new RuntimeException(
                    "Team not found: " + teamId
            );
        }

        return response
                .getResponse()
                .get(0);
    }
}