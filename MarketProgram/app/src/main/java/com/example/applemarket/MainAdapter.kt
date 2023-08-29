package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemBinding
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class MainAdapter(val mItems: MutableList<ItemData>) : RecyclerView.Adapter<MainAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

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
        holder.itemView.setOnClickListener {
            // 클릭시 이벤트 추가
            itemClick?.onClick(it, position)
        }

        // 천단위 콤마( , ) 찍기
        val formatPrice = DecimalFormat("#,###").format(mItems[position].price)

        // 클릭 시 이벤트 처리
        holder.itemView.setOnClickListener {
        }
        holder.image.setImageResource(mItems[position].image)
        holder.name.text = mItems[position].name
        holder.location.text = mItems[position].address
        holder.price.text = formatPrice
        holder.chat.text = mItems[position].chat.toString()
        holder.heart.text = mItems[position].heart.toString()
    }

    inner class Holder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
        val name = binding.tvName
        val location = binding.tvLocation
        val price = binding.tvPrice
        val chat = binding.chat
        val heart = binding.heart
    }
}