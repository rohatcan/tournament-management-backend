package com.rohat.tournamentmanagementapp.service

import com.rohat.tournamentmanagementapp.extension.toTournament
import com.rohat.tournamentmanagementapp.graphql.input.tournament.CreateTournamentInput
import com.rohat.tournamentmanagementapp.graphql.input.tournament.UpdateTournamentInput
import com.rohat.tournamentmanagementapp.model.Tournament
import com.rohat.tournamentmanagementapp.repository.TournamentRepository
import graphql.GraphQLException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TournamentService(
    private val tournamentRepository: TournamentRepository
) {

    fun findAll(): Collection<Tournament> {

        return tournamentRepository.findAll()
    }

    fun findTournamentById(id: String): Tournament {

        return tournamentRepository.findByIdOrNull(id) ?: throw GraphQLException("Tournament not found with id: $id")
    }

    fun save(request: CreateTournamentInput): Tournament {

        return tournamentRepository.insert(request.toTournament())
    }

    fun updateTournament(request: UpdateTournamentInput): Tournament {

        var tournament: Tournament = findTournamentById(request.tournamentId)

        tournament.name = request.name ?: tournament.name

//        if (request.name != null) {
//            tournament.name = request.name
//        }

        return tournamentRepository.save(tournament)
    }

    fun deleteTournamentById(tournamentId: String): Unit {


        var tournament: Tournament = findTournamentById(tournamentId)
        return tournamentRepository.delete(tournament)
    }
}