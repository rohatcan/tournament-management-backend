package com.rohat.tournamentmanagementapp.graphql.resolver

import com.rohat.tournamentmanagementapp.graphql.input.participant.AddMemberInput
import com.rohat.tournamentmanagementapp.graphql.input.participant.CreateParticipantInput
import com.rohat.tournamentmanagementapp.graphql.input.participant.UpdateParticipantInput
import com.rohat.tournamentmanagementapp.graphql.input.tournament.ChooseWinnerInput
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

    fun deleteParticipant(participantId: String): DeleteParticipantPayload {

        participantService.deleteParticipantById(participantId)
        return DeleteParticipantPayload(participantId)

    }

    fun chooseWinner(request: ChooseWinnerInput): Participant {

        return participantService.chooseWinner(request)
    }
}