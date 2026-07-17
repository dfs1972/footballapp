package org.footballapp.repository;

import org.footballapp.model.fixtures.FixtureEvent;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class FixtureEventRepository extends BaseRepository {

    public void deleteFixtureEvents(
            long fixtureId
    ) throws SQLException {

        String sql =
                """
                DELETE FROM fixture_events
                WHERE fixture_id = ?
                """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(
                    1,
                    fixtureId
            );

            stmt.executeUpdate();

        }

    }

    public FixtureEventRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveFixtureEvent(

            FixtureEvent event

    ) throws Exception {

        String sql = """

                INSERT INTO fixture_events
                (
                    fixture_id,
                    elapsed,
                    extra_time,
                    team_id,
                    player_id,
                    assist_player_id,
                    event_type,
                    event_detail,
                    comments
                )
                VALUES
                (?, ?, ?, ?, ?, ?, ?, ?, ?)

                """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setLong(
                    1,
                    event.getFixtureId()
            );

            statement.setObject(
                    2,
                    event.getElapsed()
            );

            statement.setObject(
                    3,
                    event.getExtraTime()
            );

            statement.setInt(
                    4,
                    event.getTeamId()
            );

            statement.setObject(
                    5,
                    event.getPlayerId()
            );

            statement.setObject(
                    6,
                    event.getAssistPlayerId()
            );

            statement.setString(
                    7,
                    event.getEventType()
            );

            statement.setString(
                    8,
                    event.getEventDetail()
            );

            statement.setString(
                    9,
                    event.getComments()
            );

            statement.executeUpdate();

        }

    }

}