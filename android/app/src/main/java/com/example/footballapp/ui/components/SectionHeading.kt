package com.example.footballapp.ui.components

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
fun SectionHeading(

    text: String

) {

    Text(

        text = text.uppercase(),

        style = AppTypography.SectionHeading,

        color = MaterialTheme.colorScheme.onSurfaceVariant,

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = AppSpacing.Section,
                bottom = AppSpacing.Small
            )

    )

}

@Preview(showBackground = true)
@Composable
private fun SectionHeadingPreview() {

    MaterialTheme {

        SectionHeading(

            text = "Leagues"

        )

    }

}