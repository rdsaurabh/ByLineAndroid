package com.file.saurabh.byline.legueclubs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.file.saurabh.byline.network.FootballAPI
import com.file.saurabh.byline.network.moshipropertyclasses.Clubs
import kotlinx.coroutines.*

class ClubListViewModel : ViewModel() {
    private val job : Job = Job()
    private var coroutineScope : CoroutineScope = CoroutineScope(job + Dispatchers.Main)
    private var _clubs : MutableLiveData<Clubs> = MutableLiveData<Clubs>()

    fun getClubs() : LiveData<Clubs> {
        return _clubs
    }

    fun fetchClubsForLeagueCode(code : String){
            when(code){
                "PL" -> getPremierLeagueClubs()
                "PD" -> getLaLigaClubs()
                "BL1" ->getBundesLigaClubs()
                "SA" ->getSerieAClubs()
                "FL1" ->getFrenchLeagueClubs()
            }
    }

    private fun getFrenchLeagueClubs() {
        coroutineScope.launch {
            try{
                _clubs.value  = FootballAPI.footballServiceObject.getFrenchLeagueClubs().await()

            }catch (t : Throwable){
                Log.d("PL Teams",""+ t.message)
            }

        }
    }

    private fun getSerieAClubs() {
        coroutineScope.launch {
            try{
                _clubs.value  = FootballAPI.footballServiceObject.getSerieAClubs().await()

            }catch (t : Throwable){
                Log.d("PL Teams",""+ t.message)
            }

        }
    }

    private fun getBundesLigaClubs() {
        coroutineScope.launch {
            try{
                _clubs.value  = FootballAPI.footballServiceObject.getBundesligaClubs().await()

            }catch (t : Throwable){
                Log.d("PL Teams",""+ t.message)
            }

        }
    }

    private fun getLaLigaClubs() {
        coroutineScope.launch {
            try{
                _clubs.value  = FootballAPI.footballServiceObject.getLaLigaClubs().await()

            }catch (t : Throwable){
                Log.d("PL Teams",""+ t.message)
            }

        }
    }

    private fun getPremierLeagueClubs() {
        coroutineScope.launch {
            try{
                _clubs.value  = FootballAPI.footballServiceObject.getPremierLeagueClubs().await()
                Log.d("PL Teams",""+ _clubs.value!!.teams)
            }catch (t : Throwable){
                Log.d("PL Teams",""+ t.message)
            }

        }

    }

}