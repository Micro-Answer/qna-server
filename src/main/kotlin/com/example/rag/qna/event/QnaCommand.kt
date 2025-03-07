package com.example.rag.qna.event

import com.example.rag.qna.event.opinion.OpinionEvent
import com.example.rag.qna.event.opinion.OpinionEventRepository
import com.example.rag.qna.event.opinion.OpinionEventStore
import com.example.rag.qna.event.question.QuestionEvent
import com.example.rag.qna.event.question.QuestionEventRepository
import com.example.rag.qna.event.question.QuestionEventStore
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class QnaCommand(
    private val questionEventRepository: QuestionEventRepository,
    private val opinionEventRepository: OpinionEventRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun recordEvent(questionEvent: QuestionEvent) {
        questionEvent.run {
            questionEventRepository.save(QuestionEventStore(questionId, eventType, category, title, content, userId))
            applicationEventPublisher.publishEvent(this)
        }
    }

    fun recordEvent(opinionEvent: OpinionEvent) {
        opinionEvent.run {
            opinionEventRepository.save(OpinionEventStore(opinionId, eventType, questionId, title, content, userId))
            applicationEventPublisher.publishEvent(this)
        }
    }
}