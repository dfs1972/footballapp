package org.footballapp.tools;

import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.model.teams.Team;
import org.footballapp.service.PlayerImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.footballapp.service.importer.FixtureLineupImportService;

import java.util.List;

@Component
public class ImportRunner implements CommandLineRunner {

    private static final boolean IMPORT_ENABLED = false;

    private final PlayerImportService playerImportService;
    private final TeamRepository teamRepository;
    private final FixtureLineupImportService fixtureLineupImportService;

    public ImportRunner(
            PlayerImportService playerImportService,
            TeamRepository teamRepository,
            FixtureLineupImportService fixtureLineupImportService
    ) {

        this.playerImportService = playerImportService;

        this.teamRepository = teamRepository;

        this.fixtureLineupImportService =
                fixtureLineupImportService;

    }

    @Override
    public void run(String... args) throws Exception {

        if (!IMPORT_ENABLED) {
            return;
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("Importing Fixture Lineups");
        System.out.println("========================================");
        System.out.println();

        fixtureLineupImportService.importFixtureLineups(
                1220118L
        );

        System.out.println();
        System.out.println("========================================");
        System.out.println("Fixture Lineup Import Complete");
        System.out.println("========================================");
        System.out.println();


        /*********************************/

        List<Team> teams =
                teamRepository.getTeamsForLeague(
                        AppConstants.DEVELOPMENT_LEAGUE,
                        AppConstants.DEVELOPMENT_SEASON
                );

        System.out.println();
        System.out.println("========================================");
        System.out.println("Importing Players");
        System.out.println("========================================");
        System.out.println();

        for (Team team : teams) {

            System.out.println(
                    "Importing "
                            + team.getName()
            );

            playerImportService.importPlayers(

                    team.getId(),

                    AppConstants.DEVELOPMENT_SEASON

            );

        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("Player Import Complete");
        System.out.println("========================================");
        System.out.println();

    }
}