package com.example.footballapp.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppElevation

@Composable
fun CountryCard(

    countryName: String,

    competitionCount: Int,

    flagUrl: String?,

    expanded: Boolean,

    onClick: () -> Unit,

    modifier: Modifier = Modifier

) {

    val rotation by animateFloatAsState(

        targetValue =
            if (expanded) 180f else 0f,

        label = "CountryExpandRotation"

    )

    Card(

        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),

        elevation = CardDefaults.cardElevation(
            defaultElevation = AppElevation.Card
        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.Medium),

            verticalAlignment =
                Alignment.CenterVertically

        ) {

            /*
             * Country flag
             */

            if (!flagUrl.isNullOrBlank()) {

                AsyncImage(

                    model =
                        ImageRequest.Builder(
                            LocalContext.current
                        )
                            .data(flagUrl)
                            .decoderFactory(
                                SvgDecoder.Factory()
                            )
                            .build(),

                    contentDescription =
                        "$countryName flag",

                    modifier = Modifier
                        .size(32.dp)

                )

            }

            Spacer(
                modifier = Modifier.width(
                    AppSpacing.Medium
                )
            )

            /*
             * Country name and
             * competition count
             */

            Column(

                modifier =
                    Modifier.weight(1f)

            ) {

                Text(

                    text = countryName,

                    style =
                        MaterialTheme.typography.titleMedium

                )

                Text(

                    text =
                        "$competitionCount competitions",

                    style =
                        MaterialTheme.typography.bodySmall,

                    color =
                        MaterialTheme
                            .colorScheme
                            .onSurfaceVariant

                )

            }

            /*
             * Expand/collapse icon
             */

            Icon(

                imageVector =
                    Icons.Default.ExpandMore,

                contentDescription =
                    if (expanded) {
                        "Collapse $countryName"
                    } else {
                        "Expand $countryName"
                    },

                modifier =
                    Modifier.rotate(rotation),

                tint =
                    MaterialTheme
                        .colorScheme
                        .primary

            )

        }

    }

    /*
     * Small gap between country cards.
     */

    Spacer(
        modifier = Modifier.height(
            AppSpacing.ExtraSmall
        )
    )
}