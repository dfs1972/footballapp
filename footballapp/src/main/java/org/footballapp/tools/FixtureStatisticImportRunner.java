package org.footballapp.tools;

import org.footballapp.service.importer.FixtureStatisticImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FixtureStatisticImportRunner
        implements CommandLineRunner {

    private static final boolean IMPORT_ENABLED = false;

    private static final long FIXTURE_ID = 1220118L;

    /**
     * Change this to the home or away team
     * participating in the fixture.
     */
    private static final int TEAM_ID = 257;

    private final FixtureStatisticImportService
            fixtureStatisticImportService;

    public FixtureStatisticImportRunner(

            FixtureStatisticImportService
                    fixtureStatisticImportService

    ) {

        this.fixtureStatisticImportService =
                fixtureStatisticImportService;

    }

    @Override
    public void run(
            String... args
    ) throws Exception {

        if (!IMPORT_ENABLED) {
            return;
        }

        System.out.println(
                "========================================"
        );
        System.out.println(
                "Importing Fixture Statistics"
        );
        System.out.println(
                "========================================"
        );
        System.out.println();

        System.out.println(
                "Fixture ID: "
                        + FIXTURE_ID
        );

        System.out.println(
                "Team ID: "
                        + TEAM_ID
        );

        fixtureStatisticImportService
                .importFixtureStatistics(

                        FIXTURE_ID,

                        TEAM_ID

                );

        System.out.println();

        System.out.println(
                "========================================"
        );
        System.out.println(
                "Fixture Statistics Import Complete"
        );
        System.out.println(
                "========================================"
        );

    }

}