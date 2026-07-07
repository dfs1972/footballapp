package com.example.footballapp.ui.model

data class ClubDetailsUiModel(

    val clubId: Int,

    val name: String,

    val badgeUrl: String? = null,

    val league: String,

    val founded: Int? = null,

    val stadium: String? = null,

    val capacity: Int? = null,

    val manager: String? = null

)