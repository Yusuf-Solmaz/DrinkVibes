package com.yusuf.drinkvibes.data.roomdb.Dao

import androidx.room.Dao
import androidx.room.Query
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages

@Dao
interface FavouriteBeveragesDao {

    @Query("Select * From beverages")
    suspend fun getAllFavouriteBeverages() : List<FavouriteBeverages>



}