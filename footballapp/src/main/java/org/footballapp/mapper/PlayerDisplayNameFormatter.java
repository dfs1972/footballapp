//package org.footballapp.mapper;
//
//import static org.footballapp.util.PlayerDisplayNameFormatter.firstWord;
//
//public final class PlayerDisplayNameFormatter {
//
//    private PlayerDisplayNameFormatter() {
//    }
//
//    public static String format(
//            String firstName,
//            String lastName,
//            String fallback
//    ) {
//
//        if (firstName == null || firstName.isBlank()
//                || lastName == null || lastName.isBlank()) {
//
//            return fallback;
//        }
//
//        return firstWord(firstName)
//                + " "
//                + firstWord(lastName);
//    }
//
//}