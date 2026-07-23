package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.test.espresso.base.Default
import com.example.footballapp.ui.design.AppSpacing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsSoccer
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun LogoPlaceholder(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.SportsSoccer,
            contentDescription = "Match Day",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(32.dp)
        )

        Spacer(
            modifier = Modifier.width(AppSpacing.Small)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LogoPlaceholderPreview() {

    Box(
        modifier = Modifier
            .background(HeaderBlue)
            .padding(16.dp)
    ) {
        LogoPlaceholder()
    }
}