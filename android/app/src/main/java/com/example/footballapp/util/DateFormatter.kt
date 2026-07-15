package com.example.footballapp.util

import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Formats dates for display within the FootballApp UI.
 */
object DateFormatter {

    private val ukZone =
        ZoneId.of("Europe/London")

    private val fixtureFormatter =
        DateTimeFormatter.ofPattern(
            "dd/MM/yyyy HH:mm",
            Locale.UK
        )

    private val shortFixtureFormatter =
        DateTimeFormatter.ofPattern(
            "EEE d MMM HH:mm",
            Locale.UK
        )

    private val dateFormatter =
        DateTimeFormatter.ofPattern(
            "d MMMM yyyy",
            Locale.UK
        )

    private val fixtureDateOnlyFormatter =
        DateTimeFormatter.ofPattern(
            "d MMMM yyyy",
            Locale.UK
        )

    private val fixtureTimeFormatter =
        DateTimeFormatter.ofPattern(
            "HH:mm",
            Locale.UK
        )

    /**
     * Example:
     * 2024-08-03T14:00:00+00:00
     *
     * becomes
     *
     * 03/08/2024 15:00
     */
    fun formatFixtureDate(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(fixtureFormatter)

    }

    /**
     * Example:
     *
     * Sat 3 Aug 15:00
     */
    fun formatFixtureDateShort(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(shortFixtureFormatter)

    }

    /**
     * Example:
     *
     * 1999-03-12
     *
     * becomes
     *
     * 12 March 1999
     */
    fun formatDate(
        date: String?
    ): String {

        if (date.isNullOrBlank()) {
            return ""
        }

        return java.time.LocalDate
            .parse(date)
            .format(dateFormatter)

    }

    /**
     * Returns- 3 August 2024 for example.
     */

    fun formatFixtureDateOnly(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(fixtureDateOnlyFormatter)

    }

    /**
     * Returns- 12:30 for example..
     */

    fun formatFixtureTime(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return OffsetDateTime
            .parse(utcDateTime)
            .atZoneSameInstant(ukZone)
            .format(fixtureTimeFormatter)

    }

}