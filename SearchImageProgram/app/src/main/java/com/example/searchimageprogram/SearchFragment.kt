package com.example.searchimageprogram

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.searchimageprogram.databinding.FragmentSearchBinding
import com.example.searchimageprogram.retrofit.NetWorkClient
import com.example.searchimageprogram.retrofit.SearchDocument
import kotlinx.coroutines.launch

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchFragment : Fragment() {
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private var items = mutableListOf<SearchDocument>()
    private val handler = Handler(Looper.getMainLooper())

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.searchbtn.setOnClickListener {
            val input = binding.searchEditText.text.toString()
            if (!input.isNullOrEmpty()) {
                val trimInput = input.trim()
                communicateNetwork(queryParameter(trimInput))
            } else
                Toast.makeText(context, "검색어를 입력해주세요.", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }


    private fun communicateNetwork(param: HashMap<String, String>) = lifecycleScope.launch {
        val authorization = "KakaoAK ${Constrant.API_KEY}"
        val response = NetWorkClient.service.searchImages(authorization, param)
        items = response.searchDocument!!
        handler.post {
            binding.searchRecyclerView.apply {
                Log.d("ImageSearch", items.toString())
                // 어댑터 업데이트
                adapter = SearchAdapter(context, items)
                // recyclerview 일정하게
                setHasFixedSize(true)
            }
        }
    }

    private fun queryParameter(input: String): HashMap<String, String> {
        return hashMapOf(
            "query" to input,
            "sort" to "recency",
            "page" to "1",
            "size" to "80"
        )
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}