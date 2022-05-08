package com.rohat.tournamentmanagementapp.service

import com.rohat.tournamentmanagementapp.extension.toUser
import com.rohat.tournamentmanagementapp.graphql.input.UserInput
import com.rohat.tournamentmanagementapp.model.User
import com.rohat.tournamentmanagementapp.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(
    val userRepository: UserRepository
) {

    fun save(request: UserInput): User {

        return userRepository.insert(request.toUser())
    }

}