package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.theme.AppSpacing
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun CompetitionRow(

    competition: CompetitionUiModel,
    onClick: () -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable { onClick() }
            .padding(horizontal = AppSpacing.Medium),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Row(

            verticalAlignment = Alignment.CenterVertically

        ) {

            Box(

                modifier = Modifier.size(AppDimensions.CompetitionLogo),

                contentAlignment = Alignment.Center

            ) {

                AsyncImage(
                    model = competition.logoUrl,
                    contentDescription = competition.name
                )

            }

            Text(

                text = competition.name,

                style = AppTypography.Body,

                modifier = Modifier.padding(
                    start = AppSpacing.Medium
                )

            )

        }

        Icon(

            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )
    }
}
@Preview(showBackground = true)
@Composable
private fun CompetitionRowPreview() {

    CompetitionRow(

        competition = PreviewData.ScottishPremiership,

        onClick = {}

    )
}