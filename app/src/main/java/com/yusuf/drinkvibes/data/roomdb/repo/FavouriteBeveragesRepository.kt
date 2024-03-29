package com.yusuf.drinkvibes.data.roomdb.repo

import android.util.Log
import com.yusuf.drinkvibes.data.roomdb.Dao.FavouriteBeveragesDao
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages

class FavouriteBeveragesRepository(var favBeveraegsDao: FavouriteBeveragesDao) {
    fun getAllFavouriteBeverages(): List<FavouriteBeverages> {
        Log.i("favbeverages",favBeveraegsDao.getAllFavouriteBeverages().toString())
        return favBeveraegsDao.getAllFavouriteBeverages()
    }

    fun addFavouriteBeverage(favouriteBeverages: FavouriteBeverages) {
        favBeveraegsDao.addFavouriteBeverage(favouriteBeverages)
    }

    fun deleteBeverage(favouriteBeverages: FavouriteBeverages){
        favBeveraegsDao.deleteFavouriteBeverage(favouriteBeverages)
    }

    fun isFavourite(query:String) : List<FavouriteBeverages>{
        return favBeveraegsDao.isFavouriteBeverage(query)
    }

}