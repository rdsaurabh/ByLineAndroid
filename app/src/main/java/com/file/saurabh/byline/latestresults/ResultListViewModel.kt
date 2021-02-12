package com.file.saurabh.byline.latestresults

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.file.saurabh.byline.network.FootballAPI
import com.file.saurabh.byline.network.moshipropertyclasses.Clubs
import com.file.saurabh.byline.network.moshipropertyclasses.Matchdays
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ResultListViewModel : ViewModel(){

    private val job : Job = Job()
    private var coroutineScope : CoroutineScope = CoroutineScope(job + Dispatchers.Main)
    private var _matchDays : MutableLiveData<Matchdays> = MutableLiveData<Matchdays>()


    fun getMatchdays() : LiveData<Matchdays> {
        return _matchDays
    }


    fun fetchLatestResults(code: String) {
        when(code){
            "PL" -> getPremierLeagueResults()
            "PD" -> getLaLigaResults()
            "BL1" ->getBundesLigaResults()
            "SA" ->getSerieAResults()
            "FL1" ->getFrenchLeagueResults()
        }
    }

    private fun getFrenchLeagueResults() {
        coroutineScope.launch {
            try{
                _matchDays.value = FootballAPI.footballServiceObject.getFrenchLeagueMatches().await()
            }catch (t : Throwable){
                Log.d("Results error", "" + t.message)
            }
        }
    }

    private fun getSerieAResults() {
        coroutineScope.launch {
            try{
                _matchDays.value = FootballAPI.footballServiceObject.getSerieAMatches().await()
            }catch (t : Throwable){
                Log.d("Results error", "" + t.message)
            }
        }
    }

    private fun getBundesLigaResults() {
        coroutineScope.launch {
            try{
                _matchDays.value = FootballAPI.footballServiceObject.getBundesligaMatches().await()
            }catch (t : Throwable){
                Log.d("Results error", "" + t.message)
            }
        }
    }

    private fun getLaLigaResults() {
        coroutineScope.launch {
            try{
                _matchDays.value = FootballAPI.footballServiceObject.getLaLigaMatches().await()
            }catch (t : Throwable){
                Log.d("Results error", "" + t.message)
            }
        }
    }

    private fun getPremierLeagueResults() {
        coroutineScope.launch {
            try{
                _matchDays.value = FootballAPI.footballServiceObject.getPremierLeagueMatches().await()
            }catch (t : Throwable){
                Log.d("Results error", "" + t.message)
            }
        }
    }

}