package org.footballapp.controller;

import org.footballapp.config.competitions.SupportedCompetitionGroup;
import org.footballapp.service.SupportedCompetitionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeagueController {

    private final SupportedCompetitionsService
            supportedCompetitionsService;

    public LeagueController(
            SupportedCompetitionsService supportedCompetitionsService
    ) {
        this.supportedCompetitionsService =
                supportedCompetitionsService;
    }

    @GetMapping("/leagues")
    public List<SupportedCompetitionGroup> getLeagues() {

        return supportedCompetitionsService.getCompetitionGroups();
    }
}