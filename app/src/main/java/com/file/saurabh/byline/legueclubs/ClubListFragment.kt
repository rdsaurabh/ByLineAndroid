package com.file.saurabh.byline.legueclubs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.FragmentClubListBinding


class ClubListFragment(val code : String) : Fragment() {

    private lateinit var clubListRecyclerView :RecyclerView
    lateinit var clubListViewModel: ClubListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = DataBindingUtil.inflate<FragmentClubListBinding>(inflater,R.layout.fragment_club_list,container,false)
        clubListRecyclerView = binding.clubListRecyclerView
        clubListViewModel = ViewModelProvider(this).get(ClubListViewModel::class.java)
        clubListViewModel.fetchClubsForLeagueCode(code)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clubListRecyclerView.layoutManager = LinearLayoutManager(view.context)

        val clubRecyclerViewAdapter = ClubListRecyclerViewAdapter()
        clubListRecyclerView.adapter = clubRecyclerViewAdapter

        clubListRecyclerView.addItemDecoration(
            DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL)
        )

        clubListViewModel.getClubs().observe(viewLifecycleOwner){
            it?.let {
                clubRecyclerViewAdapter.updateClubsList(it.teams)
            }
        }


    }


}