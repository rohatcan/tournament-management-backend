package com.rohat.tournamentmanagementapp.graphql.input.user

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotNull

@Validated
data class UserInput(

    @NotNull
    val username: String,

    @NotNull
    val email: String,

    )
