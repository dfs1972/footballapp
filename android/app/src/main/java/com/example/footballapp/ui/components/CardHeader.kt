package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun CardHeader(

    title: String,

    subtitle: String? = null

) {

    Text(

        text = title,

        modifier = Modifier.fillMaxWidth(),

        textAlign = TextAlign.Center,

        style = MaterialTheme.typography.titleMedium,

        fontWeight = FontWeight.Bold

    )

    if (subtitle != null) {

        Spacer(
            modifier = Modifier.height(AppSpacing.ExtraSmall)
        )

        SectionHeading(

            text = subtitle,

            centered = true

        )

    }

    Spacer(
        modifier = Modifier.height(AppSpacing.Small)
    )

}