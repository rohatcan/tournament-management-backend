package com.rohat.tournamentmanagementapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Participant(

    @Id
    var participantId : String? = null,

    var members: MutableList<User>,

    var tournament: Tournament,

    var name: String? = null,

    var leader: User? = null,

) {
}