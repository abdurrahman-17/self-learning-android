package com.example.selflearning.model.postDataModel

import com.google.gson.annotations.SerializedName

data class PostDataModel(
    @SerializedName("job")
    val job: String,
    @SerializedName("name")
    val name: String
)