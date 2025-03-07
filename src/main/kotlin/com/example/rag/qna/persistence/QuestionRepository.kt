package com.example.rag.qna.persistence

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface QuestionRepository: JpaRepository<QuestionEntity, UUID> {
    @Query("SELECT q FROM QuestionEntity q WHERE :category MEMBER OF q.category ORDER BY q.createdAt DESC")
    fun findByCategory(category: String, pageable: Pageable): Page<QuestionEntity>
}