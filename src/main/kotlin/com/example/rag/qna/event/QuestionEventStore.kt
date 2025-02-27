package com.example.rag.qna.event

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "question_event_store")
class QuestionEventStore(
    @Column(name = "question_id", nullable = false)
    val questionId: UUID,

    @Column(name = "event_type", nullable = false)
    val eventType: String,

    @Column(name = "category", nullable = false)
    val category: List<String>,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content", nullable = false, length = 2000)
    val content: String,

    @Column(name = "user_id", nullable = false)
    val userId: String,

    @Column(name = "event_timestamp", nullable = false)
    val eventTimestamp: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
