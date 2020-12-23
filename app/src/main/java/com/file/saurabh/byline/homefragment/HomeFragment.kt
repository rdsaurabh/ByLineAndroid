package com.file.saurabh.byline.homefragment

import android.content.Context
import android.content.SharedPreferences
import com.file.saurabh.byline.homefragment.Pager.NewsPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.viewpager2.widget.ViewPager2
import com.file.saurabh.byline.R
import com.file.saurabh.byline.Utils.SVGUtils
import com.file.saurabh.byline.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import de.hdodenhof.circleimageview.CircleImageView


class HomeFragment : Fragment() {
    private lateinit var  newsPagerAdapter : NewsPagerAdapter
    private lateinit var viewPager : ViewPager2


    private  val tabNames : List<String> = listOf("Top News","My CLUB")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)
        setHasOptionsMenu(true)

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

        val menuItem : MenuItem  = menu.getItem(0)
        val view = menuItem.actionView

        val clubCrestImageView : ImageView = view.findViewById(R.id.club_crest_circle_image_view)

        clubCrestImageView.setOnClickListener {
            Log.d("ImageView","Circle Image View")
            findNavController().navigate(R.id.action_homeFragment_to_leagueClubsFragment)
        }

        val context : Context = view.context.applicationContext
        val sharedPreferences : SharedPreferences = context
                .getSharedPreferences(context.getString(R.string.my_club_preference),Context.MODE_PRIVATE)

        val myCulbCrestURL = sharedPreferences.getString(context.getString(R.string.my_club_crest_key),"")
        if (myCulbCrestURL != null) {
            if(myCulbCrestURL.isNotEmpty())
                SVGUtils.fetchSvg(context,myCulbCrestURL,clubCrestImageView)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }





}