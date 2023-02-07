package com.z0o0a.mvvmtest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.z0o0a.mvvmtest.R
import com.z0o0a.mvvmtest.databinding.DrinkInfoBinding
import com.z0o0a.mvvmtest.viewmodel.DrinkInfoVM

class DrinkInfo : AppCompatActivity() {
    private lateinit var viewModel: DrinkInfoVM
    private lateinit var binding : DrinkInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.drink_info)

        viewModel = ViewModelProvider(this)[DrinkInfoVM::class.java]
        binding.vm = viewModel

        binding.lifecycleOwner = this

    }
}