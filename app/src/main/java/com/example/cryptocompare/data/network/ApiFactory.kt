package com.example.cryptocompare.data.network

import com.example.cryptocompare.di.ApplicationScope
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@ApplicationScope
class ApiFactory @Inject constructor() {

    companion object {
        private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
        const val BASE_IMAGE_URL = "https://www.cryptocompare.com"
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}