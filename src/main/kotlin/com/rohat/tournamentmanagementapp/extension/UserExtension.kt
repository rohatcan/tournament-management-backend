package com.rohat.tournamentmanagementapp.extension

import com.rohat.tournamentmanagementapp.graphql.input.user.UserInput
import com.rohat.tournamentmanagementapp.model.User


fun UserInput.toUser(): User {

    return User(username = username, email = email)
}
