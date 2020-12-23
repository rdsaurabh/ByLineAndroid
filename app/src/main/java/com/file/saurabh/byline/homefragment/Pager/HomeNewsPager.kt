package com.file.saurabh.byline.homefragment.Pager



import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.file.saurabh.byline.ChooseClubFragment
import com.file.saurabh.byline.R
import com.file.saurabh.byline.newsfragment.NewsFragment

class  NewsPagerAdapter(val  fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val tabSize : Int = 2
    private lateinit  var sharedPreferences : SharedPreferences
    override fun getItemCount(): Int {
        return tabSize
    }

    override fun createFragment(position: Int): Fragment {


         if(position == 0){
           return  NewsFragment()
        }else{
            val context : Context = fragment.requireContext().applicationContext

             sharedPreferences = context
                    .getSharedPreferences(context.getString(R.string.my_club_preference),Context.MODE_PRIVATE)

            val resultString : String? = sharedPreferences.getString(context.getString(R.string.my_club_key),context.getString(R.string.no_club_chosen))

            Log.d("Fir Aya","Pehla")
            resultString?.let {
                if(resultString != context.getString(R.string.no_club_chosen)){
                    return NewsFragment(it)
                }

            }




        }


        return ChooseClubFragment()
    }




}