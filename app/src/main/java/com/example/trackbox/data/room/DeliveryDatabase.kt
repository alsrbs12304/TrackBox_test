package com.example.trackbox.data.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trackbox.model.entity.Delivery
import android.content.Context

@Database(entities = [Delivery::class], version = 1, exportSchema = false)
abstract class DeliveryDatabase : RoomDatabase() {

    abstract fun deliveryDao() : DeliveryDao

    companion object {

        @Volatile
        private var instance: DeliveryDatabase? = null

        @Synchronized
        fun getInstance(context: Context): DeliveryDatabase? {
            if (instance == null) {
                synchronized(DeliveryDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DeliveryDatabase::class.java,
                        "delivery_database"
                    ).build()
                }
            }
            return instance
        }
    }
}