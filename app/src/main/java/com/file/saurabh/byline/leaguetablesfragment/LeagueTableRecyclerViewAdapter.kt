package com.file.saurabh.byline.leaguetablesfragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.file.saurabh.byline.R
import com.file.saurabh.byline.Utils.SVGUtils
import com.file.saurabh.byline.databinding.LeagueTableItemLayoutBinding
import com.file.saurabh.byline.network.moshipropertyclasses.LeagueTable

class LeagueTableRecyclerViewAdapter : RecyclerView.Adapter<LeagueTableRecyclerViewAdapter.LeagueTableViewHolder>() {

    private val leagueTable : MutableList<LeagueTable.Table> = mutableListOf<LeagueTable.Table>()
    class LeagueTableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamPositionTextView : TextView = itemView.findViewById(R.id.teamPositionTextView)
        val clubCrestInLeagueTableImageView : ImageView = itemView.findViewById(R.id.clubCrestInLeagueTable)
        val matchesPlayedTextView : TextView = itemView.findViewById(R.id.matchesPlayedTextView)
        val matchesWonTextView : TextView = itemView.findViewById(R.id.matchesWonTextView)
        val matchesDrawnTextView : TextView = itemView.findViewById(R.id.matchesDrawnTextView)
        val matchesLostTextView : TextView = itemView.findViewById(R.id.matchesLostTextView)
        val goalDifferenceTextView : TextView = itemView.findViewById(R.id.goalDifferenceTextView)
        val pointsTextView : TextView = itemView.findViewById(R.id.pointsTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueTableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LeagueTableItemLayoutBinding>(inflater, R.layout.league_table_item_layout,parent,false)


        return LeagueTableViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: LeagueTableViewHolder, position: Int) {
        holder.teamPositionTextView.text = leagueTable[position].position.toString()
                    SVGUtils.fetchSvg(holder.itemView.context,leagueTable[position].team.crestUrl,holder.clubCrestInLeagueTableImageView)
        holder.matchesPlayedTextView.text = leagueTable[position].playedGames.toString()
        holder.matchesWonTextView.text = leagueTable[position].won.toString()
        holder.matchesDrawnTextView.text = leagueTable[position].draw.toString()
        holder.matchesLostTextView.text = leagueTable[position].lost.toString()
        holder.goalDifferenceTextView.text = leagueTable[position].goalDifference.toString()
        holder.pointsTextView.text = leagueTable[position].points.toString()

        val currentTeamsFormGuide: LeagueTable.Table = leagueTable[position]
        holder.itemView.setOnClickListener {

            it.findNavController().navigate(LeagueTablesFragmentDirections.actionLeagueTablesFragmentToFormGuideFragment(currentTeamsFormGuide))

        }

    }

    override fun getItemCount(): Int {

        return  leagueTable.size
    }

    fun updateLeagueTable(newTable: List<LeagueTable.Table>) {
        leagueTable.clear()
        leagueTable.addAll(newTable)
        notifyDataSetChanged()
    }
}