package com.z0o0a.mvvmtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.z0o0a.mvvmtest.R
import com.z0o0a.mvvmtest.databinding.RecyclerviewItemBinding
import com.z0o0a.mvvmtest.model.Drink

class RecyclerviewAdapter: RecyclerView.Adapter<RecyclerviewAdapter.DrinkViewHolder>(){
    private var drinkList = ArrayList<Drink>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DrinkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(drinkList[position])

        holder.binding.btnDrinkDel.setOnClickListener {
            delDrink(position)
        }
    }

    override fun getItemCount() = drinkList.size

    inner class DrinkViewHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentDrink : Drink) {
            binding.drink = currentDrink
        }
    }

    fun delDrink(position: Int){
        drinkList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, drinkList.size)
    }

    fun setDrinkList(drinks:ArrayList<Drink>){
        this.drinkList = drinks
        notifyDataSetChanged()
    }
}