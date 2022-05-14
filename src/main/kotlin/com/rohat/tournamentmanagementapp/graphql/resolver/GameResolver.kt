package com.rohat.tournamentmanagementapp.graphql.resolver

import com.rohat.tournamentmanagementapp.graphql.input.game.CreateGameInput
import com.rohat.tournamentmanagementapp.model.Game
import com.rohat.tournamentmanagementapp.service.GameService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller

@Controller
class GameResolver(
    private val gameService: GameService,

) : GraphQLQueryResolver, GraphQLMutationResolver{

    @PreAuthorize("isAnonymous()")
    fun getAllGames(): Collection<Game?> {

        return gameService.findAll()
    }

    fun getGameById(id: String): Game? {

        return gameService.findGameById(id)
    }

    @PreAuthorize("isAuthenticated()")
    fun createGame(request: CreateGameInput): Game? {

        return gameService.save(request)
    }

}