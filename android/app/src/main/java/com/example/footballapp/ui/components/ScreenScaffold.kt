package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScreenScaffold(

    title: String? = null,

    subtitle: String? = null,

    modifier: Modifier = Modifier,

    showBackButton: Boolean = false,

    onBackClick: (() -> Unit)? = null,

    backgroundContent: (@Composable BoxScope.() -> Unit)? = null,

    content: LazyListScope.() -> Unit

) {

    val listState = rememberLazyListState()

    Box(

        modifier = modifier
            .fillMaxSize()

    ) {

        /*
         * Decorative background.
         *
         * This is completely outside the LazyColumn,
         * so it never affects measurement or spacing.
         */

        backgroundContent?.invoke(this)

        /*
         * Foreground content.
         */

        LazyColumn(

            state = listState,

            modifier = Modifier.fillMaxSize()

        ) {

            if (title != null || subtitle != null) {

                item {

                    if (title != null) {

                        Text(
                            text = title,
                            style = MaterialTheme.typography.headlineMedium
                        )

                    }

                    if (subtitle != null) {

                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodyMedium
                        )

                    }

                }

            }

            content()

        }

    }

}