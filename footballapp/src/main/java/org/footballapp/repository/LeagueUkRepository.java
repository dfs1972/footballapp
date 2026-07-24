package org.footballapp.repository;


import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import org.footballapp.model.league.LeagueUk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeagueUkRepository
        extends BaseRepository {

    public LeagueUkRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    /**
     * Save league metadata
     */
    public void saveLeague(
            LeagueUk league
    ) throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO leagues_uk
                        (
                            league_id,
                            name,
                            country,
                            logo_url
                        )
                        VALUES (?, ?, ?, ?)

                        ON CONFLICT (league_id)
                        DO UPDATE SET

                            name =
                                EXCLUDED.name,

                            country =
                                EXCLUDED.country,

                            logo_url =
                                EXCLUDED.logo_url
                        """
                );

        stmt.setInt(
                1,
                league.getLeagueId()
        );

        stmt.setString(
                2,
                league.getName()
        );

        stmt.setString(
                3,
                league.getCountry()
        );

        stmt.setString(
                4,
                league.getLogoUrl()
        );

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**
     * Get all leagues in leagues_uk table in DB.
     */
    public List<LeagueUk> getLeagues()
            throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            league_id,
                            name,
                            country,
                            logo_url
                        FROM leagues_uk
                        ORDER BY country,
                                 name
                        """
                );

        ResultSet rs =
                stmt.executeQuery();

        List<LeagueUk> leagues =
                new ArrayList<>();

        while (rs.next()) {

            LeagueUk league =
                    new LeagueUk();

            league.setLeagueId(
                    rs.getInt(
                            "league_id"
                    )
            );

            league.setName(
                    rs.getString(
                            "name"
                    )
            );

            league.setCountry(
                    rs.getString(
                            "country"
                    )
            );

            league.setLogoUrl(
                    rs.getString(
                            "logo_url"
                    )
            );

            leagues.add(
                    league
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return leagues;
    } // End of get all leagues in league_uk table in DB.

//    /**
//     *Get specified leagues in league_uk table in DB.
//     */
//    public List<LeagueUk> getEnabledLeagues()
//            throws Exception {
//
//        Connection conn =
//                getConnection();
//
//        PreparedStatement stmt =
//                conn.prepareStatement(
//                        """
//                        SELECT
//                            league_id,
//                            name,
//                            country,
//                            logo_url
//                        FROM leagues_uk
//                        WHERE enabled = TRUE
//                        ORDER BY country,
//                                 name
//                        """
//                );
//
//        ResultSet rs =
//                stmt.executeQuery();
//
//        List<LeagueUk> leagues =
//                new ArrayList<>();
//
//        while (rs.next()) {
//
//            LeagueUk league =
//                    new LeagueUk();
//
//            league.setLeagueId(
//                    rs.getInt("league_id")
//            );
//
//            league.setName(
//                    rs.getString("name")
//            );
//
//            league.setCountry(
//                    rs.getString("country")
//            );
//
//            league.setLogoUrl(
//                    rs.getString("logo_url")
//            );
//
//            leagues.add(league);
//        }
//
//        rs.close();
//        stmt.close();
//        conn.close();
//
//        return leagues;
//    } // End of getEnabledLeagues().

    /**
     * Get league by id
     */
    public LeagueUk getLeagueById(
            int leagueId
    ) throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT
                            league_id,
                            name,
                            country,
                            logo_url
                        FROM leagues_uk
                        WHERE league_id = ?
                        """
                );

        stmt.setInt(
                1,
                leagueId
        );

        ResultSet rs =
                stmt.executeQuery();

        LeagueUk league = null;

        if (rs.next()) {

            league =
                    new LeagueUk();

            league.setLeagueId(
                    rs.getInt(
                            "league_id"
                    )
            );

            league.setName(
                    rs.getString(
                            "name"
                    )
            );

            league.setCountry(
                    rs.getString(
                            "country"
                    )
            );

            league.setLogoUrl(
                    rs.getString(
                            "logo_url"
                    )
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return league;
    }
}
