package com.yusuf.drinkvibes.data.retrofit.entity

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import java.io.Serializable

@Entity(tableName = "beverages")
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
) : Serializable {



}
