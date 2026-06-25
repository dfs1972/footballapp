package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.footballapp.model.player.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

/**
 * Repository for storing player identity information.
 *
 * This repository only stores player details.
 * Season statistics are stored separately.
 */
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
    }
}