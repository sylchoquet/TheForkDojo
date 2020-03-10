package com.example.theforkdojo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://androidcodingdojo.appspot.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val actionsService = retrofit.create(ActionService::class.java)

    fun getActions(): Call<List<Action>> {
        return actionsService.getActions()
    }

}
