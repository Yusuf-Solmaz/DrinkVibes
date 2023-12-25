package com.yusuf.drinkvibes.data.retrofit.api

import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.utils.Utils
import retrofit2.http.GET

interface MoodsApi {

    @GET(Utils.GET_MOODS_URL)
    suspend fun getAllMoods() : List<Moods>
}