package com.rohat.tournamentmanagementapp.graphql.resolver

import com.rohat.tournamentmanagementapp.graphql.input.tournament.CreateTournamentInput
import com.rohat.tournamentmanagementapp.graphql.input.tournament.UpdateTournamentInput
import com.rohat.tournamentmanagementapp.graphql.payload.DeleteTournamentPayload
import com.rohat.tournamentmanagementapp.model.Tournament
import com.rohat.tournamentmanagementapp.service.TournamentService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Controller

@Controller
class TournamentResolver(

    private val tournamentService: TournamentService

) : GraphQLQueryResolver,
    GraphQLMutationResolver {

    fun getTournaments(): Collection<Tournament> {

        return tournamentService.findAll()
    }

    fun createTournament(request: CreateTournamentInput): Tournament {

        return tournamentService.save(request)
    }

    fun updateTournament(request: UpdateTournamentInput): Tournament {

        return tournamentService.updateTournament(request)
    }

    fun deleteTournament(id: String): DeleteTournamentPayload {

        tournamentService.deleteTournamentById(id)
        return DeleteTournamentPayload(id)
    }


}