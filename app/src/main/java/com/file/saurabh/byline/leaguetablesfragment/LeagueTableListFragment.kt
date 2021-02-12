package com.file.saurabh.byline.leaguetablesfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.FragmentLeagueTableListBinding


class LeagueTableListFragment(val code :String) : Fragment() {
    private lateinit var leagueTableRecyclerView : RecyclerView
    private lateinit  var leagueTableListViewModel : LeagueTableListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLeagueTableListBinding>(inflater,R.layout.fragment_league_table_list,container,false)
        leagueTableRecyclerView = binding.leagueTableRecyclerView
        leagueTableListViewModel = ViewModelProvider(this).get(LeagueTableListViewModel::class.java)
        leagueTableListViewModel.fetchLeagueTable(code)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leagueTableRecyclerView.layoutManager = LinearLayoutManager(view.context)
        val  leagueTableRecyclerViewAdapter = LeagueTableRecyclerViewAdapter()
        leagueTableRecyclerView.adapter = leagueTableRecyclerViewAdapter
        leagueTableRecyclerView.addItemDecoration(
                DividerItemDecoration(context,
                        DividerItemDecoration.VERTICAL)
        )

        leagueTableListViewModel.getLeagueTable().observe(viewLifecycleOwner){
                leagueTableRecyclerViewAdapter.updateLeagueTable(it.standings[0].table)

        }



    }


}