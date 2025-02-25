package com.example.rag.web.request

class QuestionRequest(
    val title: String,
    val category: Array<String>,
    val content: String,
    val userId: String,
)