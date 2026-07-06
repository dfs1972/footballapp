package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.theme.AppDimensions
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.theme.AppSpacing
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment

@Composable
fun StatusChip(

    text: String,

    modifier: Modifier = Modifier

) {

    Card(

        modifier = modifier
            .width(AppDimensions.StatusChipWidth)
            .height(AppDimensions.StatusChipHeight),

        shape = AppShapes.Button,

        elevation = CardDefaults.cardElevation(
            defaultElevation = AppSpacing.ExtraSmall
        )

    ) {

        Box(

            modifier = Modifier.fillMaxSize(),

            contentAlignment = Alignment.Center

        ) {

            Text(

                text = text,

                style = MaterialTheme.typography.labelMedium,

                fontWeight = FontWeight.SemiBold

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ScheduledChipPreview() {

    MaterialTheme {

        StatusChip("15:00")

    }

}

@Preview(showBackground = true)
@Composable
private fun LiveChipPreview() {

    MaterialTheme {

        StatusChip("LIVE")

    }

}

@Preview(showBackground = true)
@Composable
private fun FinishedChipPreview() {

    MaterialTheme {

        StatusChip("FT")

    }

}