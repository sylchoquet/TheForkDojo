package com.example.theforkdojo.data

import com.example.theforkdojo.domain.Action

class HomeRepository {

    fun getActions(): List<Action> {
        return listOf(
            Action(description = "I have to do that", owner = "Me"),
            Action(description = "I have to do this", owner = "Me"),
            Action(description = "I have to do an other thing", owner = "Me")
        )
    }

}
