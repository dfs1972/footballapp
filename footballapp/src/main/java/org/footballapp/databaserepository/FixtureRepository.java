package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixtureRow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Repository
public class FixtureRepository {

    public void saveFixture(FixtureResponse fixtureResponse)
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        
                                INSERT INTO fixtures
                        (
                            fixture_id,
                            league_id,
                            season,
                            round,
                            fixture_date,
                            venue_id,
                            home_team_id,
                            away_team_id,
                            home_goals,
                            away_goals
                        )
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                        ON CONFLICT (fixture_id)
                        DO UPDATE SET
                            home_goals = EXCLUDED.home_goals,
                            away_goals = EXCLUDED.away_goals
                        """
                );

        /**Setters*/
        stmt.setLong(
                1,
                fixtureResponse.getFixture().getId()
        );

        stmt.setInt(
                2,
                fixtureResponse.getLeague().getId()
        );

        stmt.setInt(
                3,
                fixtureResponse.getLeague().getSeason()
        );

        stmt.setString(
                4,
                fixtureResponse.getLeague().getRound()
        );

        stmt.setString(
                5,
                fixtureResponse.getFixture().getDate()
        );

        stmt.setInt(
                6,
                fixtureResponse.getFixture().getVenue().getId()
        );

        stmt.setInt(
                7,
                fixtureResponse.getTeams().getHome().getId()
        );

        stmt.setInt(
                8,
                fixtureResponse.getTeams().getAway().getId()
        );

        stmt.setObject(
                9,
                fixtureResponse.getGoals().getHome()
        );

        stmt.setObject(
                10,
                fixtureResponse.getGoals().getAway()
        );


        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**
     * Get fixtures from a particular season
     */
    public List<FixtureRow> getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.league_id = ?
                        AND f.season = ?
    
                        ORDER BY f.fixture_date
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> fixtures =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString(
                            "fixture_date"
                    )
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            fixtures.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return fixtures;
    }

    /**
     * Get fixtures for a team from a particular season
     */
    public List<FixtureRow> getLeagueFixtures(
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.league_id = ?
                        AND f.season = ?
    
                        ORDER BY f.fixture_date
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> fixtures =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString(
                            "fixture_date"
                    )
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            fixtures.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return fixtures;
    }
    /**
     * Get fixtures for a particular team.
     */
    public List<FixtureRow> getFixturesByTeam(
            int teamId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.home_team_id = ?
                           OR f.away_team_id = ?
    
                        ORDER BY f.fixture_date
                        """
                );

        stmt.setInt(1, teamId);
        stmt.setInt(2, teamId);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> fixtures =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString("fixture_date")
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            fixtures.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return fixtures;
    }

    /**
     * Get a particular team's recent results.
     */
    public List<FixtureRow> getRecentResults(
            int leagueId,
            int season,
            int limit
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.league_id = ?
                        AND f.season = ?
    
                        ORDER BY f.fixture_date DESC
    
                        LIMIT ?
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, limit);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> results =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString("fixture_date")
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );

            results.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return results;
    }
    /**
     * Get recent fixtures by Team.
     */
    public List<FixtureRow> getRecentFixturesByTeam(
            int teamId,
            int limit
    ) throws Exception {
        Connection conn =
                DatabaseConnection.connect();
                PreparedStatement stmt =
                        conn.prepareStatement(
                        """
              
                                SELECT
                                    f.fixture_id,
                                    f.fixture_date,
                                    home.name AS home_team,
                                    away.name AS away_team,
                                    f.home_team_id,
                                    f.away_team_id,
                                    f.home_goals,
                                    f.away_goals
              
                                FROM fixtures f
              
                                JOIN teams home
                                ON f.home_team_id = home.id
              
                                JOIN teams away
                                ON f.away_team_id = away.id
              
                                WHERE f.home_team_id = ?
                                OR f.away_team_id = ?
              
                                ORDER BY f.fixture_date DESC
              
              LIMIT ?
                    """
                );
        stmt.setInt(1, teamId);
        stmt.setInt(2, teamId);
        stmt.setInt(3, limit);

        ResultSet rs =
                stmt.executeQuery();

        List<FixtureRow> results =
                new ArrayList<>();

        while (rs.next()) {

            FixtureRow row =
                    new FixtureRow();

            populateFixtureDateTime(
                    row,
                    rs.getString("fixture_date")
            );

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );
            row.setHomeGoals(
                    rs.getInt("home_goals")
            );
            row.setAwayGoals(
                    rs.getInt("away_goals")
            );
            results.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return results;
    }

    public FixtureRow getFixtureDetails(
            long fixtureId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
                            f.home_team_id,
                            f.away_team_id,
                            home.name AS home_team,
                            away.name AS away_team,
                            f.home_goals,
                            f.away_goals
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON f.home_team_id = home.id
    
                        JOIN teams away
                            ON f.away_team_id = away.id
    
                        WHERE f.fixture_id = ?
                        """
                );

        stmt.setLong(
                1,
                fixtureId
        );

        ResultSet rs =
                stmt.executeQuery();

        FixtureRow row =
                new FixtureRow();

        if (rs.next()) {

            row.setFixtureId(
                    rs.getLong("fixture_id")
            );

            populateFixtureDateTime(
                    row,
                    rs.getString(
                            "fixture_date"
                    )
            );

//            row.setRound(
//                    rs.getString("round")
//            );

            row.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            row.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            row.setHomeTeam(
                    rs.getString("home_team")
            );

            row.setAwayTeam(
                    rs.getString("away_team")
            );

            row.setHomeGoals(
                    rs.getInt("home_goals")
            );

            row.setAwayGoals(
                    rs.getInt("away_goals")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return row;
    }

    /**
     * Date & Time helper method for UK style format
     */
    private void populateFixtureDateTime(
            FixtureRow row,
            String rawDate
    ) {

        OffsetDateTime fixtureDate =
                OffsetDateTime.parse(
                        rawDate
                );

        ZonedDateTime ukDateTime =
                fixtureDate
                        .atZoneSameInstant(
                                ZoneId.of(
                                        "Europe/London"
                                )
                        );

        row.setFixtureDate(
                ukDateTime.format(
                        DateTimeFormatter.ofPattern(
                                "EEE dd MMM yyyy"
                        )
                )
        );

        row.setFixtureTime(
                ukDateTime.format(
                        DateTimeFormatter.ofPattern(
                                "HH:mm"
                        )
                )
        );
    }
}