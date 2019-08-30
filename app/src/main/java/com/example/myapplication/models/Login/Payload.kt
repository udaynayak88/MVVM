package com.example.md0055_udaykumar.taxidriver.model.Login

import com.google.gson.annotations.SerializedName

data class Payload(
        @SerializedName("access_token")
        val accessToken: String,
        @SerializedName("driver")
        val driver: Driver,
        @SerializedName("token_type")
        val tokenType: String
    ) 