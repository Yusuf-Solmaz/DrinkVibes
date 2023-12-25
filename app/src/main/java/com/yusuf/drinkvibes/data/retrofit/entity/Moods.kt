package com.yusuf.drinkvibes.data.retrofit.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Moods(

    @SerializedName("id")
    val id: Int,

    @SerializedName("moodName")
    val moodName: String
) : Serializable