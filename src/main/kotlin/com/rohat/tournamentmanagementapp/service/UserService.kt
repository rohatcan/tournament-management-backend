package com.rohat.tournamentmanagementapp.service

import com.rohat.tournamentmanagementapp.extension.toUser
import com.rohat.tournamentmanagementapp.graphql.input.user.UpdateUserInput
import com.rohat.tournamentmanagementapp.graphql.input.user.UserInput
import com.rohat.tournamentmanagementapp.model.User
import com.rohat.tournamentmanagementapp.repository.UserRepository
import graphql.GraphQLException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): Collection<User> {

        return userRepository.findAll()
    }

    fun findUserById(id: String): User {

        return userRepository.findByIdOrNull(id) ?: throw GraphQLException("User not found with id: $id")
    }

    fun save(request: UserInput): User {

        return userRepository.insert(request.toUser())
    }

    fun updateUser(request: UpdateUserInput): User {

        var user = findUserById(request.id)

        if (request.email != null) {
            user.email = request.email
        }
        if (request.username != null) {
            user.username = request.username
        }

        return userRepository.save(user)
    }

    fun deleteUserById(userId: String): Unit {

        return userRepository.deleteById(userId)
    }


}