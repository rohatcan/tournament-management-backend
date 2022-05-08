package com.rohat.tournamentmanagementapp.extensions

import com.rohat.tournamentmanagementapp.graphql.input.UserInput
import com.rohat.tournamentmanagementapp.model.User

class UserExtensions {

    fun UserInput.toUser(): User {

        return User(username, email)
    }
}