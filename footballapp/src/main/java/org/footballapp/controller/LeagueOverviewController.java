package org.footballapp.controller;

import org.footballapp.model.league.LeagueOverview;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for league overview information.
 */
@RestController
public class LeagueOverviewController {

    private final LeagueDataService
            leagueDataService;

    public LeagueOverviewController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    /**
     * Returns overview information for a league.
     */
    @GetMapping("/leagueOverview")
    public LeagueOverview getLeagueOverview(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getLeagueOverview(
                leagueId,
                season
        );

    }

}