package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingLeague;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.api.ApiFootballService;

@Service
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
        /*
         * Scottish Premiership split league handling.
         *
         * Group 0 = Phase 1 (33 games)
         * Group 1 = Championship Group (positions 1-6)
         * Group 2 = Relegation Group (positions 7-12)
         *
         * Import final standings from Groups 1 and 2
         * and renumber positions 1-12.
         */

        int finalPosition = 1;

        // Championship Group (positions 1-6)
        for (Standing standing :
                league.getStandings().get(1)) {

            standing.setRank(
                    finalPosition++
            );

            standingRepository.saveStanding(
                    league.getId(),
                    league.getSeason(),
                    standing
            );
        }

        // Relegation Group (positions 7-12)
        for (Standing standing :
                league.getStandings().get(2)) {

            standing.setRank(
                    finalPosition++
            );

            standingRepository.saveStanding(
                    league.getId(),
                    league.getSeason(),
                    standing
            );
        }
    }
}
