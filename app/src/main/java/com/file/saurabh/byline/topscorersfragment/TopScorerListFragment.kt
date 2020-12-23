
package com.file.saurabh.byline.topscorersfragment

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
import com.file.saurabh.byline.databinding.FragmentTopScoreListBinding


class TopScorerListFragment(val code :String) : Fragment() {
    private lateinit var topScorerListRecyclerView : RecyclerView
    lateinit var topScorerListViewModel: TopScorerListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTopScoreListBinding>(inflater,R.layout.fragment_top_score_list,container,false)
        topScorerListRecyclerView = binding.topScoreListRecyclerView
        topScorerListViewModel = ViewModelProvider(this).get(TopScorerListViewModel::class.java)

        topScorerListViewModel.fetchTopScorers(code)


        binding.topScoreListViewModel = topScorerListViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topScorerListRecyclerView.layoutManager = LinearLayoutManager(view.context)

        val topScorerListRecyclerViewAdapter = TopScorerListRecyclerViewAdapter()

        topScorerListRecyclerView.adapter = topScorerListRecyclerViewAdapter

        topScorerListRecyclerView.addItemDecoration(
                DividerItemDecoration(context,
                        DividerItemDecoration.VERTICAL)
        )

        topScorerListViewModel.getTopScorers().observe(viewLifecycleOwner){
            it?.let {
                topScorerListRecyclerViewAdapter.updateScorerList(it.scorers)
            }

        }

    }
}



