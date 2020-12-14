package com.file.saurabh.byline.newsfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.file.saurabh.byline.network.NewsAPI
import com.file.saurabh.byline.network.moshipropertyclasses.TopHeadlinesProperty
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewsViewModel : ViewModel() {

    private  val topHeadlines : MutableLiveData<TopHeadlinesProperty> = MutableLiveData()
    private  val job : Job = Job()
    private val coroutineScope : CoroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun getTopHeadlines() : LiveData<TopHeadlinesProperty>{
        return topHeadlines
    }




    fun fetchTopHeadlines() {

        val currentDate = LocalDateTime.now().minusHours(48)

        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val fromDate  : String = currentDate.format(dateFormatter)


        coroutineScope.launch {
            val deferred : Deferred<TopHeadlinesProperty> = NewsAPI.newsServiceObject.getTopHeadlines(fromDate)

            try{
                val topHeadlinesProperty : TopHeadlinesProperty = deferred.await()
                topHeadlines.value = topHeadlinesProperty

            }catch (t : Throwable){
                Log.d("NewsViewModel","" + t.message)

            }

        }


    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}