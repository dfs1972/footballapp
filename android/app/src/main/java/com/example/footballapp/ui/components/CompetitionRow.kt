package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.CompetitionUiModel
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun CompetitionRow(

    competition: CompetitionUiModel,

    onClick: () -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(AppSpacing.Large)
            .clickable { onClick() }
            .padding(horizontal = AppSpacing.Medium),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement =
            Arrangement.SpaceBetween

    ) {

        Column {

            Text(
                text = competition.name,
                style = AppTypography.Body,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(

                text = competition.type,

                style = MaterialTheme.typography.bodySmall,

                color =
                    MaterialTheme
                        .colorScheme
                        .onSurfaceVariant

            )

        }

        Icon(

            imageVector =
                Icons.AutoMirrored.Filled.KeyboardArrowRight,

            contentDescription = null,

            tint =
                MaterialTheme
                    .colorScheme
                    .onSurfaceVariant

        )

    }
}