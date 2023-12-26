package com.yusuf.drinkvibes.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.drinkvibes.data.retrofit.entity.Beverages
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.data.retrofit.repository.BeveragesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeveragesViewModel @Inject constructor(val repo: BeveragesRepository) : ViewModel() {

    var beverageList = MutableLiveData<List<Beverages>>()
    var loading = MutableLiveData<Boolean>()


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
}

