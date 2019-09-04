package com.example.kotlinrecyclertask

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import java.util.concurrent.TimeUnit


class ApiClient {



    companion object{
        private val BasuRl: String = "http://40.85.116.121:8678/api/"

        private var retrofit: Retrofit? = null
        public  fun  getClient(): Retrofit? {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BasuRl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build()
            }

            return retrofit
        }
    }

}