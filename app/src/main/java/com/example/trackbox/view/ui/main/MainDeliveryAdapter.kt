package com.example.trackbox.view.ui.main

import android.annotation.SuppressLint
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trackbox.databinding.ItemMainBinding
import com.example.trackbox.model.entity.Delivery

class MainDeliveryAdapter : RecyclerView.Adapter<MainDeliveryAdapter.ViewHolder>() {

    private var deliveryList : List<Delivery> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainDeliveryAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainDeliveryAdapter.ViewHolder, position: Int) {
        holder.bind(deliveryList[position])
    }

    override fun getItemCount(): Int {
        return deliveryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(delivery: List<Delivery>){
        this.deliveryList = delivery
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ItemMainBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(delivery : Delivery){
            binding.delivery = delivery
        }
    }
}