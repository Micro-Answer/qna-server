package com.example.rag.qna.persistence

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "questions")
class QuestionEntity(
    @Id
    @Column(name = "question_id")
    val id: UUID,

    @ElementCollection
    @CollectionTable(
        name = "question_categories",
        joinColumns = [JoinColumn(name = "question_id")]
    )
    @Column(name = "category_value", nullable = false)
    var category: List<String>,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content", nullable = false, length = 2000)
    var content: String,

    @Column(name = "user_id", nullable = false)
    var userId: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = createdAt
) {
    @Version
    var version = 0
}