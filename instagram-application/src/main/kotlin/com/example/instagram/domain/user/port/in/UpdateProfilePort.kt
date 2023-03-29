package com.example.instagram.domain.user.port.`in`

import com.example.instagram.domain.user.model.User

interface UpdateProfilePort {

    fun updateProfile(user: User)
}
