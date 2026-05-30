package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.footballapp.model.teams.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TeamRepository {

    public void saveTeam(Team team) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO teams
                        (id, name)
                        VALUES (?, ?)
                        ON CONFLICT (id)
                        DO NOTHING
                        """
                );

        stmt.setInt(1, team.getId());
        stmt.setString(2, team.getName());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}