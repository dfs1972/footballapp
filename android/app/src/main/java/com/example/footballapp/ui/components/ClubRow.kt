package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.ClubUiModel
import com.example.footballapp.ui.previews.PreviewData
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun ClubRow(

    club: ClubUiModel,

    onClick: (ClubUiModel) -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick(club)

            }
            .padding(vertical = AppSpacing.Small),

        verticalAlignment = Alignment.CenterVertically

    ) {

        ClubBadge(

            logoUrl = club.badgeUrl,

            modifier = Modifier
                .size(AppDimensions.ImageMedium)
                .padding(end = AppSpacing.Medium)

        )

        Spacer(

            modifier = Modifier.width(
                AppSpacing.Medium
            )

        )

        Column(

            modifier = Modifier.weight(1f)

        ) {

            Text(

                text = club.shortName ?: club.name,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.SemiBold

            )

            club.stadium?.let {

                Text(

                    text = it,

                    modifier = Modifier.padding(
                        top = AppSpacing.ExtraSmall
                    ),

                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

        }

        Icon(

            imageVector = Icons.Default.ChevronRight,

            contentDescription = "Open Club",

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}

/**
 * Preview
 */
@Preview(showBackground = true)
@Composable
private fun ClubRowPreview() {

    MaterialTheme {

        SectionCard {

            ClubRow(

                club = PreviewData.Celtic,

                onClick = {}

            )

        }

    }

}