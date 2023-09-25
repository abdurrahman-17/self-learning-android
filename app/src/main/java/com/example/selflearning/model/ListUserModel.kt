package com.example.selflearning.model

import com.google.gson.annotations.SerializedName

data class ListUserModel(
    @SerializedName("data")
    val data : List<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val total_pages: Int
)