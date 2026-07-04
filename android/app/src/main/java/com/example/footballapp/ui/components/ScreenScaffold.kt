package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.ui.theme.AppSpacing

@Composable
fun ScreenScaffold(

    title: String,

    subtitle: String,

    modifier: Modifier = Modifier,

    content: LazyListScope.() -> Unit

) {

    Surface(

        modifier = modifier.fillMaxSize(),

        color = MaterialTheme.colorScheme.background

    ) {

        LazyColumn(

            modifier = Modifier.fillMaxSize(),

            contentPadding = PaddingValues(

                vertical = AppSpacing.Medium

            )

        ) {

            item {

                ScreenHeader(

                    title = title,

                    subtitle = subtitle

                )

            }

            content()

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenScaffoldPreview() {

    ScreenScaffold(

        title = "Preview",

        subtitle = "Reusable screen scaffold"

    ) {

        item {

            SectionCard {

                SectionHeading(

                    text = "Example"

                )

            }

        }

    }

}