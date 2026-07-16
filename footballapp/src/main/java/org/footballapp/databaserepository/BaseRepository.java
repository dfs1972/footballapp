package org.footballapp.databaserepository;

import javax.sql.DataSource;

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

}