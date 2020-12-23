package com.file.saurabh.byline.network

import com.file.saurabh.byline.legueclubs.League
import com.file.saurabh.byline.network.moshipropertyclasses.Clubs
import com.file.saurabh.byline.network.moshipropertyclasses.LeagueTable
import com.file.saurabh.byline.network.moshipropertyclasses.TopHeadlinesProperty
import com.file.saurabh.byline.network.moshipropertyclasses.TopScorers
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


private val baseURLNews : String = "https://newsapi.org/v2/"
private val baseURLFootball : String = "https://api.football-data.org/v2/"


private val moshi : Moshi by lazy {
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}
/*
* Objects for news api
* */
private val retrofitNews : Retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(baseURLNews)
        .build()
}

object NewsAPI {
    val newsServiceObject : NewsService by lazy {
        retrofitNews.create(NewsService::class.java)
    }
}

interface NewsService {
    @GET("everything?lang=en")
    @Headers("X-Api-Key:76f50a8f135043bc900521eb13b832cc")
    fun getTopHeadlines(@Query("q")queryParameter : String ,@Query("from") fromDate : String ) : Deferred<TopHeadlinesProperty>
}


/*
* Objects for football API
* */

private  val retrofitFootball : Retrofit by lazy{
    Retrofit.Builder()
        .baseUrl(baseURLFootball)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

object FootballAPI{
    val footballServiceObject : FootballService by lazy {
        retrofitFootball.create(FootballService::class.java)
    }
}

interface FootballService{


    //PREMIER LEAGUE QUERIES
    @GET("competitions/PL/teams")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getPremierLeagueClubs() : Deferred<Clubs>

    @GET("competitions/PL/scorers")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getPremierLeagueTopScorers() : Deferred<TopScorers>

    @GET("competitions/PL/standings")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getPremierLeagueStandings() : Deferred<LeagueTable>






    //LA LIGA QUERIES
    @GET("competitions/PD/teams")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getLaLigaClubs() : Deferred<Clubs>

    @GET("competitions/PD/scorers")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getLaLigaTopScorers() : Deferred<TopScorers>

    @GET("competitions/PD/standings")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getLaLigaStandings() : Deferred<LeagueTable>





    //BUNEDESLIGA QUERIES

    @GET("competitions/BL1/teams")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getBundesligaClubs() : Deferred<Clubs>

    @GET("competitions/BL1/scorers")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getBundesligaTopScorers() : Deferred<TopScorers>

    @GET("competitions/BL1/standings")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getBundesligaStandings() : Deferred<LeagueTable>





    // SERIE A QUERIES
    @GET("competitions/SA/teams")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getSerieAClubs() : Deferred<Clubs>

    @GET("competitions/SA/scorers")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getSerieATopScorers() : Deferred<TopScorers>

    @GET("competitions/SA/standings")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getSerieAStandings() : Deferred<LeagueTable>





    //FRENCH LEAGUE QUERIES
    @GET("competitions/FL1/teams")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getFrenchLeagueClubs() : Deferred<Clubs>

    @GET("competitions/FL1/scorers")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getFrenchLeagueTopScorers() : Deferred<TopScorers>

    @GET("competitions/FL1/standings")
    @Headers("X-Auth-Token:a69465ba912f4224963c86bffce39cfb")
    fun getFrenchLeagueStandings() : Deferred<LeagueTable>

}
