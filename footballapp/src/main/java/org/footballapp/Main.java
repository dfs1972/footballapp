package org.footballapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.databaserepository.*;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.teams.Team;
import org.footballapp.service.*;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.model.standings.LeagueTableRow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Application entry point.
 *
 * Current workflow:
 *
 * API-Football
 *      ↓
 * TeamService
 *      ↓
 * TeamImportService
 *      ↓
 * Repositories
 *      ↓
 * PostgreSQL
 *
 * Future workflow:
 *
 * LeagueImportService
 *      ├── TeamImportService
 *      ├── StandingsImportService
 *      └── FixtureImportService
 */

public class Main {

    public static void main(String[] args) throws Exception {
        try {

//            ObjectMapper mapper =
//                    new ObjectMapper();
//
//            StandingsApiResponse response =
//                    mapper.readValue(
//                            new File("data/standings.json"),
//                            StandingsApiResponse.class
//                    );
//
//            StandingRepository repository =
//                    new StandingRepository();
//
//            StandingsImportService service =
//                    new StandingsImportService(
//                            repository
//                    );
//
//            service.importStandings(
//                    response
//            );
//
//            System.out.println(
//                    "Standings imported."
//            );
            /**Get team by ID + league position + points for season*/
            StandingRepository repository =
                    new StandingRepository();

            List<LeagueTableRow> table =
                    repository.getLeagueTable(
                            179,
                            2024
                    );

            for (LeagueTableRow row : table) {

                System.out.println(
                        row.getPosition()
                                + " "
                                + row.getTeamName()
                                + " "
                                + row.getPoints()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// End of main method.
}