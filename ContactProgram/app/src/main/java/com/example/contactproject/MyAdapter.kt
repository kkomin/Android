package com.example.contactproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val mItems : MutableList<MyItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 즐겨찾기 여부 viewType 상수 정의
    private val TYPE_NORMAL = 0
    private val TYPE_SPECIAL = 1

    // 즐겨찾기 여부에 따른 리스트 정렬
    init {
        // 즐겨찾기 된 항목이 상단에 배치
        val sortedList = mItems.sortedBy { it.type == TYPE_NORMAL }
        mItems.clear()
        mItems.addAll(sortedList)
    }

    // 즐겨찾기 여부에 따른 viewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View
        return when(viewType) {
            TYPE_NORMAL -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle, parent, false)
                NormalHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle_favorite, parent, false)
                SpecialHolder(view)
            }
        }
    }
    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return mItems[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 선택한 아이템 상수로 정의
        val item = mItems[position].type
        when(item) {
            TYPE_NORMAL -> {
                (holder as NormalHolder).bind(mItems[position])
                holder.setIsRecyclable(false)
            }
            TYPE_SPECIAL -> {
                (holder as SpecialHolder).bind(mItems[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    // 즐겨찾기 안했을 시 viewHolder 클래스 정의
    inner class NormalHolder(view : View) : RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.imageView)
        val name = view.findViewById<TextView>(R.id.tvName)
        val number = view.findViewById<TextView>(R.id.tvNumber)

        fun bind(item:MyItem) {
            image.setImageResource(item.aIcon)
            name.text = item.aName
            number.text = item.aNumber
        }
    }

    // 즐겨찾기 시 viewHolder 클래스 정의
    inner class SpecialHolder(view:View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val name = view.findViewById<TextView>(R.id.tvName)
        val number = view.findViewById<TextView>(R.id.tvNumber)

        fun bind(item:MyItem) {
            image.setImageResource(item.aIcon)
            name.text = item.aName
            number.text = item.aNumber
        }
    }
}
