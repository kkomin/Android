package com.example.searchimageprogram.retrofit

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetWorkInterface {
    @GET("https://dapi.kakao.com/v2/search/image")
    suspend fun searchImage (
        @Header("Authorization") apiKey : String = "4306e757a3c73ab1274bda8c58d629ff",
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : SearchResponse
}