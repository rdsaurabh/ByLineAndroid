package com.file.saurabh.byline.hotaroundleaguesfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.file.saurabh.byline.homefragment.Pager.NewsPagerAdapter
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.FragmentHotAroundLeaguesBinding
import com.file.saurabh.byline.hotaroundleaguesfragment.hotaroundleaguespager.HotAroundLeaguePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HotAroundLeaguesFragment : Fragment() {


    private lateinit var hotAroundLeaguesViewPager : ViewPager2

    private var tabNames : MutableList<String> = mutableListOf("Premier League",
            "La Liga",
            "Bundesliga",
            "Serie A",
            "Ligue 1")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = DataBindingUtil.inflate<FragmentHotAroundLeaguesBinding>(inflater,R.layout.fragment_hot_around_leagues,container,false)


        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        hotAroundLeaguesViewPager = view.findViewById(R.id.HotAroundLeaguespager)
        val tabLayout : TabLayout = view.findViewById(R.id.HotAroundLeaguesTabLayout)
        hotAroundLeaguesViewPager.adapter = HotAroundLeaguePagerAdapter(this,tabNames)

        TabLayoutMediator(tabLayout,hotAroundLeaguesViewPager){ tab: TabLayout.Tab, position: Int ->
            tab.text = tabNames[position]
        }.attach()




    }

}