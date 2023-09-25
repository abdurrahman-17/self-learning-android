package com.example.selflearning.model

import com.google.gson.annotations.SerializedName

data class SingleSupport(
    @SerializedName("text")
    val text: String,
    @SerializedName("url")
    val url: String
)