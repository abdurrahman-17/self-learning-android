package com.example.selflearning.model.postDataModel

import com.google.gson.annotations.SerializedName

data class PostDataResponse(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("job")
    val job: String,
    @SerializedName("name")
    val name: String
)