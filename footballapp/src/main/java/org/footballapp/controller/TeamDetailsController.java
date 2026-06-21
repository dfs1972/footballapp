package org.footballapp.controller;

import org.footballapp.config.AppConfig;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamDetailsController {

    private final LeagueDataService
            leagueDataService;

    public TeamDetailsController() {

        AppConfig config =
                new AppConfig();

        leagueDataService =
                config.getLeagueDataService();
    }

    @GetMapping("/teamDetails")
    public Object getTeamDetails(
            @RequestParam int leagueId,
            @RequestParam int season,
            @RequestParam int teamId
    ) throws Exception {

        return leagueDataService.getTeamDetails(
                leagueId,
                season,
                teamId
        );
    }
}