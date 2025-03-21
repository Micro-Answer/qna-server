package com.example.rag.qna.event.question

import org.springframework.context.ApplicationEvent
import java.time.LocalDateTime
import java.util.*

class QuestionEvent private constructor(
    val eventType: String,
    val title: String,
    val category: List<String>,
    val content: String,
    val userId: String,
    val questionId: UUID = UUID.randomUUID(),
    val eventTimestamp: LocalDateTime = LocalDateTime.now()
) : ApplicationEvent(eventType) {
    companion object {
        fun create(title: String, category: List<String>, content: String, userId: String): QuestionEvent {
            return QuestionEvent("created", title, category, content, userId)
        }

        fun update(questionId: UUID, title: String, category: List<String>, content: String, userId: String): QuestionEvent {
            return QuestionEvent("updated", title, category, content, userId, questionId)
        }

        fun delete(questionId: UUID, userId: String, deletionReason: String = "No reason provided"): QuestionEvent {
            return QuestionEvent("deleted", "Deleted question", listOf("deleted"), deletionReason, userId, questionId)
        }
    }
}
