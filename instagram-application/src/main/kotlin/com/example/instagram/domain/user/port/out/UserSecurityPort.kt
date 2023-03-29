package com.example.instagram.domain.user.port.out

import com.example.instagram.domain.user.model.User
import com.example.instagram.domain.user.port.`in`.PasswordEncodingPort

interface UserSecurityPort: GetCurrentUserPort, PasswordEncodingPort, PasswordMatchesPort{

    override fun encoding(password: String): String

    override fun passwordMatch(password: String, encodedPassword: String): Boolean

    override fun getUserByToken(): User?
}