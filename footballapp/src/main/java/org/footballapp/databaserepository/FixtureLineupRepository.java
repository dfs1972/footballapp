package org.footballapp.databaserepository;

import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class FixtureLineupRepository {

    private final DataSource dataSource;

    public FixtureLineupRepository(
            DataSource dataSource
    ) {

        this.dataSource = dataSource;

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

                Connection connection =
                        dataSource.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

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

                Connection connection =
                        dataSource.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

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

}