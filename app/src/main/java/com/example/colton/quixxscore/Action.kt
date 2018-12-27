package com.example.colton.quixxscore

import android.os.Parcel
import android.os.Parcelable

class Action(val kind: Int, val number: Int) : Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    )

    companion object CREATOR : Parcelable.Creator<Action> {
        const val RED = 0
        const val RED_LOCK = 1
        const val YELLOW = 2
        const val YELLOW_LOCK = 3
        const val GREEN = 4
        const val GREEN_LOCK = 5
        const val BLUE = 6
        const val BLUE_LOCK = 7
        const val SCRATCH = 8

        override fun createFromParcel(parcel: Parcel): Action {
            return Action(parcel)
        }

        override fun newArray(size: Int): Array<Action?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(kind)
        parcel.writeInt(number)
    }

    override fun describeContents(): Int {
        return 0
    }
}