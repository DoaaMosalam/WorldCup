package com.example.worldcup.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.worldcup.data.DataManger
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.util.CSVParser
import com.example.worldcup.util.Constants
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity:BaseActivity<ActivityMainBinding> (),MatchInteractionListener {
    override val LOG_TAG: String = "MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    lateinit var adapter :MatchesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
        addCallBacks()
    }

    override fun setUp() {
        parseFile()
        adapter = MatchesAdapter(DataManger.matches,this)
        binding!!.recyclerView.adapter = adapter

    }

    override fun addCallBacks() {
        binding!!.fab.setOnClickListener {
            addFinalMatch()

        }
//        _binding?.apply {
//            nextIcon.setOnClickListener {
//                bindMatch(DataManger.getNextMatches())
//            }
//            prevoisIcon.setOnClickListener {
//                bindMatch(DataManger.getPreviousMatches())
//            }
//
//        }

    }

    private fun addFinalMatch() {
        val finalMatch = Match(
            year = 2022,
            stadium = "Qatar",
            city = "Qatar",
            homeTeamName = "Algentine",
            awayTeamName = "France",
            homeTeamGoal = 5,
            awayTeamGoal = 3,
        )
        DataManger.addMatchIndex(finalMatch,0)
        adapter.setData(DataManger.matches)

    }


    private fun parseFile() {
        val inputStream = assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CSVParser()
        buffer.forEachLine {
            val currentMatch = parser.parse(it)
//            log(currentMatch)
            DataManger.addMatches(currentMatch)
        }
//        bindMatch(DataManger.getCurrentMatches())
    }

    override fun onClickItem(match: Match) {
        Intent(this, DetailsActivity::class.java).also {
            it.putExtra(Constants.Key.MATCH,match.toString())
            startActivity(it)
        }
    }


    override fun onclickNameTeam(name: String) {
        Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
    }

    override fun deleteItemAt(index: Int) {
       DataManger.deleteMatchAt(index)
        adapter.setData(DataManger.matches)
    }

//    private fun bindMatch(matches: Match) {
//        _binding?.apply {
//            year.text = matches.year.toString()
//            studiemName.text = matches.stadium
//            teamOneName.text = matches.homeTeamName
//            teamTwoName.text = matches.awayTeamName
//            teamOneGoals.text = matches.homeTeamGoal.toString()
//            teamTwoGoals.text = matches.awayTeamGoal.toString()
//
//        }
//    }
}