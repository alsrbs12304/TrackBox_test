package com.example.trackbox

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DeliveryService {

    @GET("carriers/{carrier_id}/tracks/{track_id}")
    suspend fun getData(
        @Path("carrier_id") carrierId: String,
        @Path("track_id") trackId: String
    ): DeliveryResponse

    @GET("carriers/{carrier_id}/tracks/{track_id}")
    fun testGetData(
        @Path("carrier_id") carrierId: String,
        @Path("track_id") trackId: String
    ): Call<Delivery>
}