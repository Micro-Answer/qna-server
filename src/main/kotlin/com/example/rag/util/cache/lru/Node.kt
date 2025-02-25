package com.example.rag.util.cache.lru

import com.example.rag.util.cache.common.Timeout

class Node<K, V>(
    val key: K,
    var value: V,
    var next: Node<K, V>? = null,
    var prev: Node<K, V>? = null,
    private val timeout: Timeout = Timeout()
) {
    fun isExpired(): Boolean =
        timeout.isExpired()
}