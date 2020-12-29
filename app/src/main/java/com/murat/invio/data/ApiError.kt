package com.murat.invio.data

import com.google.gson.annotations.SerializedName

data class ApiError (
    @SerializedName("status")
    val status:String,
    @SerializedName("type")
    val type:String,
    @SerializedName("message")
    val message: String
)
