package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.design.AppSpacing.ExtraLarge

@Composable
fun LeagueTableHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(
                horizontal = AppSpacing.Medium,
                vertical = AppSpacing.Small
            )
    ) {

        Row(
            modifier = Modifier.weight(1f)
        ) {

            // Space for the position number
            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.width(22.dp)
            )

            // Space for the badge
            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.width(28.dp)
            )

            Text(
                text = Strings.TABLE_TEAM,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

        }

        HeaderCell(Strings.TABLE_PLAYED)
        HeaderCell(Strings.TABLE_WINS)
        HeaderCell(Strings.TABLE_DRAWS)
        HeaderCell(Strings.TABLE_LOSSES)
        HeaderCell(Strings.TABLE_POINTS)

    }

}

@Composable
private fun HeaderCell(

    text: String,

    modifier: Modifier = Modifier.width(ExtraLarge),

    textAlign: TextAlign = TextAlign.End

) {

    Text(

        text = text,

        modifier = modifier,

        textAlign = textAlign,

        style = MaterialTheme.typography.labelMedium,

        fontWeight = FontWeight.Bold,

        color = MaterialTheme.colorScheme.onSurfaceVariant

    )

}

@Preview(showBackground = true)
@Composable
private fun LeagueTableHeaderPreview() {

    MaterialTheme {

        LeagueTableHeader()

    }

}