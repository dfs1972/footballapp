package com.example.footballapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballapp.model.TeamDetails
import com.example.footballapp.repositories.TeamDetailsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.NumberFormat

@Composable
fun TeamScreen(
    teamId: Int,
    onFixturesClick: (String) -> Unit
) {

    var teamState by remember {
        mutableStateOf<TeamScreenState>(
            TeamScreenState.Loading
        )
    }

    LaunchedEffect(
        teamId
    ) {

        teamState =
            TeamScreenState.Loading

        teamState =
            withContext(
                Dispatchers.IO
            ) {

                runCatching {
                    TeamDetailsApiRepository()
                        .getTeamDetails(
                            teamId
                        )
                }.fold(
                    onSuccess = { details ->
                        TeamScreenState.Ready(details)
                    },
                    onFailure = { error ->
                        TeamScreenState.Error(
                            error.message
                                ?: "Unable to load team details"
                        )
                    }
                )
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(16.dp)
    ) {

        when (val state = teamState) {

            TeamScreenState.Loading -> {
                Text(
                    text = "Loading team...",
                    style =
                        MaterialTheme.typography.bodyMedium
                )
            }

            is TeamScreenState.Error -> {
                Text(
                    text = state.message,
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.error
                )
            }

            is TeamScreenState.Ready -> {
                TeamDetailsContent(
                    teamDetails = state.teamDetails,
                    onFixturesClick = onFixturesClick
                )
            }
        }
    }
}

@Composable
private fun TeamDetailsContent(
    teamDetails: TeamDetails,
    onFixturesClick: (String) -> Unit
) {

    val team =
        teamDetails.team

    val venue =
        teamDetails.venue

    Text(
        text =
            team.name,
        style =
            MaterialTheme.typography.headlineSmall,
        fontWeight =
            FontWeight.SemiBold,
        maxLines =
            2,
        overflow =
            TextOverflow.Ellipsis
    )

    Spacer(
        modifier =
            Modifier.height(20.dp)
    )

    Surface(
        modifier =
            Modifier.fillMaxWidth(),
        shape =
            RoundedCornerShape(8.dp),
        color =
            MaterialTheme.colorScheme.surface,
        tonalElevation =
            1.dp
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            SectionTitle(
                text = "Club"
            )

            DetailRow(
                label = "Name",
                value = team.name
            )

            DetailRow(
                label = "Founded",
                value = team.founded.toDisplayText()
            )

            DetailRow(
                label = "Country",
                value = team.country
            )

            HorizontalDivider(
                modifier =
                    Modifier.padding(vertical = 10.dp),
                color =
                    MaterialTheme.colorScheme.outlineVariant
            )

            SectionTitle(
                text = "Stadium"
            )

            DetailRow(
                label = "Name",
                value = venue?.name.toDisplayText()
            )

            DetailRow(
                label = "Address",
                value = formatAddress(
                    venue?.address,
                    venue?.city
                )
            )

            DetailRow(
                label = "Capacity",
                value = venue?.capacity.toCapacityText()
            )
        }
    }

    Spacer(
        modifier =
            Modifier.height(16.dp)
    )

    Button(
        onClick = {
            onFixturesClick(
                team.name
            )
        },
        modifier =
            Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Fixtures"
        )
    }
}

@Composable
private fun SectionTitle(
    text: String
) {

    Text(
        text = text,
        style =
            MaterialTheme.typography.titleMedium,
        fontWeight =
            FontWeight.SemiBold,
        modifier =
            Modifier.padding(
                bottom = 8.dp
            )
    )
}

@Composable
private fun DetailRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 5.dp
            )
    ) {

        Text(
            text = label,
            modifier =
                Modifier.weight(0.42f),
            style =
                MaterialTheme.typography.bodyMedium,
            color =
                MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,
            modifier =
                Modifier.weight(0.58f),
            style =
                MaterialTheme.typography.bodyMedium,
            fontWeight =
                FontWeight.Medium
        )
    }
}

private fun String?.toDisplayText(): String =
    if (isNullOrBlank()) {
        "Not available"
    } else {
        this
    }

private fun Int.toDisplayText(): String =
    if (this <= 0) {
        "Not available"
    } else {
        toString()
    }

private fun Int?.toCapacityText(): String =
    if (this == null || this <= 0) {
        "Not available"
    } else {
        NumberFormat
            .getIntegerInstance()
            .format(this)
    }

private fun formatAddress(
    address: String?,
    city: String?
): String {

    val parts =
        listOfNotNull(
            address?.takeIf {
                it.isNotBlank()
            },
            city?.takeIf {
                it.isNotBlank()
            }
        )

    return if (parts.isEmpty()) {
        "Not available"
    } else {
        parts.joinToString(", ")
    }
}

private sealed interface TeamScreenState {

    data object Loading : TeamScreenState

    data class Ready(
        val teamDetails: TeamDetails
    ) : TeamScreenState

    data class Error(
        val message: String
    ) : TeamScreenState
}
