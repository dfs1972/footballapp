package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.LeagueTableRow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StandingRepository {

    public void saveStanding(
            int leagueId,
            int season,
            Standing standing
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO standings
                        (
                            league_id,
                            season,
                            team_id,
                            position,
                            points,
                            goal_difference,
                            played,
                            wins,
                            draws,
                            losses,
                            goals_for,
                            goals_against
                        )
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

                        ON CONFLICT
                        (
                            league_id,
                            season,
                            team_id
                        )
                        DO UPDATE SET

                            position =
                                EXCLUDED.position,

                            points =
                                EXCLUDED.points,

                            goal_difference =
                                EXCLUDED.goal_difference,

                            played =
                                EXCLUDED.played,

                            wins =
                                EXCLUDED.wins,

                            draws =
                                EXCLUDED.draws,

                            losses =
                                EXCLUDED.losses,

                            goals_for =
                                EXCLUDED.goals_for,

                            goals_against =
                                EXCLUDED.goals_against
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        stmt.setInt(
                3,
                standing.getTeam().getId()
        );

        stmt.setInt(
                4,
                standing.getRank()
        );

        stmt.setInt(
                5,
                standing.getPoints()
        );

        stmt.setInt(
                6,
                standing.getGoalsDiff()
        );

        stmt.setInt(
                7,
                standing.getAll().getPlayed()
        );

        stmt.setInt(
                8,
                standing.getAll().getWin()
        );

        stmt.setInt(
                9,
                standing.getAll().getDraw()
        );

        stmt.setInt(
                10,
                standing.getAll().getLose()
        );

        stmt.setInt(
                11,
                standing.getAll()
                        .getGoals()
                        .getForGoals()
        );

        stmt.setInt(
                12,
                standing.getAll()
                        .getGoals()
                        .getAgainst()
        );

        System.out.println(
                standing.getTeam().getId()
                        + " Played="
                        + standing.getAll().getPlayed()
        );

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    public List<LeagueTableRow> getLeagueTable(
            int leagueId,
            int season
    )
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            s.position,
                            s.team_id,
                            t.name,
                            s.played,
                            s.wins,
                            s.draws,
                            s.losses,
                            s.goal_difference,
                            s.points
                        FROM standings s
                        JOIN teams t
                            ON s.team_id = t.id
                        WHERE s.league_id = ?
                        AND s.season = ?
                        ORDER BY s.position
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<LeagueTableRow> table =
                new ArrayList<>();

        while (rs.next()) {

            LeagueTableRow row =
                    new LeagueTableRow();

            row.setPosition(
                    rs.getInt("position")
            );

            row.setTeamId(
                    rs.getInt("team_id")
            );

            row.setTeamName(
                    rs.getString("name")
            );

            row.setPlayed(
                    rs.getInt("played")
            );

            row.setWins(
                    rs.getInt("wins")
            );

            row.setDraws(
                    rs.getInt("draws")
            );

            row.setLosses(
                    rs.getInt("losses")
            );

            row.setGoalDifference(
                    rs.getInt("goal_difference")
            );

            row.setPoints(
                    rs.getInt("points")
            );

            table.add(row);
        }

        rs.close();
        stmt.close();
        conn.close();

        return table;
    }

    /**
     * Returns a team's league standing
     */
    public LeagueTableRow getTeamStanding(
            int leagueId,
            int season,
            int teamId
    )
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            s.position,
                            t.name,
                            s.points
                        FROM standings s
                        JOIN teams t
                            ON s.team_id = t.id
                        WHERE s.league_id = ?
                        AND s.season = ?
                        AND s.team_id = ?
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, teamId);

        ResultSet rs =
                stmt.executeQuery();

        LeagueTableRow row = null;

        if (rs.next()) {

            row = new LeagueTableRow();

            row.setPosition(
                    rs.getInt("position")
            );

            row.setTeamName(
                    rs.getString("name")
            );

            row.setPoints(
                    rs.getInt("points")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return row;
    }
}



