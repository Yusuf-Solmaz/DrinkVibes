package com.yusuf.drinkvibes.data.retrofit.repository

import com.yusuf.drinkvibes.data.retrofit.api.BeveragesApi
import com.yusuf.drinkvibes.data.retrofit.entity.Beverages
import com.yusuf.drinkvibes.data.retrofit.service.BeveragesService

class BeveragesRepository (val api: BeveragesApi) : BeveragesService{

    override suspend fun getAllComfortableBeverages(): List<Beverages> {
        return api.getAllComfortableBeverages()
    }

    override suspend fun getAllEnergeticBeverages(): List<Beverages> {
        return api.getAllEnergeticBeverages()
    }

    override suspend fun getAllExcitedBeverages(): List<Beverages> {
        return api.getAllExcitedBeverages()
    }

    override suspend fun getAllHappyBeverages(): List<Beverages> {
        return api.getAllHappyBeverages()
    }

    override suspend fun getAllRomanticBeverages(): List<Beverages> {
        return api.getAllRomanticBeverages()
    }

    override suspend fun getAllSadBeverages(): List<Beverages> {
        return api.getAllSadBeverages()
    }

    override suspend fun getAllStressfulBeverages(): List<Beverages> {
        return  api.getAllStressfulBeverages()
    }

    override suspend fun getAllTiredBeverages(): List<Beverages> {
       return api.getAllTiredBeverages()
    }
}