package com.example.footballapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun PlayerPhoto(

    photoUrl: String?,

    modifier: Modifier = Modifier

) {

    if (photoUrl.isNullOrBlank()) {

        PlaceholderPlayerPhoto(

            modifier = modifier

        )

    } else {

        AsyncImage(

            model = photoUrl,

            contentDescription = null,

            modifier = modifier
                .clip(CircleShape),

            contentScale = ContentScale.Crop

        )

    }

}

@Composable
private fun PlaceholderPlayerPhoto(

    modifier: Modifier = Modifier

) {

    Box(

        modifier = modifier
            .clip(CircleShape)
            .background(
                MaterialTheme.colorScheme.surfaceVariant
            )
            .border(

                width = AppDimensions.BadgeBorder,

                color = MaterialTheme.colorScheme.outlineVariant,

                shape = CircleShape

            ),

        contentAlignment = Alignment.Center

    ) {

        Icon(

            imageVector = Icons.Default.Person,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}

@Preview(showBackground = true)
@Composable
private fun PlayerPhotoPreview() {

    MaterialTheme {

        PlayerPhoto(

            photoUrl = null,

            modifier = Modifier.size(
                AppDimensions.ImageLarge
            )

        )

    }

}