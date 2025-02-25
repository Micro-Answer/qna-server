package com.example.rag.util.cache.common

import java.util.concurrent.TimeUnit

class Timeout(
    private val timeout: Long = TimeUnit.DAYS.toMillis(1),
    private val createdAt: Long = System.currentTimeMillis()
) {
    fun isExpired(): Boolean =
        System.currentTimeMillis() - createdAt > timeout
}