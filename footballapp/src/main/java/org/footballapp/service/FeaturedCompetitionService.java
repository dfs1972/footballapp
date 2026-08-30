package org.footballapp.service;

import org.footballapp.config.competitions.SupportedCompetition;
import org.footballapp.model.league.LeagueApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeaturedCompetitionService {

    private final LeagueDataService leagueDataService;
    private final SupportedCompetitionsService supportedCompetitionsService;

    public FeaturedCompetitionService(
            LeagueDataService leagueDataService,
            SupportedCompetitionsService supportedCompetitionsService
    ) {
        this.leagueDataService = leagueDataService;
        this.supportedCompetitionsService = supportedCompetitionsService;
    }

    /**
     * Returns the actual league data for the
     * configured featured competitions.
     */
    public List<LeagueApiResponse> getFeaturedLeagueData(
            String country,
            int season
    ) throws Exception {

        List<SupportedCompetition> configured =
                supportedCompetitionsService.getFeaturedCompetitionsForCountry(country);

        if (configured.isEmpty()) {
            return List.of();
        }

        List<LeagueApiResponse> available =
                leagueDataService.getLeagues(
                        country,
                        season
                );

        if (available == null
                || available.isEmpty()) {

            return List.of();
        }

        List<LeagueApiResponse> result =
                new ArrayList<>();

        for (SupportedCompetition featured : configured) {

            for (LeagueApiResponse league : available) {

                if (league == null
                        || league.getLeague() == null) {

                    continue;
                }

                if (league
                        .getLeague()
                        .getId()
                        == featured.getCompetitionId()) {

                    result.add(league);

                    break;
                }
            }
        }

        return result;
    }
}
