package com.rohat.tournamentmanagementapp.graphql.resolver

import com.rohat.tournamentmanagementapp.graphql.input.user.UpdateUserInput
import com.rohat.tournamentmanagementapp.graphql.input.user.CreateUserInput
import com.rohat.tournamentmanagementapp.graphql.payload.DeleteUserPayload
import com.rohat.tournamentmanagementapp.model.User
import com.rohat.tournamentmanagementapp.service.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller

@Controller
class UserResolver(
    private val userService: UserService
) : GraphQLQueryResolver, GraphQLMutationResolver {


    @PreAuthorize("isAuthenticated()")
    fun getAllUsers(): Collection<User> {

        return userService.findAll()
    }

    fun getUserById(id: String): User {

        return userService.findUserById(id)
    }

    @PreAuthorize("isAnonymous()")
    fun createUser(request: CreateUserInput): User {

        return userService.save(request)
    }

    fun updateUser(request: UpdateUserInput): User {

        return userService.updateUser(request)
    }

    fun deleteUser(id: String): DeleteUserPayload {

        userService.deleteUserById(id)
        return DeleteUserPayload(id)
    }

}