package com.myblog.blog.dto.response

import com.myblog.blog.common.ResponseCode
import com.myblog.blog.common.ResponseMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ResponseDTO (
        val code: String,
        val message: String,
        ) {

        fun databaseError(): ResponseEntity<ResponseDTO> {
                val responseBodyDTO = ResponseDTO(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR)
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBodyDTO)
        }
}