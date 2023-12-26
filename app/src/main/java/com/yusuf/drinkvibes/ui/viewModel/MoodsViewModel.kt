package com.yusuf.drinkvibes.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.drinkvibes.data.retrofit.entity.Moods
import com.yusuf.drinkvibes.data.retrofit.repository.MoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoodsViewModel @Inject constructor(val repo: MoodsRepository): ViewModel() {

    var moodList = MutableLiveData<List<Moods>>()

    var loading = MutableLiveData<Boolean>()



    fun getAllMoods(){
        loading.value = true
        viewModelScope.launch {
            try {
                moodList.value = repo.getAllMoods()
                loading.value = false
            }
            catch (e:Exception){
                Log.e("getAllMoods",e.message.toString())
            }
        }
    }


}