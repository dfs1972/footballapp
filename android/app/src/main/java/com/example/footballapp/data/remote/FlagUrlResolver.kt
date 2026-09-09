package com.example.footballapp.data.remote

object FlagUrlResolver {

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
        val baseUrl = NetworkConfig.baseUrl.removeSuffix("/")
        return if (flagPath.startsWith("/")) {
            baseUrl + flagPath
        } else {
            "$baseUrl/$flagPath"
        }
    }
}