package com.rohat.tournamentmanagementapp.extension

import com.rohat.tournamentmanagementapp.graphql.input.user.CreateUserInput
import com.rohat.tournamentmanagementapp.model.User


fun CreateUserInput.toUser(encodedPassword: String): User {

    return User(
        userId = userId,
        username = username,
        email = email,
        password = encodedPassword
    )
}
