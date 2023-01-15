package com.z0o0a.mvvmtest.viewmodel

import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.z0o0a.mvvmtest.model.Drink

class RecyclerViewVM : ViewModel() {
    // 데이터 원본
    var _inputName = MutableLiveData<String>()
    var _inputVintage = MutableLiveData<String>()
    private val _drinkList = MutableLiveData<ArrayList<Drink>>()
    private var items = ArrayList<Drink>()

    init {
        _inputName.value = ""
        _inputVintage.value = ""
        items = arrayListOf(Drink("이름이름", "700"))
        _drinkList.value = items
    }

    // Getter (무결성을 위하여)
//    val inputName : LiveData<String> get() = _inputName
//    val inputVintage : LiveData<String> get() = _inputVintage
    val drinkList: LiveData<ArrayList<Drink>> get() = _drinkList

    // Setter
    fun addDrink(){
        items.add(Drink(_inputName.value!!, _inputVintage.value!!))
        _drinkList.value = items
    }

    fun getAll():LiveData<ArrayList<Drink>>{
        return drinkList
    }

}