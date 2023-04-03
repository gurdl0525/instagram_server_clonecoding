package com.example.instagram.global.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindException): BindErrorResponse = ErrorResponse.of(e)


    @ExceptionHandler(BusinessException::class)
    protected fun customExceptionHandle(e: BusinessException): ResponseEntity<ErrorResponse> {
        val body = ErrorResponse.of(e.errorProperty)
        val status = HttpStatus.valueOf(e.errorProperty.status())
        return ResponseEntity(body, status)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    protected fun handleHttpMessageNotReadable(e: HttpMessageNotReadableException) = ErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        e.httpInputMessage.toString(),
        e.message ?: e.localizedMessage
    )
}