package com.example.orderapp.model

import android.os.Parcel
import android.os.Parcelable
import com.example.orderapp.R

data class Pizza(
    override val name:String?,
    override val imageResource: Int,
    override val price: Double
): Item,Parcelable {

    constructor(parcel:Parcel):this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble()
    ){

    }

    companion object CREATOR : Parcelable.Creator<Pizza>{
        val items : Array<Item> = arrayOf(
            Pizza("Fresca", R.drawable.pizza_fresca,5.00),
            Pizza("Kiwi", R.drawable.pizza_kiwi,6.00),
            Pizza("Salami", R.drawable.pizza_salami,5.50),
            Pizza("Fresca2", R.drawable.pizza_fresca,5.00),
            Pizza("Kiwi2", R.drawable.pizza_kiwi,6.00),
            Pizza("Salami2", R.drawable.pizza_salami,5.50),
        )

        override fun createFromParcel(source: Parcel): Pizza {
            return Pizza(source)
        }

        override fun newArray(size: Int): Array<Pizza?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(imageResource)
        dest.writeDouble(price)
    }
}