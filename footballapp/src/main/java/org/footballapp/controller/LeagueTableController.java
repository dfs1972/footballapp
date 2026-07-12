package org.footballapp.controller;

import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST endpoints for league standings.
 */
@RestController
public class LeagueTableController {

    private final LeagueDataService
            leagueDataService;

    public LeagueTableController(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    /**
     * Returns the league table for a competition.
     */
    @GetMapping("/leagueTable")
    public List<LeagueTableRow> getLeagueTable(

            @RequestParam int leagueId,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getLeagueTable(
                leagueId,
                season
        );

    }

}