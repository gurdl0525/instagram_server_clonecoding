package com.example.instagram.domain.auth.dto.request

data class LoginRequest (
    val accountId: String,
    val password: String
)