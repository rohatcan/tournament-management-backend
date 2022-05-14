package com.rohat.tournamentmanagementapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document
data class Tournament(

    @Id
    var tournamentId: String? = null,

    var name: String,

    var tournamentStatus: ETournamentStatus,

    var teamSize: Int,

    var game: Game,

    var participants: MutableList<Participant>?,

    var owner: User,

    val prizeInUsd: BigDecimal?,

    var winner: User?
)
