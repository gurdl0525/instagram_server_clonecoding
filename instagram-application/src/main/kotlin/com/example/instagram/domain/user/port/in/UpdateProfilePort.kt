package com.example.instagram.domain.user.port.`in`

import com.example.instagram.domain.user.dto.UpdateProfileRequest

interface UpdateProfilePort {

    fun updateProfile(accountId: String, request: UpdateProfileRequest)
}
