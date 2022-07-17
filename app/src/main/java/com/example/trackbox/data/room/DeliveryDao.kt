package com.example.trackbox.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.trackbox.model.entity.Delivery

@Dao
interface DeliveryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(delivery: Delivery)

}