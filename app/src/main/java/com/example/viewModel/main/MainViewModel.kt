package com.example.viewModel.main

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lojamvvmofc.model.Loja
import com.example.lojamvvmofc.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel(){

    val lojaList = MutableLiveData<List<Loja>>()
    val errorMessage = MutableLiveData<String>()

    fun gelAllLojas(){

        val request = repository.getAllLojas()
        request.enqueue(object : Callback<List<Loja>>{
            override fun onResponse(call: Call<List<Loja>>, response: Response<List<Loja>>) {
              //Quando houver uma resposta
                lojaList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Loja>>, t: Throwable) {
                //Quando houver uma falha
                errorMessage.postValue(t.message)

            }

        })
    }
    private fun detailItem(){
        val detail = Intent()
    }
}