package org.footballapp.controller;

import org.footballapp.config.AppConfig;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaguesController {

    private final LeagueDataService
            leagueDataService;

    public LeaguesController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/leagues")
    public Object getEnabledLeagues()
            throws Exception {

        return leagueDataService
                .getEnabledLeagues();
    }
}