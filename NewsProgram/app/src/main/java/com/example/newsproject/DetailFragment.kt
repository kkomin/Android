package com.example.newsproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val detailTitle = view.findViewById<TextView>(R.id.detail_title)
        val detailArticle = view.findViewById<TextView>(R.id.detail_article)
        val detailDate = view.findViewById<TextView>(R.id.detail_date)
        val detailImage = view.findViewById<ImageView>(R.id.detail_image)

        arguments?.let {
            val title = it.getString("title")
            val article = it.getString("article")
            val date = it.getString("date")
            val image = it.getInt("image")

            detailTitle.text = title
            detailArticle.text = article
            detailDate.text = date
            detailImage.setImageResource(image)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(newsItem: NewsItem) =
            DetailFragment().apply {
                // 데이터를 Bundle에 설정
                arguments = Bundle().apply {
                    putString("title", newsItem.title)
                    putString("article", newsItem.article)
                    putString("date", newsItem.date)
                    putInt("image", newsItem.image)
                }
            }
    }
}