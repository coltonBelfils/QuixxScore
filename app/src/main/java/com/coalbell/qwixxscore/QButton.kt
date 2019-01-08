package com.coalbell.qwixxscore

import android.os.Parcel
import android.os.Parcelable

class QButton(var id: Int, var number: Int, var kind: Int, var pressed: Boolean) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(number)
        parcel.writeInt(kind)
        parcel.writeByte(if (pressed) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QButton> {
        const val RED = 0
        const val RED_LOCK = 1
        const val YELLOW = 2
        const val YELLOW_LOCK = 3
        const val GREEN = 4
        const val GREEN_LOCK = 5
        const val BLUE = 6
        const val BLUE_LOCK = 7
        const val SCRATCH = 8

        override fun createFromParcel(parcel: Parcel): QButton {
            return QButton(parcel)
        }

        override fun newArray(size: Int): Array<QButton?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "id: $id, number: $number, kind: $kind, pressed: $pressed"
    }
}