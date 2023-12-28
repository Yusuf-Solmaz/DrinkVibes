package com.yusuf.drinkvibes.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.drinkvibes.data.retrofit.entity.Beverages
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.data.retrofit.repository.BeveragesRepository
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import com.yusuf.drinkvibes.data.roomdb.repo.FavouriteBeveragesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeveragesViewModel @Inject constructor(val repo: BeveragesRepository,val favRepo:FavouriteBeveragesRepository) : ViewModel() {

    var beverageList = MutableLiveData<List<Beverages>>()
    var loading = MutableLiveData<Boolean>()
    val isFavouriteBeverageLiveData =  MutableLiveData<Boolean>()


    fun getBeverages(moods: Moods) {
        loading.value=true
        viewModelScope.launch {
            when (moods.moodName) {

                "Mutlu" -> {
                    beverageList.value = repo.api.getAllHappyBeverages()
                }

                "Hüzünlü" -> {
                    beverageList.value = repo.api.getAllSadBeverages()
                }

                "Enerjik" -> {
                    beverageList.value = repo.api.getAllEnergeticBeverages()
                }

                "Romantik" -> {
                    beverageList.value = repo.api.getAllRomanticBeverages()
                }

                "Stresli" -> {
                    beverageList.value = repo.api.getAllStressfulBeverages()
                }

                "Rahat" -> {
                    beverageList.value = repo.api.getAllComfortableBeverages()
                }

                "Yorgun" -> {
                    beverageList.value = repo.api.getAllTiredBeverages()
                }

                "Heyecanlı" -> {
                    beverageList.value = repo.api.getAllExcitedBeverages()
                }

            }
        }

    }

    fun saveFavBeverages(favbeverage: FavouriteBeverages){
            favRepo.addFavouriteBeverage(favbeverage)
            Log.i("favBeverage",favbeverage.toString())

    }

    fun isFavouriteBeverage(query:String) {
        val isFavBeverage = favRepo.isFavourite(query)
        Log.i("isFavResult",isFavBeverage.isEmpty().toString())
        isFavouriteBeverageLiveData.value = isFavBeverage.isNotEmpty()
    }

    fun deleteFromFavourite(favbeverage: FavouriteBeverages){
        favRepo.deleteBeverage(favbeverage)
    }
}

