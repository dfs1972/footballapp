package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.footballapp.model.teams.Venue;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VenueRepository {

    public void saveVenue(Venue venue) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO venue
                        (id, name, capacity)
                        VALUES (?, ?, ?)
                        ON CONFLICT (id)
                        DO NOTHING
                        """
                );

        stmt.setInt(1, venue.getId());
        stmt.setString(2, venue.getName());
        stmt.setInt(3, venue.getCapacity());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}