package org.footballapp.util;

public class TeamNameFormatter {

    /**
     * Formats team names for consistent display.
     *
     * Example:
     *   "ST Johnstone" -> "St Johnstone"
     *   "ST Mirren" -> "St Mirren"
     */
    public static String format(String name) {
        if (name == null || name.isBlank()) {
            return name;
        }

        String formatted = name;

        // Manual nicknames for very long names
        if (formatted.equalsIgnoreCase("Heart of Midlothian")) {
            return "Hearts";
        }
        
        if (formatted.equalsIgnoreCase("Inverness Caledonian Thistle")) {
            return "Inverness CT";
        }

        // Replace "ST " at the beginning with "St "
        if (formatted.toUpperCase().startsWith("ST ")) {
            formatted = "St " + formatted.substring(3);
        }

        return formatted;
    }
}
