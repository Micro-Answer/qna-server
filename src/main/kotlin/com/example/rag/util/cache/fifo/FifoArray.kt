package com.example.rag.util.cache.fifo

class FifoArray<T>(private val capacity: Int) {
    private val fifo: Array<Any?> = arrayOfNulls(capacity)
    private var front = 0
    private var rear = 0
    private var size = 0

    fun addLast(element: T) {
        if (isFull()) {
            removeFirst()
        }
        fifo[rear] = element
        rear = (rear + 1) % capacity
        size++
    }

    fun isFull(): Boolean {
        return size == capacity
    }

    fun removeFirst(): T {
        val element = fifo[front] ?: throw NoSuchElementException("Empty")
        fifo[front] = null
        front = (front + 1) % capacity
        size--
        return element as T
    }

    fun get(i: Int): T {
        if (isEmpty()) {
            throw NoSuchElementException("Empty")
        }

        if (i < 0 || i >= size) {
            throw IndexOutOfBoundsException("Index $i is out of bounds")
        }

        return fifo[(front + i) % capacity] as T
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun size(): Int {
        return size
    }
}