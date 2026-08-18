package org.footballapp.controller;

import org.footballapp.model.fixtures.CompetitionStage;
import org.footballapp.model.standings.LeagueTableGroup;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.service.CompetitionMetadataService;
import org.footballapp.service.FootballDataProvider;
import org.footballapp.service.LeagueDataService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dev")
@Profile("live")
public class DevelopmentController {

    private final CompetitionMetadataService competitionMetadataService;
    private final FootballDataProvider footballDataProvider;
    private final LeagueDataService leagueDataService;

    public DevelopmentController(
            CompetitionMetadataService competitionMetadataService,
            FootballDataProvider footballDataProvider,
            LeagueDataService leagueDataService
    ) {
        this.competitionMetadataService =
                competitionMetadataService;
        this.footballDataProvider = footballDataProvider;
        this.leagueDataService = leagueDataService;
    }

    @GetMapping("/competition/{leagueId}/{season}/metadata")
    public org.footballapp.model.competition.CompetitionMetadata getCompetitionMetadata(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        return competitionMetadataService
                .getCompetitionMetadata(
                        leagueId,
                        season
                );
    }

    @GetMapping("/competition/{leagueId}/{season}/stages")
    public List<CompetitionStage> getCompetitionStages(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        return competitionMetadataService.getCompetitionStages(
                leagueId,
                season
        );
    }

    @GetMapping("/competition/{leagueId}/{season}/standings-raw")
    public StandingsApiResponse getStandingsRaw(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        return footballDataProvider.getStandings(
                leagueId,
                season
        );
    }

    @GetMapping("/competition/{leagueId}/{season}/standings")
    public List<LeagueTableGroup> getStandings(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        return leagueDataService.getLeagueTable(
                leagueId,
                season
        );
    }

    @GetMapping("/competition/{leagueId}/{season}/current-round")
    public String getCurrentRound(
            @PathVariable int leagueId,
            @PathVariable int season
    ) throws Exception {

        return competitionMetadataService.getCurrentRound(
                leagueId,
                season
        );
    }
}