package com.rohat.tournamentmanagementapp.graphql.input.tournament

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotNull

@Validated
data class ChooseWinnerInput(

    @NotNull
    val tournamentId: String,

    @NotNull
    val winnerId: String
)
