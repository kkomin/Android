package com.example.searchimageprogram.Fragment.Save

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchimageprogram.databinding.ItemBinding


class SaveAdapter (private val mContext: Context) : RecyclerView.Adapter<SaveAdapter.SaveViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHolder {
        val view =ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SaveViewHolder(view)
    }

    override fun getItemCount(): Int {
    }

    override fun onBindViewHolder(holder: SaveViewHolder, position: Int) {

    }
    inner class SaveViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
