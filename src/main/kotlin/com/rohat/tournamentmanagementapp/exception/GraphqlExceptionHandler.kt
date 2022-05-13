package com.rohat.tournamentmanagementapp.exception

import graphql.GraphQLException
import graphql.kickstart.spring.error.ThrowableGraphQLError
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.security.access.AccessDeniedException

@Component
class GraphqlExceptionHandler {

    @ExceptionHandler(value = [GraphQLException::class])
    fun handle(e: GraphQLException): ThrowableGraphQLError {

        return ThrowableGraphQLError(e, e.message)
    }

    @ExceptionHandler(value = [AccessDeniedException::class])
    fun handle(e: AccessDeniedException): ThrowableGraphQLError {

        return ThrowableGraphQLError(e, e.message)
    }

    @ExceptionHandler(value = [RuntimeException::class])
    fun handle(e: RuntimeException): ThrowableGraphQLError {

        return ThrowableGraphQLError(e, "Internal Server Error")
    }
}