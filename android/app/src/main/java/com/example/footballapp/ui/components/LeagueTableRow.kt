package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment

import com.example.footballapp.ui.model.LeagueTableRowUiModel
import com.example.footballapp.ui.model.QualificationType
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.theme.AppSpacing

@Composable
fun LeagueTableRow(

    row: LeagueTableRowUiModel,

    isEvenRow: Boolean,

    onClubClick: (Int) -> Unit

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
                onClubClick(row.teamId)
            }
            .padding(
                start = AppSpacing.Small,
                end = AppSpacing.Medium,
                top = AppSpacing.ExtraSmall,
                bottom = AppSpacing.ExtraSmall
            ),

        verticalAlignment = Alignment.CenterVertically

    ) {

        Text(
            text = row.position.toString(),
            modifier = Modifier.width(28.dp),
            fontWeight = FontWeight.SemiBold
        )

        ClubBadge(

            logoUrl = row.teamLogo,

            modifier = Modifier
                .size(AppDimensions.ImageSmall)
                .padding(
                    start = AppSpacing.ExtraSmall,
                    end = AppSpacing.Small
                )

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

            onClubClick = {}

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