package org.footballapp.controller;

import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Returns data from a single fixture.
 */
@RestController
public class FixtureDetailsController {

    private final LeagueDataService
            leagueDataService;

    public FixtureDetailsController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    @GetMapping("/fixture")
    public Object getFixture(

            @RequestParam long fixtureId

    ) throws Exception {

        return leagueDataService.getFixtureDetails(
                fixtureId
        );

    }

}