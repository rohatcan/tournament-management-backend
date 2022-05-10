package com.rohat.tournamentmanagementapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Tournament(

    @Id
    var tournamentId: String? = null,

    var name: String,

    var tournamentStatus: ETournamentStatus
)
