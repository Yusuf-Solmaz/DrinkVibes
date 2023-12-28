package com.yusuf.drinkvibes.data.roomdb.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages

@Dao
interface FavouriteBeveragesDao {

    @Query("Select * From beverages")
    fun getAllFavouriteBeverages() : List<FavouriteBeverages>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavouriteBeverage(beverages: FavouriteBeverages)

    @Delete
    fun deleteFavouriteBeverage(beverages: FavouriteBeverages)

    @Query("SELECT * FROM beverages WHERE beverageName = :searchString")
    fun isFavouriteBeverage(searchString: String): List<FavouriteBeverages>
}