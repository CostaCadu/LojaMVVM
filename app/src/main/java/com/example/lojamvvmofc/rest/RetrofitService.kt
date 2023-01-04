package com.example.lojamvvmofc.rest

import com.example.lojamvvmofc.model.Loja
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("327c4367-8eca-4bd5-b98f-6aea396ea491")
    fun getAllLojas(): Call<List<Loja>>

    companion object {
        private val retrofitService: RetrofitService by lazy{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://mocki.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService{
            return retrofitService
        }

    }

}