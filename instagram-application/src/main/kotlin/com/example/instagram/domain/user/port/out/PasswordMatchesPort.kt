package com.example.instagram.domain.user.port.out

interface PasswordMatchesPort {

    fun passwordMatch(password: String, encodedPassword: String): Boolean
}
