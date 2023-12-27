package com.yusuf.drinkvibes.di

import android.content.Context
import androidx.room.Room
import com.yusuf.drinkvibes.data.retrofit.api.BeveragesApi
import com.yusuf.drinkvibes.data.retrofit.api.MoodsApi
import com.yusuf.drinkvibes.data.retrofit.repository.BeveragesRepository
import com.yusuf.drinkvibes.data.retrofit.repository.MoodsRepository
import com.yusuf.drinkvibes.data.roomdb.Dao.FavouriteBeveragesDatabase
import com.yusuf.drinkvibes.data.roomdb.Dao.FavouriteBeveragesDao
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import com.yusuf.drinkvibes.data.roomdb.repo.FavouriteBeveragesRepository
import com.yusuf.drinkvibes.utils.Utils.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFavouriteBeveragesRepository(dao:FavouriteBeveragesDao): FavouriteBeveragesRepository{
        return FavouriteBeveragesRepository(dao)
    }

    @Provides
    @Singleton
    fun provideFavouriteBeveragesDao(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,FavouriteBeveragesDatabase::class.java,"beverages"
    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build().getFavouriteBeveragesDao()


    @Provides
    @Singleton
    fun provideBeveragesRepository(api: BeveragesApi): BeveragesRepository{
        return BeveragesRepository(api)
    }

    @Provides
    @Singleton
    fun provideMoodsRepository(api: MoodsApi): MoodsRepository{
        return MoodsRepository(api)
    }

    @Provides
    @Singleton
    fun provideBeveragesApi() : BeveragesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeveragesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMoodsApi() : MoodsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoodsApi::class.java)
    }


}