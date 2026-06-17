package org.footballapp.service;

import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingLeague;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.api.ApiFootballService;

public class StandingsImportService {

    private final ApiFootballService apiFootballService;
    private final StandingRepository standingRepository;

    public StandingsImportService(
            ApiFootballService apiFootballService,
            StandingRepository standingRepository
    ) {
        this.apiFootballService =
                apiFootballService;

        this.standingRepository =
                standingRepository;
    }
    public void importLeagueStandings(
            int leagueId,
            int season
    ) throws Exception {

        StandingsApiResponse response =
                apiFootballService.getStandings(
                        leagueId,
                        season
                );

        StandingLeague league =
                response.getResponse()
                        .get(0)
                        .getLeague();

        for (Standing standing :
                league.getStandings().get(0)) {

            standingRepository.saveStanding(
                    league.getId(),
                    league.getSeason(),
                    standing
            );
        }
    }
}
