package com.example.lojamvvmofc.repositories

import com.example.lojamvvmofc.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllLojas() = retrofitService.getAllLojas()
}