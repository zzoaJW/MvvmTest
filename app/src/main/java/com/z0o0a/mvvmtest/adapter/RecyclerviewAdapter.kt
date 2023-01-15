package com.z0o0a.mvvmtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.z0o0a.mvvmtest.R
import com.z0o0a.mvvmtest.databinding.RecyclerviewItemBinding
import com.z0o0a.mvvmtest.model.Drink

class RecyclerviewAdapter: RecyclerView.Adapter<RecyclerviewAdapter.DrinkViewHolder>(){
    var drinkList = mutableListOf<Drink>()

    inner class DrinkViewHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentDrink : Drink) {
            binding.drink = currentDrink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DrinkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(drinkList[position])
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    fun setData(data : ArrayList<Drink>){
        drinkList = data
        notifyDataSetChanged()
    }
}