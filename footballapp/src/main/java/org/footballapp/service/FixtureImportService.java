package org.footballapp.service;

import org.footballapp.databaserepository.FixtureRepository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;

public class FixtureImportService {

    private final FixtureRepository fixtureRepository;

    public FixtureImportService(
            FixtureRepository fixtureRepository
    ) {
        this.fixtureRepository = fixtureRepository;
    }

    public void importFixtures(
            FixturesApiResponse response
    ) throws Exception {

        for (FixtureResponse fixtureResponse
                : response.getResponse()) {

            fixtureRepository.saveFixture(
                    fixtureResponse
            );
        }
    }
}
