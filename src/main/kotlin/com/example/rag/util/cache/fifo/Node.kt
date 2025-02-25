package com.example.rag.util.cache.fifo

import com.example.rag.util.cache.common.Timeout

class Node<T>(
    var value: T,
    private val timeout: Timeout = Timeout()
) {
}