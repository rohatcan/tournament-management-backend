//package com.rohat.tournamentmanagementapp.graphql.resolver.mutation
//
//import com.rohat.tournamentmanagementapp.graphql.input.UserInput
//import com.rohat.tournamentmanagementapp.model.User
//import com.rohat.tournamentmanagementapp.service.UserService
//import graphql.kickstart.tools.GraphQLMutationResolver
//import org.springframework.stereotype.Component
//
//@Component
//class UserMutationResolver(
//    private val userService: UserService
//) : GraphQLMutationResolver {
//
//    fun createUser(request: UserInput): User {
//
//        return userService.save(request)
//    }
//}