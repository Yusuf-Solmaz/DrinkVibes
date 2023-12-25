package com.yusuf.drinkvibes.data.retrofit.repository

import com.yusuf.drinkvibes.data.retrofit.api.BeveragesApi
import com.yusuf.drinkvibes.data.retrofit.api.MoodsApi
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.data.retrofit.service.MoodsService

class MoodsRepository(val api: MoodsApi) : MoodsService {
    override suspend fun getAllMoods(): List<Moods> {
        return api.getAllMoods()
    }
}