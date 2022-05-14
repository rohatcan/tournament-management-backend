package com.rohat.tournamentmanagementapp.extension

import com.rohat.tournamentmanagementapp.graphql.input.participant.CreateParticipantInput
import com.rohat.tournamentmanagementapp.model.Participant
import com.rohat.tournamentmanagementapp.model.Tournament
import com.rohat.tournamentmanagementapp.model.User

fun CreateParticipantInput.toParticipant(tournament: Tournament, leader: User): Participant {

    return Participant(
        name = this.name,
        tournament = tournament,
        members = mutableListOf(),
        leader = leader
    )
}
