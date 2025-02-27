package com.example.rag.qna.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OpinionRepository: JpaRepository<OpinionEntity, Long> {
}