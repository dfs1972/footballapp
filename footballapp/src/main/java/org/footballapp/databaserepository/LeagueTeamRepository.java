package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LeagueTeamRepository {

    public void saveLeagueTeam(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO league_teams
                        (
                            league_id,
                            season,
                            team_id
                        )
                        VALUES (?, ?, ?)

                        ON CONFLICT
                        (
                            league_id,
                            season,
                            team_id
                        )
                        DO NOTHING
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, teamId);

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}