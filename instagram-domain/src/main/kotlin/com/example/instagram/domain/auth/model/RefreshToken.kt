package com.example.instagram.domain.auth.model

data class RefreshToken (
    val accountId: String,
    val token: String
)
