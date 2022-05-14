package com.rohat.tournamentmanagementapp.graphql.resolver

import com.rohat.tournamentmanagementapp.graphql.input.participant.AddMemberInput
import com.rohat.tournamentmanagementapp.graphql.input.participant.CreateParticipantInput
import com.rohat.tournamentmanagementapp.graphql.input.participant.UpdateParticipantInput
import com.rohat.tournamentmanagementapp.graphql.payload.DeleteParticipantPayload
import com.rohat.tournamentmanagementapp.model.Participant
import com.rohat.tournamentmanagementapp.service.ParticipantService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Controller

@Controller
class ParticipantResolver(
    private val participantService: ParticipantService
) : GraphQLQueryResolver, GraphQLMutationResolver {

    fun getParticipantsByTournament(tournamentId: String): Collection<Participant> {

        return participantService.findAllByTournament(tournamentId)
    }

    fun getParticipantById(id: String): Participant {

        return participantService.findParticipantById(id)
    }

    fun createParticipant(request: CreateParticipantInput): Participant {

        return participantService.save(request)
    }

    fun updateParticipant(request: UpdateParticipantInput): Participant {

        return participantService.updateParticipant(request)
    }

    fun addMember(request: AddMemberInput): Participant {

        return participantService.addMemberToParticipant(request)
    }

    fun deleteParticipant(id: String): DeleteParticipantPayload {

        participantService.deleteParticipantById(id)
        return DeleteParticipantPayload(id)

    }
}