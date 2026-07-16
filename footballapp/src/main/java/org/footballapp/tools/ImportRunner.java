package org.footballapp.tools;

import org.footballapp.service.importer.FixtureLineupImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ImportRunner implements CommandLineRunner {

    private static final boolean IMPORT_ENABLED = false;

    private static final long FIXTURE_ID = 1220118L;

    private final FixtureLineupImportService fixtureLineupImportService;

    public ImportRunner(
            FixtureLineupImportService fixtureLineupImportService
    ) {

        this.fixtureLineupImportService =
                fixtureLineupImportService;

    }

    @Override
    public void run(
            String... args
    ) throws Exception {

        if (!IMPORT_ENABLED) {
            return;
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("Importing Fixture Lineups");
        System.out.println("========================================");
        System.out.println();

        System.out.println(
                "Fixture ID: "
                        + FIXTURE_ID
        );

        fixtureLineupImportService.importFixtureLineups(
                FIXTURE_ID
        );

        System.out.println();
        System.out.println("========================================");
        System.out.println("Fixture Lineup Import Complete");
        System.out.println("========================================");
        System.out.println();

    }

}