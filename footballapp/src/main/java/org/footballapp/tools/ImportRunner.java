package org.footballapp.tools;

import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.model.teams.Team;
import org.footballapp.service.PlayerImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImportRunner implements CommandLineRunner {

    private static final boolean RUN_IMPORT = false;

    private static final int TEAM_ID = 257;   // Rangers
    private static final int SEASON = 2024;

    private final PlayerImportService playerImportService;
    private final TeamRepository teamRepository;

    public ImportRunner(
            PlayerImportService playerImportService,
            TeamRepository teamRepository
    ) {

        this.playerImportService = playerImportService;

        this.teamRepository = teamRepository;

    }

    @Override
    public void run(String... args) throws Exception {

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