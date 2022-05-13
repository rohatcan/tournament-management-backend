package com.rohat.tournamentmanagementapp.graphql.input.user

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotNull

@Validated
data class LoginInput(

    @NotNull
    val userName: String,

    @NotNull
    val password: String
)
