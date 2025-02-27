package com.example.rag.qna.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface QuestionRepository: JpaRepository<QuestionEntity, UUID> {
}