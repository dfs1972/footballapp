package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.PlayerDetailsDto
import com.example.footballapp.ui.model.PlayerDetailsUiModel

fun PlayerDetailsDto.toUiModel() =
    PlayerDetailsUiModel(

        playerId = playerId,

        name = displayName,

        photoUrl = photoUrl,

        shirtNumber = shirtNumber,

        position = position,

        nationality = nationality,

        dateOfBirth = birthDate,

        age = age,

        height = height,

        weight = weight,

        preferredFoot = null,

        captain = captain,

        starts = starts,

        appearances = appearances,

        goals = goals,

        assists = assists,

        yellowCards = yellowCards,

        redCards = redCards,

        minutesPlayed = minutes

    )