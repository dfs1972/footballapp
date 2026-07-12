package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teams.Team;
import org.footballapp.model.club.ClubDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles persistence of team data.
 *
 * Responsible for inserting and updating records
 * in the teams table.
 */
@Repository
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

                        """
                       INSERT INTO teams
                       (id, name, country, founded, venue_id)
                       VALUES (?, ?, ?, ?, ?)
                       ON CONFLICT (id)
                       DO UPDATE SET
                          name = EXCLUDED.name,
                          country = EXCLUDED.country,
                          founded = EXCLUDED.founded,
                          venue_id = EXCLUDED.venue_id
                       """
                );

        stmt.setInt(1, team.getId());
        stmt.setString(2, team.getName());
        stmt.setString(3, team.getCountry());
        stmt.setInt(4, team.getFounded());
        stmt.setInt(5, team.getVenueId());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**Test GET Team By ID.*/
    public Team getTeamById(int teamId)
            throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT *
                        FROM teams
                        WHERE id = ?
                        """
                );

        stmt.setInt(1, teamId);

        ResultSet rs =
                stmt.executeQuery();

        Team team = null;

        if (rs.next()) {

            team = new Team();

            team.setId(
                    rs.getInt("id")
            );

            team.setName(
                    rs.getString("name")
            );

            team.setCountry(
                    rs.getString("country")
            );

            team.setFounded(
                    rs.getInt("founded")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return team;
    }

    /** GET League & Season to JOIN with Team */
    public List<Team> getTeamsForLeague(
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            t.id,
                            t.name,
                            t.country,
                            t.founded
                        FROM teams t
    
                        JOIN standings lt
                            ON t.id = lt.team_id
    
                        WHERE lt.league_id = ?
                        AND lt.season = ?
    
                        ORDER BY t.name
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        List<Team> teams =
                new ArrayList<>();

        while (rs.next()) {

            Team team =
                    new Team();

            team.setId(
                    rs.getInt("id")
            );

            team.setName(
                    rs.getString("name")
            );

            team.setCountry(
                    rs.getString("country")
            );

            team.setFounded(
                    rs.getInt("founded")
            );

            teams.add(team);
        }

        rs.close();
        stmt.close();
        conn.close();

        return teams;
    }

    /**
     * Get Club Details - Retrieves full club details including venue information.
     */
    public ClubDetails getClubDetails(
            int clubId
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            t.id,
                            t.name,
                            t.country,
                            t.founded,
                            v.name AS stadium,
                            v.city,
                            v.capacity
    
                        FROM teams t
    
                        LEFT JOIN venues v
                            ON t.venue_id = v.id
    
                        WHERE t.id = ?
                        """
                );

        stmt.setInt(1, clubId);

        ResultSet rs =
                stmt.executeQuery();

        ClubDetails club = null;

        if (rs.next()) {

            club = new ClubDetails();

            club.setClubId(
                    rs.getInt("id")
            );

            club.setName(
                    rs.getString("name")
            );

            club.setCountry(
                    rs.getString("country")
            );

            club.setFounded(
                    rs.getInt("founded")
            );

            club.setStadium(
                    rs.getString("stadium")
            );

            club.setCity(
                    rs.getString("city")
            );

            club.setCapacity(
                    rs.getInt("capacity")
            );

        }

        rs.close();
        stmt.close();
        conn.close();

        return club;
    }
}