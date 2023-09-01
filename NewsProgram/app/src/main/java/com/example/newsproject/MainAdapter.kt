package com.example.newsproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.databinding.ItemRecyclerBinding

class MainAdapter(val mItems : MutableList<NewsItem>) : RecyclerView.Adapter<MainAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.Holder, position: Int) {
        holder.img
        holder.title
        holder.content
        holder.Date
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder( binding : ItemRecyclerBinding ) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imageView
        val title = binding.tvTitle
        val content = binding.tvContext
        val Date = binding.tvDate
    }
}