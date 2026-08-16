package org.footballapp.service;

import org.footballapp.model.standings.Standing;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.standings.StandingsApiResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class StandingService {

    private final FootballDataProvider footballDataProvider;

    public StandingService(
            FootballDataProvider footballDataProvider
    ) {
        this.footballDataProvider = footballDataProvider;
    }

    public StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception {

        return footballDataProvider.getStandings(
                leagueId,
                season
        );
    }

    /**
     * Returns the standings as a single league table.
     *
     * Normal leagues:
     *   Group 0
     *
     * Scottish Premiership:
     *   Group 0 = Phase 1
     *   Group 1 = Championship Group
     *   Group 2 = Relegation Group
     */
    public List<Standing> getLeagueStandings(
            int leagueId,
            int season
    ) throws Exception {

        StandingsApiResponse response =
                getStandings(
                        leagueId,
                        season
                );

        if (response.getResponse() == null
                || response.getResponse().isEmpty()) {

            return List.of();
        }

        List<List<Standing>> groups =
                response.getResponse()
                        .getFirst()
                        .getLeague()
                        .getStandings();

        if (groups == null
                || groups.isEmpty()) {

            return List.of();
        }

        /*
         * Normal single-table competition.
         */
        if (groups.size() == 1) {

            return groups.getFirst();

        }

        /*
         * This method is retained for callers that still expect
         * a flat List<Standing>.
         *
         * Presentation-specific handling of groups belongs in
         * LeagueDataService.getLeagueTable().
         */
        List<Standing> merged =
                new ArrayList<>();

        for (List<Standing> group : groups) {

            if (group != null) {

                merged.addAll(group);

            }
        }

        return merged;
    }

    public List<List<Standing>> getLeagueStandingGroups(
            int leagueId,
            int season
    ) throws Exception {

        StandingsApiResponse response =
                getStandings(
                        leagueId,
                        season
                );

        if (response.getResponse() == null
                || response.getResponse().isEmpty()) {

            return List.of();
        }

        List<List<Standing>> groups =
                response.getResponse()
                        .getFirst()
                        .getLeague()
                        .getStandings();

        if (groups == null
                || groups.isEmpty()) {

            return List.of();
        }

        return groups;
    }
}