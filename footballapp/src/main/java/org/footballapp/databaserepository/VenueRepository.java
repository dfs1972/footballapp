package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.footballapp.model.teams.Venue;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Handles persistence of venue data.
 *
 * Responsible for inserting and updating records
 * in the venue table.
 */
public class VenueRepository {

    /**
     * Saves a venue to the database.
     *
     * If the venue already exists, updates the existing record.
     */
    public void saveVenue(Venue venue) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
//                        """
//                        INSERT INTO venue
//                        (id, name, address, city, capacity, surface)
//                        VALUES (?, ?, ?, ?, ?, ?)
//                        ON CONFLICT (id)
//                        DO NOTHING
//                        """
                        """
                        INSERT INTO venue
                        (id, name, address, city, capacity, surface)
                        VALUES (?, ?, ?, ?, ?, ?)
                        ON CONFLICT (id)
                        DO UPDATE SET
                           city = EXCLUDED.city,
                           capacity = EXCLUDED.capacity,
                           name = EXCLUDED.name,
                           address = EXCLUDED.address,
                           surface = EXCLUDED.surface
                        """
                );

        stmt.setInt(1, venue.getId());
        stmt.setString(2, venue.getName());
        stmt.setString(3, venue.getAddress());
        stmt.setString(4, venue.getCity());
        stmt.setInt(5, venue.getCapacity());
        stmt.setString(6, venue.getSurface());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}