package com.example.trackbox

import com.google.gson.annotations.SerializedName

class DeliveryResponse {
    @SerializedName("from") var from : From? = null
    @SerializedName("to") var to : To? = null
    @SerializedName("state") var state : State? = null
    @SerializedName("progresses") var progresses = ArrayList<Progresses>()
    @SerializedName("carrier") var carrier : Carrier? = null
}