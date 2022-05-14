package com.rohat.tournamentmanagementapp.service

import com.rohat.tournamentmanagementapp.extension.toParticipant
import com.rohat.tournamentmanagementapp.graphql.input.participant.AddMemberInput
import com.rohat.tournamentmanagementapp.graphql.input.participant.CreateParticipantInput
import com.rohat.tournamentmanagementapp.graphql.input.participant.UpdateParticipantInput
import com.rohat.tournamentmanagementapp.model.Participant
import com.rohat.tournamentmanagementapp.repository.ParticipantRepository
import graphql.GraphQLException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service

@Service
class ParticipantService(
    private val participantRepository: ParticipantRepository,
    private val userService: UserService,
    private val tournamentService: TournamentService

) {

    fun findAllByTournament(tournamentId: String): Collection<Participant> {

        val tournament = tournamentService.findTournamentById(tournamentId)
        return participantRepository.findAllByTournament(tournament = tournament)
    }

    fun findParticipantById(id: String): Participant {

        return participantRepository.findByIdOrNull(id) ?: throw GraphQLException("Participant not found with id: $id")
    }


    @PreAuthorize("isAuthenticated()")
    fun save(request: CreateParticipantInput): Participant {

        var leader = userService.getCurrentUser()

        if (request.leaderId != null) {

            leader = userService.findUserById(request.leaderId)
        }
        val tournament = tournamentService.findTournamentById(request.tournamentId)
        val participant = request.toParticipant(tournament = tournament, leader = leader)
        tournament.participants?.add(participant)
        tournamentService.save(tournament)
        return participantRepository.save(participant)
    }

    fun updateParticipant(request: UpdateParticipantInput): Participant {

        var user = findParticipantById(request.participantId)


        return participantRepository.save(user)
    }

    fun deleteParticipantById(userId: String): Unit {

        return participantRepository.deleteById(userId)
    }

    fun addMemberToParticipant(request: AddMemberInput): Participant {

        val participant = findParticipantById(request.participantId)
        if (participant.tournament.teamSize <= participant.members.size) {
            throw GraphQLException("Team is full")

        }
        val memberToAdd = userService.findUserById(request.userId)
        val members = participant.members
        members.add(memberToAdd)

        participantRepository.save(participant)

        return participant
    }


}