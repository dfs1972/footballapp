package org.footballapp.databaserepository;

import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FixtureLineupRepository extends BaseRepository {

    public FixtureLineupRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    /**
     * Maps a fixture lineup row.
     */
    private FixtureLineup mapFixtureLineup(
            ResultSet rs
    ) throws SQLException {

        FixtureLineup lineup =
                new FixtureLineup();

        lineup.setFixtureId(
                rs.getLong("fixture_id")
        );

        lineup.setTeamId(
                rs.getInt("team_id")
        );

        lineup.setCoachId(
                rs.getInt("coach_id")
        );

        lineup.setCoachName(
                rs.getString("coach_name")
        );

        lineup.setFormation(
                rs.getString("formation")
        );

        return lineup;

    }

    /**
     * Maps a fixture lineup player row.
     */
    private FixtureLineupPlayer mapFixtureLineupPlayer(
            ResultSet rs
    ) throws SQLException {

        FixtureLineupPlayer player =
                new FixtureLineupPlayer();

        player.setFixtureId(
                rs.getLong("fixture_id")
        );

        player.setTeamId(
                rs.getInt("team_id")
        );

        player.setPlayerId(
                rs.getInt("player_id")
        );

        player.setShirtNumber(
                rs.getInt("shirt_number")
        );

        player.setPosition(
                rs.getString("position")
        );

        player.setGrid(
                rs.getString("grid")
        );

        player.setStarting(
                rs.getBoolean("is_starting")
        );

        player.setDisplayOrder(
                rs.getInt("display_order")
        );

        return player;

    }

    /**
     * Saves a team's lineup for a fixture.
     */
    public void saveFixtureLineup(
            FixtureLineup lineup
    ) throws SQLException {

        String sql = """

            INSERT INTO fixture_lineups (

                fixture_id,
                team_id,
                coach_id,
                coach_name,
                formation

            )

            VALUES (?, ?, ?, ?, ?)

            ON CONFLICT (

                fixture_id,
                team_id

            )

            DO UPDATE SET

                coach_id = EXCLUDED.coach_id,
                coach_name = EXCLUDED.coach_name,
                formation = EXCLUDED.formation

            """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    lineup.getFixtureId()
            );

            statement.setInt(
                    2,
                    lineup.getTeamId()
            );

            statement.setInt(
                    3,
                    lineup.getCoachId()
            );

            statement.setString(
                    4,
                    lineup.getCoachName()
            );

            statement.setString(
                    5,
                    lineup.getFormation()
            );

            statement.executeUpdate();

        }

    }

    /**
     * Saves a player in a fixture lineup.
     */
    public void saveFixtureLineupPlayer(
            FixtureLineupPlayer player
    ) throws SQLException {

        String sql = """

            INSERT INTO fixture_lineup_players (

                fixture_id,
                team_id,
                player_id,
                shirt_number,
                position,
                grid,
                is_starting,
                display_order

            )

            VALUES (?, ?, ?, ?, ?, ?, ?, ?)

            ON CONFLICT (

                fixture_id,
                team_id,
                player_id

            )

            DO UPDATE SET

                shirt_number = EXCLUDED.shirt_number,
                position = EXCLUDED.position,
                grid = EXCLUDED.grid,
                is_starting = EXCLUDED.is_starting,
                display_order = EXCLUDED.display_order

            """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    player.getFixtureId()
            );

            statement.setInt(
                    2,
                    player.getTeamId()
            );

            statement.setInt(
                    3,
                    player.getPlayerId()
            );

            statement.setInt(
                    4,
                    player.getShirtNumber()
            );

            statement.setString(
                    5,
                    player.getPosition()
            );

            statement.setString(
                    6,
                    player.getGrid()
            );

            statement.setBoolean(
                    7,
                    player.isStarting()
            );

            statement.setInt(
                    8,
                    player.getDisplayOrder()
            );

            statement.executeUpdate();

        }

    }

    /**
     * Retrieves the lineups for a fixture.
     */
    public List<FixtureLineup> getFixtureLineups(
            long fixtureId
    ) throws Exception {

        String sql = """

            SELECT *
            FROM fixture_lineups
            WHERE fixture_id = ?
            ORDER BY team_id

            """;

        List<FixtureLineup> lineups =
                new ArrayList<>();

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    fixtureId
            );

            ResultSet rs =
                    statement.executeQuery();

            while (rs.next()) {

                lineups.add(
                        mapFixtureLineup(rs)
                );

            }

            rs.close();

        }

        return lineups;

    }

    /**
     * Retrieves the players for a team's lineup.
     */
    public List<FixtureLineupPlayer> getFixtureLineupPlayers(

            long fixtureId,

            int teamId

    ) throws Exception {

        String sql = """

            SELECT *
            FROM fixture_lineup_players
            WHERE fixture_id = ?
            AND team_id = ?
            ORDER BY display_order

            """;

        List<FixtureLineupPlayer> players =
                new ArrayList<>();

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    fixtureId
            );

            statement.setInt(
                    2,
                    teamId
            );

            ResultSet rs =
                    statement.executeQuery();

            while (rs.next()) {

                players.add(
                        mapFixtureLineupPlayer(rs)
                );

            }

            rs.close();

        }

        return players;

    }

}