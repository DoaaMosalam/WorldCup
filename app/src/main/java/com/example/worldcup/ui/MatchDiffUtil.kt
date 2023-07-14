package com.example.worldcup.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.worldcup.data.domain.Match

class MatchDiffUtil(var mOldList: List<Match> ,var mNewList: List<Match>) :DiffUtil.Callback() {

    override fun getOldListSize() = mOldList.size

    override fun getNewListSize()= mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
               mOldList[oldItemPosition].homeTeamName == mNewList[newItemPosition].homeTeamName
                       && mOldList[oldItemPosition].awayTeamGoal == mNewList[newItemPosition].awayTeamGoal
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}