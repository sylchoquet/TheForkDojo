package com.example.theforkdojo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val view: HomeView,
    private val homeRepository: HomeRepository
) {

    fun initialize() {
        view.displayMessage("Hello")

        homeRepository.getActions().enqueue(object : Callback<List<Action>> {
            override fun onFailure(call: Call<List<Action>>, t: Throwable) {
                TODO("not implemented")
            }

            override fun onResponse(call: Call<List<Action>>, response: Response<List<Action>>) {
                if (response.isSuccessful) {
                    view.displayActions(response.body()!!)
                } else {

                }
            }
        })

    }

}
