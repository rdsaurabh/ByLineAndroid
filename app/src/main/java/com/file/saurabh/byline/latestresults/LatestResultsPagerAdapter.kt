package com.file.saurabh.byline.latestresults

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.file.saurabh.byline.legueclubs.League

class LatestResultsPagerAdapter(fragment : Fragment,val tabNames : List<League>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return  tabNames.size
    }

    override fun createFragment(position: Int): Fragment {
            return ResultsListFragment(tabNames[position].code)
    }
}