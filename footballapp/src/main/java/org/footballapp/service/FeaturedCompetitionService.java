package org.footballapp.service;

import org.footballapp.model.competition.FeaturedCompetition;
import org.footballapp.model.league.LeagueApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FeaturedCompetitionService {

    private final LeagueDataService leagueDataService;

    private final List<FeaturedCompetition> featuredCompetitions =
            List.of(

                    // England
                    new FeaturedCompetition(
                            "England",
                            39,
                            1
                    ),

                    new FeaturedCompetition(
                            "England",
                            40,
                            2
                    ),

                    new FeaturedCompetition(
                            "England",
                            41,
                            3
                    ),

                    new FeaturedCompetition(
                            "England",
                            42,
                            4
                    ),

                    new FeaturedCompetition(
                            "England",
                            45,
                            5
                    ),

                    new FeaturedCompetition(
                            "England",
                            46,
                            6
                    ),

                    // Scotland
                    new FeaturedCompetition(
                            "Scotland",
                            179,
                            1
                    ),

                    new FeaturedCompetition(
                            "Scotland",
                            180,
                            2
                    ),

                    new FeaturedCompetition(
                            "Scotland",
                            181,
                            3
                    ),

                    new FeaturedCompetition(
                            "Scotland",
                            183,
                            4
                    ),

                    new FeaturedCompetition(
                            "Scotland",
                            184,
                            5
                    ),

                    new FeaturedCompetition(
                            "Scotland",
                            185,
                            6
                    )
            );

    public FeaturedCompetitionService(
            LeagueDataService leagueDataService
    ) {
        this.leagueDataService =
                leagueDataService;
    }

    /**
     * Returns the configured featured competitions
     * for a country.
     */
    public List<FeaturedCompetition> getFeaturedCompetitions(
            String country
    ) {

        if (country == null
                || country.isBlank()) {

            return List.of();
        }

        List<FeaturedCompetition> result =
                new ArrayList<>();

        for (FeaturedCompetition competition
                : featuredCompetitions) {

            if (competition
                    .getCountry()
                    .equalsIgnoreCase(country)) {

                result.add(competition);
            }
        }

        result.sort(
                Comparator.comparingInt(
                        FeaturedCompetition::getPriority
                )
        );

        return result;
    }

    /**
     * Returns the actual league data for the
     * configured featured competitions.
     *
     * The existing LeagueDataService remains responsible
     * for obtaining the country's competitions from
     * API-Football.
     */
    public List<LeagueApiResponse> getFeaturedLeagueData(
            String country,
            int season
    ) throws Exception {

        List<FeaturedCompetition> configured =
                getFeaturedCompetitions(
                        country
                );

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

        for (FeaturedCompetition featured
                : configured) {

            for (LeagueApiResponse league
                    : available) {

                if (league == null
                        || league.getLeague() == null) {

                    continue;
                }

                if (league
                        .getLeague()
                        .getId()
                        == featured.getLeagueId()) {

                    result.add(league);

                    break;
                }
            }
        }

        return result;
    }
}