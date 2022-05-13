package com.rohat.tournamentmanagementapp.service

import com.rohat.tournamentmanagementapp.extension.toUser
import com.rohat.tournamentmanagementapp.graphql.input.user.CreateUserInput
import com.rohat.tournamentmanagementapp.graphql.input.user.UpdateUserInput
import com.rohat.tournamentmanagementapp.model.User
import com.rohat.tournamentmanagementapp.repository.UserRepository
import com.rohat.tournamentmanagementapp.security.UserPrincipal
import graphql.GraphQLException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userRepository: UserRepository,

    private val passwordEncoder: PasswordEncoder,
) {

    fun findAll(): Collection<User> {

        return userRepository.findAll()
    }

    fun findUserById(id: String): User {

        return userRepository.findByIdOrNull(id) ?: throw GraphQLException("User not found with id: $id")
    }

    fun save(request: CreateUserInput): User {

        val encodedPassword = passwordEncoder.encode(request.password)
        return userRepository.insert(request.toUser(encodedPassword))
    }

    fun updateUser(request: UpdateUserInput): User {

        var user = findUserById(request.userId)

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

    fun findUserByUserName(username: String): User {

        return userRepository.findUserByUsernameEquals(username)
            ?: throw GraphQLException("User not found with user name: $username")
    }

    fun getCurrentUser(): User? {

        val principal = SecurityContextHolder.getContext().authentication.principal as UserPrincipal
        return userRepository.findUserByUsernameEquals(principal.username)
    }


}