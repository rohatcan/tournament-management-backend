package com.rohat.tournamentmanagementapp.extension

import com.rohat.tournamentmanagementapp.graphql.input.tournament.CreateTournamentInput
import com.rohat.tournamentmanagementapp.model.ETournamentStatus
import com.rohat.tournamentmanagementapp.model.Game
import com.rohat.tournamentmanagementapp.model.Tournament
import com.rohat.tournamentmanagementapp.model.User

fun CreateTournamentInput.toTournament(game: Game, ownerUser: User): Tournament {

    return Tournament(
        tournamentId = this.tournamentId,
        name = this.name,
        tournamentStatus = ETournamentStatus.NEW,
        teamSize = this.teamSize,
        game = game,
        participants = mutableListOf(),
        owner = ownerUser,
        prizeInUsd = this.prizeInUsd,
        winner = null
    )
}
