package com.rohat.tournamentmanagementapp.graphql.input.tournament

import com.rohat.tournamentmanagementapp.model.ETournamentStatus
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotNull

@Validated
data class UpdateTournamentInput(

    @NotNull
    val tournamentId: String,
    val name: String?,
    val status: ETournamentStatus?,
    var winnerId: String?
)
