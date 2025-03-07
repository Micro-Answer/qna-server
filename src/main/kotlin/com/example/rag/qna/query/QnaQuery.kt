package com.example.rag.qna.query

import com.example.rag.qna.persistence.OpinionRepository
import com.example.rag.qna.persistence.QuestionEntity
import com.example.rag.qna.persistence.QuestionRepository
import com.example.rag.web.request.QuestionTitle
import org.springframework.data.domain.PageRequest
import java.util.UUID

class QnaQuery(
    private val questionRepository: QuestionRepository,
    private val opinionRepository: OpinionRepository
) {
    fun readQuestionTitles(category: String, offset: Int, limit: Int): List<QuestionTitle> =
        questionRepository.findByCategory(category, PageRequest.of(offset, limit))
            .content.map { QuestionTitle(it.id, it.title, it.userId, it.createdAt) }

    fun readQuestion(questionId: UUID): QuestionEntity =
        questionRepository.findById(questionId).orElseThrow()
}