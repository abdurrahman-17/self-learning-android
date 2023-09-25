package com.example.selflearning.model

import com.google.gson.annotations.SerializedName

data class SingleUserDataModel(
    @SerializedName("data")
    val data: SingleData,
    @SerializedName("support")
    val support: SingleSupport
)