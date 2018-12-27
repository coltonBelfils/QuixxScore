package com.example.colton.quixxscore

import android.app.Activity
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Button

class Scratch(var activity: Activity) : Parcelable{
    private var current: Int = 0
        set(value) {
            if(value in 0..4) field = value
        }
    //lateinit var activity: Activity

    constructor(parcel: Parcel) : this() {
        current = parcel.readInt()
        for (i in 0 until current) {
            activity.findViewById<Button>(MainActivity.scratch[i]).setBackgroundResource(R.drawable.scratch_circle_line)
        }
    }

    fun pressed() {
        current++
        for (i in 0 until current) {
            activity.findViewById<Button>(MainActivity.scratch[i]).setBackgroundResource(R.drawable.scratch_circle_line)
        }
    }

    fun undo() {
        current--
        for (i in current..4) {
            activity.findViewById<Button>(MainActivity.scratch[i]).setBackgroundResource(R.drawable.scratch_circle)
        }
    }

    fun getPenalty(): Int {
        return current * 5
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(current)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Scratch> {
        override fun createFromParcel(parcel: Parcel): Scratch {
            return Scratch(parcel)
        }

        override fun newArray(size: Int): Array<Scratch?> {
            return arrayOfNulls(size)
        }
    }
}