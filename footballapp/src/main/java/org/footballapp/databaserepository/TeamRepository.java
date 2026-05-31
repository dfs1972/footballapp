package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.footballapp.model.teams.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Handles persistence of team data.
 *
 * Responsible for inserting and updating records
 * in the teams table.
 */
public class TeamRepository {

    /**
     * Saves a team to the database.
     *
     * If the team already exists, updates the existing record.
     */
    public void saveTeam(Team team) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
//                        """
//                        INSERT INTO teams
//                        (id, name)
//                        VALUES (?, ?)
//                        ON CONFLICT (id)
//                        DO NOTHING
//                        """
                        """
                       INSERT INTO teams
                       (id, name, country, founded)
                       VALUES (?, ?, ?, ?)
                       ON CONFLICT (id)
                       DO UPDATE SET
                          name = EXCLUDED.name,
                          country = EXCLUDED.country,
                          founded = EXCLUDED.founded
                       """
                );

        stmt.setInt(1, team.getId());
        stmt.setString(2, team.getName());
        stmt.setString(3, team.getCountry());
        stmt.setInt(4, team.getFounded());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}