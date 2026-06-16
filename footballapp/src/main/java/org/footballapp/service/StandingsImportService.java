package org.footballapp.service;

import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingLeague;
import org.footballapp.model.standings.StandingsApiResponse;

public class StandingsImportService {

    private final StandingRepository standingRepository;

    public StandingsImportService(
            StandingRepository standingRepository
    ) {
        this.standingRepository =
                standingRepository;
    }

    public void importStandings(
            StandingsApiResponse response
    ) throws Exception {

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
