package com.yusuf.drinkvibes.utils

import com.yusuf.drinkvibes.data.retrofit.entity.Beverages
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages

class Utils {

    companion object{

        const val BASE_URL= "https://raw.githubusercontent.com/"

        const val GET_MOODS_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Moods.json"
        const val GET_COMFORTABLE_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Comfortable.json"
        const val GET_ENERGETIC_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Energetic.json"
        const val GET_EXCITED_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Excited.json"
        const val GET_HAPPY_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Happy.json"
        const val GET_ROMANTIC_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Romantic.json"
        const val GET_SAD_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Sad.json"
        const val GET_STRESSFUL_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Stressful.json"
        const val GET_TIRED_URL= "/Yusuf-Solmaz/MyData/main/Beverages/Tired.json"

        fun Beverages.toFavBeverages(): FavouriteBeverages {
            return FavouriteBeverages(
                id, beverageName, contents, imageUrl, mood, preparation, youtubeVideoId
            )
        }

        fun FavouriteBeverages.toBeverages(): Beverages{
            return Beverages(id, beverageName, contents, imageUrl, mood, preparation, youtubeVideoId)
        }
    }





}