package org.footballapp.database;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Creates JDBC connections to the PostgreSQL database.
 *
 * All repositories use this class when reading or writing data.
 */
public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://192.168.1.200:5432/footballapp_db";

    private static final String USER = "admin_dw";
    private static final String PASSWORD = "1565";

    /*
     * Opens a connection to footballapp_db.
     */
    public static Connection connect() throws Exception {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}