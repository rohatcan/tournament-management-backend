package com.rohat.tournamentmanagementapp.service

import com.rohat.tournamentmanagementapp.extension.toTournament
import com.rohat.tournamentmanagementapp.graphql.input.tournament.CreateTournamentInput
import com.rohat.tournamentmanagementapp.graphql.input.tournament.UpdateTournamentInput
import com.rohat.tournamentmanagementapp.model.ETournamentStatus
import com.rohat.tournamentmanagementapp.model.Tournament
import com.rohat.tournamentmanagementapp.repository.TournamentRepository
import graphql.GraphQLException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TournamentService(
    private val tournamentRepository: TournamentRepository,
    private val gameService: GameService,
    private val userService: UserService,
) {

    fun findAll(): Collection<Tournament> {

        return tournamentRepository.findAll()
    }

    fun findTournamentById(id: String): Tournament {

        return tournamentRepository.findByIdOrNull(id) ?: throw GraphQLException("Tournament not found with id: $id")
    }

    fun save(request: CreateTournamentInput): Tournament {

        val game = gameService.findGameById(request.gameId)
        val owner = userService.findUserById(request.ownerId)

        return tournamentRepository.insert(request.toTournament(game, owner))
    }

    fun save(tournament: Tournament): Tournament {
        return tournamentRepository.save(tournament)
    }

    fun updateTournament(request: UpdateTournamentInput): Tournament {

        val tournament: Tournament = findTournamentById(request.tournamentId)

        tournament.name = request.name ?: tournament.name

        if (request.status != null) {
            updateTournamentStatus(request, tournament, request.status!!)
        }

        return tournamentRepository.save(tournament)
    }

    private fun updateTournamentStatus(
        request: UpdateTournamentInput,
        tournament: Tournament,
        status: ETournamentStatus
    ) {

        if (status == ETournamentStatus.COMPLETE) {
            changeTournamentStatusToComplete(request, tournament)
        }

    }

    private fun changeTournamentStatusToComplete(request: UpdateTournamentInput, tournament: Tournament) {

        tournament.tournamentStatus = ETournamentStatus.COMPLETE
        save(tournament)
        //TODO("update stats")
    }

    fun deleteTournamentById(tournamentId: String): Unit {

        val tournament: Tournament = findTournamentById(tournamentId)
        return tournamentRepository.delete(tournament)
    }
}