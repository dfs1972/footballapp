package org.footballapp.service;

import org.footballapp.model.standings.Standing;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.standings.StandingsApiResponse;

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

        System.out.println("Responses = " + response.getResponse().size());

        if (response.getResponse() == null
                || response.getResponse().isEmpty()) {
            return List.of();
        }

        List<List<Standing>> groups =
                response.getResponse()
                        .getFirst()
                        .getLeague()
                        .getStandings();

        System.out.println("Groups = " + groups.size());

        if (groups == null || groups.isEmpty()) {
            return List.of();
        }

        // Normal league
        if (groups.size() == 1) {
            System.out.println("Returning normal league: " + groups.getFirst().size());
            return groups.getFirst();
        }

        // Scottish Premiership split
        if (groups.size() == 3) {

            List<Standing> merged =
                    new java.util.ArrayList<>();

            int rank = 1;

            for (Standing standing : groups.get(1)) {
                standing.setRank(rank++);
                merged.add(standing);
            }

            for (Standing standing : groups.get(2)) {
                standing.setRank(rank++);
                merged.add(standing);
            }
            System.out.println("Returning Scottish merged: " + merged.size());
            return merged;
        }

        // Fallback
        List<Standing> merged =
                new java.util.ArrayList<>();

        for (List<Standing> group : groups) {
            merged.addAll(group);
        }
        System.out.println("Returning fallback: " + merged.size());
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