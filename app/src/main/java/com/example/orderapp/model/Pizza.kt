package com.example.orderapp.model

import com.example.orderapp.R

data class Pizza(
    override val name:String,
    override val imageResource: Int,
    override val price: Double
): Item {

    companion object PizzaArray{
        val items : Array<Item> = arrayOf(
            Pizza("Fresca", R.drawable.pizza_fresca,5.00),
            Pizza("Kiwi", R.drawable.pizza_kiwi,6.00),
            Pizza("Salami", R.drawable.pizza_salami,5.50),
            Pizza("Fresca2", R.drawable.pizza_fresca,5.00),
            Pizza("Kiwi2", R.drawable.pizza_kiwi,6.00),
            Pizza("Salami2", R.drawable.pizza_salami,5.50),
        )
    }
}