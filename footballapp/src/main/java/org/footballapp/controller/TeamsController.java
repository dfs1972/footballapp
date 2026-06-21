package org.footballapp.controller;

import org.footballapp.config.AppConfig;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsController {

    private final LeagueDataService
            leagueDataService;

    public TeamsController() {

        AppConfig config =
                new AppConfig();

        leagueDataService =
                config.getLeagueDataService();
    }

    @GetMapping("/teams")
    public Object getTeamsForleague(
            @RequestParam int leagueId,
            @RequestParam int season
    ) throws Exception {

        return leagueDataService.getTeamsForLeague(
                leagueId,
                season
        );
    }
}