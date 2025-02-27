package com.example.rag.qna.event.question

import org.springframework.data.jpa.repository.JpaRepository

interface QuestionEventRepository: JpaRepository<QuestionEventStore, Long> {
}