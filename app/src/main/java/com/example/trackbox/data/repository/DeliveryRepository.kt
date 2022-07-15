package com.example.trackbox.data.repository

import android.app.Application
import com.example.trackbox.DeliveryDao
import com.example.trackbox.DeliveryDatabase
import com.example.trackbox.model.entity.Delivery

class DeliveryRepository(application: Application) {

    private val deliveryDao = DeliveryDatabase.getInstance(application)!!.deliveryDao()

    suspend fun insert(delivery: Delivery){
        deliveryDao.insert(delivery)
    }
}