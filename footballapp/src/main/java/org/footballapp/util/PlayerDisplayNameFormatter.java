package org.footballapp.util;

public final class PlayerDisplayNameFormatter {

    private PlayerDisplayNameFormatter() {
    }

    public static String format(
            String apiName,
            String firstName,
            String lastName
    ) {

        if (isBlank(firstName) || isBlank(lastName)) {
            return apiName;
        }

        return firstWord(firstName)
                + " "
                + firstWord(lastName);
    }

    private static String firstWord(
            String value
    ) {

        return value.trim()
                .split("\\s+")[0];
    }

    private static boolean isBlank(
            String value
    ) {

        return value == null
                || value.isBlank();
    }

}