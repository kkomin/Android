package com.example.newsproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsItem(
    val title : String,
    val article : String,
    //날짜 및 이미지 넣고 싶어서 추가함
    val date : String,
    val image : Int
) : Parcelable
