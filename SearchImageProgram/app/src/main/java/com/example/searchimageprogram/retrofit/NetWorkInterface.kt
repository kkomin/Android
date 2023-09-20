package com.example.searchimageprogram.retrofit

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

// 인터페이스 생성
interface NetWorkInterface {
    companion object {
        const val API_KEY = "4306e757a3c73ab1274bda8c58d629ff"
    }

    @GET("https://dapi.kakao.com/v2/search/image")
    suspend fun searchImages (
        @Header("Authorization") apiKey : String = API_KEY,
        @QueryMap param :HashMap<String, String>
        /*@Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int*/
    ) : SearchResponse
}
