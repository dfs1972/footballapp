package com.example.footballapp.data.remote

import android.os.Build

object NetworkConfig {
    /**
     * When using a physical device via USB, we use 127.0.0.1 combined with 'adb reverse'.
     * This avoids firewall issues on the local network.
     */
    private const val HOST_NAME = "127.0.0.1"
    private const val PORT = "8081"

    private const val EMULATOR_HOST = "10.0.2.2"

    val DEFAULT_BASE_URL: String
        get() = if (isEmulator) "http://$EMULATOR_HOST:$PORT/" else "http://$HOST_NAME:$PORT/"

    private val isEmulator: Boolean
        get() = (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.HARDWARE.contains("goldfish")
                || Build.HARDWARE.contains("ranchu")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || Build.PRODUCT.contains("sdk_google")
                || Build.PRODUCT.contains("google_sdk")
                || Build.PRODUCT.contains("sdk")
                || Build.PRODUCT.contains("sdk_x86")
                || Build.PRODUCT.contains("vbox86p")
                || Build.PRODUCT.contains("emulator")
                || Build.PRODUCT.contains("simulator")

    val baseUrl: String
        get() {
            val remoteUrl = RemoteConfigManager.baseUrl
            // If Firebase is still returning the default (127.0.0.1) and we are NOT on an emulator,
            // let's try to use the Railway URL as a hardcoded fallback to help the user.
            return if (remoteUrl.contains("127.0.0.1") && !isEmulator) {
                "https://footballapp-production.up.railway.app/"
            } else {
                remoteUrl
            }
        }
}
