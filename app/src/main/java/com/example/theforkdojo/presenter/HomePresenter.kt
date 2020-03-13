package com.example.theforkdojo.presenter

import com.example.theforkdojo.data.HomeRepository
import com.example.theforkdojo.domain.Action
import com.example.theforkdojo.view.HomeView

class HomePresenter(
    private val view: HomeView,
    private val homeRepository: HomeRepository
) {

    fun initialize() {
        view.displayMessage("Hello")
        view.displayActions(homeRepository.getActions())
    }

    fun onRefresh() {
        homeRepository.add(Action("new action", "Meee"))
        view.displayActions(homeRepository.getActions())
    }

}
