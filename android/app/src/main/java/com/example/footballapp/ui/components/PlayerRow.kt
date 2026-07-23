package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.model.PlayerUiModel
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun PlayerRow(

    player: PlayerUiModel,

    onClick: (PlayerUiModel) -> Unit,

    modifier: Modifier = Modifier

) {

    Row(

        modifier = modifier
            .fillMaxWidth()
            .clickable {

                onClick(player)

            },

        verticalAlignment = Alignment.CenterVertically

    ) {

        Row(

            modifier = Modifier.weight(1f),

            verticalAlignment = Alignment.Top

        ) {

            Box(

                modifier = Modifier.width(
                    AppDimensions.ShirtNumberWidth
                ),

                contentAlignment = Alignment.TopEnd

            ) {

                Text(

                    text = player.shirtNumber?.toString() ?: "-",

                    style = MaterialTheme.typography.bodyLarge,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

            Spacer(

                modifier = Modifier.width(
                    AppSpacing.Small
                )

            )

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    AppSpacing.ExtraSmall
                )

            ) {

                Text(

                    text = player.name,

                    style = MaterialTheme.typography.titleMedium

                )

                Text(

                    text = player.position,

                    //style = MaterialTheme.typography.bodyMedium,
                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

        }

        Icon(

            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}

//@Preview(showBackground = true)
//@Composable
//private fun PlayerRowPreview() {
//
//    MaterialTheme {
//
//        SectionCard {
//
//            PlayerRow(
//
//                player = PlayerUiModel(
//
//                    playerId = 1,
//
//                    shirtNumber = 2,
//
//                    name = "James Tavernier",
//
//                    position = "Defender"
//
//                ),
//
//                onClick = {}
//
//            )
//
//        }
//
//    }
//
//}