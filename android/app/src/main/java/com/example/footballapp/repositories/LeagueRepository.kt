package com.example.footballapp.repositories

import com.example.footballapp.model.TableRow

class LeagueRepository {

    fun getLeagueTable(): List<TableRow> {

        return listOf(
            TableRow(1, "Celtic", 81),
            TableRow(2, "Rangers", 66),
            TableRow(3, "Hibernian", 53),
            TableRow(4, "Dundee United", 50)
        )
    }
}