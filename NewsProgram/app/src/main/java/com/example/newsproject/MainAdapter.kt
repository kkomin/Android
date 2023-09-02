package com.example.newsproject

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.databinding.ItemRecyclerBinding

class MainAdapter(val mItems : List<NewsItem>) : RecyclerView.Adapter<MainAdapter.Holder>(){
    interface ItemClick {
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.Holder, position: Int) {
        holder.img.setImageResource(mItems[position].image)
        holder.title.text = mItems[position].title
        holder.content.text = mItems[position].article
        holder.Date.text = mItems[position].date

        // view 클릭시 view 및 position 넘기기
        holder.itemView.setOnClickListener {
            view -> itemClick?.onClick(view, position)
        }
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