package com.yusuf.drinkvibes.data.roomdb.repo

import com.yusuf.drinkvibes.data.roomdb.Dao.FavouriteBeveragesDao
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import com.yusuf.drinkvibes.data.roomdb.service.FavouriteBeveragesService

class FavouriteBeveragesRepository(var favBeveraegsDao: FavouriteBeveragesDao) : FavouriteBeveragesService {
    override suspend fun getAllFavouriteBeverages(): List<FavouriteBeverages> {
        return favBeveraegsDao.getAllFavouriteBeverages()
    }
}