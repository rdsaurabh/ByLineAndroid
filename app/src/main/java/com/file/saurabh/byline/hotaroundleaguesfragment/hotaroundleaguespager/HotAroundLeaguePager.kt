package com.file.saurabh.byline.hotaroundleaguesfragment.hotaroundleaguespager


import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.file.saurabh.byline.newsfragment.NewsFragment


class HotAroundLeaguePagerAdapter(fragment : Fragment,var allTabs : List<String>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return  allTabs.size
    }

    override fun createFragment(position: Int): Fragment {
        val queryParameter : String = allTabs[position]
        return NewsFragment(queryParameter)
    }




}