package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
        if (isLoading && fixture.fixtureId == 0L) {
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
            MatchHeader(fixture)
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
private fun MatchHeader(fixture: FixtureDetailsUiModel) {
    SectionCard {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TeamLogo(fixture.homeTeam, fixture.homeTeamLogo)
                
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${fixture.homeGoals ?: 0} - ${fixture.awayGoals ?: 0}",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    fixture.statusShort?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                TeamLogo(fixture.awayTeam, fixture.awayTeamLogo)
            }
        }
    }
}

@Composable
private fun TeamLogo(name: String, logoUrl: String?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = logoUrl,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Text(text = name, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun EventItem(event: FixtureEventUiModel) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${event.elapsed}'",
            modifier = Modifier.width(40.dp),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        
        AsyncImage(
            model = event.teamLogo,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(Modifier.width(16.dp))
        
        Column {
            Text(
                text = "${event.type}: ${event.playerName ?: ""}",
                style = MaterialTheme.typography.bodyLarge
            )
            event.detail.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
