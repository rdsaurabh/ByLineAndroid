package com.file.saurabh.byline.network.moshipropertyclasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class LeagueTable(
        val competition: Competition,
        val filters: Filters,
        val season: Season,
        val standings: List<Standing>
){
    data class Competition(
            val area: Area,
            val code: String,
            val id: Int,
            val lastUpdated: String,
            val name: String,
            val plan: String
    )

    class Filters(
    )

    data class Season(
            val currentMatchday: Int,
            val endDate: String,
            val id: Int,
            val startDate: String,
            val winner: Any?
    )


    data class Standing(
            val group: Any?,
            val stage: String,
            val table: List<Table>,
            val type: String
    )

    data class Area(
            val id: Int,
            val name: String
    )

    @Parcelize
    data class Table(
            val draw: Int,
            val form: String?,
            val goalDifference: Int,
            val goalsAgainst: Int,
            val goalsFor: Int,
            val lost: Int,
            val playedGames: Int,
            val points: Int,
            val position: Int,
            val team: Team,
            val won: Int
    ) : Parcelable

    @Parcelize
    data class Team(
            val crestUrl: String,
            val id: Int,
            val name: String
    ) : Parcelable
}








