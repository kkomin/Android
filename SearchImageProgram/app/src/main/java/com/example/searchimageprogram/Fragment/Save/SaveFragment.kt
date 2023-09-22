package com.example.searchimageprogram.Fragment.Save

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.searchimageprogram.Data.SearchData
import com.example.searchimageprogram.MainActivity
import com.example.searchimageprogram.databinding.FragmentSaveBinding

class SaveFragment : Fragment() {
    private val binding by lazy { FragmentSaveBinding.inflate(layoutInflater) }
    private var savedList : List<SearchData> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedList = (activity as MainActivity).saveList

        binding.saveRecyclerview.adapter = SaveAdapter(requireContext()).apply {
            mData = savedList.toMutableList()
            Log.d("Data", "$mData")
        }

        binding.saveRecyclerview.apply {
            adapter = SaveAdapter(requireContext())
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}