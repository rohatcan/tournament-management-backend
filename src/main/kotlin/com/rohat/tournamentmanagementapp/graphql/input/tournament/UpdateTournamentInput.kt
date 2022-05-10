package com.rohat.tournamentmanagementapp.graphql.input.tournament

data class UpdateTournamentInput(

    val tournamentId: String,
    val name: String?
)
