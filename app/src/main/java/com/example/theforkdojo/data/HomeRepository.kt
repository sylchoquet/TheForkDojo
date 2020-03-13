package com.example.theforkdojo.data

import com.example.theforkdojo.domain.Action

class HomeRepository {

    private val data = mutableListOf<Action>(
        Action(description = "I have to do that", owner = "Me"),
        Action(description = "I have to do this", owner = "Me"),
        Action(description = "I have to do an other thing", owner = "Me")
    )

    fun getActions(): List<Action> {
        return data
    }

    fun add(action: Action) {
        data.add(action)
    }

}
