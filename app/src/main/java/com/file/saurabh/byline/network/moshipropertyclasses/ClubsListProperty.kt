package com.file.saurabh.byline.network.moshipropertyclasses

data class Clubs(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val season: Season,
    val teams: List<Team>
)

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

data class Team(
    val address: String,
    val area: AreaX,
    val clubColors: String,
    val crestUrl: String,
    val email: String?,
    val founded: Int?,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val phone: String?,
    val shortName: String,
    val tla: String,
    val venue: String,
    val website: String
)

data class Area(
    val id: Int,
    val name: String
)

data class AreaX(
    val id: Int,
    val name: String
)