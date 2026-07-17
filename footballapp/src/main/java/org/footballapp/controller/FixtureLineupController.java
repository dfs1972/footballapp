package org.footballapp.controller;

import org.footballapp.api.response.lineups.FixtureLineupResponse;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FixtureLineupController {

    private final LeagueDataService leagueDataService;

    public FixtureLineupController(
            LeagueDataService leagueDataService
    ) {

        this.leagueDataService =
                leagueDataService;

    }

    @GetMapping("/fixtureLineup")
    public FixtureLineupResponse getFixtureLineup(

            @RequestParam long fixtureId

    ) throws Exception {

        return leagueDataService.getFixtureLineupResponse(
                fixtureId
        );

    }

}