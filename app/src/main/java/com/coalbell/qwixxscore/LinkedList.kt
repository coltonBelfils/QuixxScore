package com.coalbell.qwixxscore

class LinkedList<E> {
    private var head: Node<E>
    private var tail: Node<E>
    var size: Int = 0
        private set

    private class Node<H>(var next: Node<H>?, var prev: Node<H>?, var data: H?)

    init {
        var temp = Node<E>(null, null, null)
        head = Node(temp, null, null)
        tail = Node(null, head, null)
        head.next = tail
    }

    fun isEmpty() = this.head.next == this.tail.prev

    fun clearList() {
        this.head.next = this.tail
        this.tail.prev = this.head
    }

    fun addFirst(data: E) {
        val nn = Node(this.head.next, this.head, data)
        this.head.next?.prev = nn
        this.head.next = nn
    }

    fun addLast(data: E) {
        val nn = Node(this.tail, this.tail.prev, data)
        this.tail.prev?.next = nn
        this.tail.next = nn
    }

    fun removeFirst(): E? {
        if(this.head.next != this.tail) {
            val temp = this.head.next?.data
            this.head.next = this.head.next?.next
            return temp
        }
        return null
    }

    fun removeLast(): E? {
        if(this.tail.prev != this.head) {
            val temp = this.tail.prev?.data
            this.tail.prev = this.tail.prev?.prev
            return temp
        }
        return null
    }
}