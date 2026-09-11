package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballapp.ui.theme.AppElevation
import com.example.footballapp.ui.theme.AppShapes
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun SectionCard(

    modifier: Modifier = Modifier,

    outerPadding: PaddingValues = PaddingValues(
        horizontal = AppSpacing.Screen,
        vertical = AppSpacing.Twelve
    ),

    innerPadding: PaddingValues = PaddingValues(
        AppSpacing.Twenty
    ),

    content: @Composable () -> Unit

) {

    Card(

        modifier = modifier
            .fillMaxWidth()
            .padding(outerPadding),

        shape = AppShapes.Card,

        elevation = CardDefaults.cardElevation(

            defaultElevation =
                AppElevation.Card

        ),

        colors = CardDefaults.cardColors(

            containerColor =
                MaterialTheme.colorScheme.surface

        )

    ) {

        Column(

            modifier = Modifier.padding(innerPadding)

        ) {

            content()

        }

    }

}