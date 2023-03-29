package com.example.instagram.domain.user.port.out

import com.example.instagram.domain.user.model.User

interface GetCurrentUserPort {

    fun getUserByToken(): User?
}