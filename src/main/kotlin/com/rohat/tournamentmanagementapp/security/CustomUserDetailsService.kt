package com.rohat.tournamentmanagementapp.security

import com.rohat.tournamentmanagementapp.repository.UserRepository
import graphql.GraphQLException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsService(

    private var userRepository: UserRepository
) : UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findUserByUsernameEquals(username)
            ?: throw GraphQLException("User not found with username: $username")
        return UserPrincipal.create(user)
    }

    @Transactional
    fun loadUserById(id: String): UserDetails {

        val user = userRepository.findByIdOrNull(id)
            ?: throw GraphQLException("User not found with id: $id")
        return UserPrincipal.create(user)
    }
}