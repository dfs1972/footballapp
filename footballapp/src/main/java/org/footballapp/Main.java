package org.footballapp;

import org.footballapp.config.AppConfig;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.model.teamdetails.TeamDetails;
import org.footballapp.service.LeagueDataService;
import org.footballapp.util.DateUtils;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
            throws Exception {

        AppConfig config =
                new AppConfig();

//        LeagueDataService leagueDataService =
//                config.getLeagueDataService();
//
//        Scanner scanner =
//                new Scanner(System.in);
//
//        System.out.println();
//        System.out.println("=== Football App Test Menu ===");
//        System.out.println("1. League Table");
//        System.out.println("2. Team Details");
//        System.out.println("3. Fixtures");
//        System.out.println();
//        System.out.print("Select option: ");
//
//        int option =
//                scanner.nextInt();
//
//        switch (option) {
//
//            case 1:
//
//                List<LeagueTableRow> table =
//                        leagueDataService.getLeagueTable(
//                                179,
//                                2024
//                        );
//
//                System.out.println();
//                System.out.println("Scottish Premiership 2024");
//
//                for (LeagueTableRow row : table) {
//
//                    System.out.println(
//                            row.getPosition()
//                                    + ". "
//                                    + row.getTeamName()
//                                    + " - "
//                                    + row.getPoints()
//                                    + " pts"
//                    );
//                }
//
//                break;
//
//            case 2:
//
//                TeamDetails details =
//                        leagueDataService.getTeamDetails(
//                                179,
//                                2024,
//                                257 // Rangers
//                        );
//
//                System.out.println();
//                System.out.println(
//                        details.getTeam().getName()
//                );
//
//                System.out.println(
//                        "Position: "
//                                + details.getLeaguePosition()
//                );
//
//                System.out.println(
//                        "Points: "
//                                + details.getPoints()
//                );
//
//                System.out.println(
//                        "Form: "
//                                + details.getForm()
//                );
//
//                System.out.println();
//                System.out.println("Recent Fixtures:");
//
//                for (FixtureRow fixture :
//                        details.getRecentFixtures()) {
//
//                    System.out.println(
//                            fixture.getHomeTeam()
//                                    + " "
//                                    + fixture.getHomeGoals()
//                                    + "-"
//                                    + fixture.getAwayGoals()
//                                    + " "
//                                    + fixture.getAwayTeam()
//                    );
//                }
//
//                break;
//
//            case 3:
//
//                List<FixtureRow> fixtures =
//                        leagueDataService.getLeagueFixtures(
//                                179,
//                                2024
//                        );
//
//                System.out.println();
//                System.out.println("Fixtures");
//
//                for (FixtureRow fixture : fixtures) {
//
//                    System.out.println(
//                            DateUtils.formatFixtureDate(
//                                    fixture.getFixtureDate()
//                            )
//                                    + " | "
//                                    + fixture.getHomeTeam()
//                                    + " "
//                                    + fixture.getHomeGoals()
//                                    + "-"
//                                    + fixture.getAwayGoals()
//                                    + " "
//                                    + fixture.getAwayTeam()
//                    );
//                }
//
//                break;
//
//            default:
//
//                System.out.println(
//                        "Invalid option."
//                );
//        }
//
//        scanner.close();

        config
                .getStandingsImportService()
                .importLeagueStandings(
                        179,
                        2024
                );

        System.out.println(
                "Standings import complete."
        );
    } // End of main method.
}