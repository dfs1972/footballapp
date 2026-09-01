package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.example.footballapp.ui.design.Strings

@Composable
fun InfoRow(

    label: String,

    value: String?,

    modifier: Modifier = Modifier,

    emptyText: String = Strings.NOT_AVAILABLE

) {

    val displayValue =
        value
            ?.takeIf { it.isNotBlank() }
            ?: emptyText

    Row(

        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppSpacing.ExtraSmall),

        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Text(

            text = label,

            style = MaterialTheme.typography.bodySmall,

            color = MaterialTheme.colorScheme.onSurfaceVariant,

            fontWeight = FontWeight.Medium

        )

        Text(

            text = displayValue,

            modifier = Modifier.weight(1f),

            textAlign = TextAlign.End,

            maxLines = 2,

            style = MaterialTheme.typography.bodyLarge,

            fontWeight = FontWeight.Medium

        )

    }

}