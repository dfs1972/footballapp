package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import com.example.footballapp.ui.model.PlayerLineupUiModel

@Composable
fun PlayerLineupRow(

    player: PlayerLineupUiModel,

    onClick: () -> Unit

) {

    Row(

        modifier = Modifier.clickable {

            onClick()

        },

        horizontalArrangement =
            Arrangement.spacedBy(8.dp),

        verticalAlignment =
            Alignment.CenterVertically

    )  {

        Text(

            text =
                player.shirtNumber?.toString() ?: "-",

            modifier =
                Modifier.width(32.dp),

            style =
                MaterialTheme.typography.bodyMedium,

            fontWeight =
                FontWeight.Bold

        )

        Text(

            text = player.playerName,

            style =
                MaterialTheme.typography.bodyMedium

        )

        Spacer(

            modifier = Modifier.weight(1f)

        )

        Icon(

            imageVector = Icons.Default.ChevronRight,

            contentDescription = "Player details"

        )

    }

}