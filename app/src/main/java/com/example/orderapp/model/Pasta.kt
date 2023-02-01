package com.example.orderapp.model

import com.example.orderapp.R

data class Pasta(
    override val name:String,
    override val imageResource:Int,
    override val price:Double
): Item {

    companion object PastaArray{

        val items: Array<Item> = arrayOf(
            Pasta("Nudeln1", R.drawable.nudel1, 5.50),
            Pasta("Nudeln2", R.drawable.nudel2, 5.50),
            Pasta("Nudeln3", R.drawable.nudel3, 5.50),
            Pasta("Nudeln4", R.drawable.nudel1, 5.50),
            Pasta("Nudeln5", R.drawable.nudel2, 5.50),
            Pasta("Nudeln6", R.drawable.nudel3, 5.50)
        )
    }
}