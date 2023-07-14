package com.example.worldcup.util

import com.example.worldcup.data.domain.Match

class CSVParser {
    fun parse(line:String):Match{
        val token = line.split(",")
        return Match(
            year = token[Constants.ColumIndex.YEAR].toInt(),
            stadium = token[Constants.ColumIndex.STADIUM],
            city = token[Constants.ColumIndex.CITY],
            homeTeamName = token[Constants.ColumIndex.HOME_TEAM_NAME],
            awayTeamName = token[Constants.ColumIndex.AWAY_TEAM_NAME],
            homeTeamGoal = token[Constants.ColumIndex.HOME_TEAM_GOAL].toInt(),
            awayTeamGoal = token[Constants.ColumIndex.AWAY_TEAM_GOAL].toInt()

        )
    }
}