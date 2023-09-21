package com.example.searchimageprogram.Fragment.Save

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.searchimageprogram.R
import com.example.searchimageprogram.databinding.FragmentSaveBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SaveFragment : Fragment() {
    private val binding by lazy { FragmentSaveBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SaveFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}