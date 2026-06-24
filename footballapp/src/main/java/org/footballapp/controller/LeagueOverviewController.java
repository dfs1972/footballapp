package org.footballapp.controller;

import org.footballapp.config.AppConfig;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeagueOverviewController {

    private final LeagueDataService
            leagueDataService;

    public LeagueOverviewController() {

        AppConfig config =
                new AppConfig();

        leagueDataService =
                config.getLeagueDataService();
    }

    @GetMapping("/leagueOverview")
    public Object getLeagueOverview(
            @RequestParam int leagueId,
            @RequestParam int season
    ) throws Exception {

        return leagueDataService
                .getLeagueOverview(
                        leagueId,
                        season
                );
    }
}