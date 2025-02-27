package com.example.rag.qna.event.question

import com.example.rag.qna.persistence.QuestionEntity
import com.example.rag.qna.persistence.QuestionRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class QuestionEventListener(private val questionRepository: QuestionRepository) {

    @EventListener
    fun handleQuestionEvent(event: QuestionEvent) {
        when (event.eventType) {
            "created" -> handleCreated(event)
            "updated" -> handleUpdated(event)
            "deleted" -> handleDeleted(event)
        }
    }

    private fun handleCreated(event: QuestionEvent) {
        with(event) {
            questionRepository.save(QuestionEntity(questionId, category, title, content, userId))
        }
    }

    private fun handleUpdated(event: QuestionEvent) {
        val existingEntity = questionRepository.findById(event.questionId).orElseThrow { IllegalArgumentException("Question not found") }
        existingEntity.apply {
            title = event.title
            category = event.category
            content = event.content
            updatedAt = event.eventTimestamp
        }
        questionRepository.save(existingEntity)
    }

    private fun handleDeleted(event: QuestionEvent) {
        val existingEntity = questionRepository.findById(event.questionId).orElseThrow { IllegalArgumentException("Question not found") }
        questionRepository.delete(existingEntity)
    }
}
