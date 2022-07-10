package com.example.trackbox

import com.google.gson.annotations.SerializedName

class Carrier {
    @SerializedName("id") var id : String? = null
    @SerializedName("name") var name : String? = null
    @SerializedName("tel") var tel : String? = null
}
