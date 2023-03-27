package com.example.instagram.domain.user.model

import java.util.UUID

data class User(
    val id: UUID,
    val accountId: String,
    val password: String,
    val name: String,
    val introduction: String?,
    val isDeleted: Boolean,
    val isHided: Boolean,
    val link: MutableList<String>
)