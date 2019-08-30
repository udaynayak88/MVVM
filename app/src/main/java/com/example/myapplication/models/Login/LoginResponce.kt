package com.example.md0055_udaykumar.taxidriver.model.Login

import com.google.gson.annotations.SerializedName

data class LoginResponce(


    @SerializedName("success")
    val success: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val payload: Payload

) 