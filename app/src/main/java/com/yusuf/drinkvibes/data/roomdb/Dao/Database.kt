package com.yusuf.drinkvibes.data.roomdb.Dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages

@Database(entities = [FavouriteBeverages::class],version = 1)
abstract class Database :RoomDatabase() {
    abstract fun getFavouriteBeveragesDao(): FavouriteBeveragesDao
}