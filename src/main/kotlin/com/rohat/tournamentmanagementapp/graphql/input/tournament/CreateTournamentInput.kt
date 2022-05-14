package com.rohat.tournamentmanagementapp.graphql.input.tournament

import java.math.BigDecimal
import javax.validation.constraints.NotNull

data class CreateTournamentInput(

    val tournamentId: String?,

    @NotNull
    val gameId: String,

    @NotNull
    val ownerId: String,

    val name: String,

    val teamSize: Int,

    val prizeInUsd: BigDecimal?
)
