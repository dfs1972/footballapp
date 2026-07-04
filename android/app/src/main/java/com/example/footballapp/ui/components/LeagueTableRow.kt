package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

import coil.compose.AsyncImage
import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppSpacing
import androidx.compose.foundation.background

@Composable
fun LeagueTableRow(

    row: LeagueTableRowUiModel,

    isEvenRow: Boolean,

    onTeamClick: (Int) -> Unit

) {

    val backgroundColor =
        row.qualification.backgroundColor(
            isEvenRow
        )

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.small
            )
            .clickable {
                onTeamClick(row.teamId)
            }
            .padding(
                start = AppSpacing.Small,
                end = AppSpacing.Medium,
                top = AppSpacing.ExtraSmall,
                bottom = AppSpacing.ExtraSmall
            )
    ) {

        Text(
            text = row.position.toString(),
            modifier = Modifier.width(28.dp),
            fontWeight = FontWeight.SemiBold
        )

        AsyncImage(
            model = row.teamLogo,
            contentDescription = row.teamName,
            modifier = Modifier
                .size(24.dp)
                .padding(end = AppSpacing.Small)
        )

        Text(
            text = row.teamName,
            modifier = Modifier.weight(1f),
            maxLines = 1
        )

        ValueCell(row.played.toString())
        ValueCell(row.wins.toString())
        ValueCell(row.draws.toString())
        ValueCell(row.losses.toString())

        ValueCell(
            text = row.points.toString(),
            fontWeight = FontWeight.Bold
        )

    }
}
@Composable
private fun ValueCell(

    text: String,

    fontWeight: FontWeight = FontWeight.Normal

) {

    Text(

        text = text,

        modifier = Modifier.width(28.dp),

        textAlign = TextAlign.End,

        fontWeight = fontWeight

    )

}

@Preview(showBackground = true)
@Composable
private fun LeagueTableRowPreview() {

    MaterialTheme {

        LeagueTableRow(

            row = PreviewData.ScottishPremiershipTable.first(),

            isEvenRow = true,

            onTeamClick = {}

        )
    }
}

@Composable
private fun QualificationType.backgroundColor(
    isEvenRow: Boolean
): Color {

    return when (this) {

        QualificationType.CHAMPION ->
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.18f)

        QualificationType.RELEGATION ->
            MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.18f)

        QualificationType.SAFE ->
            MaterialTheme.colorScheme.surface

    }

}