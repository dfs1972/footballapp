package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.ClubDto
import com.example.footballapp.ui.model.ClubDetailsUiModel

fun ClubDto.toDetailsUiModel() =

    ClubDetailsUiModel(

        clubId = clubId,

        name = name,

        badgeUrl = null,

        league = "Scottish Premiership",

        founded = founded,

        stadium = stadium,

        capacity = capacity,

        manager = null

    )