package com.example.rag.web

import com.example.rag.qna.event.QnaSystem
import com.example.rag.qna.event.opinion.OpinionEvent
import com.example.rag.qna.event.question.QuestionEvent
import com.example.rag.web.request.OpinionRequest
import com.example.rag.web.request.QuestionRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/v1/api/rag")
class RagController(private val qnaSystem: QnaSystem) {
    @PostMapping("/questions")
    fun enrollQuestion(@RequestBody request: QuestionRequest): ResponseEntity<String> =
        request.run {
            qnaSystem.recordEvent(QuestionEvent.create(title, category, content, userId))
            ResponseEntity.status(HttpStatus.CREATED).body("${request.title} 등록 성공!")
        }

    @PutMapping("/questions/{questionId}")
    fun updateQuestion(
        @PathVariable questionId: UUID,
        @RequestBody request: QuestionRequest
    ): ResponseEntity<String> =
        request.run {
            qnaSystem.recordEvent(QuestionEvent.update(questionId, title, category, content, userId))
            ResponseEntity.ok("${request.title} 수정 성공!")
        }

    @DeleteMapping("/questions/{questionId}")
    fun deleteQuestion(
        @PathVariable questionId: UUID,
        @RequestParam userId: String
    ): ResponseEntity<Void> {
        qnaSystem.recordEvent(QuestionEvent.delete(questionId, userId))
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/opinions")
    fun enrollOpinion(
        @RequestParam questionId: UUID,
        @RequestBody request: OpinionRequest
    ): ResponseEntity<String> =
        request.run {
            qnaSystem.recordEvent(OpinionEvent.create(title, content, userId, questionId))
            ResponseEntity.status(HttpStatus.CREATED).body("${request.title} 등록 성공!")
        }

    @PutMapping("/opinions/{opinionId}")
    fun updateOpinion(
        @PathVariable opinionId: UUID,
        @RequestParam questionId: UUID,
        @RequestBody request: OpinionRequest
    ): ResponseEntity<String> =
        request.run {
            qnaSystem.recordEvent(OpinionEvent.update(title, content, userId, questionId, opinionId))
            ResponseEntity.ok("${request.title} 수정 성공!")
        }

    @DeleteMapping("/opinions/{opinionId}")
    fun deleteOpinion(
        @PathVariable opinionId: UUID,
        @RequestParam questionId: UUID,
        @RequestParam userId: String
    ): ResponseEntity<Void> {
        qnaSystem.recordEvent(OpinionEvent.delete(opinionId, userId, questionId))
        return ResponseEntity.noContent().build()
    }
}
