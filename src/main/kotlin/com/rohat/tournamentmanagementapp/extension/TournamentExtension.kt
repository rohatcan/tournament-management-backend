package com.rohat.tournamentmanagementapp.extension

import com.rohat.tournamentmanagementapp.graphql.input.tournament.CreateTournamentInput
import com.rohat.tournamentmanagementapp.model.ETournamentStatus
import com.rohat.tournamentmanagementapp.model.Tournament

fun CreateTournamentInput.toTournament(): Tournament {

    return Tournament(
        tournamentId =  this.tournamentId,
        name = this.name,
        tournamentStatus = ETournamentStatus.NEW
    )
}
