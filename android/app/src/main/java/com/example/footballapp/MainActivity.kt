package com.example.footballapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.footballapp.ui.navigation.FootballDestination
import com.example.footballapp.ui.navigation.FootballNavHost
import com.example.footballapp.ui.theme.FootballAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FootballAppTheme {

                val navController =
                    rememberNavController()

                FootballNavHost(

                    navController = navController,

                    startDestination =
                        FootballDestination.Competitions.route

                )
            }

            val navController =
                rememberNavController()
        }
    }
}