package com.example.worldcup.ui

import com.example.worldcup.data.domain.Match

interface MatchInteractionListener {
    fun onClickItem(match:Match)
    fun onclickNameTeam(name:String)
    fun deleteItemAt(index:Int)
}