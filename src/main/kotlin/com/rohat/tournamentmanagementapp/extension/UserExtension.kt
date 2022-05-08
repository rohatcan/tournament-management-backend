package com.rohat.tournamentmanagementapp.extension

import com.rohat.tournamentmanagementapp.graphql.input.UserInput
import com.rohat.tournamentmanagementapp.model.User


fun UserInput.toUser(): User {

    return User(username, email)
}
