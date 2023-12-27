package com.yusuf.drinkvibes.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.drinkvibes.data.retrofit.repository.BeveragesRepository
import com.yusuf.drinkvibes.data.roomdb.entity.FavouriteBeverages
import com.yusuf.drinkvibes.data.roomdb.repo.FavouriteBeveragesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteBeveragesViewModel @Inject constructor(val repo: FavouriteBeveragesRepository) : ViewModel() {

    var favouriteBeverages = MutableLiveData<List<FavouriteBeverages>>()

    fun getAllFavouriteBeverages(){
            favouriteBeverages.value = repo.getAllFavouriteBeverages()
    }

    fun deleteBeverage(beverages: FavouriteBeverages){
        repo.deleteBeverage(beverages)
        getAllFavouriteBeverages()
    }
}