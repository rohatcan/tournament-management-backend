package com.rohat.tournamentmanagementapp.graphql.input.participant

data class CreateParticipantInput(

    val name:String?,
    val leaderId: String?,
    val tournamentId: String

)
