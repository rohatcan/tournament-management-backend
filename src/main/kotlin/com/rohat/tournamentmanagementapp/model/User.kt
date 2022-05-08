package com.rohat.tournamentmanagementapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(

    val username: String?,
    val email: String?,

    @Id
    val id: String? = null
)
