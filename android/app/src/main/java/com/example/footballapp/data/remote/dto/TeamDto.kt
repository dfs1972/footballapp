package com.example.footballapp.data.remote.dto

data class TeamDto(

    val id: Int,

    val name: String,

    val country: String? = null,

    val founded: Int? = null

)