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
    public void saveVenue(Venue venues) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(

                        """
                        INSERT INTO venues
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

        stmt.setInt(1, venues.getId());
        stmt.setString(2, venues.getName());
        stmt.setString(3, venues.getAddress());
        stmt.setString(4, venues.getCity());
        stmt.setInt(5, venues.getCapacity());
        stmt.setString(6, venues.getSurface());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}