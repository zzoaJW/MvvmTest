package com.z0o0a.mvvmtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.z0o0a.mvvmtest.R
import com.z0o0a.mvvmtest.databinding.ActivityMainBinding
import com.z0o0a.mvvmtest.viewmodel.MainViewModel

// view
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm = viewModel

        binding.lifecycleOwner = this
    }
}