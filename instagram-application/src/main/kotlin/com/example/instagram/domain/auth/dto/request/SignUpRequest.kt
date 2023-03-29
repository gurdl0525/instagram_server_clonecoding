package com.example.instagram.domain.auth.dto.request

data class SignUpRequest(

    val accountId: String,

    val password: String,

    val name: String,

    val isHided: Boolean
)