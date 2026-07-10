package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun TableDivider(

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = AppSpacing.Small
            ),

        verticalAlignment = Alignment.CenterVertically,

    ) {

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.outlineVariant
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.outlineVariant
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun EuropeQualificationDividerPreview() {

    MaterialTheme {

        TableDivider()

    }

}