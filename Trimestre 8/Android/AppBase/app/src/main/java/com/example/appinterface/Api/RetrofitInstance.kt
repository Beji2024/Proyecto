package com.example.appinterface.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL_APIKOTLIN = "http://10.0.2.2:8080/"
    val api3kotlin: ApiServiceUsuario by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_APIKOTLIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServiceUsuario::class.java)
    }
}