package com.yusuf.drinkvibes.data.retrofit.service

import com.yusuf.drinkvibes.data.retrofit.entity.Beverages
import com.yusuf.drinkvibes.utils.Utils
import retrofit2.http.GET

interface BeveragesService {

    suspend fun getAllComfortableBeverages() : List<Beverages>


    suspend fun getAllEnergeticBeverages() : List<Beverages>


    suspend fun getAllExcitedBeverages() : List<Beverages>


    suspend fun getAllHappyBeverages() : List<Beverages>


    suspend fun getAllRomanticBeverages() : List<Beverages>


    suspend fun getAllSadBeverages() : List<Beverages>


    suspend fun getAllStressfulBeverages() : List<Beverages>


    suspend fun getAllTiredBeverages() : List<Beverages>

}