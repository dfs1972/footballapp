package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.design.AppSpacing
import androidx.compose.ui.graphics.Color
import com.example.footballapp.ui.theme.HeaderBlue

@Composable
fun AppHeader(

    modifier: Modifier = Modifier,

    backgroundColor: Color = HeaderBlue

) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(backgroundColor)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = AppSpacing.Large),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoPlaceholder()

            Spacer(Modifier.width(AppSpacing.Large))

            SearchBarPlaceholder(
                modifier = Modifier.weight(1f)
            )

            Spacer(Modifier.width(AppSpacing.Large))

            AccountMenuButton()
        }
    }

}
