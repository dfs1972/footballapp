package com.example.footballapp.ui.model

data class ClubUiModel(

    val clubId: Int,

    val name: String,

    val shortName: String? = null,

    val badgeUrl: String? = null,

    val stadium: String? = null

)