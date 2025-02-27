package com.example.rag.web.request

class QuestionRequest(
    val title: String,
    val category: List<String>,
    val content: String,
    val userId: String,
)