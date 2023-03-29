package com.example.instagram.domain.auth.usecase

import com.example.instagram.domain.auth.dto.request.LoginRequest
import com.example.instagram.domain.auth.dto.response.TokenResponse
import com.example.instagram.domain.auth.exception.IncorrectPasswordException
import com.example.instagram.domain.auth.port.out.ReceiveTokenPort
import com.example.instagram.domain.user.exception.UserNotFoundException
import com.example.instagram.domain.user.port.out.FindUserPort
import com.example.instagram.domain.user.port.out.PasswordMatchesPort
import com.example.instagram.global.annotation.UseCase

@UseCase
class LoginUseCase(
    private val receiveTokenPort: ReceiveTokenPort,
    private val passwordMatchesPort: PasswordMatchesPort,
    private val findUserPort: FindUserPort
) {

    fun execute(request: LoginRequest): TokenResponse{

        val user = findUserPort.findByAccountId(request.accountId)
            ?: throw UserNotFoundException

        if(passwordMatchesPort.passwordMatch(request.password, user.password)){
            return receiveTokenPort.receiveToken(user.accountId)
        }

        throw IncorrectPasswordException
    }

}
