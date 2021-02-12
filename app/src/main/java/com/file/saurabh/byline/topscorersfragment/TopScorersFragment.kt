package com.file.saurabh.byline.topscorersfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.file.saurabh.byline.R
import com.file.saurabh.byline.Utils.LIST_OF_LEAGUES
import com.file.saurabh.byline.databinding.FragmentTopScorersBinding
import com.file.saurabh.byline.legueclubs.League
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class TopScorersFragment : Fragment() {
    private lateinit var topScorersPager : ViewPager2
    private val tabNames : MutableList<League> = LIST_OF_LEAGUES

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTopScorersBinding>(inflater,R.layout.fragment_top_scorers,container,false)
        topScorersPager = binding.topScorersPager
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout : TabLayout = view.findViewById(R.id.topScorerTabLayout)
        topScorersPager.adapter = TopScorerPagerAdapter(this,tabNames)

        TabLayoutMediator(tabLayout,topScorersPager){ tab: TabLayout.Tab, position: Int ->
            tab.text = tabNames[position].name
        }.attach()

    }


}