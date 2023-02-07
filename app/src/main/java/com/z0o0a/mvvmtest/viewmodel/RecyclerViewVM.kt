package com.z0o0a.mvvmtest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.z0o0a.mvvmtest.model.Drink
import com.z0o0a.mvvmtest.model.DrinkData
import com.z0o0a.mvvmtest.repository.DrinkRepository

class RecyclerViewVM(application: Application) : AndroidViewModel(application) {
    private val repo = DrinkRepository(application)
    private val drinks = repo.getAll()

    // 데이터 원본
    var _inputName = MutableLiveData<String>()
    var _inputVintage = MutableLiveData<String>()
//    private val _drinkList = MutableLiveData<ArrayList<Drink>>()
//    private var items = ArrayList<Drink>()

    init {
        _inputName.value = ""
        _inputVintage.value = ""
//        items = arrayListOf()
//        _drinkList.value = items
    }
//
//    // Getter (무결성을 위하여)
//    val drinkList: LiveData<ArrayList<Drink>> get() = _drinkList
//
//    // Setter
//    fun addDrink(){
//        items.add(Drink(_inputName.value!!, _inputVintage.value!!))
//        _drinkList.value = items
//    }
//
//    fun getAll():LiveData<ArrayList<Drink>>{
//        return drinkList
//    }

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