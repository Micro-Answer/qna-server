package com.example.rag.qna.persistence

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OpinionRepository: JpaRepository<OpinionEntity, UUID> {
    @Query("SELECT o FROM OpinionEntity o WHERE o.questionId = :questionId ORDER BY o.createdAt DESC")
    fun findByQuestionId(questionId: UUID, pageable: Pageable): Page<OpinionEntity>
}