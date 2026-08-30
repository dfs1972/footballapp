package org.footballapp.controller;

import org.footballapp.api.dto.fixtures.MatchDetailDto;
import org.footballapp.service.LeagueDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    private final LeagueDataService leagueDataService;

    public MatchController(LeagueDataService leagueDataService) {
        this.leagueDataService = leagueDataService;
    }

    @GetMapping("/matchDetails")
    public MatchDetailDto getMatchDetails(
            @RequestParam long fixtureId
    ) throws Exception {
        return leagueDataService.getMatchDetails(fixtureId);
    }
}
