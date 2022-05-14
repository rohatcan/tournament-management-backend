package com.rohat.tournamentmanagementapp.service

import com.rohat.tournamentmanagementapp.graphql.input.game.CreateGameInput
import com.rohat.tournamentmanagementapp.model.EGameType
import com.rohat.tournamentmanagementapp.model.Game
import com.rohat.tournamentmanagementapp.repository.GameRepository
import graphql.GraphQLException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameService(
    private val gameRepository: GameRepository
) {

    fun findGameById(id: String): Game {

        return gameRepository.findByIdOrNull(id) ?: throw GraphQLException("Game not found with id: $id")
    }

    fun findAll(): Collection<Game?> {

        return gameRepository.findAll()
    }

    fun save(request: CreateGameInput): Game? {

        val newGame = Game(
            id = request.id,
            name = request.name,
            tags = request.tags

        )
        return gameRepository.insert(newGame)
    }

    fun deleteGameById(id: String) {

        val game = findGameById(id)
        return gameRepository.delete(game)
    }


}
