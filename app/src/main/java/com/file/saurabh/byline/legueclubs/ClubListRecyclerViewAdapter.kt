package com.file.saurabh.byline.legueclubs


import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

import com.file.saurabh.byline.R
import com.file.saurabh.byline.Utils.SVGUtils
import com.file.saurabh.byline.databinding.ClubItemLayoutBinding
import com.file.saurabh.byline.network.moshipropertyclasses.Team

class ClubListRecyclerViewAdapter :
    RecyclerView.Adapter<ClubListRecyclerViewAdapter.ClubListRecyclerViewHolder>() {

    private var currentTeams : MutableList<Team> = mutableListOf<Team>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubListRecyclerViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding  = DataBindingUtil.inflate<ClubItemLayoutBinding>(layoutInflater, R.layout.club_item_layout,parent,false)

        return ClubListRecyclerViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ClubListRecyclerViewHolder, position: Int) {
        holder.clubNameTextView.text = "" + currentTeams[position].name
        SVGUtils.fetchSvg(holder.itemView.context,currentTeams[position].crestUrl,holder.clubCrestImageView)

        val context : Context = holder.itemView.context.applicationContext

        holder.itemView.setOnClickListener {
            val sharedPreferences : SharedPreferences.Editor = context
                    .getSharedPreferences(context.getString(R.string.my_club_preference),Context.MODE_PRIVATE)
                    .edit()

            sharedPreferences.putString(context.getString(R.string.my_club_key),currentTeams[position].name.replace("FC","").trim())
            sharedPreferences.putString(context.getString(R.string.my_club_crest_key),currentTeams[position].crestUrl)

            sharedPreferences.commit()

            holder.itemView.findNavController().popBackStack()



        }
    }

    override fun getItemCount(): Int {
        return currentTeams.size
    }

    fun updateClubsList(newTeams: List<Team>) {
        currentTeams.clear()
        currentTeams.addAll(newTeams)
        notifyDataSetChanged()
    }

    class ClubListRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val clubNameTextView : TextView = itemView.findViewById(R.id.clubItemTextView)
            val clubCrestImageView : ImageView = itemView.findViewById(R.id.clubCrestImageView)

    }


}