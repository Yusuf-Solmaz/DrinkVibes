package com.yusuf.drinkvibes.data.retrofit.service

import com.yusuf.drinkvibes.data.retrofit.entity.Moods

interface MoodsService {

    suspend fun getAllMoods() : List<Moods>
}