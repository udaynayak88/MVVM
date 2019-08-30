package com.example.myapplication.network

import com.example.md0055_udaykumar.taxidriver.model.Login.LoginResponce
import com.example.myapplication.models.Login.UserResult
import com.example.myapplication.models.Post
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PostApi {

    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>


   /* @POST("driver/login")
    @FormUrlEncoded
    fun getLoginPost(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("device_token") device_token: String
    ): Observable<LoginResponce>*/


    /*val params: HashMap<String, Any> = HashMap()
    params["userName"] = username
    params["password"] = password
    params["deviceId"] = FirebaseInstanceId.getInstance().token.toString()
    params["latitude"] = latitude
    params["longitude"] = longitude
    params["isTLUnlock"] = isTlUnlock
    params["appType"] = appType
    params["imeiNo"] = imeiNo*/

    @POST("Authenticate/Login/")
    @FormUrlEncoded
    fun getLoginPost(
        @Field("userName") userName: String,
        @Field("password") password: String,

        @Field("latitude") latitude: String,
        @Field("longitude") longitude: String,
        @Field("isTLUnlock") isTLUnlock: String,
        @Field("appType") appType: String,
        @Field("imeiNo") imeiNo: String,

        @Field("deviceId") deviceId: String
    ): Observable<UserResult>


}
