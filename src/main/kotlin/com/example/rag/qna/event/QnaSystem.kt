package com.example.rag.qna.event

import org.springframework.stereotype.Service
import java.util.*

@Service
class QnaSystem(private val questionEventRepository: QuestionEventRepository) {
    fun recordEvent(questionEvent: QuestionEvent) {
        questionEvent.run {
            val id = UUID.randomUUID()
            questionEventRepository.save(QuestionEventStore(id, eventType, category, title, content, userId))
        }
    }
}