package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teams.Venue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Handles persistence of venue data.
 *
 * Responsible for inserting and updating records
 * in the venue table.
 */
@Repository
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

    public Venue getVenueForTeam(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT DISTINCT
                            v.id,
                            v.name,
                            v.address,
                            v.city,
                            v.capacity,
                            v.surface
                        FROM venues v
                        JOIN fixtures f
                            ON v.id = f.venue_id
                        WHERE f.league_id = ?
                        AND f.season = ?
                        AND f.home_team_id = ?
                        LIMIT 1
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, teamId);

        ResultSet rs =
                stmt.executeQuery();

        Venue venue = null;

        if (rs.next()) {

            venue =
                    new Venue();

            venue.setId(
                    rs.getInt("id")
            );

            venue.setName(
                    rs.getString("name")
            );

            venue.setAddress(
                    rs.getString("address")
            );

            venue.setCity(
                    rs.getString("city")
            );

            venue.setCapacity(
                    rs.getInt("capacity")
            );

            venue.setSurface(
                    rs.getString("surface")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return venue;
    }
}
