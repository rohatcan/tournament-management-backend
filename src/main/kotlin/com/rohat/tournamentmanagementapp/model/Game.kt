package com.rohat.tournamentmanagementapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Game(
    @Id
    val id: String? = null,

//    @Indexed(unique = true)
    val name: String,

    val tags: Set<EGameType?>
)
