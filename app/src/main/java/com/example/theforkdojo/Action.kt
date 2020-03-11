package com.example.theforkdojo

import java.util.*

data class Action(
    val id: String?=null,
    val description: String,
    val owner: User,
    val creationDate: Date,
    val dueDate: Date?
)