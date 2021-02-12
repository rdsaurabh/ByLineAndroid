package com.file.saurabh.byline.latestresults

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.FragmentResultsListBinding
import com.file.saurabh.byline.network.moshipropertyclasses.Matchdays


class ResultsListFragment(val code : String) : Fragment() {


    private lateinit var latestResultRecyclerView : RecyclerView

    private lateinit var resultListViewModel : ResultListViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentResultsListBinding>(inflater,R.layout.fragment_results_list,container,false)
        resultListViewModel = ViewModelProvider(this).get(ResultListViewModel::class.java)
        resultListViewModel.fetchLatestResults(code)

        latestResultRecyclerView  = binding.resultListRecyclerView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latestResultRecyclerView.layoutManager = LinearLayoutManager(view.context)

        val latestResultsRecyclerViewAdapter = LatestResultsRecyclerViewAdapter()
        latestResultRecyclerView.adapter = latestResultsRecyclerViewAdapter

        latestResultRecyclerView.addItemDecoration(
                DividerItemDecoration(context,
                        DividerItemDecoration.VERTICAL)
        )

        resultListViewModel.getMatchdays().observe(viewLifecycleOwner){
            it?.let {

              val matches : List<Matchdays.Match> = it.matches

              val currentMatchday : Int = matches[0].season.currentMatchday

             val latestResultsList : MutableList<Matchdays.Match> = mutableListOf()

                for(match in matches){

                    if(match.matchday == currentMatchday){
                        latestResultsList.add(match)
                    }
                }

                latestResultsRecyclerViewAdapter.updateMatches(latestResultsList)


            }
        }

    }


}