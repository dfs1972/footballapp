package org.footballapp.repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Base class for all repositories.
 *
 * Provides access to the Spring-managed DataSource.
 * Concrete repositories are responsible for their own SQL.
 */
public abstract class BaseRepository {

    protected final DataSource dataSource;

    protected BaseRepository(
            DataSource dataSource
    ) {

        this.dataSource = dataSource;

    }

    protected Connection getConnection()
            throws SQLException {

        return dataSource.getConnection();

    }

}