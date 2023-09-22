package com.example.searchimageprogram.Fragment.Search

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchimageprogram.MainActivity
import com.example.searchimageprogram.R
import com.example.searchimageprogram.Data.SearchData
import com.example.searchimageprogram.databinding.ItemBinding
import com.example.searchimageprogram.retrofit.SearchDocument
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class SearchAdapter(
    private val mContext: Context,
    private val mItems: MutableList<SearchDocument>,
    private val mData : List<SearchData>
) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = mItems[position]
        // 문자열 파싱
        val parsed = OffsetDateTime.parse(item.datetime)
        // 원하는 형식으로 변환
        val parseDate = parsed.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val parseTime = parsed.format(DateTimeFormatter.ofPattern("HH:mm"))

        Glide.with(mContext)
            .load(item.image_url)
            .into(holder.image)
        holder.title.text = item.display_sitename
        holder.date.text = parseDate
        holder.time.text = parseTime
    }

    inner class SearchViewHolder(view :View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val title = view.findViewById<TextView>(R.id.title)
        val date = view.findViewById<TextView>(R.id.date)
        val time = view.findViewById<TextView>(R.id.time)
        val bookmark = view.findViewById<ImageButton>(R.id.bookmark)

        init {
            bookmark.setOnClickListener {
                // 아이템의 위치
                val position = adapterPosition
                // 아이템의 위치가 유효하다면
                if (position != RecyclerView.NO_POSITION) {
                    val userData = mData[position]
                    if (userData.isSave) {
                        bookmark.setImageResource(R.drawable.bookmark_empty)
                        (mContext as MainActivity).removeItemList(userData)
                        Log.d("remove", "제거")
                    } else {
                        bookmark.setImageResource(R.drawable.bookmark_fill)
                        (mContext as MainActivity).addItemList(userData)
                        Log.d("add", "추가")
                    }
                    userData.isSave = !userData.isSave
                }
            }
        }
    }
}