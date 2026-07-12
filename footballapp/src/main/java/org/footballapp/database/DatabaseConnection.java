package org.footballapp.database;

import java.sql.*;

/*
 * Creates JDBC connections to the PostgreSQL database.
 *
 * Connection details are supplied through environment variables.
 */
public class DatabaseConnection {

    private static final String URL =
            System.getenv("FOOTBALLAPP_DB_URL");

    private static final String USER =
            System.getenv("FOOTBALLAPP_DB_USER");

    private static final String PASSWORD =
            System.getenv("FOOTBALLAPP_DB_PASSWORD");

    /*
     * Opens a connection to the configured PostgreSQL database.
     */
    public static Connection connect() throws SQLException {

        System.out.println("DB_URL  = " + URL);
        System.out.println("DB_USER = " + USER);
        System.out.println("DB_PASS = " + (PASSWORD == null ? "null" : "***"));

        if (URL == null || USER == null || PASSWORD == null) {

            throw new IllegalStateException(
                    "FootballApp database environment variables are not configured."
            );

        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}