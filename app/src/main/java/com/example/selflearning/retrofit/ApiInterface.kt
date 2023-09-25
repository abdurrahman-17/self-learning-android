package com.example.selflearning.retrofit

import com.example.selflearning.model.ListUserModel
import com.example.selflearning.model.SingleUserDataModel
import com.example.selflearning.model.postDataModel.PostDataModel
import com.example.selflearning.model.postDataModel.PostDataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("users?page=")
    fun getData(): Call<ListUserModel>

    @POST("users")
    fun postData(@Body data: PostDataModel): Call<PostDataResponse>

    @GET("users/{id}")
    fun getSingleUserData(@Path("id") id: String): Call<SingleUserDataModel>
}