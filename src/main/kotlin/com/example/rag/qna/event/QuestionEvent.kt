package com.example.rag.qna.event

import java.time.LocalDateTime
import java.util.*

class QuestionEvent private constructor(
    val eventType: String,
    val title: String,
    val category: Array<String>,
    val content: String,
    val userId: String,
    val questionId: UUID = UUID.randomUUID(),
    val eventTimestamp: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun create(title: String, category: Array<String>, content: String, userId: String): QuestionEvent {
            return QuestionEvent("created", title, category, content, userId)
        }

        fun update(questionId: UUID, title: String, category: Array<String>, content: String, userId: String): QuestionEvent {
            return QuestionEvent("updated", title, category, content, userId, questionId)
        }

        fun delete(questionId: UUID, userId: String, deletionReason: String = "No reason provided"): QuestionEvent {
            return QuestionEvent("deleted", "Deleted question", arrayOf("deleted"), deletionReason, userId, questionId)
        }
    }
}
