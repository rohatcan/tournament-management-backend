package com.rohat.tournamentmanagementapp.graphql.resolver

import com.rohat.tournamentmanagementapp.graphql.input.UserInput
import com.rohat.tournamentmanagementapp.model.User
import com.rohat.tournamentmanagementapp.service.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Controller

@Controller
class UserController(

    private val userService: UserService
) : GraphQLQueryResolver, GraphQLMutationResolver {

    fun info(): String {

        return "Hello World"
    }

    fun createUser(request: UserInput): User {

        return userService.save(request)
    }

}