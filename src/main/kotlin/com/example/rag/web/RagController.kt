package com.example.rag.web

import com.example.rag.web.request.OpinionRequest
import com.example.rag.web.request.QuestionRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/rag")
class RagController() {
    @PostMapping("/questions")
    fun enrollQuestion(@RequestBody request: QuestionRequest): ResponseEntity<String> {
        TODO()
        return ResponseEntity.status(HttpStatus.CREATED).body("${request.title} 등록 성공!")
    }

    @PostMapping("/opinions")
    fun enrollOpinion(@RequestBody request: OpinionRequest): ResponseEntity<String> {
        TODO()
        return ResponseEntity.status(HttpStatus.CREATED).body("${request.title} 등록 성공!")
    }
}
