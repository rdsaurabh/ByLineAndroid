package com.file.saurabh.byline.leaguetablesfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.file.saurabh.byline.network.FootballAPI
import com.file.saurabh.byline.network.moshipropertyclasses.Clubs
import com.file.saurabh.byline.network.moshipropertyclasses.LeagueTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LeagueTableListViewModel : ViewModel() {
    private val job : Job = Job()
    private var coroutineScope : CoroutineScope = CoroutineScope(job + Dispatchers.Main)
    private var _leagueTable : MutableLiveData<LeagueTable> = MutableLiveData<LeagueTable>()

    fun getLeagueTable() : LiveData<LeagueTable>{
        return _leagueTable
    }

    fun fetchLeagueTable(code: String) {
        when(code){
            "PL" -> getPremierLeagueTable()
            "PD" -> getLaLigaTable()
            "BL1" ->getBundesLigaTable()
            "SA" ->getSerieATable()
            "FL1" ->getFrenchLeagueTable()
        }
    }

    private fun getFrenchLeagueTable() {
        coroutineScope.launch {
            try {
                _leagueTable.value = FootballAPI.footballServiceObject.getFrenchLeagueStandings().await()
            }catch (t : Throwable){
                Log.d("League Tables","" + t.message)
            }



        }
    }

    private fun getSerieATable() {
        coroutineScope.launch {
            try {
                _leagueTable.value = FootballAPI.footballServiceObject.getSerieAStandings().await()
            }catch (t : Throwable){
                Log.d("League Tables","" + t.message)
            }



        }
    }

    private fun getBundesLigaTable() {
        coroutineScope.launch {
            try {
                _leagueTable.value = FootballAPI.footballServiceObject.getBundesligaStandings().await()
            }catch (t : Throwable){
                Log.d("League Tables","" + t.message)
            }



        }
    }

    private fun getLaLigaTable() {
        coroutineScope.launch {
            try {
                _leagueTable.value = FootballAPI.footballServiceObject.getLaLigaStandings().await()
            }catch (t : Throwable){
                Log.d("League Tables","" + t.message)
            }



        }
    }

    private fun getPremierLeagueTable() {
        coroutineScope.launch {
            try {
                _leagueTable.value = FootballAPI.footballServiceObject.getPremierLeagueStandings().await()
            }catch (t : Throwable){
                Log.d("League Tables","" + t.message)
            }



        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}