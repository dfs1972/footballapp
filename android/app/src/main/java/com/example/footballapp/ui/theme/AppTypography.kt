package com.example.footballapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

object AppTypography {

    val ScreenTitle: TextStyle
        @Composable
        get() = MaterialTheme.typography.headlineLarge

    val ScreenSubtitle: TextStyle
        @Composable
        get() = MaterialTheme.typography.bodyLarge

    val SectionHeading: TextStyle
        @Composable
        get() = MaterialTheme.typography.labelLarge

    val Body: TextStyle
        @Composable
        get() = MaterialTheme.typography.bodyLarge

}