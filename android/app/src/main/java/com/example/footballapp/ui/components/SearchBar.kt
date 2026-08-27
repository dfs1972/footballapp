package com.example.footballapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.footballapp.ui.design.AppSpacing

@Composable
fun SearchBar(

    modifier: Modifier = Modifier,

    query: String = "",

    onQueryChange: (String) -> Unit = {}

) {

    Surface(

        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),

        shape =
            RoundedCornerShape(24.dp),

        color =
            Color.White,

        shadowElevation =
            2.dp

    ) {

        Row(

            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal =
                            AppSpacing.Medium
                    ),

            verticalAlignment =
                Alignment.CenterVertically

        ) {

            Icon(

                imageVector =
                    Icons.Default.Search,

                contentDescription =
                    "Search",

                tint =
                    Color.Gray

            )

            Spacer(
                modifier =
                    Modifier.width(
                        AppSpacing.Small
                    )
            )

            TextField(

                value = query,

                onValueChange =
                    onQueryChange,

                modifier =
                    Modifier.fillMaxWidth(),

                placeholder = {

                    Text(
                        text =
                            "Search competitions, clubs, players...",

                        style =
                            MaterialTheme
                                .typography
                                .bodyMedium,

                        color =
                            Color.Gray
                    )

                },

                singleLine = true,

                colors =
                    TextFieldDefaults.colors(

                        focusedContainerColor =
                            Color.Transparent,

                        unfocusedContainerColor =
                            Color.Transparent,

                        disabledContainerColor =
                            Color.Transparent,

                        focusedIndicatorColor =
                            Color.Transparent,

                        unfocusedIndicatorColor =
                            Color.Transparent,

                        disabledIndicatorColor =
                            Color.Transparent

                    )

            )

        }

    }

}