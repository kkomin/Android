package com.example.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemBinding

class MainAdapter (val mItems : MutableList<ItemData>) : RecyclerView.Adapter<MainAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 클릭 시 이벤트 처리
        holder.itemView.setOnClickListener {
        }
        holder.image.setImageResource(mItems[position].image)
        holder.name.text = mItems[position].name
        holder.location.text = mItems[position].address
        holder.price.text = mItems[position].price
    }
    inner class Holder(binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
        val name = binding.tvName
        val location = binding.tvLocation
        val price = binding.tvPrice
    }
}