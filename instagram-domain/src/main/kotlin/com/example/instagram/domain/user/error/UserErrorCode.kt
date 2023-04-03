package com.example.instagram.domain.user.error

import com.example.instagram.global.error.ErrorProperty

enum class UserErrorCode(
    private val status: Int,
    private val code: String,
    private val message: String
): ErrorProperty {

    //400
    DUPLICATED_USER(400, "B02", "Duplicated User"),
    INCORRECT_PASSWORD(400, "B03", "Incorrect Password"),

    //404
    USER_NOT_FOUND(404, "N01", "User Not Found")
    ;

    override fun status() = status

    override fun code() = code

    override fun message() = message

}