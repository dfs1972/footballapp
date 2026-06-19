package com.example.footballapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.navigation.FootballNavGraph
import com.example.footballapp.ui.theme.FootballAppTheme
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FootballAppTheme {

                FootballNavGraph()
            }
        }
    }
}

@Composable
fun MainScreen(
    onLeagueSelectionClick: () -> Unit,
    onLeagueTableClick: () -> Unit,
    onFixturesClick: () -> Unit,
    onTeamsClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = "Football App",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text =
                "League: " +
                        AppState.selectedLeagueName,
            modifier =
                Modifier.padding(top = 8.dp)
        )

        Button(
            onClick = onLeagueSelectionClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Leagues")
        }

        Button(
            onClick = onLeagueTableClick,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("League Table")
        }

        Button(
            onClick = onTeamsClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Teams")
        }

        Button(
            onClick = onFixturesClick,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Fixtures")
        }
    }
}