package com.file.saurabh.byline.Pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.file.saurabh.byline.newsfragment.NewsFragment

class  NewsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val tabSize : Int = 2;


    override fun getItemCount(): Int {
        return tabSize
    }

    override fun createFragment(position: Int): Fragment {
        val fragment : Fragment = NewsFragment()
        return fragment
    }

}