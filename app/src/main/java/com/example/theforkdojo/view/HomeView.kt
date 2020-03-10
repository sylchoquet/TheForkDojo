package com.example.theforkdojo.view

import com.example.theforkdojo.domain.Action

interface HomeView {

    fun displayMessage(message: String)

    fun displayActions(actions: List<Action>)

}
