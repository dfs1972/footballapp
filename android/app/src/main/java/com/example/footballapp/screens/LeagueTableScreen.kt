package com.example.footballapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballapp.AppState
import com.example.footballapp.model.TableRow
import com.example.footballapp.repositories.LeagueApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LeagueTableScreen(
    onTeamClick: (Int) -> Unit
) {

    var tableState by remember {
        mutableStateOf<LeagueTableState>(
            LeagueTableState.Loading
        )
    }

    LaunchedEffect(
        AppState.selectedLeagueId,
        AppState.selectedSeason
    ) {

        tableState =
            LeagueTableState.Loading

        tableState =
            withContext(
                Dispatchers.IO
            ) {

                runCatching {
                    LeagueApiRepository()
                        .getLeagueTable(
                            AppState.selectedLeagueId,
                            AppState.selectedSeason
                        )
                }.fold(
                    onSuccess = { rows ->
                        LeagueTableState.Ready(rows)
                    },
                    onFailure = { error ->
                        LeagueTableState.Error(
                            error.message
                                ?: "Unable to load league table"
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

        Text(
            text =
                AppState.selectedLeagueName,
            style =
                MaterialTheme.typography.headlineSmall,
            fontWeight =
                FontWeight.SemiBold
        )

        Text(
            text =
                "Season ${AppState.selectedSeason}",
            style =
                MaterialTheme.typography.bodyMedium,
            color =
                MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier =
                Modifier.height(20.dp)
        )

        when (val state = tableState) {

            LeagueTableState.Loading -> {
                Text(
                    text = "Loading table...",
                    style =
                        MaterialTheme.typography.bodyMedium
                )
            }

            is LeagueTableState.Error -> {
                Text(
                    text = state.message,
                    style =
                        MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.error
                )
            }

            is LeagueTableState.Ready -> {
                LeagueTable(
                    table = state.table,
                    onTeamClick = onTeamClick
                )
            }
        }
    }
}

@Composable
private fun LeagueTable(
    table: List<TableRow>,
    onTeamClick: (Int) -> Unit
) {

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

        Column {

            LeagueTableHeader()

            HorizontalDivider(
                color =
                    MaterialTheme.colorScheme.outlineVariant
            )

            LazyColumn(
                modifier =
                    Modifier.fillMaxWidth()
            ) {

                itemsIndexed(
                    table,
                    key = { _, row ->
                        row.teamId
                    }
                ) { index, row ->

                    LeagueTableRowItem(
                        row = row,
                        isEvenRow = index % 2 == 0,
                        onTeamClick = onTeamClick
                    )

                    HorizontalDivider(
                        color =
                            MaterialTheme.colorScheme.outlineVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun LeagueTableHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant
            )
            .padding(
                horizontal = 10.dp,
                vertical = 10.dp
            ),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        TableHeaderCell(
            text = "#",
            modifier =
                Modifier.width(32.dp),
            textAlign =
                TextAlign.Start
        )

        TableHeaderCell(
            text = "Club",
            modifier =
                Modifier.weight(1f),
            textAlign =
                TextAlign.Start
        )

        TableHeaderCell("P")
        TableHeaderCell("W")
        TableHeaderCell("D")
        TableHeaderCell("L")
        TableHeaderCell("GD")
        TableHeaderCell("Pts")
    }
}

@Composable
private fun LeagueTableRowItem(
    row: TableRow,
    isEvenRow: Boolean,
    onTeamClick: (Int) -> Unit
) {

    val rowColor =
        if (isEvenRow) {
            MaterialTheme.colorScheme.surface
        } else {
            MaterialTheme.colorScheme.surfaceVariant.copy(
                alpha = 0.35f
            )
        }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(rowColor)
            .clickable {
                onTeamClick(row.teamId)
            }
            .padding(
                horizontal = 10.dp,
                vertical = 11.dp
            ),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(
            text =
                row.position.toString(),
            modifier =
                Modifier.width(32.dp),
            style =
                MaterialTheme.typography.bodyMedium,
            fontWeight =
                FontWeight.Medium
        )

        Column(
            modifier =
                Modifier.weight(1f),
            verticalArrangement =
                Arrangement.Center
        ) {

            Text(
                text =
                    row.teamName,
                style =
                    MaterialTheme.typography.bodyMedium,
                fontWeight =
                    FontWeight.SemiBold,
                maxLines =
                    1,
                overflow =
                    TextOverflow.Ellipsis
            )
        }

        TableValueCell(row.played.toString())
        TableValueCell(row.wins.toString())
        TableValueCell(row.draws.toString())
        TableValueCell(row.losses.toString())
        TableValueCell(
            row.goalDifference.toSignedText()
        )
        TableValueCell(
            text = row.points.toString(),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun TableHeaderCell(
    text: String,
    modifier: Modifier = Modifier.width(34.dp),
    textAlign: TextAlign = TextAlign.End
) {

    Text(
        text = text,
        modifier =
            modifier,
        style =
            MaterialTheme.typography.labelMedium,
        color =
            MaterialTheme.colorScheme.onSurfaceVariant,
        fontWeight =
            FontWeight.Bold,
        textAlign =
            textAlign,
        maxLines =
            1
    )
}

@Composable
private fun TableValueCell(
    text: String,
    fontWeight: FontWeight = FontWeight.Normal
) {

    Text(
        text = text,
        modifier =
            Modifier.width(34.dp),
        style =
            MaterialTheme.typography.bodyMedium,
        fontWeight =
            fontWeight,
        textAlign =
            TextAlign.End,
        maxLines =
            1,
        color =
            Color.Unspecified
    )
}

private fun Int.toSignedText(): String =
    if (this > 0) {
        "+$this"
    } else {
        toString()
    }

private sealed interface LeagueTableState {

    data object Loading : LeagueTableState

    data class Ready(
        val table: List<TableRow>
    ) : LeagueTableState

    data class Error(
        val message: String
    ) : LeagueTableState
}
