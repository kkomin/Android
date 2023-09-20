package com.example.searchimageprogram.retrofit

import com.example.searchimageprogram.Constrant
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

// 인터페이스 생성
interface NetWorkInterface {
    @GET(Constrant.BASE_KEY)
    suspend fun searchImages (
        @Header("Authorization") apiKey : String = Constrant.API_KEY,
        @QueryMap param :HashMap<String, String>
        /*@Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int*/
    ) : SearchResponse
}
