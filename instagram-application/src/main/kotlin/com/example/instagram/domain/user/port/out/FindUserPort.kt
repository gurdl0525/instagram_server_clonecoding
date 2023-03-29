package com.example.instagram.domain.user.port.`out`

import com.example.instagram.domain.user.model.User

interface FindUserPort {

    fun findByAccountId(accountId: String): User?
}