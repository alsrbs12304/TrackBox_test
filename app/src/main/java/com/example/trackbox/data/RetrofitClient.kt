package com.example.trackbox.data

import com.example.trackbox.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    var service : DeliveryService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(DeliveryService::class.java)
    }
}