package com.example.footballapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun NavigationCard(

    title: String,

    subtitle: String,

    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Small
            )
            .clickable(onClick = onClick),

        shape = AppShapes.Card,

        elevation = CardDefaults.cardElevation(

            defaultElevation = AppElevation.Card

        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.Medium),

            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Column {

                Text(

                    text = title,

                    style = MaterialTheme.typography.titleMedium

                )

                Text(

                    text = subtitle,

                    style = MaterialTheme.typography.bodyMedium,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

            Icon(

                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,

                contentDescription = null

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun NavigationCardPreview() {

    MaterialTheme {

        NavigationCard(

            title = "League Table",

            subtitle = "View complete standings",

            onClick = {}

        )

    }

}