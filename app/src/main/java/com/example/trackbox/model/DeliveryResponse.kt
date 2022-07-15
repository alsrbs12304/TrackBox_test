package com.example.trackbox.model

import com.example.trackbox.model.entity.Delivery
import com.example.trackbox.view.util.CarrierIdUtil.Companion.convertId

data class DeliveryResponse(
    val from: From,
    val to: To,
    val state: State,
    val progresses: ArrayList<Progresses>,
    val carrier: Carrier
) {
    data class From(
        val name: String?,
        val time: String?
    )

    data class To(
        val name: String?,
        val time: String?
    )

    data class State(
        val text: String?
    )

    data class Progresses(
        val location: Location,
        val status: Status,
        val time: String,
        val description: String
    )

    data class Location(
        val name: String
    )

    data class Status(
        val text: String
    )

    data class Carrier(
        val name: String?
    )

    fun toDelivery(id: Long?, carrierName: String, trackId: String) =
        Delivery(
            id = id,
            fromName = from.name ?: "-",
            fromTime = from.time ?: "-",
            toName = to.name ?: "-",
            carrierId = convertId(carrierName)!!,
            carrierName = carrier.name ?: "-",
            trackId = trackId,
            status = state.text ?: "-"
        )
}