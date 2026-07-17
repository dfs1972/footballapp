package org.footballapp.tools;

import org.footballapp.service.importer.FixtureLineupImportService;
import org.footballapp.service.importer.FixtureEventImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import static org.footballapp.tools.AppConstants.DEVELOPMENT_LEAGUE;
//import static org.footballapp.tools.AppConstants.DEVELOPMENT_SEASON;

@Component
public class ImportRunner implements CommandLineRunner {

    private static final boolean IMPORT_ENABLED = false;

    private static final long FIXTURE_ID = 1220118L;

    //private final FixtureLineupImportService fixtureLineupImportService;

    private final FixtureEventImportService fixtureEventImportService;

    public ImportRunner(

            //FixtureLineupImportService fixtureLineupImportService,

            FixtureEventImportService fixtureEventImportService
    ) {

//        this.fixtureLineupImportService =
//                fixtureLineupImportService;

        this.fixtureEventImportService =
                fixtureEventImportService;

    }

    @Override
    public void run(
            String... args
    ) throws Exception {

        if (!IMPORT_ENABLED) {
            return;
        }

        System.out.println("========================================");
        System.out.println("Importing Fixture Events");
        System.out.println("========================================");
        System.out.println();

        System.out.println(
                "Fixture ID: "
                        + FIXTURE_ID
        );

        fixtureEventImportService.replaceFixtureEvents(
                FIXTURE_ID
        );

        System.out.println();

        System.out.println("========================================");
        System.out.println("Fixture Events Import Complete");
        System.out.println("========================================");

    }

}