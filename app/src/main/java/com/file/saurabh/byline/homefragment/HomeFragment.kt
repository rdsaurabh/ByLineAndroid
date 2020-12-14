package com.file.saurabh.byline.homefragment

import com.file.saurabh.byline.Pager.NewsPagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    private lateinit var  newsPagerAdapter : NewsPagerAdapter
    private lateinit var viewPager : ViewPager2

    private  val tabNames : List<String> = listOf("Top News","My Club")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager = view.findViewById(R.id.pager)
        val tabLayout : TabLayout = view.findViewById(R.id.tab_layout)

        newsPagerAdapter = NewsPagerAdapter(this)
        viewPager.adapter = newsPagerAdapter

        TabLayoutMediator(tabLayout,viewPager){ tab: TabLayout.Tab, position: Int ->
            tab.text = tabNames[position]
        }.attach()


    }

}