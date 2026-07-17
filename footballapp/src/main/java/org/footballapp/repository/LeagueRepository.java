package org.footballapp.repository;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import org.footballapp.model.league.League;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Handles persistence of league data.
 *
 * Responsible for inserting and updating records
 * in the leagues table.
 */
@Repository
public class LeagueRepository
        extends BaseRepository {

    public LeagueRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    /**
     * Saves a league to the database.
     *
     * If the league already exists, updates the existing record.
     */
    public void saveLeague(League league)
            throws Exception {
        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                       INSERT INTO leagues
                       (league_id, name, country, season)
                       VALUES (?, ?, ?, ?)
                       ON CONFLICT (league_id, season)
                       DO UPDATE SET
                           name = EXCLUDED.name,
                           country = EXCLUDED.country
                       """
                );

        stmt.setInt(1, league.getId());
        stmt.setString(2, league.getName());
        stmt.setString(3, league.getCountry());
        stmt.setInt(4, league.getSeason());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
}
