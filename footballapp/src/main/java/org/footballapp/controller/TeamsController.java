package org.footballapp.controller;

import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoints for league teams.
 */
@RestController
public class TeamsController {

    private final LeagueDataService
            leagueDataService;

    public TeamsController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/teams")
    public Object getTeamsForLeague(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getTeamsForLeague(
                leagueId,
                season
        );

    }

}