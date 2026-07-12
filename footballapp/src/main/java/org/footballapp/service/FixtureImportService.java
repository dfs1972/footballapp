package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.databaserepository.FixtureRepository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.api.ApiFootballService;

/**
 * Imports fixtures for a given league and season
 * from API-Football into the PostgreSQL database.
 */
@Service
public class FixtureImportService {

    private final ApiFootballService apiFootballService;
    private final FixtureRepository fixtureRepository;

    public FixtureImportService(
            ApiFootballService apiFootballService,
            FixtureRepository fixtureRepository
    ) {
        this.apiFootballService =
                apiFootballService;

        this.fixtureRepository =
                fixtureRepository;
    }

    /**
     * Fetches fixtures from API and stores them in DB.
     */
    public void importLeagueFixtures(
            int leagueId,
            int season
    ) throws Exception {

        FixturesApiResponse response =
                apiFootballService.getFixtures(
                        leagueId,
                        season
                );

        for (FixtureResponse fixtureResponse
                : response.getResponse()) {

            fixtureRepository.saveFixture(
                    fixtureResponse
            );
        }
    }
}