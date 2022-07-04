package br.com.compass.compassmart.ui.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://us-central1-pbpuc2022-1-trimestre.cloudfunctions.net/pbcompass2022/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiService() = retrofit.create(ApiService::class.java)
}