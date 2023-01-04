package com.example.lojamvvmofc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lojamvvmofc.adapters.MainAdapter
import com.example.lojamvvmofc.databinding.ActivityMainBinding
import com.example.lojamvvmofc.repositories.MainRepository
import com.example.lojamvvmofc.rest.RetrofitService
import com.example.viewModel.main.MainViewModel
import com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()

    private val adapter = MainAdapter {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        binding.recyclerview.adapter = adapter

    }

    override fun onStart() {
        super.onStart()

        viewModel.lojaList.observe(this, Observer {
            Log.i("Cadu", "onCreate: $it")
            adapter.setLojaList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.gelAllLojas()
    }

}