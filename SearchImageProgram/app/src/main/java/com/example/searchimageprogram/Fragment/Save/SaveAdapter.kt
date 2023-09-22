package com.example.searchimageprogram.Fragment.Save

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchimageprogram.Data.SearchData
import com.example.searchimageprogram.R
import com.example.searchimageprogram.databinding.ItemBinding
import com.example.searchimageprogram.retrofit.SearchDocument
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class SaveAdapter(private val mContext: Context, var mData: List<SearchData>) :
    RecyclerView.Adapter<SaveAdapter.SaveViewHolder>() {
    private val mItems = mutableListOf<SearchDocument>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        view.bookmark.setImageResource(R.drawable.bookmark_fill)
        return SaveViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: SaveViewHolder, position: Int) {
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

    inner class SaveViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
        val title = binding.title
        val date = binding.date
        val time = binding.time

        // mItems 리스트 초기화
        init {
            mData.forEach { searchData ->
                mItems.add(SearchDocument(searchData.url, searchData.site, searchData.dateTime))
            }
        }
    }
}
