package com.example.footballapp.ui.model

/**
 * Represents the presentation state of a fixture.
 *
 * The backend is responsible for mapping API-Football
 * status codes to these UI-friendly values.
 */
enum class FixtureStatus {

    /**
     * Match has not yet started.
     */
    SCHEDULED,

    /**
     * Match is currently being played.
     */
    LIVE,

    /**
     * Half-time interval.
     */
    HALF_TIME,

    /**
     * Match has finished.
     */
    FINISHED,

    /**
     * Match has gone to extra time.
     */
    EXTRA_TIME,

    /**
     * Match is being decided by penalties.
     */
    PENALTIES,

    /**
     * Match has been postponed.
     */
    POSTPONED,

    /**
     * Match has been cancelled.
     */
    CANCELLED

}