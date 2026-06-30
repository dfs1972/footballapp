package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.theme.AppSpacing

@Composable
fun SectionCard(

    modifier: Modifier = Modifier,

    content: @Composable () -> Unit

) {

    Card(

        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSpacing.Screen,
                vertical = AppSpacing.Small
            ),

        shape = AppShapes.Card,

        elevation = CardDefaults.cardElevation(

            defaultElevation = AppElevation.Card

        ),

        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.surface

        )

    ) {

        Column(

            modifier = Modifier.padding(

                AppSpacing.Medium

            )

        ) {

            content()

        }

    }

}