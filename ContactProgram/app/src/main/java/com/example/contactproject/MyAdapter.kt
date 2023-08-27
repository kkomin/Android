package com.example.contactproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.contactproject.databinding.ItemRecycleBinding
import com.example.contactproject.databinding.ItemRecycleFavoriteBinding

class MyAdapter(val mItems : MutableList<MyItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 즐겨찾기 여부 viewType 상수 정의
    private val TYPE_NORMAL = 0
    private val TYPE_SPECIAL = 1

    // 즐겨찾기 여부에 따른 viewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TYPE_NORMAL -> {
                val binding = ItemRecycleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                NormalHolder(binding)
            }
            TYPE_SPECIAL -> {
                val binding = ItemRecycleFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SpecialHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 선택한 아이템 상수로 정의
        val item = mItems[position]

        when(holder) {
            is NormalHolder -> {
                holder.image.setImageResource(item.aIcon)
                holder.name.text = item.aName
                holder.number.text = item.aNumber
            }
            is SpecialHolder -> {
                holder.image.setImageResource(item.aIcon)
                holder.name.text = item.aName
                holder.number.text = item.aNumber
            }
        }
    }

    // 즐겨찾기 안했을 시 viewHolder 클래스 정의
    inner class NormalHolder(binding : ItemRecycleBinding) : RecyclerView.ViewHolder(binding.root){
        val image = binding.imageView
        val name = binding.tvName
        val number = binding.tvNumber
        //val favorite = binding.star
    }

    // 즐겨찾기 시 viewHolder 클래스 정의
    inner class SpecialHolder(binding : ItemRecycleFavoriteBinding) : RecyclerView.ViewHolder(binding.root){
        val image = binding.imageView
        val name = binding.tvName
        val number = binding.tvNumber
        //val favorite = binding.star
    }
}
