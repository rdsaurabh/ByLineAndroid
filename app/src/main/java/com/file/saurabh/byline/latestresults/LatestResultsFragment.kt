package com.file.saurabh.byline.latestresults

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.file.saurabh.byline.R
import com.file.saurabh.byline.Utils.LIST_OF_LEAGUES
import com.file.saurabh.byline.databinding.FragmentLatestResultsBinding
import com.file.saurabh.byline.legueclubs.League
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LatestResultsFragment : Fragment() {

    private lateinit var matchesViewPager: ViewPager2
    private lateinit var matchesTabLayout : TabLayout

    private val tabsNames : MutableList<League> = LIST_OF_LEAGUES

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLatestResultsBinding>(inflater, R.layout.fragment_latest_results,container,false)

        matchesViewPager = binding.matchesViewPager
        matchesTabLayout = binding.matchesTabLayout

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchesViewPager.adapter = LatestResultsPagerAdapter(this,tabsNames)
        TabLayoutMediator(matchesTabLayout,matchesViewPager){ tab: TabLayout.Tab, position: Int ->
            tab.text = tabsNames[position].name
        }.attach()
    }


}