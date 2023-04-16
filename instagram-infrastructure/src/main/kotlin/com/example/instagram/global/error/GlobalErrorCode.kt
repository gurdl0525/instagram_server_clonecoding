package com.example.instagram.global.error

enum class GlobalErrorCode(
    private val status: Int,
    private val code: String,
    private val message: String
): ErrorProperty {

    //400
    BAD_REQUEST(400, "B01", "Bad Request"),

    //401
    INVALID_TOKEN(401, "U01", "Invalid Token"),
    EXPIRED_TOKEN(401, "U02", "Expired Token"),
    UN_AUTHORIZED(401, "U03", "Un Authenticated"),

    //500
    INTERNAL_SERVER_GLOBAL_ERROR(500, "I01", "Internal Server Error")
    ;

    override fun status() = status

    override fun code() = code

    override fun message() = message
}