package com.file.saurabh.byline.topscorersfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.file.saurabh.byline.network.FootballAPI
import com.file.saurabh.byline.network.FootballService
import com.file.saurabh.byline.network.moshipropertyclasses.Clubs
import com.file.saurabh.byline.network.moshipropertyclasses.TopScorers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TopScorerListViewModel : ViewModel() {

    private val job : Job = Job()
    private var coroutineScope : CoroutineScope = CoroutineScope(job + Dispatchers.Main)
    private var _topScorers : MutableLiveData<TopScorers> = MutableLiveData<TopScorers>()

    fun getTopScorers() : LiveData<TopScorers>{
        return _topScorers
    }

    fun fetchTopScorers(code: String) {



            when(code){
                "PL" -> getPremierLeagueTopScorers()
                "PD" -> getLaLigaTopScorers()
                "BL1" ->getBundesligaTopScorers()
                "SA" ->getSerieATopScorers()
                "FL1" ->getFrenchLeagueTopScorers()
            }


    }

    private fun getFrenchLeagueTopScorers() {
        coroutineScope.launch {
            try {
                _topScorers.value = FootballAPI.footballServiceObject.getFrenchLeagueTopScorers().await()
            }catch (t : Throwable){
                Log.d("TopScorer","" + t.message)
            }

        }
    }

    private fun getSerieATopScorers() {
        coroutineScope.launch {
            try {
                _topScorers.value = FootballAPI.footballServiceObject.getSerieATopScorers().await()
            }catch (t : Throwable){
                Log.d("TopScorer","" + t.message)
            }

        }
    }

    private fun getBundesligaTopScorers() {
        coroutineScope.launch {
            try {
                _topScorers.value = FootballAPI.footballServiceObject.getBundesligaTopScorers().await()
            }catch (t : Throwable){
                Log.d("TopScorer","" + t.message)
            }

        }
    }

    private fun getLaLigaTopScorers() {
        coroutineScope.launch {
            try {
                _topScorers.value = FootballAPI.footballServiceObject.getLaLigaTopScorers().await()
            }catch (t : Throwable){
                Log.d("TopScorer","" + t.message)
            }

        }
    }

    private fun getPremierLeagueTopScorers() {
            coroutineScope.launch {
                try {
                    _topScorers.value = FootballAPI.footballServiceObject.getPremierLeagueTopScorers().await()
                }catch (t : Throwable){
                    Log.d("TopScorer","" + t.message)
                }

            }
    }


}