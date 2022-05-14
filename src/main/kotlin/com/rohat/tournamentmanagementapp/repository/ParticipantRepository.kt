package com.rohat.tournamentmanagementapp.repository

import com.rohat.tournamentmanagementapp.model.Participant
import com.rohat.tournamentmanagementapp.model.Tournament
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticipantRepository : MongoRepository<Participant, String>{

    fun findAllByTournament(tournament: Tournament): Collection<Participant>
}