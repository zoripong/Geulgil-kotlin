package com.five.high.emirim.geulgil.geulgil.network

import com.five.high.emirim.geulgil.geulgil.network.model.Word
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

/**
 * Created by Mirim on 2018-10-05.
 */
interface RetrofitService {

//    @GET("/")
//    fun search(): Call<Word>

    @GET("search/{search_word}")
    fun search(@Path("search_word")searchWord: String): Call<Word>

    @GET("search/{search_word}/similar")
    fun searchInSimilar(@Path("search_word")searchWord: String): Call<Word>

    @GET("search/{search_word}/mean")
    fun searchInMean(@Path("search_word")searchWord: String): Call<Word>

    /**
     * Companion object to create the RetrofitService
     */
    /*
    * usage
    * val retrofitService = RetrofitService.create()
    * apiService.search(/* search params go in here */)
    * */
    companion object Factory {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://10.96.124.219:8088/")
                    .build()

            return retrofit.create(RetrofitService::class.java);
        }
    }

}