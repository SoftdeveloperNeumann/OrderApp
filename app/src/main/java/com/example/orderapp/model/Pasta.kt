package com.example.orderapp.model

import android.os.Parcel
import android.os.Parcelable
import com.example.orderapp.R

data class Pasta(
    override val name:String?,
    override val imageResource:Int,
    override val price:Double
): Item,Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble()
    ) {
    }

    companion object CREATOR : Parcelable.Creator<Pasta> {

        val items: Array<Item> = arrayOf(
            Pasta("Nudeln1", R.drawable.nudel1, 5.50),
            Pasta("Nudeln2", R.drawable.nudel2, 5.50),
            Pasta("Nudeln3", R.drawable.nudel3, 5.50),
            Pasta("Nudeln4", R.drawable.nudel1, 5.50),
            Pasta("Nudeln5", R.drawable.nudel2, 5.50),
            Pasta("Nudeln6", R.drawable.nudel3, 5.50)
        )
        override fun createFromParcel(parcel: Parcel): Pasta {
            return Pasta(parcel)
        }

        override fun newArray(size: Int): Array<Pasta?> {
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