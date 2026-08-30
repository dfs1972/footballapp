package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.footballapp.ui.components.FixtureLineupCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.model.FixtureEventUiModel
import com.example.footballapp.ui.model.FixtureLineupUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchDetailScreen(
    fixture: FixtureDetailsUiModel,
    events: List<FixtureEventUiModel>,
    lineup: FixtureLineupUiModel?,
    isLoading: Boolean,
    error: String?,
    onPlayerClick: (Int) -> Unit,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    searchResults: List<CountryUiModel> = emptyList(),
    onSearchResultClick: (CountryUiModel) -> Unit = {}
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Overview", "Lineups")

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick
    ) {
        if (isLoading && (fixture.fixtureId == 0L || fixture.fixtureId == -1L)) {
            item {
                Box(modifier = Modifier.fillMaxWidth().padding(64.dp), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }

        error?.let {
            item {
                Text(text = it, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(16.dp))
            }
        }

        item {
            MatchHeader(fixture, events)
        }

        item {
            PrimaryTabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }
        }

        when (selectedTab) {
            0 -> {
                if (events.isEmpty()) {
                    item {
                        Box(modifier = Modifier.fillMaxWidth().padding(32.dp), contentAlignment = Alignment.Center) {
                            Text("No events recorded for this match.")
                        }
                    }
                } else {
                    items(events) { event ->
                        EventItem(event)
                    }
                }
            }
            1 -> {
                item {
                    lineup?.let {
                        FixtureLineupCard(
                            lineup = it,
                            onPlayerClick = onPlayerClick
                        )
                    } ?: Text("Lineup not available", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Composable
private fun MatchHeader(
    fixture: FixtureDetailsUiModel,
    events: List<FixtureEventUiModel>
) {
    SectionCard {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top
            ) {
                // Home Team
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = fixture.homeTeam,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    
                    Spacer(Modifier.height(4.dp))
                    
                    // Home Scorers
                    ScorersList(
                        events = events,
                        teamId = fixture.homeTeamId
                    )
                }
                
                // Score and Time
                Column(
                    modifier = Modifier.width(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${fixture.homeGoals ?: 0} - ${fixture.awayGoals ?: 0}",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    
                    val timeText = when {
                        fixture.statusShort == "FT" -> "Full Time"
                        fixture.statusShort == "HT" -> "Half Time"
                        fixture.elapsed != null && fixture.elapsed > 0 -> "${fixture.elapsed}'"
                        else -> fixture.statusShort ?: ""
                    }
                    
                    Text(
                        text = timeText,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                // Away Team
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = fixture.awayTeam,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    
                    Spacer(Modifier.height(4.dp))
                    
                    // Away Scorers
                    ScorersList(
                        events = events,
                        teamId = fixture.awayTeamId
                    )
                }
            }
        }
    }
}

@Composable
private fun ScorersList(
    events: List<FixtureEventUiModel>,
    teamId: Int
) {
    val scorers = events.filter { it.type == "Goal" && it.teamId == teamId }
    
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        scorers.forEach { goal ->
            Text(
                text = "${goal.playerName} ${goal.elapsed}'",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun EventItem(event: FixtureEventUiModel) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Time
        Text(
            text = "${event.elapsed}'",
            modifier = Modifier.width(40.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(Modifier.width(8.dp))
        
        // Event Icon/Description
        val eventDescription = when (event.type) {
            "Goal" -> "GOAL: ${event.playerName}"
            "Card" -> "${event.detail}: ${event.playerName}"
            "subst" -> "SUB: ${event.assistName} for ${event.playerName}"
            else -> "${event.type}: ${event.playerName ?: ""}"
        }

        Column {
            Text(
                text = eventDescription,
                style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (!event.comments.isNullOrBlank()) {
                Text(
                    text = event.comments,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
