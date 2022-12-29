package com.z0o0a.mvvmtest.viewmodel

import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorVM : ViewModel() {
    var _inputTxt = MutableLiveData<String>()
    private val _outputTxt = MutableLiveData<String>()
    init {
        _inputTxt.value = ""
        _outputTxt.value = "입력 전"
    }


//    val inputTxt : LiveData<String>
//        @InverseMethod("_inputTxt")
//        get() = _inputTxt
    val outputTxt : LiveData<String> get() = _outputTxt

    fun setOutputTxt(){
        _outputTxt.value = _inputTxt.value
    }
}