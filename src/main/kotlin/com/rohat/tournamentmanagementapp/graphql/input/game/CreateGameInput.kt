package com.rohat.tournamentmanagementapp.graphql.input.game

import com.rohat.tournamentmanagementapp.model.EGameType

data class CreateGameInput(
    val id: String?,
    val name:String,
    val tags:MutableSet<EGameType>?,
)
