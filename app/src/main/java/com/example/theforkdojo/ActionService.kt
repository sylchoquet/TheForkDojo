package com.example.theforkdojo

import retrofit2.Call
import retrofit2.http.GET

interface ActionService {

    @GET("actions")
    fun getActions(): Call<List<Action>>

}
