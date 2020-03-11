package com.example.theforkdojo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenService {

    @POST("token")
    fun postToken(@Body token: Token): Call<Result>

}
