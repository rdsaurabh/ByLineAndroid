package com.file.saurabh.byline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.file.saurabh.byline.databinding.FragmentChooseClubBinding


class ChooseClubFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding : FragmentChooseClubBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_choose_club,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.chooseClubButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_leagueClubsFragment)
        }


        return binding.root
    }


}