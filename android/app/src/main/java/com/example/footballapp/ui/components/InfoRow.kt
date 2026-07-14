package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.Strings
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun InfoRow(

    label: String,

    value: String?,

    emptyText: String = Strings.NOT_AVAILABLE

) {

    val displayValue =

        value
            ?.takeIf { it.isNotBlank() }
            ?: emptyText

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = displayValue,
            style = MaterialTheme.typography.bodyMedium
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun InfoRowPreview() {

    MaterialTheme {

        SectionCard {

            InfoRow(

                label = "Founded",

                value = "1872"

            )

        }

    }
}
