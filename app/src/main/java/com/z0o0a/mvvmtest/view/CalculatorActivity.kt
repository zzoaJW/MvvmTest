package com.z0o0a.mvvmtest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.z0o0a.mvvmtest.R
import com.z0o0a.mvvmtest.databinding.CalculatorActivityBinding
import com.z0o0a.mvvmtest.viewmodel.CalculatorVM

class CalculatorActivity : AppCompatActivity() {
    private lateinit var viewModel: CalculatorVM
    private lateinit var binding : CalculatorActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.calculator_activity)

        viewModel = ViewModelProvider(this).get(CalculatorVM::class.java)
        binding.vm = viewModel

        binding.lifecycleOwner = this

    }
}