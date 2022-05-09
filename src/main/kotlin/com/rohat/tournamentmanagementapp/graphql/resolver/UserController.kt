package com.rohat.tournamentmanagementapp.graphql.resolver

import com.rohat.tournamentmanagementapp.graphql.input.user.UpdateUserInput
import com.rohat.tournamentmanagementapp.graphql.input.user.UserInput
import com.rohat.tournamentmanagementapp.graphql.payload.DeleteUserPayload
import com.rohat.tournamentmanagementapp.model.User
import com.rohat.tournamentmanagementapp.service.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Controller

@Controller
class UserController(
    private val userService: UserService
) : GraphQLQueryResolver, GraphQLMutationResolver {

    fun getAllUsers(): Collection<User> {

        return userService.findAll()
    }

    fun getUserById(id: String): User {

        return userService.findUserById(id)
    }

    fun createUser(request: UserInput): User {

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