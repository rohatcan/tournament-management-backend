package com.rohat.tournamentmanagementapp.repository

import com.rohat.tournamentmanagementapp.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>{

    fun findUserByUsernameEquals(username: String):User?

}