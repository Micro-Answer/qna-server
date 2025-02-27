package com.example.rag.qna.event.opinion

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class OpinionEventListener() {

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
            TODO()
        }
    }

    private fun handleUpdated(event: OpinionEvent) {
        TODO()
    }

    private fun handleDeleted(event: OpinionEvent) {
        TODO()
    }
}
