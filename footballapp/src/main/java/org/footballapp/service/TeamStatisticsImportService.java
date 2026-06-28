package org.footballapp.service;

import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.databaserepository.TeamStatisticsRepository;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.databaserepository.LeagueTeamRepository;
import org.footballapp.model.teamstatistics.TeamStatisticsResponse;

import java.util.List;

public class TeamStatisticsImportService {

    private final ApiFootballService apiFootballService;
    private final TeamStatisticsRepository repository;
    private final StandingRepository standingRepository;

    public TeamStatisticsImportService(
            ApiFootballService apiFootballService,
            TeamStatisticsRepository repository,
            StandingRepository standingRepository
    ) {

        this.apiFootballService = apiFootballService;
        this.repository = repository;
        this.standingRepository = standingRepository;
    }

    /**
     * Imports statistics for one team in one league season.
     */
    public void importLeagueStatistics(
            int leagueId,
            int season
    ) throws Exception {

        List<Integer> teamIds =
                standingRepository.getTeamIds(
                        leagueId,
                        season
                );

        for (Integer teamId : teamIds) {

            importTeamStatistics(
                    leagueId,
                    season,
                    teamId
            );
        }
    }

    private void importTeamStatistics(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        TeamStatisticsApiResponse response =
                apiFootballService.getTeamStatistics(
                        leagueId,
                        season,
                        teamId
                );

        if (response.getResponse() != null) {

            repository.save(
                    response.getResponse()
            );
        }
    }
}