package org.footballapp.repository;

import org.footballapp.model.fixtures.FixtureStatistic;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

@Repository
public class FixtureStatisticRepository extends BaseRepository {

    public FixtureStatisticRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveFixtureStatistic(
            FixtureStatistic statistic
    ) throws SQLException {

        String sql =
                """
                INSERT INTO fixture_statistics (
                    fixture_id,
                    team_id,
                    shots_on_goal,
                    shots_off_goal,
                    total_shots,
                    blocked_shots,
                    shots_inside_box,
                    shots_outside_box,
                    fouls,
                    corner_kicks,
                    offsides,
                    ball_possession,
                    yellow_cards,
                    red_cards,
                    goalkeeper_saves,
                    total_passes,
                    accurate_passes,
                    pass_percentage,
                    expected_goals,
                    goals_prevented
                )
                VALUES (
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
                )
                """;

        try (

                Connection conn = getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(1, statistic.getFixtureId());
            stmt.setInt(2, statistic.getTeamId());

            stmt.setObject(3, statistic.getShotsOnGoal());
            stmt.setObject(4, statistic.getShotsOffGoal());
            stmt.setObject(5, statistic.getTotalShots());
            stmt.setObject(6, statistic.getBlockedShots());
            stmt.setObject(7, statistic.getShotsInsideBox());
            stmt.setObject(8, statistic.getShotsOutsideBox());
            stmt.setObject(9, statistic.getFouls());
            stmt.setObject(10, statistic.getCornerKicks());
            stmt.setObject(11, statistic.getOffsides());
            stmt.setString(12, statistic.getBallPossession());
            stmt.setObject(13, statistic.getYellowCards());
            stmt.setObject(14, statistic.getRedCards());
            stmt.setObject(15, statistic.getGoalkeeperSaves());
            stmt.setObject(16, statistic.getTotalPasses());
            stmt.setObject(17, statistic.getAccuratePasses());
            stmt.setString(18, statistic.getPassPercentage());
            stmt.setBigDecimal(19, statistic.getExpectedGoals());
            stmt.setBigDecimal(20, statistic.getGoalsPrevented());

            stmt.executeUpdate();

        }

    }

    public FixtureStatistic getFixtureStatistic(
            long fixtureId,
            int teamId
    ) throws SQLException {

        String sql =
                """
                SELECT *
                FROM fixture_statistics
                WHERE fixture_id = ?
                  AND team_id = ?
                """;

        try (

                Connection conn = getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(1, fixtureId);
            stmt.setInt(2, teamId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return mapRow(rs);

            }

        }

        return null;

    }

    public List<FixtureStatistic> getFixtureStatistics(
            long fixtureId
    ) throws SQLException {

        List<FixtureStatistic> statistics =
                new ArrayList<>();

        String sql =
                """
                SELECT *
                FROM fixture_statistics
                WHERE fixture_id = ?
                ORDER BY team_id
                """;

        try (

                Connection conn = getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setLong(1, fixtureId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                statistics.add(
                        mapRow(rs)
                );

            }

        }

        return statistics;

    }

    private FixtureStatistic mapRow(
            ResultSet rs
    ) throws SQLException {

        FixtureStatistic statistic =
                new FixtureStatistic();

        statistic.setFixtureId(
                rs.getLong("fixture_id"));

        statistic.setTeamId(
                rs.getInt("team_id"));

        statistic.setShotsOnGoal(
                (Integer) rs.getObject("shots_on_goal"));

        statistic.setShotsOffGoal(
                (Integer) rs.getObject("shots_off_goal"));

        statistic.setTotalShots(
                (Integer) rs.getObject("total_shots"));

        statistic.setBlockedShots(
                (Integer) rs.getObject("blocked_shots"));

        statistic.setShotsInsideBox(
                (Integer) rs.getObject("shots_inside_box"));

        statistic.setShotsOutsideBox(
                (Integer) rs.getObject("shots_outside_box"));

        statistic.setFouls(
                (Integer) rs.getObject("fouls"));

        statistic.setCornerKicks(
                (Integer) rs.getObject("corner_kicks"));

        statistic.setOffsides(
                (Integer) rs.getObject("offsides"));

        statistic.setBallPossession(
                rs.getString("ball_possession"));

        statistic.setYellowCards(
                (Integer) rs.getObject("yellow_cards"));

        statistic.setRedCards(
                (Integer) rs.getObject("red_cards"));

        statistic.setGoalkeeperSaves(
                (Integer) rs.getObject("goalkeeper_saves"));

        statistic.setTotalPasses(
                (Integer) rs.getObject("total_passes"));

        statistic.setAccuratePasses(
                (Integer) rs.getObject("accurate_passes"));

        statistic.setPassPercentage(
                rs.getString("pass_percentage"));

        statistic.setExpectedGoals(
                rs.getBigDecimal("expected_goals"));

        statistic.setGoalsPrevented(
                rs.getBigDecimal("goals_prevented"));

        return statistic;

    }

}