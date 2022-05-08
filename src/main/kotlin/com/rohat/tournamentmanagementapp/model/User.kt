package com.rohat.tournamentmanagementapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(

    @Indexed(unique = true)
    val username: String?,

    @Indexed(unique = true)
    val email: String?,

    @Id
    val id: String? = null
)
