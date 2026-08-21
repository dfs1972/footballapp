package com.example.footballapp.data.remote

object FlagUrlResolver {

    private const val BASE_URL =
        "http://10.0.2.2:8081"

    fun resolve(
        flagPath: String?
    ): String? {

        if (flagPath.isNullOrBlank()) {
            return null
        }

        /*
         * Already an absolute URL.
         */
        if (
            flagPath.startsWith("http://") ||
            flagPath.startsWith("https://")
        ) {
            return flagPath
        }

        /*
         * Backend returns paths such as:
         *
         * /images/flags/al
         */
        return if (flagPath.startsWith("/")) {
            BASE_URL + flagPath
        } else {
            "$BASE_URL/$flagPath"
        }
    }
}