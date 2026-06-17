package org.footballapp.util;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final ZoneId UK_ZONE =
            ZoneId.of("Europe/London");

    private static final DateTimeFormatter DISPLAY_FORMAT =
            DateTimeFormatter.ofPattern(
                    "dd/MM/yyyy HH:mm"
            );

    /**
     * Converts API-Football UTC datetime
     * into UK local time.
     *
     * Example:
     * 2024-08-03T11:30:00+00:00
     *
     * becomes:
     * 03/08/2024 12:30
     */
    public static String formatFixtureDate(
            String utcDateTime
    ) {

        OffsetDateTime utc =
                OffsetDateTime.parse(
                        utcDateTime
                );

        ZonedDateTime ukTime =
                utc.atZoneSameInstant(
                        UK_ZONE
                );

        return ukTime.format(
                DISPLAY_FORMAT
        );
    }

    /**
     * Returns the UK ZonedDateTime object
     * if further processing is required.
     */
    public static ZonedDateTime toUkTime(
            String utcDateTime
    ) {

        OffsetDateTime utc =
                OffsetDateTime.parse(
                        utcDateTime
                );

        return utc.atZoneSameInstant(
                UK_ZONE
        );
    }

    private DateUtils() {
        // Utility class
    }
}