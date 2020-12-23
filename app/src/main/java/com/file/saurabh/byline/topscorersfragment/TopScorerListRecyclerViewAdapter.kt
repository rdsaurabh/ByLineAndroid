package com.file.saurabh.byline.topscorersfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.TopScorerListItemLayoutBinding
import com.file.saurabh.byline.network.moshipropertyclasses.TopScorers


class TopScorerListRecyclerViewAdapter : RecyclerView.Adapter<TopScorerListRecyclerViewAdapter.TopScorerViewHolder>() {

    private var topScorersList :  MutableList<TopScorers.Scorer> = mutableListOf<TopScorers.Scorer>()


    class TopScorerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val scorerNameTextView : TextView = itemView.findViewById(R.id.goalScorerTextView)
        val playersTeamTextView : TextView = itemView.findViewById(R.id.playersTeamTextView)
        val goalsCountTextView : TextView = itemView.findViewById(R.id.goalsCountTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScorerViewHolder {
       val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)


        val binding  = DataBindingUtil.inflate<TopScorerListItemLayoutBinding>(layoutInflater, R.layout.top_scorer_list_item_layout,parent,false)

        return TopScorerViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TopScorerViewHolder, position: Int) {
        holder.goalsCountTextView.text = "" + topScorersList[position].numberOfGoals
        holder.scorerNameTextView.text =  topScorersList[position].player.name.toString()
        holder.playersTeamTextView.text = topScorersList[position].team.name
    }

    override fun getItemCount(): Int {
        return topScorersList.size
    }

    fun updateScorerList(newTopScorers: List<TopScorers.Scorer>) {
        topScorersList.clear()
        topScorersList.addAll(newTopScorers)
        notifyDataSetChanged()
    }
}