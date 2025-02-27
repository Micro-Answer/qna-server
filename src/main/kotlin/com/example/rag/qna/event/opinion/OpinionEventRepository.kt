package com.example.rag.qna.event.opinion

import org.springframework.data.jpa.repository.JpaRepository

interface OpinionEventRepository: JpaRepository<OpinionEventStore, Long> {
}