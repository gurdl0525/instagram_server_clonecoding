package com.example.instagram.domain.user.port.`in`

interface PasswordEncodingPort {

    fun encoding(password: String): String
}