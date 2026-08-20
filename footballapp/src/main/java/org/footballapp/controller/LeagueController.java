package org.footballapp.controller;

import org.footballapp.config.competitions.SupportedCompetitionGroup;
import org.footballapp.model.league.LeagueApiResponse;
import org.footballapp.service.LeagueDataService;
import org.footballapp.service.SupportedCompetitionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeagueController {

    private final SupportedCompetitionsService
            supportedCompetitionsService;

    private final LeagueDataService leagueDataService;


    public LeagueController(
            SupportedCompetitionsService supportedCompetitionsService,
            LeagueDataService leagueDataService
    ) {
        this.supportedCompetitionsService =
                supportedCompetitionsService;
        this.leagueDataService = leagueDataService;

    }

    @GetMapping("/leagues")
    public List<SupportedCompetitionGroup> getLeagues() {

        return supportedCompetitionsService.getCompetitionGroups();
    }

    @GetMapping("/leagues/by-country")
    public List<LeagueApiResponse> getLeaguesByCountry(

            @RequestParam String country,

            @RequestParam int season

    ) throws Exception {

        return leagueDataService.getLeagues(
                country,
                season
        );
    }
}