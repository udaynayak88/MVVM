package com.example.md0055_udaykumar.taxidriver.model.Login

import com.google.gson.annotations.SerializedName

data class Driver(
            @SerializedName("city_id")
            val cityId: Int,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("deleted_at")
            val deletedAt: Any,
            @SerializedName("driver_type_id")
            val driverTypeId: Int,
            @SerializedName("driving_time")
            val drivingTime: String,
            @SerializedName("email")
            val email: String,
            @SerializedName("first_name")
            val firstName: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("invitation_code")
            val invitationCode: String,
            @SerializedName("last_name")
            val lastName: String,
            @SerializedName("mobile_number")
            val mobileNumber: String,
            @SerializedName("status")
            val status: Int,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("verification_code")
            val verificationCode: String
        )