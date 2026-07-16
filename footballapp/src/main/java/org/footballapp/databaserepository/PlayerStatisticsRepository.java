package org.footballapp.databaserepository;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.playerstatistics.PlayerStatistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for storing player statistics.
 */
@Repository
public class PlayerStatisticsRepository
        extends BaseRepository {

    public PlayerStatisticsRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void savePlayerStatistics(
            int playerId,
            int season,
            PlayerStatistics statistics
    ) throws Exception {

        String sql =
                """
                INSERT INTO player_statistics (

                    player_id,
                    team_id,
                    league_id,
                    season,

                    position,
                    shirt_number,
                    captain,

                    appearances,
                    starts,
                    minutes,

                    goals,
                    assists,

                    yellow_cards,
                    red_cards,

                    rating

                )

                VALUES (

                    ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?

                )

                ON CONFLICT (

                    player_id,
                    league_id,
                    season

                )

                DO UPDATE SET

                    team_id = EXCLUDED.team_id,

                    position = EXCLUDED.position,
                    shirt_number = EXCLUDED.shirt_number,
                    captain = EXCLUDED.captain,

                    appearances = EXCLUDED.appearances,
                    starts = EXCLUDED.starts,
                    minutes = EXCLUDED.minutes,

                    goals = EXCLUDED.goals,
                    assists = EXCLUDED.assists,

                    yellow_cards = EXCLUDED.yellow_cards,
                    red_cards = EXCLUDED.red_cards,

                    rating = EXCLUDED.rating
                """;

        try (

                Connection conn =
                        getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setInt(
                    1,
                    playerId
            );

            stmt.setInt(
                    2,
                    statistics.getTeam()
                            .getTeamId()
            );

            stmt.setInt(
                    3,
                    statistics.getLeague()
                            .getLeagueId()
            );

            stmt.setInt(
                    4,
                    season
            );

            /*
             * Games
             */

            stmt.setString(
                    5,
                    statistics.getGames()
                            .getPosition()
            );

            if (statistics.getGames()
                    .getNumber() != null) {

                stmt.setInt(
                        6,
                        statistics.getGames()
                                .getNumber()
                );

            } else {

                stmt.setNull(
                        6,
                        Types.INTEGER
                );
            }

            if (statistics.getGames()
                    .getCaptain() != null) {

                stmt.setBoolean(
                        7,
                        statistics.getGames()
                                .getCaptain()
                );

            } else {

                stmt.setNull(
                        7,
                        Types.BOOLEAN
                );
            }

            /*
             * Appearances
             */

            if (statistics.getGames()
                    .getAppearances() != null) {

                stmt.setInt(
                        8,
                        statistics.getGames()
                                .getAppearances()
                );

            } else {

                stmt.setNull(
                        8,
                        Types.INTEGER
                );
            }

            if (statistics.getGames()
                    .getLineups() != null) {

                stmt.setInt(
                        9,
                        statistics.getGames()
                                .getLineups()
                );

            } else {

                stmt.setNull(
                        9,
                        Types.INTEGER
                );
            }

            if (statistics.getGames()
                    .getMinutes() != null) {

                stmt.setInt(
                        10,
                        statistics.getGames()
                                .getMinutes()
                );

            } else {

                stmt.setNull(
                        10,
                        Types.INTEGER
                );
            }

            /*
             * Goals
             */

            if (statistics.getGoals()
                    .getTotal() != null) {

                stmt.setInt(
                        11,
                        statistics.getGoals()
                                .getTotal()
                );

            } else {

                stmt.setNull(
                        11,
                        Types.INTEGER
                );
            }

            if (statistics.getGoals()
                    .getAssists() != null) {

                stmt.setInt(
                        12,
                        statistics.getGoals()
                                .getAssists()
                );

            } else {

                stmt.setNull(
                        12,
                        Types.INTEGER
                );
            }

            /*
             * Cards
             */

            if (statistics.getCards()
                    .getYellow() != null) {

                stmt.setInt(
                        13,
                        statistics.getCards()
                                .getYellow()
                );

            } else {

                stmt.setNull(
                        13,
                        Types.INTEGER
                );
            }

            if (statistics.getCards()
                    .getRed() != null) {

                stmt.setInt(
                        14,
                        statistics.getCards()
                                .getRed()
                );

            } else {

                stmt.setNull(
                        14,
                        Types.INTEGER
                );
            }

            /*
             * Rating
             */

            if (statistics.getGames()
                    .getRating() != null &&
                    !statistics.getGames()
                            .getRating()
                            .isBlank()) {

                stmt.setBigDecimal(
                        15,
                        new java.math.BigDecimal(
                                statistics.getGames()
                                        .getRating()
                        )
                );

            } else {

                stmt.setNull(
                        15,
                        Types.DECIMAL
                );
            }

            stmt.executeUpdate();
        }
    }

    /**
     * Get Player line up from a game
     */

    public List<PlayerSummary> getPlayersForTeam(
            int teamId,
            int leagueId,
            int season
    )throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
    
                            p.player_id,
                            p.display_name,
                            p.photo_url,
                            p.nationality,
                            p.age,
    
                            ps.position,
                            ps.shirt_number,
                            ps.captain,
                            ps.appearances,
                            ps.goals,
                            ps.assists
    
                        FROM players p
    
                        JOIN player_statistics ps
                          ON p.player_id = ps.player_id
    
                        WHERE ps.team_id = ?
                          AND ps.league_id = ?
                          AND ps.season = ?
    
                        ORDER BY
                        CASE ps.position
                            
                            WHEN 'Goalkeeper' THEN 1
                            WHEN 'Defender'   THEN 2
                            WHEN 'Midfielder' THEN 3
                            WHEN 'Attacker'   THEN 4
                        
                            ELSE 5
                        END,
                            
                        p.display_name;
                            
                        """
                );

        stmt.setInt(1, teamId);
        stmt.setInt(2, leagueId);
        stmt.setInt(3, season);

        ResultSet rs =
                stmt.executeQuery();

        List<PlayerSummary> players =
                new ArrayList<>();

        while (rs.next()) {

            PlayerSummary player =
                    new PlayerSummary();

            player.setPlayerId(
                    rs.getInt("player_id")
            );

            player.setDisplayName(
                    rs.getString("display_name")
            );

            player.setPhotoUrl(
                    rs.getString("photo_url")
            );

            player.setNationality(
                    rs.getString("nationality")
            );

            player.setAge(
                    (Integer) rs.getObject("age")
            );

            player.setPosition(
                    rs.getString("position")
            );

            if (!rs.wasNull()) {
                player.setShirtNumber(
                        (Integer) rs.getObject(
                                "shirt_number"
                        )
                );
            }

            player.setCaptain(
                    (Boolean) rs.getObject(
                            "captain"
                    )
            );

            player.setAppearances(
                    (Integer) rs.getObject(
                            "appearances"
                    )
            );

            player.setGoals(
                    (Integer) rs.getObject(
                            "goals"
                    )
            );

            player.setAssists(
                    (Integer) rs.getObject(
                            "assists"
                    )
            );

            players.add(player);
        }

        rs.close();
        stmt.close();
        conn.close();

        return players;
    }

} // End of Class.