package com.example.theforkdojo

class HomePresenter(
    private val view: HomeView,
    private val homeRepository: HomeRepository
) {

    fun initialize() {
        view.displayMessage("Hello")
        view.displayActions(homeRepository.getActions())
    }

}
