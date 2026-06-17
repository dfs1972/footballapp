package org.footballapp;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.databaserepository.*;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.model.teams.Team;
import org.footballapp.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args)
            throws Exception {

        String apiKey =
                System.getenv("API_FOOTBALL_KEY");

        ApiFootballClient client =
                new ApiFootballClient(apiKey);

// SERVICES (API layer)
        TeamService teamService =
                new TeamService(client);

        StandingService standingService =
                new StandingService(client);

        FixtureService fixtureService =
                new FixtureService(client);

// REPOSITORIES
        TeamRepository teamRepository =
                new TeamRepository();

        VenueRepository venueRepository =
                new VenueRepository();

        StandingRepository standingRepository =
                new StandingRepository();

        FixtureRepository fixtureRepository =
                new FixtureRepository();

        LeagueTeamRepository leagueTeamRepository =
                new LeagueTeamRepository();

// IMPORT SERVICES
//        TeamImportService teamImportService =
//                new TeamImportService(
//                        teamService,
//                        teamRepository,
//                        venueRepository,
//                        leagueTeamRepository
//                );
//
//        StandingsImportService standingsImportService =
//                new StandingsImportService(
//                        standingService,
//                        standingRepository
//                );
//
//        FixtureImportService fixtureImportService =
//                new FixtureImportService(
//                        fixtureService,
//                        fixtureRepository
//                );

// ORCHESTRATOR
//        LeagueImportService leagueImportService =
//                new LeagueImportService(
//                        teamImportService,
//                        standingsImportService,
//                        fixtureImportService
//                );
        LeagueDataService leagueDataService =
                new LeagueDataService(
                        teamRepository,
                        standingRepository,
                        fixtureRepository
                );

        // =========================
        // RUN IMPORT
        // =========================

//        leagueImportService.importLeague(
//                179,
//                2024
//        );
        /**List results of all games from 2024*/
//        List<FixtureRow> fixtures =
//                leagueDataService.getLeagueFixtures(
//                        179,
//                        2024
//                );
//
//        for (FixtureRow fixture : fixtures) {
//
//            System.out.println(
//                    fixture.getHomeTeam()
//                            + " "
//                            + fixture.getHomeGoals()
//                            + "-"
//                            + fixture.getAwayGoals()
//                            + " "
//                            + fixture.getAwayTeam()
//            );
//        }
//        /** List all the teams in 2024 season */
//        List<Team> teams =
//                leagueDataService.getTeamsForLeague(
//                        179,
//                        2024
//                );
//
//        for (Team team : teams) {
//
//            System.out.println(
//                    team.getName()
//            );
//        }
//        /** Get fixtures for a particular team.*/
//        List<FixtureRow> fixtures =
//                leagueDataService.getFixturesByTeam(257);
//
//        for (FixtureRow f : fixtures) {
//
//            System.out.println(
//                    f.getFixtureDate()
//                            + " | "
//                            + f.getHomeTeam()
//                            + " "
//                            + f.getHomeGoals()
//                            + "-"
//                            + f.getAwayGoals()
//                            + " "
//                            + f.getAwayTeam()
//            );
//        }
        /** Get a list of a team's recent(5) results. */
//        List<FixtureRow> results =
//                leagueDataService.getRecentResults(
//                        179,
//                        2024,
//                        5
//                );
//
//        for (FixtureRow result : results) {
//
//            System.out.println(
//                    result.getHomeTeam()
//                            + " "
//                            + result.getHomeGoals()
//                            + "-"
//                            + result.getAwayGoals()
//                            + " "
//                            + result.getAwayTeam()
//            );
//        }
        /** Get team's form in last 5 matches. */
        System.out.println(leagueDataService.getTeamForm(257));
    }// End of main.
}
































