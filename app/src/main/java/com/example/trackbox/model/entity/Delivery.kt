package com.example.trackbox.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "delivery")
data class Delivery(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val fromName: String,
    val fromTime: String,
    val toName: String,
    val carrierId: String,
    val carrierName: String,
    val trackId: String,
    val status: String
)