package com.example.colton.quixxscore

import android.app.Activity
import android.os.Parcel
import android.os.Parcelable

class History() : Parcelable{

    lateinit var activity: Activity
    var hist = HistoryStack()
    var red = Color(activity, 0)
    var yellow = Color(activity, 1)
    var green = Color(activity, 2)
    var blue = Color(activity, 3)
    var scratch = Scratch(activity)

    constructor(parcel: Parcel) : this() {
        parcel.readParcelableArray(History::class.java.classLoader)
    }

    fun write(action: Action) {
        hist.push(action)
    }

    fun readHistory() {
        hist.resetQueue()
        var histRead = hist.deQueue()
        while(histRead != null) {
            doAction(histRead)
            histRead = hist.deQueue()
        }
    }

    fun undo() {
        when(hist.pop()?.kind) {
            0 -> red.undo()
            1 -> red.undo()
            2 -> yellow.undo()
            3 -> yellow.undo()
            4 -> green.undo()
            5 -> green.undo()
            6 -> blue.undo()
            7 -> blue.undo()
            8 -> scratch.undo()
        }
    }

    private fun doAction(action: Action) {
        when(action.kind) {
            0 -> red.pressed(action.number)
            1 -> red.lock()
            2 -> yellow.pressed(action.number)
            3 -> yellow.lock()
            4 -> green.pressed(action.number)
            5 -> green.lock()
            6 -> blue.pressed(action.number)
            7 -> blue.lock()
            8 -> scratch.pressed()
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(hist, 0)
        parcel.writeParcelable(red, 0)
        parcel.writeParcelable(yellow, 0)
        parcel.writeParcelable(green, 0)
        parcel.writeParcelable(blue, 0)
        parcel.writeParcelable(scratch, 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<History> {
        override fun createFromParcel(parcel: Parcel): History {
            return History(parcel)
        }

        override fun newArray(size: Int): Array<History?> {
            return arrayOfNulls(size)
        }
    }
}