package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.CountryDto
import com.example.footballapp.ui.model.CountryUiModel

fun CountryDto.toUiModel() =
    CountryUiModel(
        name = name,
        code = code,
        flag = flag
    )