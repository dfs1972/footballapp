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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun AppHeader(

    modifier: Modifier = Modifier,

    backgroundColor: Color =
        MaterialTheme.colorScheme.primary,

    searchQuery: String = "",

    onSearchQueryChange: (String) -> Unit = {},

    onAccountClick: () -> Unit = {},

    showBackButton: Boolean = false,

    onBackClick: () -> Unit = {}

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
                .padding(
                    horizontal = AppSpacing.Large
                ),

            verticalAlignment =
                Alignment.CenterVertically

        ) {

            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                
                Spacer(Modifier.width(AppSpacing.Small))
            } else {
                LogoPlaceholder()
            }

            Spacer(
                Modifier.width(
                    AppSpacing.Large
                )
            )

            SearchBar(

                modifier =
                    Modifier.weight(1f),

                query = searchQuery,

                onQueryChange =
                    onSearchQueryChange

            )

            Spacer(
                Modifier.width(
                    AppSpacing.Large
                )
            )

            AccountMenuButton(
                onClick = onAccountClick
            )

        }

    }

}