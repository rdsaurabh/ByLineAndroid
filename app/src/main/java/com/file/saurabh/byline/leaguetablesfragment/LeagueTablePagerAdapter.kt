package com.file.saurabh.byline.leaguetablesfragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.file.saurabh.byline.legueclubs.League

class LeagueTablePagerAdapter(fragment: Fragment,val tabNames  : List<League>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return tabNames.size
    }

    override fun createFragment(position: Int): Fragment {
        return LeagueTableListFragment(tabNames[position].code)
    }
}