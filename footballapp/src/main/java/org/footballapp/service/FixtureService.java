package org.footballapp.service;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.fixtures.FixturesApiResponse;

@Service
public class FixtureService {

    private final FootballDataProvider footballDataProvider;

    public FixtureService(
            FootballDataProvider footballDataProvider
    ) {
        this.footballDataProvider = footballDataProvider;
    }

    /**
     * Returns all the Fixtures for that league & season
     */

    public FixturesApiResponse getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        return footballDataProvider.getFixtures(
                leagueId,
                season
        );
    }

    /**
     * Returns the team's last 5 fixtures
     */

    public FixturesApiResponse getTeamFixtures(
            int teamId,
            int last
    ) throws Exception {

        return footballDataProvider.getTeamFixtures(
                teamId,
                last
        );
    }
}
