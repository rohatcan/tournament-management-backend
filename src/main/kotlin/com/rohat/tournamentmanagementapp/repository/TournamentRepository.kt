package com.rohat.tournamentmanagementapp.repository

import com.rohat.tournamentmanagementapp.model.Tournament
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TournamentRepository : MongoRepository<Tournament, String> {}