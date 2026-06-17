package org.footballapp.service;

import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingLeague;
import org.footballapp.model.standings.StandingsApiResponse;

public class StandingsImportService {

    private final StandingRepository standingRepository;
    private final StandingService standingService;

    public StandingsImportService(
            StandingService standingService,
            StandingRepository standingRepository
    ) {
        this.standingService = standingService;
        this.standingRepository = standingRepository;
    }

    public void importLeagueStandings(
            int leagueId,
            int season
    ) throws Exception {

        StandingsApiResponse response =
                standingService.getStandings(
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
