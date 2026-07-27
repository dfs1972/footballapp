package org.footballapp.controller;

import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.service.FootballDataProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportedCompetitionsController {

    private final FootballDataProvider footballDataProvider;

    public SupportedCompetitionsController(
            FootballDataProvider footballDataProvider
    ) {
        this.footballDataProvider = footballDataProvider;
    }

    @GetMapping("/league/{leagueId}")
    public LeaguesApiResponse getLeague(
            @PathVariable int leagueId
    ) throws Exception {

        return footballDataProvider.getLeague(
                leagueId
        );
    }
}