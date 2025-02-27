package com.example.rag.qna.event

import org.springframework.data.jpa.repository.JpaRepository

interface QuestionEventRepository: JpaRepository<QuestionEventStore, Long> {
}