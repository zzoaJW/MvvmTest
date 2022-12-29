package com.z0o0a.mvvmtest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.z0o0a.mvvmtest.R
import com.z0o0a.mvvmtest.databinding.ActivityMainBinding
import com.z0o0a.mvvmtest.databinding.FragmentActivityBinding
import com.z0o0a.mvvmtest.viewmodel.FragmentVM

class FragmentActivity : AppCompatActivity() {
    private lateinit var viewModel: FragmentVM
    private lateinit var binding : FragmentActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_activity)

        viewModel = ViewModelProvider(this).get(FragmentVM::class.java)
        binding.vm = viewModel

        binding.lifecycleOwner = this

    }
}