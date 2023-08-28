package com.example.applemarket

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemBinding

class MainAdapter (val mItems : MutableList<ItemData>) : RecyclerView.Adapter<MainAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }
    inner class Holder(val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
        val name = binding.tvName
        val location = binding.tvLocation
        val price = binding.tvPrice
    }
}