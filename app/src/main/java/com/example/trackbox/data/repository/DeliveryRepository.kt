package com.example.trackbox.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.trackbox.data.room.DeliveryDatabase
import com.example.trackbox.model.entity.Delivery

class DeliveryRepository(application: Application) {

    private val deliveryDao = DeliveryDatabase.getInstance(application)!!.deliveryDao()

    suspend fun insert(delivery: Delivery){
        deliveryDao.insert(delivery)
    }

    fun getList() : LiveData<List<Delivery>> {
        return deliveryDao.getList()
    }

    companion object {
        private var instance: DeliveryRepository? = null

        fun getInstance(application : Application): DeliveryRepository? { // singleton pattern
            if (instance == null) instance = DeliveryRepository(application)
            return instance
        }
    }
}