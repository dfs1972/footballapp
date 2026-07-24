package com.example.footballapp.data.mapper

import com.example.footballapp.data.remote.dto.CompetitionGroupDto
import com.example.footballapp.ui.model.CompetitionGroupUiModel
import com.example.footballapp.ui.model.CompetitionUiModel

fun CompetitionGroupDto.toUiModel() =

    CompetitionGroupUiModel(

        title = country,

        headerIcon = headerIcon,

        displayOrder = displayOrder,

        leagues =

            competitions
                .filter { it.type == "LEAGUE" }
                .map {

                    CompetitionUiModel(

                        id = it.competitionId,

                        name = it.name,

                        country = country,

                        logoUrl = it.logoUrl

                    )

                },

        domesticCups =

            competitions
                .filter { it.type == "CUP" }
                .map {

                    CompetitionUiModel(

                        id = it.competitionId,

                        name = it.name,

                        country = country,

                        logoUrl = it.logoUrl

                    )

                }

    )