package com.example.trackbox.data

import com.example.trackbox.model.DeliveryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DeliveryService {
    @GET("carriers/{carrier_id}/tracks/{track_id}")
    fun getData(
        @Path("carrier_id") carrierId: String,
        @Path("track_id") trackId: String
    ): Call<DeliveryResponse>
}