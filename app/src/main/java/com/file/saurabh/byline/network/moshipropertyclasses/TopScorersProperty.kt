package com.file.saurabh.byline.network.moshipropertyclasses

data class TopScorers(
        val competition: Competition,
        val count: Int,
        val filters: Filters,
        val scorers: List<Scorer>,
        val season: Season
){
    data class Team(
            val id: Int,
            val name: String
    )

    data class Competition(
            val area: Area,
            val code: String,
            val id: Int,
            val lastUpdated: String,
            val name: String,
            val plan: String
    )
    data class Filters(
            val limit: Int?
    )
    data class Scorer(
            val numberOfGoals: Int,
            val player: Player,
            val team: Team
    )

    data class Season(
            val currentMatchday: Int,
            val endDate: String,
            val id: Int,
            val startDate: String,
            val winner: Any?
    )

    data class Player(
            val countryOfBirth: String,
            val dateOfBirth: String,
            val firstName: String,
            val id: Int,
            val lastName: Any?,
            val lastUpdated: String,
            val name: String,
            val nationality: String,
            val position: String,
            val shirtNumber: Any?
    )

    data class Area(
            val id: Int,
            val name: String
    )


}











