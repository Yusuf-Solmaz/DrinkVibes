package com.yusuf.drinkvibes.data.retrofit.api

import com.yusuf.drinkvibes.data.retrofit.entity.Beverages
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_COMFORTABLE_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_ENERGETIC_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_EXCITED_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_HAPPY_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_MOODS_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_ROMANTIC_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_SAD_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_STRESSFUL_URL
import com.yusuf.drinkvibes.utils.Utils.Companion.GET_TIRED_URL
import retrofit2.http.GET

interface BeveragesApi {



    @GET(GET_COMFORTABLE_URL)
    suspend fun getAllComfortableBeverages() : List<Beverages>

    @GET(GET_ENERGETIC_URL)
    suspend fun getAllEnergeticBeverages() : List<Beverages>

    @GET(GET_EXCITED_URL)
    suspend fun getAllExcitedBeverages() : List<Beverages>

    @GET(GET_HAPPY_URL)
    suspend fun getAllHappyBeverages() : List<Beverages>

    @GET(GET_ROMANTIC_URL)
    suspend fun getAllRomanticBeverages() : List<Beverages>

    @GET(GET_SAD_URL)
    suspend fun getAllSadBeverages() : List<Beverages>

    @GET(GET_STRESSFUL_URL)
    suspend fun getAllStressfulBeverages() : List<Beverages>

    @GET(GET_TIRED_URL)
    suspend fun getAllTiredBeverages() : List<Beverages>
}