package com.yusuf.drinkvibes.data.retrofit.entity

data class Beverages(
    val beverageName: String,
    val contents: String,
    val id: Int,
    val imageUrl: String,
    val mood: String,
    val preparation: String,
    val youtubeVideoId: String
)