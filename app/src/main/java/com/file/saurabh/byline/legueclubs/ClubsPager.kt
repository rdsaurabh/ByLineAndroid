package com.file.saurabh.byline.legueclubs

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ClubsPagerAdapter(fragment: Fragment,val tabNames  : List<League>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return tabNames.size
    }

    override fun createFragment(position: Int): Fragment {
        return ClubListFragment(tabNames[position].code)
    }

}