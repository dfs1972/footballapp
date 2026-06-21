package org.footballapp.controller;

import org.footballapp.config.AppConfig;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FixturesController {

    private final LeagueDataService
            leagueDataService;

    public FixturesController() {

        AppConfig config =
                new AppConfig();

        leagueDataService =
                config.getLeagueDataService();
    }

    @GetMapping("/fixtures")
    public List<FixtureRow> getFixtures(
            @RequestParam int leagueId,
            @RequestParam int season
    ) throws Exception {

        return leagueDataService
                .getLeagueFixtures(
                        leagueId,
                        season
                );
    }
}