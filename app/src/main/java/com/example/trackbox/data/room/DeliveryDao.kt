package com.example.trackbox.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.trackbox.model.entity.Delivery

@Dao
interface DeliveryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(delivery: Delivery)

    @Query("SELECT * FROM delivery")
    fun getList() : LiveData<List<Delivery>>
}