package com.example.rag.qna.event.opinion

import org.springframework.context.ApplicationEvent
import java.time.LocalDateTime
import java.util.*

class OpinionEvent private constructor(
    val eventType: String,
    val title: String,
    val content: String,
    val userId: String,
    val questionId: UUID,
    val opinionId: UUID = UUID.randomUUID(),
    val eventTimestamp: LocalDateTime = LocalDateTime.now()
) : ApplicationEvent(eventType) {
    companion object {
        fun create(title: String, content: String, userId: String, questionId: UUID): OpinionEvent =
            OpinionEvent("created", title, content, userId, questionId)

        fun update(title: String, content: String, userId: String, questionId: UUID, opinionId: UUID): OpinionEvent =
            OpinionEvent("updated", title, content, userId, questionId, opinionId)

        fun delete(opinionId: UUID, userId: String, questionId: UUID, deletionReason: String = "No reason provided"): OpinionEvent =
            OpinionEvent("deleted", "Deleted opinion", deletionReason, userId, questionId, opinionId)
    }
}
