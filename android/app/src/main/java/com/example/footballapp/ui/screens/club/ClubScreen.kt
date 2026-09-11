package com.example.footballapp.ui.screens.club

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballapp.data.local.UserLogoManager
import com.example.footballapp.ui.components.ClubHeaderCard
import com.example.footballapp.ui.components.NavigationCard
import com.example.footballapp.ui.components.ScreenScaffold
import com.example.footballapp.ui.design.AppSpacing
import com.example.footballapp.ui.model.ClubDetailsUiModel
import com.example.footballapp.ui.model.CountryUiModel
import kotlinx.coroutines.launch

@Composable
fun ClubScreen(

    leagueName: String,

    season: Int,

    club: ClubDetailsUiModel,

    onSquadClick: (Int) -> Unit,

    onFixturesClick: (Int) -> Unit,

    searchQuery: String = "",

    onSearchQueryChange: (String) -> Unit = {},

    searchResults: List<CountryUiModel> = emptyList(),

    onSearchResultClick: (CountryUiModel) -> Unit = {},

    onAccountClick: () -> Unit = {}

) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            coroutineScope.launch {
                UserLogoManager.saveTeamLogo(context, club.clubId, uri)
            }
        }
    }

    ScreenScaffold(
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        searchResults = searchResults,
        onSearchResultClick = onSearchResultClick,
        onAccountClick = onAccountClick
    ) {

        item {

            Spacer(
                modifier = Modifier.height(
                    AppSpacing.ExtraLarge
                )
            )

        }

        item {

            ClubHeaderCard(
                club = club,
                leagueName = leagueName
            )

        }

        /*
         * Navigation
         */

        item {

            NavigationCard(

                title = "Squad",

                subtitle = "View first-team squad",

                onClick = {

                    onSquadClick(

                        club.clubId

                    )

                }

            )

        }

        item {

            NavigationCard(

                title = "Fixtures",

                subtitle = "Current and upcoming matches",

                onClick = {

                    onFixturesClick(

                        club.clubId

                    )

                }

            )

        }

    }

}