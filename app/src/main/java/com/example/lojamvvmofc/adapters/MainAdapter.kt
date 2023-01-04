package com.example.lojamvvmofc.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lojamvvmofc.databinding.ActivityResItemLojaBinding

import com.example.lojamvvmofc.model.Loja

class MainAdapter (private val onItemClicked: (Loja) -> Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    private var lojas = mutableListOf<Loja>()

    fun setLojaList(loja: List<Loja>) {
        this.lojas = loja.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityResItemLojaBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       val loja = lojas[position]
        holder.bind(loja,onItemClicked)
    }

    override fun getItemCount(): Int {
        return lojas.size
    }

    class MainViewHolder(val binding: ActivityResItemLojaBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(loja: Loja, onItemClicked: (Loja) -> Unit){
            binding.tvModelAnswer.text = loja.model

            Glide.with(itemView.context)
                .load(loja.imageUrl)
                .into(binding.ivPoster)

        }

    }
}