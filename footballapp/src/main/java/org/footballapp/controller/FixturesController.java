package org.footballapp.controller;

import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoints for league fixtures.
 */
@RestController
public class FixturesController {

    private final LeagueDataService
            leagueDataService;

    public FixturesController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    /**
     * Returns all fixtures for a league and season.
     */
    @GetMapping("/fixtures")
    public List<FixtureRow> getFixtures(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getFixtures(
                leagueId,
                season
        );

    }

}