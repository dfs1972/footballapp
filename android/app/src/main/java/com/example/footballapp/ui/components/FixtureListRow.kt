package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballapp.ui.model.FixtureStatus
import com.example.footballapp.ui.model.FixtureUiModel
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.util.FixtureStatusResolver

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
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Box(
            modifier = Modifier
                .padding(horizontal = AppSpacing.Medium)
                .width(80.dp),
            contentAlignment = Alignment.Center
        ) {
            val isLive = FixtureStatusResolver.isLive(fixture.status)
            if (isLive) {
                LiveChip(onClick = onClick)
            } else {
                Text(
                    text = centreText(fixture),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
        }

        Text(
            text = fixture.awayTeamName,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun LiveChip(onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = Color.Red,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(vertical = 2.dp)
    ) {
        Text(
            text = "LIVE",
            color = Color.White,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            letterSpacing = 1.sp
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