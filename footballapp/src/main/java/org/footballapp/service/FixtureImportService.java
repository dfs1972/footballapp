package org.footballapp.service;

import org.footballapp.databaserepository.FixtureRepository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;

/**
 * Imports fixtures for a given league and season
 * from API-Football into the PostgreSQL database.
 */
public class FixtureImportService {

    private final FixtureService fixtureService;
    private final FixtureRepository fixtureRepository;

    public FixtureImportService(
            FixtureService fixtureService,
            FixtureRepository fixtureRepository
    ) {
        this.fixtureService = fixtureService;
        this.fixtureRepository = fixtureRepository;
    }

    /**
     * Fetches fixtures from API and stores them in DB.
     */
    public void importLeagueFixtures(
            int leagueId,
            int season
    ) throws Exception {

        FixturesApiResponse response =
                fixtureService.getFixtures(
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