package com.rohat.tournamentmanagementapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(

    @Id
    val userId: String? = null,

//    @Indexed(unique = true)
    var username: String,

//    @Indexed(unique = true)
    var email: String? = "",

    val password: String
)
