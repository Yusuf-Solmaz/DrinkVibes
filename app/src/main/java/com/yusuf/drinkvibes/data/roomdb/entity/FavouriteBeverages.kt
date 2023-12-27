package com.yusuf.drinkvibes.data.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "beverages")
data class FavouriteBeverages(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NotNull
    var id: Int,

    @ColumnInfo(name = "beverageName")
    @NotNull
    var beverageName: String,

    @ColumnInfo(name = "contents")
    @NotNull
    var contents: String,

    @ColumnInfo(name = "imageUrl")
    @NotNull
    var imageUrl: String,

    @ColumnInfo(name = "mood")
    @NotNull
    var mood: String,

    @ColumnInfo(name = "preparation")
    @NotNull
    var preparation: String,

    @ColumnInfo(name = "youtubeVideoId")
    @NotNull
    var youtubeVideoId: String
) : Serializable
