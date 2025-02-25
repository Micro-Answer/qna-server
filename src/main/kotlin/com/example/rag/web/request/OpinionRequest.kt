package com.example.rag.web.request

class OpinionRequest(
    val questionId: String,
    val title: String,
    val content: String,
    val userId: String,
)