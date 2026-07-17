package org.footballapp.repository;

import javax.sql.DataSource;
import org.footballapp.model.fixtures.FixtureDetails;
import org.springframework.stereotype.Repository;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixtureRow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Repository
public class FixtureRepository extends BaseRepository {

    public FixtureRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveFixture(FixtureResponse fixtureResponse)
            throws Exception {

        Connection conn =
                getConnection();

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
                getConnection();

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
                getConnection();

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
                getConnection();

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
                getConnection();

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
                getConnection();

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

    /**
     * Get Fixture Details
     */

    public FixtureDetails getFixtureDetails(
            long fixtureId
    ) throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
    
                            f.fixture_id,
                            f.fixture_date,
                            f.round,
    
                            f.home_team_id,
                            home.name AS home_team,
    
                            f.away_team_id,
                            away.name AS away_team,
    
                            f.home_goals,
                            f.away_goals,
    
                            f.league_id,
                            l.name AS league_name,
    
                            f.season,
    
                            f.venue_id,
                            v.name AS venue_name
    
                        FROM fixtures f
    
                        JOIN teams home
                            ON home.id = f.home_team_id
    
                        JOIN teams away
                            ON away.id = f.away_team_id
    
                        JOIN leagues l
                            ON l.league_id = f.league_id
    
                        LEFT JOIN venues v
                            ON v.id = f.venue_id
    
                        WHERE f.fixture_id = ?
                        """
                );

        stmt.setLong(
                1,
                fixtureId
        );

        ResultSet rs =
                stmt.executeQuery();

        FixtureDetails details = null;

        if (rs.next()) {

            details =
                    new FixtureDetails();

            details.setFixtureId(
                    rs.getLong("fixture_id")
            );

            details.setFixtureDate(
                    rs.getString("fixture_date")
            );

            details.setRound(
                    rs.getString("round")
            );

            details.setHomeTeamId(
                    rs.getInt("home_team_id")
            );

            details.setHomeTeam(
                    rs.getString("home_team")
            );

            details.setAwayTeamId(
                    rs.getInt("away_team_id")
            );

            details.setAwayTeam(
                    rs.getString("away_team")
            );

            details.setHomeGoals(
                    (Integer) rs.getObject("home_goals")
            );

            details.setAwayGoals(
                    (Integer) rs.getObject("away_goals")
            );

            details.setLeagueId(
                    rs.getInt("league_id")
            );

            details.setLeagueName(
                    rs.getString("league_name")
            );

            details.setSeason(
                    rs.getInt("season")
            );

            details.setVenueName(
                    rs.getString("venue_name")
            );

        }

        rs.close();
        stmt.close();
        conn.close();

        return details;

    }

    public List<Long> getFixtureIds(
            int leagueId,
            int season
    ) throws SQLException {

        String sql = """
            SELECT fixture_id
            FROM fixtures
            WHERE league_id = ?
              AND season = ?
            ORDER BY fixture_date
            """;

        List<Long> fixtureIds = new ArrayList<>();

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, leagueId);
            statement.setInt(2, season);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    fixtureIds.add(
                            rs.getLong("fixture_id")
                    );

                }
            }
        }

        return fixtureIds;
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