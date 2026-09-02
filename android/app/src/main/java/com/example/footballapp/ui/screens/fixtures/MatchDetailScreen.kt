package com.example.footballapp.ui.screens.fixtures

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.ui.draw.clip
import com.example.footballapp.ui.components.FixtureLineupCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.components.SectionCard
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CountryUiModel
import com.example.footballapp.ui.model.FixtureDetailsUiModel
import com.example.footballapp.ui.model.FixtureEventUiModel
import com.example.footballapp.ui.model.FixtureLineupUiModel
import com.example.footballapp.ui.model.FixtureTeamLineupUiModel
import com.example.footballapp.ui.model.MatchStatisticsUiModel
import com.example.footballapp.util.ColorUtils
import com.example.footballapp.util.DateFormatter
import com.example.footballapp.util.FixtureStatusResolver

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchDetailScreen(
    fixture: FixtureDetailsUiModel?,
    events: List<FixtureEventUiModel>,
    lineup: FixtureLineupUiModel?,
    statistics: List<MatchStatisticsUiModel>,
    isLoading: Boolean,
    error: String?,
    onPlayerClick: (Int) -> Unit,
    onTeamClick: (Int) -> Unit = {},
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    searchResults: List<CountryUiModel> = emptyList(),
    onSearchResultClick: (CountryUiModel) -> Unit = {}
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Overview", "Lineups", "Stats")

    val homeTeamLineup = lineup?.teams?.find { it.teamId == fixture?.homeTeamId }
    val awayTeamLineup = lineup?.teams?.find { it.teamId == fixture?.awayTeamId }

    val homeColor = ColorUtils.parseHexColor(homeTeamLineup?.colors?.player?.primary) ?: MaterialTheme.colorScheme.primary
    val awayColor = ColorUtils.parseHexColor(awayTeamLineup?.colors?.player?.primary) ?: MaterialTheme.colorScheme.secondary

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick
    ) {
        if (isLoading && fixture == null) {
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

        if (fixture != null) {
            item {
                MatchHeader(
                    fixture = fixture,
                    events = events,
                    homeColors = homeTeamLineup?.colors?.player?.primary,
                    awayColors = awayTeamLineup?.colors?.player?.primary,
                    onTeamClick = onTeamClick
                )
            }

            item {
                SecondaryTabRow(
                    selectedTabIndex = selectedTab,
                    modifier = Modifier
                        .padding(horizontal = AppSpacing.Screen)
                        .padding(bottom = AppSpacing.Medium)
                        .clip(AppShapes.Card),
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    divider = {}
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
            }

            when (selectedTab) {
                0 -> {
                    item {
                        if (events.isEmpty()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(32.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("No events recorded for this match.")
                            }
                        } else {
                            SectionCard {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(AppSpacing.Small)
                                ) {
                                    Text(
                                        text = "Match Events",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.padding(bottom = AppSpacing.Small)
                                    )
                                    events.forEach { event ->
                                        EventItem(event)
                                    }
                                }
                            }
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
                2 -> {
                    item {
                        SectionCard {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(AppSpacing.Medium),
                                verticalArrangement = Arrangement.spacedBy(AppSpacing.Medium)
                            ) {
                                // Team identification color indicators
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp, 12.dp)
                                            .clip(CircleShape)
                                            .background(homeColor)
                                    )
                                    Text(
                                        text = "VS",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp, 12.dp)
                                            .clip(CircleShape)
                                            .background(awayColor)
                                    )
                                }

                                if (statistics.isEmpty()) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(32.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("Statistics not available for this match.")
                                    }
                                } else {
                                    statistics.forEach { stat ->
                                        val isPossession = stat.type.contains("Possession", ignoreCase = true)
                                        if (isPossession) {
                                            PossessionStatRow(
                                                homeValue = stat.homeValue,
                                                awayValue = stat.awayValue,
                                                homePercentage = stat.homePercentage,
                                                awayPercentage = stat.awayPercentage,
                                                homeColor = homeColor,
                                                awayColor = awayColor
                                            )
                                        } else {
                                            StatComparisonRow(
                                                label = stat.type,
                                                homeValue = stat.homeValue,
                                                awayValue = stat.awayValue,
                                                homePercentage = stat.homePercentage,
                                                awayPercentage = stat.awayPercentage,
                                                homeColor = homeColor,
                                                awayColor = awayColor
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MatchHeader(
    fixture: FixtureDetailsUiModel,
    events: List<FixtureEventUiModel>,
    homeColors: String?,
    awayColors: String?,
    onTeamClick: (Int) -> Unit
) {
    SectionCard {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // First Row: Team Names and Score
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Home Team Chip
                Box(modifier = Modifier.weight(1.2f), contentAlignment = Alignment.Center) {
                    TeamNameChip(
                        name = fixture.homeTeam,
                        hexColor = homeColors,
                        onClick = { onTeamClick(fixture.homeTeamId) }
                    )
                }
                
                // Score
                Text(
                    text = "${fixture.homeGoals ?: 0} - ${fixture.awayGoals ?: 0}",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(0.8f),
                    textAlign = TextAlign.Center
                )

                // Away Team Chip
                Box(modifier = Modifier.weight(1.2f), contentAlignment = Alignment.Center) {
                    TeamNameChip(
                        name = fixture.awayTeam,
                        hexColor = awayColors,
                        onClick = { onTeamClick(fixture.awayTeamId) }
                    )
                }
            }

            // Second Row: Scorers and Match Time
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top
            ) {
                // Home Scorers
                Column(
                    modifier = Modifier.weight(1.2f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ScorersList(events = events, teamId = fixture.homeTeamId)
                }

                // Match Time
                Column(
                    modifier = Modifier.weight(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val status = FixtureStatusResolver.fromShortStatus(fixture.statusShort)
                    val timeText = when {
                        FixtureStatusResolver.isFinished(status) -> "FT"
                        status == com.example.footballapp.ui.model.FixtureStatus.HALF_TIME -> "HT"
                        FixtureStatusResolver.isLive(status) -> {
                            if (fixture.elapsed != null && fixture.elapsed > 0) "${fixture.elapsed}'"
                            else "LIVE"
                        }
                        status == com.example.footballapp.ui.model.FixtureStatus.SCHEDULED -> {
                            val time = DateFormatter.formatFixtureTime(fixture.fixtureDate)
                            if (time.isNotBlank()) time else (fixture.statusShort ?: "")
                        }
                        else -> fixture.statusShort ?: ""
                    }
                    
                    Text(
                        text = timeText,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Away Scorers
                Column(
                    modifier = Modifier.weight(1.2f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ScorersList(events = events, teamId = fixture.awayTeamId)
                }
            }
        }
    }
}

@Composable
private fun TeamNameChip(
    name: String,
    hexColor: String?,
    onClick: () -> Unit
) {
    val backgroundColor = ColorUtils.parseHexColor(hexColor) ?: MaterialTheme.colorScheme.surfaceVariant
    val contentColor = ColorUtils.getContrastColor(backgroundColor)

    Surface(
        onClick = onClick,
        color = backgroundColor,
        contentColor = contentColor,
        shape = AppShapes.Card,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(minHeight = 40.dp)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                style = if (name.length > 15) MaterialTheme.typography.labelSmall else MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 2,
                lineHeight = if (name.length > 15) 12.sp else 16.sp
            )
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "⚽",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(end = 4.dp)
                )
                val timeDisplay = if (goal.extra != null) "${goal.elapsed}+${goal.extra}'" else "${goal.elapsed}'"
                Text(
                    text = "${goal.playerName} $timeDisplay",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
private fun MatchCardIcon(detail: String?) {
    val color = when {
        detail?.contains("Yellow", ignoreCase = true) == true -> Color(0xFFFFD700) // Gold/Yellow
        detail?.contains("Red", ignoreCase = true) == true -> Color(0xFFFF0000) // Red
        else -> null
    }

    color?.let {
        Box(
            modifier = Modifier
                .size(width = 10.dp, height = 14.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .background(it)
        )
    }
}

@Composable
private fun EventItem(event: FixtureEventUiModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Time
        val timeDisplay = if (event.extra != null) "${event.elapsed}+${event.extra}'" else "${event.elapsed}'"
        Text(
            text = timeDisplay,
            modifier = Modifier.width(48.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(Modifier.width(8.dp))
        
        // Icon
        Box(modifier = Modifier.size(24.dp), contentAlignment = Alignment.Center) {
            when (event.type) {
                "Goal" -> Text("⚽", fontSize = 16.sp)
                "Card" -> MatchCardIcon(event.detail)
                "subst" -> Text("🔄", fontSize = 16.sp)
            }
        }

        Spacer(Modifier.width(12.dp))

        val eventDescription = when (event.type) {
            "Goal" -> event.playerName ?: "Goal"
            "Card" -> "${event.detail}: ${event.playerName}"
            "subst" -> "SUB: ${event.assistName} for ${event.playerName}"
            else -> "${event.type}: ${event.playerName ?: ""}"
        }

        Column {
            Text(
                text = eventDescription,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
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

@Composable
private fun PossessionStatRow(
    homeValue: String,
    awayValue: String,
    homePercentage: Float,
    awayPercentage: Float,
    homeColor: Color,
    awayColor: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = AppSpacing.Small)
    ) {
        Text(
            text = "Ball Possession",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(AppSpacing.ExtraSmall))
        
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Home Possession
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(homePercentage.coerceAtLeast(0.01f))
                        .background(homeColor),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = homeValue,
                        color = ColorUtils.getContrastColor(homeColor),
                        modifier = Modifier.padding(start = 12.dp),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                
                // Away Possession
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(awayPercentage.coerceAtLeast(0.01f))
                        .background(awayColor),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = awayValue,
                        color = ColorUtils.getContrastColor(awayColor),
                        modifier = Modifier.padding(end = 12.dp),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun StatComparisonRow(
    label: String,
    homeValue: String,
    awayValue: String,
    homePercentage: Float,
    awayPercentage: Float,
    homeColor: Color,
    awayColor: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Label centered
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        // Values
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = homeValue,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = awayValue,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Split Progress Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(homePercentage.coerceAtLeast(0.01f))
                    .background(homeColor)
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(awayPercentage.coerceAtLeast(0.01f))
                    .background(awayColor)
            )
        }
    }
}
