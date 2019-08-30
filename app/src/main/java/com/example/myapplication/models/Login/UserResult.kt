package com.example.myapplication.models.Login

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * Created by Bhavik Makwana on 10-09-2018.
 */
data class UserResult(
        @SerializedName("user")
        val user: User,
        @SerializedName("type")
        val userType: String
) : BaseResult() {
    data class User(
            @SerializedName("userId") val userId: Int,
            @SerializedName("firstName") val firstName: String,
            @SerializedName("lastName") val lastName: String,
            @SerializedName("userName") val userName: String,
            @SerializedName("email") val email: String,
            @SerializedName("phoneNumber") val phoneNumber: String,
            @SerializedName("profileImageURL") val profileImageURL: String,
            @SerializedName("availabilityStatus") val availabilityStatus: Boolean,
            @SerializedName("dob") val dob: String,
            @SerializedName("isPasswordChanged") var isPasswordChanged: Boolean,
            @SerializedName("token") val token: String,
            @SerializedName("currentLocation") var currentLocation: String,
            @SerializedName("buggyNumber") val buggyNumber: String,
            @SerializedName("licenseNumber") val licenseNumber: String,
            @SerializedName("licenseExpiry") val licenseExpiry: String,
            @SerializedName("achievementImage") val achievementImage: String,
            @SerializedName("totalTripsDone") val totalTripsDone: Int,
            @SerializedName("totalTripsRejected") val totalTripsRejected: Int,
            @SerializedName("showDamageConfirmation") var showDamageConfirmation: Boolean,
            @SerializedName("hasDriverPermission") val hasDriverPermission: Boolean,
            @SerializedName("hasControllerPermission") val hasControllerPermission: Boolean,
            @SerializedName("hasMaintenanceControllerPermission") val hasMaintenanceControllerPermission: Boolean,
            @SerializedName("hasTeamLeadPermission") val hasTeamLeadPermission: Boolean,
            @SerializedName("hasBuggyWashingPermission") val hasBuggyWashingPermission: Boolean,
            @SerializedName("driverWaitingTime") val driverWaitingTime: Int,
            @SerializedName("isPasswordExpired") var isPasswordExpired: Boolean
    )
    /*{
        companion object {
            fun saveUserDetails(user: User) {
                val toJson = Gson().toJson(user)
                PrefUtils.putString(PrefConstants.PREF_USER_DETAILS, toJson)
            }

            fun getUserDetails(): User? {
                val fromJson = PrefUtils.getString(PrefConstants.PREF_USER_DETAILS, "")
                return Gson().fromJson<User>(fromJson, User::class.java)
            }
        }
    }*/
}


open class BaseResult {

    @field:SerializedName("id")
    val id: Int? = null

    @field:SerializedName("logId")
    val waitTimeLogId: Int = 0

    @field:SerializedName("totalTime")
    val totalTime: String? = null

    @field:SerializedName("message")
    val message: String? = null

    @field:SerializedName("code")
    val code: Int? = null



}