package com.example.worldcup.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcup.R
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ItemMatchBinding


class MatchesAdapter(private var matchesList: List<Match>,private val listener: MatchInteractionListener)
    :RecyclerView.Adapter<MatchesAdapter.MatchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder( LayoutInflater.from(parent.context)
            .inflate(R.layout.item_match,parent,false))
    }

    override fun getItemCount()=  matchesList.size


    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentMatches = matchesList[position]
        //using data binding
       holder.binding.apply{
           year.text = currentMatches.year.toString()
           teamOneName.text = currentMatches.homeTeamName
           teamTwoName.text = currentMatches.awayTeamName
           teamOneGoals.text = currentMatches.homeTeamGoal.toString()
           teamTwoGoals.text = currentMatches.awayTeamGoal.toString()
           studiemName.text = currentMatches.stadium

           //appear winner team green color and appear loser name team red color
           if (currentMatches.homeTeamGoal > currentMatches.awayTeamGoal){
               teamOneGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
               teamTwoGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.red))
           }else if (currentMatches.homeTeamGoal < currentMatches.awayTeamGoal){
               teamTwoGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
               teamOneGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.red))
           }
           //Click Listener,first click appear name team, second click intent details class
           teamOneName.setOnClickListener { listener.onclickNameTeam(currentMatches.homeTeamName) }
           teamTwoName.setOnClickListener { listener.onclickNameTeam(currentMatches.awayTeamName) }
           iconDelete.setOnClickListener { listener.deleteItemAt(position) }
           root.setOnClickListener { listener.onClickItem(currentMatches) }

       }
        //*********************** original code ******************************
        /*holder.apply {
            year.text = currentMatches.year.toString()
            teamOneName.text = currentMatches.homeTeamName
            teamTwoName.text = currentMatches.awayTeamName
            teamOneGoal.text=currentMatches.homeTeamGoal.toString()
            teamTwoGoal.text=currentMatches.awayTeamGoal.toString()
        }*/

    }
//inner class View Holder
    class MatchViewHolder(viewHolder: View) :RecyclerView.ViewHolder(viewHolder) {
        // using data Binding
        val binding= ItemMatchBinding.bind(viewHolder)

    }
    fun setData(newList:List<Match>){
        val diffResult = DiffUtil.calculateDiff(MatchDiffUtil(matchesList,newList))
        matchesList = newList
        diffResult.dispatchUpdatesTo(this)
//        matchesList = newList
//        notifyDataSetChanged()

    }


}