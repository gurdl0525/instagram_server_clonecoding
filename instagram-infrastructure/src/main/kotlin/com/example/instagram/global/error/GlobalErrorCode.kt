package com.example.instagram.global.error

import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    private val status: HttpStatus,
    private val code: String,
    private val message: String
): ErrorProperty {

    //400
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "B01", "Bad Request"),

    //401
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "U01", "Invalid Token"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "U02", "Expired Token"),
    UN_AUTHORIZED(HttpStatus.UNAUTHORIZED, "U03", "Un Authenticated"),

    //500
    INTERNAL_SERVER_GLOBAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "I01", "Internal Server Error")
    ;

    override fun status() = status

    override fun code() = code

    override fun message() = message
}