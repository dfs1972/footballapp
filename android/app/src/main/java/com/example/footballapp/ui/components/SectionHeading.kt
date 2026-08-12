package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.theme.AppTypography

@Composable
fun SectionHeading(

    text: String,

    centered: Boolean = false

) {

    Text(

        text = text,

        modifier = Modifier.fillMaxWidth(),

        textAlign =
            if (centered)
                TextAlign.Center
            else
                TextAlign.Start,

        style = MaterialTheme.typography.titleSmall,

        fontWeight = FontWeight.Bold,

        color = MaterialTheme.colorScheme.onSurfaceVariant,

    )

}