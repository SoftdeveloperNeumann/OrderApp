package com.example.orderapp.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.databinding.PizzaLayoutBinding
import com.example.orderapp.model.Pizza

class PizzaAdapter(val pizzen: Array<Pizza>) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>(){
    class ViewHolder(val binding: PizzaLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }

    private var listener : Listener? = null

    interface Listener{
        fun onItemClick(position: Int)
    }

    fun setListener(listener: Listener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = PizzaLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.binding
        cardView.tvPizzaName.text = pizzen[position].name
        cardView.tvPizzaPrice.text = pizzen[position].price.toString()
        val imageView = cardView.imgPizza
        val drawable = ContextCompat.getDrawable(imageView.context,pizzen[position].imageResource)
        imageView.setImageDrawable(drawable)
        cardView.root.setOnClickListener {
            listener?.onItemClick(position)
        }
    }

    override fun getItemCount() = pizzen.size
}