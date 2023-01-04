package com.example.lojamvvmofc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lojamvvmofc.databinding.ActivityActiviydetailBinding

class activiydetail : AppCompatActivity() {


    private lateinit var binding: ActivityActiviydetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityActiviydetailBinding.inflate(layoutInflater)


    }
}