package com.example.searchimageprogram.retrofit

import com.google.gson.annotations.SerializedName

data class SearchResponse (
    @SerializedName("meta")
    val searchMeta: SearchMeta,
    @SerializedName("documents")
    val searchDocument: MutableList<SearchDocument>
)

data class SearchMeta (
    val total_count : Int,
    val pageable_count : Int,
    val is_end : Boolean
)

data class SearchDocument (
    val image_url : String,
    val display_sitename : String,
    val datetime : String
)
