package com.example.md0055_udaykumar.taxidriver.model.Login

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("device_token")
    val device_token: String

) 