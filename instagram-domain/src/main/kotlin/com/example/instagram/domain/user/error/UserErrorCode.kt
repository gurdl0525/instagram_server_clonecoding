package com.example.instagram.domain.user.error

import com.example.instagram.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class UserErrorCode(
    private val status: HttpStatus,
    private val code: String,
    private val message: String
): ErrorProperty {

    //400
    DUPLICATED_USER(HttpStatus.BAD_REQUEST, "B02", "Duplicated User"),
    INCORRECT_PASSWORD(HttpStatus.BAD_REQUEST, "B03", "Incorrect Password"),

    //404
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "N01", "User Not Found")
    ;

    override fun status() = status

    override fun code() = code

    override fun message() = message

}