package com.example.kotlinrecyclertask

//import ListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface service {



    @GET("Category/Sectors")
    public fun getListCat(@Query("count")cout:Int): Call<List<DataModel>>
}