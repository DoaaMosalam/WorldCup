package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

object DataManger {
    private val matchesList = mutableListOf<Match>()
    val matches:List<Match>
        get() = matchesList.toList()
    private var matchesIndex = 0

    fun addMatches(match: Match){
        matchesList.add(match)
    }
    fun deleteMatchAt(index:Int){
        matchesList.removeAt(index)
    }
    fun addMatchIndex(match: Match,index:Int){
        matchesList.add(index,match)
    }

    fun getCurrentMatches():Match = matchesList[matchesIndex]

    fun getNextMatches():Match{
        matchesIndex++
        if (matchesIndex == matchesList.size){
            matchesIndex=0
        }
        return matchesList[matchesIndex]
    }

    fun getPreviousMatches():Match{
        matchesIndex--
        if (matchesIndex==-1){
            matchesIndex= matchesList.size-1
        }
        return matchesList[matchesIndex]

    }


}