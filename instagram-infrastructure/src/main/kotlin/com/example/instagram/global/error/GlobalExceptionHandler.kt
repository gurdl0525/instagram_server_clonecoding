package com.example.instagram.global.error

import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindException): BindErrorResponse? = ErrorResponse.of(e)

    @ExceptionHandler(BusinessException::class)
    protected fun customExceptionHandle(e: BusinessException) = ErrorResponse(
        e.errorProperty.status(),
        e.errorProperty.code(),
        e.errorProperty.message()
    )

}