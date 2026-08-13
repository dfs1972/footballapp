package com.example.footballapp.util

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.TextStyle
import java.util.Locale

/**
 * Formats dates for display within the FootballApp UI.
 */
object DateFormatter {

    private val ukZone =
        ZoneId.of("Europe/London")

    private fun ordinalDay(day: Int): String {

        return when {

            day in 11..13 ->
                "${day}th"

            day % 10 == 1 ->
                "${day}st"

            day % 10 == 2 ->
                "${day}nd"

            day % 10 == 3 ->
                "${day}rd"

            else ->
                "${day}th"
        }

    }

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
            "EEEE d MMMM yyyy",
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
        fixtureDate: String?
    ): String {

        if (fixtureDate.isNullOrBlank()) {
            return ""
        }

        val date: LocalDate =
            try {

                // Backend fixture-list format:
                // Sat 02 Aug 2025

                LocalDate.parse(
                    fixtureDate,
                    DateTimeFormatter.ofPattern(
                        "EEE dd MMM yyyy",
                        Locale.UK
                    )
                )

            } catch (_: DateTimeParseException) {

                // Fixture-details/API format:
                // 2025-08-31T11:00:00+00:00

                OffsetDateTime
                    .parse(fixtureDate)
                    .toLocalDate()

            }

        return "${date.dayOfWeek.getDisplayName(
            TextStyle.FULL,
            Locale.UK
        )} ${ordinalDay(date.dayOfMonth)} ${
            date.month.getDisplayName(
                TextStyle.FULL,
                Locale.UK
            )
        } ${date.year}"

    }

    /**
     * Returns- 12:30 for example.
     */

    fun formatFixtureTime(
        utcDateTime: String?
    ): String {

        if (utcDateTime.isNullOrBlank()) {
            return ""
        }

        return try {

            OffsetDateTime
                .parse(utcDateTime)
                .atZoneSameInstant(ukZone)
                .format(fixtureTimeFormatter)

        } catch (e: java.time.format.DateTimeParseException) {

            ""

        }

    }

    /**
     * Parses a fixture date into a LocalDate.
     *
     * Supports:
     *
     * 2025-08-31T11:00:00+00:00
     *
     * and:
     *
     * Sat 02 Aug 2025
     *
     * Returns null when the date cannot be parsed.
     */
    fun parseFixtureDate(
        fixtureDate: String?
    ): LocalDate? {

        if (fixtureDate.isNullOrBlank()) {
            return null
        }

        return try {

            // ISO fixture date-time
            OffsetDateTime
                .parse(fixtureDate)
                .atZoneSameInstant(ukZone)
                .toLocalDate()

        } catch (e: DateTimeParseException) {

            try {

                // Backend fixture-list format:
                // Sat 02 Aug 2025

                LocalDate.parse(
                    fixtureDate,
                    DateTimeFormatter.ofPattern(
                        "EEE dd MMM yyyy",
                        Locale.UK
                    )
                )

            } catch (e: DateTimeParseException) {

                null

            }

        }

    }

}