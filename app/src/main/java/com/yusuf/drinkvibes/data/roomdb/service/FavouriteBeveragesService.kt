package com.yusuf.drinkvibes.data.roomdb.service

import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages

interface FavouriteBeveragesService {

    suspend fun getAllFavouriteBeverages() : List<FavouriteBeverages>

}