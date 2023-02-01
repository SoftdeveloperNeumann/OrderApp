package com.example.orderapp.model

import com.example.orderapp.R

class Drink(
    override val name: String,
    override val imageResource: Int,
    override val price: Double

): Item {

    companion object DrinkArray{
        val items: Array<Item> = arrayOf(
            Drink("Drink1", R.drawable.drink1, 5.50),
            Drink("Drink2", R.drawable.drink2, 5.50),
            Drink("Drink3", R.drawable.drink3, 5.50),
            Drink("Drink4", R.drawable.drink1, 5.50),
            Drink("Drink5", R.drawable.drink2, 5.50),
            Drink("Drink6", R.drawable.drink3, 5.50)
        )
    }
}