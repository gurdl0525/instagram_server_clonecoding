package com.example.instagram.domain.user.usecase

import com.example.instagram.domain.user.dto.UpdateProfileRequest
import com.example.instagram.domain.user.exception.UserNotFoundException
import com.example.instagram.domain.user.model.User
import com.example.instagram.domain.user.port.`in`.UpdateProfilePort
import com.example.instagram.domain.user.port.out.GetCurrentUserPort
import com.example.instagram.global.annotation.UseCase

@UseCase
class UpdateProfileUseCase(
    private val updateProfilePort: UpdateProfilePort,
    private val getCurrentUserPort: GetCurrentUserPort
) { 
    fun execute(request: UpdateProfileRequest){

        val accountId = (getCurrentUserPort.getUserByToken()
            ?: throw UserNotFoundException).accountId

        updateProfilePort.updateProfile(accountId, request)
    }
}
