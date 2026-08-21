package com.example.footballapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.footballapp.ui.navigation.FootballNavHost
import com.example.footballapp.ui.theme.FootballAppTheme
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FootballAppTheme {

                FootballNavHost()
            }
        }
    }
}
