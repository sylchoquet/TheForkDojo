package com.example.theforkdojo

import java.util.*

class HomeRepository {

    fun getActions(): List<Action> {
        return listOf(
            Action("edwe", "wewwwew", User(name = "Sylvain"), Date(), Date()),
            Action("sfdgdfggg", "sdfsdf", User(name = "Laurent"), Date(), Date())
        )
    }

}
