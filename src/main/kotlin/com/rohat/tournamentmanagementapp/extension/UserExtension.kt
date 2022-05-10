package com.rohat.tournamentmanagementapp.extension

import com.rohat.tournamentmanagementapp.graphql.input.user.CreateUserInput
import com.rohat.tournamentmanagementapp.model.User


fun CreateUserInput.toUser(): User {

    return User(username = username, email = email)
}
