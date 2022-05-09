package com.rohat.tournamentmanagementapp.exception

import graphql.GraphQLException
import graphql.kickstart.spring.error.ThrowableGraphQLError
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler

@Component
class GraphqlExceptionHandler {

    @ExceptionHandler(value = [GraphQLException::class])
    fun handle(e: GraphQLException): ThrowableGraphQLError {

        return ThrowableGraphQLError(e)
    }

    @ExceptionHandler(value = [RuntimeException::class])
    fun handle(e: RuntimeException): ThrowableGraphQLError {

        return ThrowableGraphQLError(e, "Internal Server Error")
    }
}