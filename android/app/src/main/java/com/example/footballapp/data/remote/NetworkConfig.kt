package com.example.footballapp.data.remote

object NetworkConfig {

    val DEFAULT_BASE_URL: String = "https://footballapp-production-1b1d.up.railway.app/"

    val baseUrl: String
        get() {
            val remoteUrl = RemoteConfigManager.baseUrl
            // If Firebase provides a local URL or is empty, use the hardcoded Railway production URL
            return if (remoteUrl.isEmpty() || remoteUrl.contains("127.0.0.1") || remoteUrl.contains("10.0.2.2")) {
                DEFAULT_BASE_URL
            } else {
                remoteUrl
            }
        }
}
