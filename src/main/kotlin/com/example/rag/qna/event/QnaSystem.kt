package com.example.rag.qna.event

import com.example.rag.qna.event.question.QuestionEvent
import com.example.rag.qna.event.question.QuestionEventRepository
import com.example.rag.qna.event.question.QuestionEventStore
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

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