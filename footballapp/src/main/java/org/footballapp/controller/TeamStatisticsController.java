package org.footballapp.controller;

import org.footballapp.config.AppConfig;
import org.footballapp.model.teamstatistics.TeamStatistics;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for team statistics.
 */
@RestController
public class TeamStatisticsController {

    private final LeagueDataService leagueDataService;

    public TeamStatisticsController() {

        AppConfig config =
                new AppConfig();

        leagueDataService =
                config.getLeagueDataService();
    }

    /**
     * Returns statistics for a team.
     */
    @GetMapping(
            "/api/teams/{teamId}/statistics"
    )
    public TeamStatistics getTeamStatistics(

            @PathVariable
            int teamId,

            @RequestParam
            int leagueId,

            @RequestParam
            int season

    ) throws Exception {

        return leagueDataService
                .getTeamStatistics(

                        teamId,

                        leagueId,

                        season
                );
    }
}