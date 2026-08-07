package org.footballapp.controller;

import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoints for a team's fixtures.
 */
@RestController
public class TeamFixturesController {

    private final LeagueDataService leagueDataService;

    public TeamFixturesController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService = leagueDataService;
    }

    @GetMapping("/teamFixtures")
    public List<FixtureRow> getTeamFixtures(

            @RequestParam int teamId,

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getTeamFixtures(
                teamId,
                leagueId,
                season
        );

    }

}