package com.z0o0a.mvvmtest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.z0o0a.mvvmtest.model.DrinkData
import com.z0o0a.mvvmtest.repository.DrinkRepository

class RecyclerViewVM(application: Application) : AndroidViewModel(application) {
    private val repo = DrinkRepository(application)
    private val drinks = repo.getAll()

    // 데이터 원본
    var _inputName = MutableLiveData<String>()
    var _inputVintage = MutableLiveData<String>()

    init {
        _inputName.value = ""
        _inputVintage.value = ""
    }

    fun insert(){
        repo.insert(DrinkData(0, _inputName.value!!, _inputVintage.value!!))
    }

    fun delete(drinkData : DrinkData){
        repo.delete(drinkData)
    }

    fun getAll(): LiveData<List<DrinkData>>{
        return drinks
    }

}