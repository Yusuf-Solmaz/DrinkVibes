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
    var id: Int = 0,

    @ColumnInfo(name = "beverageName")
    var beverageName: String ="",

    @ColumnInfo(name = "contents")
    var contents: String ="",

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String ="",

    @ColumnInfo(name = "mood")
    var mood: String ="",

    @ColumnInfo(name = "preparation")
    var preparation: String ="",

    @ColumnInfo(name = "youtubeVideoId")
    var youtubeVideoId: String =""
)