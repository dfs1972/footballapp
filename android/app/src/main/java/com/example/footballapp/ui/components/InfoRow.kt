package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun InfoRow(

    label: String,

    value: String?,

    modifier: Modifier = Modifier

) {

    if (!value.isNullOrBlank()) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = AppSpacing.Small)
        ) {

            Text(

                text = label,

                style = MaterialTheme.typography.labelMedium,

                color = MaterialTheme.colorScheme.onSurfaceVariant

            )

            Text(

                text = value,

                modifier = Modifier.padding(
                    top = AppSpacing.ExtraSmall
                ),

                style = MaterialTheme.typography.bodyLarge,

                fontWeight = FontWeight.Medium

            )

        }
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
