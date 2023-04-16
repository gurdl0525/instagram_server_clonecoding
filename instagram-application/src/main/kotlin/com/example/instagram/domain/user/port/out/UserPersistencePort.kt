package com.example.instagram.domain.user.port.out

import com.example.instagram.domain.auth.port.`in`.SignUpPort
import com.example.instagram.domain.user.dto.UpdateProfileRequest
import com.example.instagram.domain.user.model.User
import com.example.instagram.domain.user.port.`in`.UpdateProfilePort

interface UserPersistencePort: SignUpPort, FindUserPort, UpdateProfilePort {

    override fun saveUser(user: User)

    override fun findByAccountId(accountId: String): User?

    override fun updateProfile(accountId: String, request: UpdateProfileRequest)
}