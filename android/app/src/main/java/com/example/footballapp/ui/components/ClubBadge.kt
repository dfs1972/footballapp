package com.example.footballapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.footballapp.R
import com.example.footballapp.ui.theme.AppDimensions

@Composable
fun ClubBadge(

    logoUrl: String?,

    modifier: Modifier = Modifier

) {

    if (logoUrl.isNullOrBlank()) {

        Image(

            painter = painterResource(
                R.drawable.badge_rangers_257
            ),

            contentDescription = null,

            modifier = modifier

                .clip(CircleShape),

            contentScale = ContentScale.Fit

        )

    } else {

        AsyncImage(

            model = logoUrl,

            contentDescription = null,

            modifier = modifier

                .clip(CircleShape),

            contentScale = ContentScale.Fit

        )
    }
}

@Composable
fun PreviewTeamBadge(

    modifier: Modifier = Modifier

) {

    Box(

        modifier = modifier
            .size(AppDimensions.ClubBadgeMedium)
            .clip(CircleShape)

    ) {

        androidx.compose.foundation.Image(

            painter = painterResource(

                R.drawable.badge_rangers_257

            ),

            contentDescription = null,

            modifier = Modifier.matchParentSize(),

            contentScale = ContentScale.Fit

        )

    }

}

@Composable
private fun PlaceholderBadge(

    modifier: Modifier = Modifier

) {

    Box(

        modifier = modifier
            .size(AppDimensions.ClubBadgeMedium)
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

            imageVector = Icons.Default.SportsSoccer,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}