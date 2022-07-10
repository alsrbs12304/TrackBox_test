package com.example.trackbox

import com.google.gson.annotations.SerializedName

class Progresses {
    @SerializedName("time") var time : String? = null
    @SerializedName("description") var description : String? = null
    @SerializedName("status") var status : Status? = null
    @SerializedName("location") var location : Location? = null
}
