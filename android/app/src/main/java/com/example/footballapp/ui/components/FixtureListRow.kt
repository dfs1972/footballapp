package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun FixtureListRow(
    fixture: FixtureUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                vertical = AppSpacing.Small
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = fixture.homeTeamName,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.End,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = centreText(fixture),
            modifier = Modifier
                .padding(
                    horizontal = AppSpacing.Medium
                ),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = fixture.awayTeamName,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

private fun centreText(
    fixture: FixtureUiModel
): String {

    return when (fixture.status) {

        FixtureStatus.FINISHED,
        FixtureStatus.LIVE,
        FixtureStatus.HALF_TIME,
        FixtureStatus.EXTRA_TIME,
        FixtureStatus.PENALTIES -> {

            if (
                fixture.homeScore != null &&
                fixture.awayScore != null
            ) {
                "${fixture.homeScore} - ${fixture.awayScore}"
            } else {
                fixture.kickOff
            }
        }

        FixtureStatus.POSTPONED ->
            "P/P"

        FixtureStatus.CANCELLED ->
            "CAN"

        FixtureStatus.SCHEDULED ->
            fixture.kickOff
    }
}