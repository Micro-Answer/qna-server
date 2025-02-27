package com.example.rag.qna.event.opinion

import com.example.rag.qna.persistence.OpinionEntity
import com.example.rag.qna.persistence.OpinionRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class OpinionEventListener(private val opinionRepository: OpinionRepository) {

    @EventListener
    fun handleEvent(event: OpinionEvent) {
        when (event.eventType) {
            "created" -> handleCreated(event)
            "updated" -> handleUpdated(event)
            "deleted" -> handleDeleted(event)
        }
    }

    private fun handleCreated(event: OpinionEvent) {
        with(event) {
            opinionRepository.save(OpinionEntity(opinionId, questionId, title, content, userId))
        }
    }

    private fun handleUpdated(event: OpinionEvent) {
        val existingEntity = opinionRepository.findById(event.opinionId).orElseThrow { IllegalArgumentException("Opinion not found") }
        existingEntity.apply {
            title = event.title
            content = event.content
            updatedAt = event.eventTimestamp
        }
        opinionRepository.save(existingEntity)
    }

    private fun handleDeleted(event: OpinionEvent) {
        val existingEntity = opinionRepository.findById(event.opinionId).orElseThrow { IllegalArgumentException("Opinion not found") }
        opinionRepository.delete(existingEntity)
    }
}
