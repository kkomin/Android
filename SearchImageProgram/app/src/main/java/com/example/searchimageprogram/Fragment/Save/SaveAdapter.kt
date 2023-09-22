package com.example.searchimageprogram.Fragment.Save

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchimageprogram.Data.SearchData
import com.example.searchimageprogram.MainActivity
import com.example.searchimageprogram.R
import com.example.searchimageprogram.databinding.ItemBinding
import com.example.searchimageprogram.retrofit.SearchDocument
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class SaveAdapter(private val mContext: Context, var mData: MutableList<SearchData>) :
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

        // 저장된 항목 제거
        holder.bookmark.setOnClickListener {
            val position = holder.adapterPosition
            // 인덱스 오류 방지
            if(position != RecyclerView.NO_POSITION){
                val userData = mData[position]
                // 해당 아이템을 저장한 리스트 제거
                (mContext as MainActivity).removeItemList(userData)
                // SearchData 리스트에서 해당 위치의 아이템 제거
                mData.removeAt(position)
                Log.d("removeData", "$mData")
                // position 항목 제거 후 recyclerview 갱신
                notifyItemRemoved(position)
            }
        }
    }

    inner class SaveViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
        val title = binding.title
        val date = binding.date
        val time = binding.time
        val bookmark = binding.bookmark

        // 생성자에서 Documnet를 리스트를 mData 항목을 복사해 초기화
        init {
/*            // mItems 리스트 초기화
            mData.forEach { searchData ->
                mItems.add(SearchDocument(searchData.url, searchData.site, searchData.dateTime))
            }*/
            // 생성자에서 Document 초기화
            mItems.addAll(mData.map {
                SearchDocument(it.url, it.site, it.dateTime)
            })
        }
    }
}
