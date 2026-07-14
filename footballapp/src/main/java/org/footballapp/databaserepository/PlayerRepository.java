package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.player.Player;
import org.footballapp.model.playerdetails.PlayerDetails;

import java.math.BigDecimal;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

/**
 * Repository for storing player identity information.
 *
 * This repository only stores player details.
 * Season statistics are stored separately.
 */
@Repository
public class PlayerRepository {

    /**
     * Inserts or updates a player.
     */
    public void savePlayer(
            Player player
    ) throws Exception {

        String sql =
                """
                INSERT INTO players (
                    player_id,
                    firstname,
                    lastname,
                    display_name,
                    birth_date,
                    birth_place,
                    birth_country,
                    nationality,
                    age,
                    height,
                    weight,
                    injured,
                    photo_url
                )
                VALUES (
                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
                )

                ON CONFLICT (player_id)

                DO UPDATE SET

                    firstname = EXCLUDED.firstname,
                    lastname = EXCLUDED.lastname,
                    display_name = EXCLUDED.display_name,
                    birth_date = EXCLUDED.birth_date,
                    birth_place = EXCLUDED.birth_place,
                    birth_country = EXCLUDED.birth_country,
                    nationality = EXCLUDED.nationality,
                    age = EXCLUDED.age,
                    height = EXCLUDED.height,
                    weight = EXCLUDED.weight,
                    injured = EXCLUDED.injured,
                    photo_url = EXCLUDED.photo_url
                """;

        try (

                Connection conn =
                        DatabaseConnection.connect();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setInt(
                    1,
                    player.getPlayerId()
            );

            stmt.setString(
                    2,
                    player.getFirstname()
            );

            stmt.setString(
                    3,
                    player.getLastname()
            );

            stmt.setString(
                    4,
                    player.getName()
            );

            /*
             * Birth information
             */
            if (player.getBirth() != null &&
                    player.getBirth().getDate() != null) {

                stmt.setDate(
                        5,
                        java.sql.Date.valueOf(
                                player.getBirth().getDate()
                        )
                );

            } else {

                stmt.setNull(
                        5,
                        Types.DATE
                );
            }

            stmt.setString(
                    6,
                    player.getBirth() != null
                            ? player.getBirth().getPlace()
                            : null
            );

            stmt.setString(
                    7,
                    player.getBirth() != null
                            ? player.getBirth().getCountry()
                            : null
            );

            stmt.setString(
                    8,
                    player.getNationality()
            );

            /*
             * Age
             */
            if (player.getAge() != null) {

                stmt.setInt(
                        9,
                        player.getAge()
                );

            } else {

                stmt.setNull(
                        9,
                        Types.INTEGER
                );
            }

            stmt.setString(
                    10,
                    player.getHeight()
            );

            stmt.setString(
                    11,
                    player.getWeight()
            );

            stmt.setBoolean(
                    12,
                    player.isInjured()
            );

            stmt.setString(
                    13,
                    player.getPhotoUrl()
            );

            stmt.executeUpdate();
        }
    } // End of savePlayer

    /**
     * Get player Details
     * Including Name, age, nationality, photo,
     * position, shirt number, appearances, goals, assists, cards
     */
    public PlayerDetails getPlayerDetails(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
    
                            p.player_id,
                            p.display_name,
                            p.firstname,
                            p.lastname,
                            p.birth_date,
                            p.age,
                            p.nationality,
                            p.height,
                            p.weight,
                            p.photo_url,
    
                            ps.position,
                            ps.shirt_number,
                            ps.captain,
                            ps.starts,
                            ps.appearances,
                            ps.minutes,
                            ps.goals,
                            ps.assists,
                            ps.yellow_cards,
                            ps.red_cards,
                            ps.rating,
                            ps.team_id,
                            t.name AS team_name,
                            ps.league_id,
                            l.name AS league_name,
                            ps.season
    
                        FROM players p
    
                        JOIN player_statistics ps
                          ON p.player_id = ps.player_id
                        
                        JOIN teams t
                          ON ps.team_id = t.id
                        
                        JOIN leagues l
                          ON ps.league_id = l.league_id
    
                        WHERE p.player_id = ?
                          AND ps.league_id = ?
                          AND ps.season = ?
                        """
                );

        stmt.setInt(1, playerId);
        stmt.setInt(2, leagueId);
        stmt.setInt(3, season);

        ResultSet rs =
                stmt.executeQuery();

        PlayerDetails details =
                new PlayerDetails();

        if (rs.next()) {

            details.setPlayerId(
                    rs.getInt("player_id")
            );

            details.setDisplayName(
                    rs.getString("display_name")
            );

            details.setFirstName(
                    rs.getString("firstname")
            );

            details.setLastName(
                    rs.getString("lastname")
            );

            details.setBirthDate(
                    rs.getDate("birth_date")
            );

            details.setHeight(
                    rs.getString("height")
            );

            details.setWeight(
                    rs.getString("weight")
            );

            details.setAge(
                    (Integer) rs.getObject("age")
            );

            details.setNationality(
                    rs.getString("nationality")
            );

            details.setPhotoUrl(
                    rs.getString("photo_url")
            );

            details.setPosition(
                    rs.getString("position")
            );

            details.setShirtNumber(
                    (Integer) rs.getObject("shirt_number")
            );

            details.setCaptain(
                    (Boolean) rs.getObject("captain")
            );

            details.setStarts(
                    (Integer) rs.getObject("starts")
            );

            details.setAppearances(
                    (Integer) rs.getObject("appearances")
            );

            details.setMinutes(
                    (Integer) rs.getObject("minutes")
            );

            details.setGoals(
                    (Integer) rs.getObject("goals")
            );

            details.setAssists(
                    rs.getObject("assists") == null
                            ? 0
                            : rs.getInt("assists")
            );

            details.setYellowCards(
                    (Integer) rs.getObject("yellow_cards")
            );

            details.setRedCards(
                    (Integer) rs.getObject("red_cards")
            );

            BigDecimal rating = rs.getBigDecimal("rating");

            details.setRating(
                    rating != null
                            ? rating.doubleValue()
                            : null
            );

            details.setTeamId(
                    (Integer) rs.getObject("team_id")
            );

            details.setTeamName(
                    rs.getString("team_name")
            );

            details.setLeagueId(
                    (Integer) rs.getObject("league_id")
            );

            details.setLeagueName(
                    rs.getString("league_name")
            );

            details.setSeason(
                    (Integer) rs.getObject("season")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return details;
    }
}