package com.example.searchimageprogram.retrofit

import com.google.gson.annotations.SerializedName

data class SearchResponse (
    @SerializedName("meta")
    val searchMeta: SearchMeta,
    @SerializedName("documents")
    val searchDocument: ArrayList<SearchDocument>
)

data class SearchMeta (
    val total_count : Int,
    val pageable_count : Int,
    val is_end : Boolean
)

data class SearchDocument (
    //val collections : String,
    //val thumbnail_url : String,
    //val width : Int,
    //val height : Int,
    //val doc_url : String,
    val image_url : String,
    val display_sitename : String,
    val datetime : String
)
