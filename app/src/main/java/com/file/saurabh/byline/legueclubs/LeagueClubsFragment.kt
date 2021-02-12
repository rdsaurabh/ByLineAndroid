package com.file.saurabh.byline.legueclubs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.file.saurabh.byline.R
import com.file.saurabh.byline.Utils.LIST_OF_LEAGUES
import com.file.saurabh.byline.databinding.FragmentLeagueClubsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LeagueClubsFragment : Fragment() {

    private lateinit var clubsPager : ViewPager2


    private var tabNames : MutableList<League> = LIST_OF_LEAGUES

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLeagueClubsBinding>(inflater,R.layout.fragment_league_clubs,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clubsPager = view.findViewById(R.id.clubListPager)
        val tabLayout : TabLayout = view.findViewById(R.id.clubListTabLayout)
        clubsPager.adapter = ClubsPagerAdapter(this,tabNames)

        TabLayoutMediator(tabLayout,clubsPager){ tab: TabLayout.Tab, position: Int ->
            tab.text = tabNames[position].name
        }.attach()

    }

}