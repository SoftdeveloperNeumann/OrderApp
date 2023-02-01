package com.example.orderapp.model

import android.os.Parcel
import android.os.Parcelable
import com.example.orderapp.R

data class Drink(
    override val name: String?,
    override val imageResource: Int,
    override val price: Double

): Item, Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble()
    ) {
    }

    companion object CREATOR : Parcelable.Creator<Drink>{
        val items: Array<Item> = arrayOf(
            Drink("Drink1", R.drawable.drink1, 5.50),
            Drink("Drink2", R.drawable.drink2, 5.50),
            Drink("Drink3", R.drawable.drink3, 5.50),
            Drink("Drink4", R.drawable.drink1, 5.50),
            Drink("Drink5", R.drawable.drink2, 5.50),
            Drink("Drink6", R.drawable.drink3, 5.50)
        )

        override fun createFromParcel(source: Parcel): Drink {
           return Drink(source)
        }

        override fun newArray(size: Int): Array<Drink?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(imageResource)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }
}