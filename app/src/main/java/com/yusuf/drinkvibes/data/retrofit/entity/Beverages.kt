package com.yusuf.drinkvibes.data.retrofit.entity

import com.google.gson.annotations.SerializedName

data class Beverages(

    @SerializedName("id")
    val id: Int,

    @SerializedName("beverageName")
    val beverageName: String,

    @SerializedName("contents")
    val contents: String,

    @SerializedName("imageUrl")
    val imageUrl: String,

    @SerializedName("mood")
    val mood: String,

    @SerializedName("preparation")
    val preparation: String,

    @SerializedName("youtubeVideoId")
    val youtubeVideoId: String
)