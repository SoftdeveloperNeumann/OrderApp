package com.example.orderapp.util

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.databinding.PizzaLayoutBinding

class PizzaAdapter(val pizzen: Array<String>) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>(){
    class ViewHolder(val binding: PizzaLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}