package com.example.colton.quixxscore

import android.os.Parcel
import android.os.Parcelable

class HistoryStack() : Parcelable{
    private var head: Node<Action>
    private var tail: Node<Action>
    var size: Int = 0
        private set
    private var queueMark: Node<Action>?
    private var queueMarkLength = 0

    constructor(parcel: Parcel) : this() {
        var array = parcel.readParcelableArray(HistoryStack::class.java.classLoader)
        if(array != null) for (i in array) {
            this.push(i as Action)
        }

        this.size = parcel.readInt()

        this.queueMarkLength = parcel.readInt()
        this.resetQueue()
        for (i in 0 until this.queueMarkLength) {
            this.deQueue()
        }
    }

    private class Node<H>(var next: Node<H>?, var prev: Node<H>?, var data: H?)

    init {
        var temp = Node<Action>(null, null, null)
        head = Node(temp, null, null)
        tail = Node(null, head, null)
        head.next = tail
        queueMark = tail
    }

    fun isEmpty() = this.head.next == this.tail

    fun clear() {
        this.head.next = this.tail
        this.tail.prev = this.head
        this.size = 0
    }

    fun push(data: Action) {
        val nn = Node(this.head.next, this.head, data)
        this.head.next?.prev = nn
        this.head.next = nn
        this.size++
    }

    fun pop(): Action? {
        if(!this.isEmpty()) {
            val temp = this.head.next?.data
            this.head.next = this.head.next?.next
            this.size--
            return temp
        }
        return null
    }

    fun deQueue(): Action? {
        if(this.isEmpty()) {
            return null
        }
        queueMark = queueMark?.prev
        return queueMark?.data
    }

    fun resetQueue() {
        queueMark = tail
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        var tempMarker = queueMark
        this.resetQueue()

        var array = Array<Action?>(this.size) {null}
        var histRead = this.deQueue()
        var index = 0
        while(histRead != null) {
            array[index] = histRead
            histRead = this.deQueue()
            index++
        }
        parcel.writeParcelableArray(array, 0)
        parcel.writeInt(this.size)
        parcel.writeInt(this.queueMarkLength)

        queueMark = tempMarker
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HistoryStack> {
        override fun createFromParcel(parcel: Parcel): HistoryStack {
            return HistoryStack(parcel)
        }

        override fun newArray(size: Int): Array<HistoryStack?> {
            return arrayOfNulls(size)
        }
    }
}