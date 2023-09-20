package com.example.searchimageprogram.retrofit

import com.example.searchimageprogram.Constrant
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

// 인터페이스 생성
interface NetWorkInterface {
    @GET(Constrant.BASE_URL)
    suspend fun searchImages (
        @Header("Authorization") apiKey : String,
        @QueryMap param :HashMap<String, String>
    ) : SearchResponse
}
