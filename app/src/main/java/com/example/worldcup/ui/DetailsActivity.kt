package com.example.worldcup.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.os.bundleOf
import com.example.worldcup.data.DataManger
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityDetailsBinding
import com.example.worldcup.util.Constants

class DetailsActivity :BaseActivity<ActivityDetailsBinding>(){
    override val LOG_TAG: String="DETAILS_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityDetailsBinding = ActivityDetailsBinding::inflate

    override fun setUp() {
        val match: Match? = intent.getStringExtra(Constants.Key.MATCH) as Match?
        match?.let { bindMatch(it) }
    }

    private fun bindMatch(matches: Match) {
        binding?.apply {
            year.text = matches.year.toString()
            studiemName.text = matches.stadium
            teamOneName.text = matches.homeTeamName
            teamTwoName.text = matches.awayTeamName
            teamOneGoals.text = matches.homeTeamGoal.toString()
            teamTwoGoals.text = matches.awayTeamGoal.toString()

        }
    }

    override fun addCallBacks() {

    }


}