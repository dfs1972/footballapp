package org.footballapp.tools.development;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.footballapp.tools.AppConstants.*;

@Component
public class ApiExplorerRunner implements CommandLineRunner {

    private static final boolean DOWNLOAD_ENABLED = false;

    private final ApiExplorerService apiExplorerService;

    public ApiExplorerRunner(
            ApiExplorerService apiExplorerService
    ) {

        this.apiExplorerService = apiExplorerService;

    }

    @Override
    public void run(
            String... args
    ) throws Exception {

        if (!DOWNLOAD_ENABLED) {
            return;
        }

//        System.out.println("========================================");
//        System.out.println("FootballApp API Explorer");
//        System.out.println("========================================");
//        System.out.println();

        // ====================================
        // Competitions
        // ====================================

        //downloadLeagues();

        // ====================================
        // League
        // ====================================

        //downloadStandings();
        //downloadFixtures();
        //apiExplorerService.downloadLeagueData(39, 2022);
        //downloadTeams();


        /**
         * Club
         */
        //printSectionHeader("Downloading Club Data");

//        apiExplorerService.downloadClubDetails();
//        apiExplorerService.downloadPlayers();
//        apiExplorerService.downloadTeamStatistics();

        //printSectionFooter("Club Data");


        /**
         * Players
         */
        //printSectionHeader("Downloading Player Data");

//        apiExplorerService.downloadPlayerDetails();
//
//        apiExplorerService.downloadPlayerStatistics();
//
//        apiExplorerService.downloadPlayerTransfers();

          apiExplorerService.downloadPlayerData(162283, 2024);

        //printSectionFooter("Player Data download");



        // ====================================
        // Fixture
        // ====================================

        //apiExplorerService.downloadFixtureStatistics();
        //apiExplorerService.downloadFixtureData(1220118L);

//        System.out.println();
//        System.out.println("========================================");
//        System.out.println("API Explorer Complete");
//        System.out.println("========================================");

    }

}