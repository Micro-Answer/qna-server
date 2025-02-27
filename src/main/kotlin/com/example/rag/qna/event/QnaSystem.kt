package com.example.rag.qna.event

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.util.*

@Service
class QnaSystem(
    private val questionEventRepository: QuestionEventRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun recordEvent(questionEvent: QuestionEvent) {
        questionEvent.run {
            questionEventRepository.save(QuestionEventStore(questionId, eventType, category, title, content, userId))
            applicationEventPublisher.publishEvent(this)
        }
    }
}