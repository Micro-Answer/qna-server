package com.example.rag.web.request

import java.time.LocalDateTime
import java.util.*

data class QuestionTitle(val questionId: UUID, val title: String, val userId: String, val createdAt: LocalDateTime)
