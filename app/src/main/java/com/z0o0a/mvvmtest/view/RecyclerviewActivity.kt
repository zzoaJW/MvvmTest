package com.z0o0a.mvvmtest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.z0o0a.mvvmtest.R
import com.z0o0a.mvvmtest.adapter.RecyclerviewAdapter
import com.z0o0a.mvvmtest.databinding.ActivityMainBinding
import com.z0o0a.mvvmtest.databinding.RecyclerviewActivityBinding
import com.z0o0a.mvvmtest.viewmodel.RecyclerViewVM

class RecyclerviewActivity : AppCompatActivity() {
    private lateinit var viewModel: RecyclerViewVM
    private lateinit var binding : RecyclerviewActivityBinding
    private lateinit var adapter: RecyclerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.recyclerview_activity)

        viewModel = ViewModelProvider(this)[RecyclerViewVM::class.java]
        binding.vm = viewModel

        binding.lifecycleOwner = this

        initRecyclerView()

        viewModel.getAll().observe(this, Observer {
            adapter.setDrinkList(it)
        })


    }

    private fun initRecyclerView(){
        adapter = RecyclerviewAdapter()
        binding.recyclerviewDrink.adapter = adapter
        binding.recyclerviewDrink.layoutManager = LinearLayoutManager(applicationContext)
    }
}