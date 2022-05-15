package com.rohat.tournamentmanagementapp.graphql.input.participant

data class CreateParticipantInput(

    val participantId: String?,
    val name: String?,
    val leaderId: String?,
    val tournamentId: String

)
