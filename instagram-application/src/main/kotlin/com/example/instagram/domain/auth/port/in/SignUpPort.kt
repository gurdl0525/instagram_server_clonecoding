package com.example.instagram.domain.auth.port.`in`

import com.example.instagram.domain.user.model.User

interface SignUpPort {

    fun saveUser(user: User)
}
