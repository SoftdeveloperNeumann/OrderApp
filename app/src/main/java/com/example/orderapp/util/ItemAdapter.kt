package com.example.orderapp.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.databinding.ItemLayoutBinding

import com.example.orderapp.model.Item


class ItemAdapter(val items: Array<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }

    private var listener : Listener? = null

    interface Listener{
        fun onItemClick(position: Int)
    }

    fun setListener(listener: Listener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.binding
        cardView.tvPizzaName.text = items[position].name
        cardView.tvPizzaPrice.text = "%.2f %s".format(items[position].price , "€")
        val imageView = cardView.imgPizza
        val drawable = ContextCompat.getDrawable(imageView.context,items[position].imageResource)
        imageView.setImageDrawable(drawable)
        cardView.root.setOnClickListener {
            listener?.onItemClick(position)
        }
    }

    override fun getItemCount() = items.size
}