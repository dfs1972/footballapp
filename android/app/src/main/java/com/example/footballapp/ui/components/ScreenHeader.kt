package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun ScreenHeader(

    title: String,

    subtitle: String? = null,

    showBackButton: Boolean = false,

    onBackClick: (() -> Unit)? = null

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Medium
            )

    ) {

        Row(

            verticalAlignment = Alignment.CenterVertically

        ) {

            if (showBackButton && onBackClick != null) {

                IconButton(

                    onClick = onBackClick

                ) {

                    Icon(

                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,

                        contentDescription = "Back"

                    )

                }

            }

            Text(

                text = title,

                style = AppTypography.ScreenTitle

            )

        }

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

            subtitle = "Choose a competition to explore.",

            showBackButton = true,

            onBackClick = {}

        )

    }

}