package com.rohat.tournamentmanagementapp.repository

import com.rohat.tournamentmanagementapp.model.Game
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : MongoRepository<Game, String>{
}