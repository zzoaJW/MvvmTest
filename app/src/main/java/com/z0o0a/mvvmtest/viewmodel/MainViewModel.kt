package com.z0o0a.mvvmtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// view model
class MainViewModel : ViewModel() {
    // 데이터 원본
    private val _currentValue = MutableLiveData<Int>()
    private val _currentValue2 = MutableLiveData<Int>()
    init {
        _currentValue.value = 0
        _currentValue2.value = 0
    }

    // Getter (무결성을 위하여)
    val currentValue : LiveData<Int> get() = _currentValue
    val currentValue2 : LiveData<Int> get() = _currentValue2

    // Setter
    fun setValueUpDown(type : Int){
        when(type){
            1 -> _currentValue.value = _currentValue.value!!.plus(1)
            2 -> _currentValue.value = _currentValue.value!!.minus(1)
        }
    }

    fun setValue2(){
        _currentValue2.value = _currentValue.value
    }
}