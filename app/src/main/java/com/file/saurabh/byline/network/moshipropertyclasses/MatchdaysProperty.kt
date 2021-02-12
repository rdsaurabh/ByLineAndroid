package com.file.saurabh.byline.network.moshipropertyclasses

data class Matchdays(
        val competition: Competition,
        val count: Int,
        val filters: Filters,
        val matches: List<Match>
) {

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

    data class Match(
            val awayTeam: AwayTeam,
            val group: String,
            val homeTeam: HomeTeam,
            val id: Int,
            val lastUpdated: String,
            val matchday: Int,
            val odds: Odds,
            val referees: List<Referee>,
            val score: Score,
            val season: Season,
            val stage: String,
            val status: String,
            val utcDate: String
    )

    data class Area(
            val id: Int,
            val name: String
    )

    data class AwayTeam(
            val id: Int,
            val name: String
    )

    data class HomeTeam(
            val id: Int,
            val name: String
    )

    data class Odds(
            val msg: String
    )

    data class Referee(
            val id: Int,
            val name: String?,
            val nationality: String?,
            val role: String?
    )

    data class Score(
            val duration: String,
            val extraTime: ExtraTime,
            val fullTime: FullTime,
            val halfTime: HalfTime,
            val penalties: Penalties,
            val winner: Any?
    )

    data class Season(
            val currentMatchday: Int,
            val endDate: String,
            val id: Int,
            val startDate: String
    )

    data class ExtraTime(
            val awayTeam: Int?,
            val homeTeam: Int?
    )

    data class FullTime(
            val awayTeam: Int?,
            val homeTeam: Int?
    )

    data class HalfTime(
            val awayTeam: Int?,
            val homeTeam: Int?
    )

    data class Penalties(
            val awayTeam: Any?,
            val homeTeam: Any?
    )
}