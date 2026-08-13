package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenScaffold(

    title: String? = null,

    subtitle: String? = null,

    modifier: Modifier = Modifier,

    showBackButton: Boolean = false,

    onBackClick: (() -> Unit)? = null,

    backgroundContent: (@Composable BoxScope.() -> Unit)? = null,

    listState: LazyListState = rememberLazyListState(),

    content: LazyListScope.() -> Unit

) {

    Box(

        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

    ) {

        /*
         * Decorative background.
         *
         * This is completely outside the LazyColumn,
         * so it never affects measurement or spacing.
         */

        backgroundContent?.invoke(this)

        /*
         * Scrolling screen content.
         *
         * The LazyColumn occupies the entire screen.
         * AppHeader is deliberately NOT placed inside it.
         */

        LazyColumn(

            state = listState,

            modifier = Modifier.fillMaxSize()

        ) {

            item {

                Spacer(
                    modifier = Modifier.height(160.dp)
                )

            }

            content()

        }
        /*
         * Fixed application header.
         *
         * This is outside the LazyColumn, so it remains
         * stationary while the screen content scrolls underneath it.
         *
         * It is placed last in the Box so that it is drawn
         * above the scrolling content.
         */

        AppHeader(

        )

    }

}