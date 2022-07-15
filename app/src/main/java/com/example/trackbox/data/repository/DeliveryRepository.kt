package com.example.trackbox.data.repository

import android.app.Application
import com.example.trackbox.DeliveryDao
import com.example.trackbox.DeliveryDatabase
import com.example.trackbox.model.DeliveryResponse
import com.example.trackbox.model.entity.Delivery

class DeliveryRepository(application: Application) {

    private val deliveryDao = DeliveryDatabase.getInstance(application)!!.deliveryDao()

    suspend fun insert(delivery: Delivery){
        deliveryDao.insert(delivery)
    }

    companion object {
        private var instance: DeliveryRepository? = null

        fun getInstance(application : Application): DeliveryRepository? { // singleton pattern
            if (instance == null) instance = DeliveryRepository(application)
            return instance
        }
    }
}