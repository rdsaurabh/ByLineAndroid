package com.file.saurabh.byline.latestresults

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.LatestResultsItemLayoutBinding
import com.file.saurabh.byline.network.moshipropertyclasses.Matchdays

class LatestResultsRecyclerViewAdapter : RecyclerView.Adapter<LatestResultsRecyclerViewAdapter.LatestResultsViewHolder>() {

    private var matches : MutableList<Matchdays.Match> = mutableListOf()

    class LatestResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val homeTeamTextView : TextView = itemView.findViewById(R.id.homeTeamTextView)
      val awayTeamTextView : TextView = itemView.findViewById(R.id.awayTeamTextView)
      val homeTeamScore : TextView = itemView.findViewById(R.id.homeTeamScore)
      val awayTeamScore : TextView = itemView.findViewById(R.id.awayTeamScore)  
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestResultsViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LatestResultsItemLayoutBinding>(inflater, R.layout.latest_results_item_layout,parent,false)
        return LatestResultsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: LatestResultsViewHolder, position: Int) {
        holder.homeTeamTextView.text = matches[position].homeTeam.name
        holder.awayTeamTextView.text = matches[position].awayTeam.name

        matches[position].score.fullTime.homeTeam?.let{
             holder.homeTeamScore.text = it.toString()
        }

        matches[position].score.fullTime.awayTeam?.let{
            holder.awayTeamScore.text = it.toString()
        }



    }

    override fun getItemCount(): Int {
        return matches.size
    }

    fun updateMatches(newMatches: MutableList<Matchdays.Match>) {
        matches.clear()
        matches.addAll(newMatches)
        notifyDataSetChanged()
    }
}
