package com.file.saurabh.byline.newsfragment

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.FragmentNewsBinding



class NewsFragment(val queryParameter : String = "soccer-football") : Fragment(),NewsViewAdapter.NewsViewCardClickedListener {
     private  lateinit var newsViewModel: NewsViewModel
     private lateinit var newsRecyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentNewsBinding>(inflater,R.layout.fragment_news,container,false)
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)


        binding.lifecycleOwner = viewLifecycleOwner
        binding.newsViewModel = newsViewModel

        newsViewModel.fetchTopHeadlines(queryParameter)

        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsRecyclerView = view.findViewById(R.id.topHeadlinesRecyclerView)
        newsRecyclerView.layoutManager = LinearLayoutManager(context)

        val newsViewAdapter =  NewsViewAdapter(this)
        newsRecyclerView.adapter = newsViewAdapter
        newsRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))


        newsViewModel.getTopHeadlines().observe(viewLifecycleOwner, Observer {
            it?.let {
                newsViewAdapter.updateArticleList(it.articles)
            }
        })



    }

    override fun onNewsViewCardClicked(context : Context,url: String) {
         CustomTabsIntent.Builder()
             .build()
             .launchUrl(context, Uri.parse(url))

    }




}