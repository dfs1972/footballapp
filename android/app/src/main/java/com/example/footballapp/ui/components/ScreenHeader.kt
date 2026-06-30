package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.theme.AppSpacing
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun ScreenHeader(

    title: String,

    subtitle: String? = null

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Medium
            )

    ) {

        Text(

            text = title,

            style = AppTypography.ScreenTitle

        )

        subtitle?.let {

            Text(

                text = it,

                style = AppTypography.ScreenSubtitle,

                color = MaterialTheme.colorScheme.onSurfaceVariant,

                modifier = Modifier.padding(
                    top = AppSpacing.Small
                )

            )

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ScreenHeaderPreview() {

    MaterialTheme {

        ScreenHeader(

            title = "Competitions",

            subtitle = "Choose a competition to explore."

        )

    }

}