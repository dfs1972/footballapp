package com.example.footballapp.data.remote

import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object RemoteConfigManager {
    private const val TAG = "RemoteConfigManager"
    private const val BASE_URL_KEY = "base_url"

    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()


    private val remoteConfig: FirebaseRemoteConfig by lazy {
        FirebaseRemoteConfig.getInstance().apply {
            val configSettings = FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0) // Set to 0 for development to fetch every time
                .build()
            setConfigSettingsAsync(configSettings)
            // Default values
            setDefaultsAsync(mapOf(BASE_URL_KEY to NetworkConfig.DEFAULT_BASE_URL))
        }
    }

    fun fetchAndActivate(onComplete: () -> Unit = {}) {
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d(TAG, "Config params updated: $updated")
                } else {
                    Log.e(TAG, "Fetch failed")
                }
                _isReady.value = true
                onComplete()
            }
    }

    val baseUrl: String
        get() {
            val url = remoteConfig.getString(BASE_URL_KEY)
            Log.d(TAG, "Providing baseUrl: $url")
            return url
        }
}
