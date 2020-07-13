package com.example.marsapi


import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.util.*

interface Football {

//    @GET("sports?page=1&pageSize=15&order=asc")
//    fun getShopsByCategories(@Query("page")  page:Int,
//                             @Query("pageSize")  pageSize:Int,
//                             @Query("order")  order:String
//    ): Observable<JsonObject>


    @GET("/v1/sports?page=1&pageSize=15&order=asc")
    fun getdata(): Call<FootballList>


}