package com.example.instagram.domain.auth.usecase

import com.example.instagram.domain.auth.dto.request.SignUpRequest
import com.example.instagram.domain.auth.exception.DuplicatedUserException
import com.example.instagram.domain.auth.port.`in`.SignUpPort
import com.example.instagram.domain.user.model.User
import com.example.instagram.domain.user.port.`in`.PasswordEncodingPort
import com.example.instagram.domain.user.port.`out`.FindUserPort
import com.example.instagram.global.annotation.UseCase

@UseCase
class SignUpUseCase(
    private val signUpPort: SignUpPort,
    private val findUserPort: FindUserPort,
    private val passwordEncodingPort: PasswordEncodingPort
) {

    fun execute(request: SignUpRequest) {

        findUserPort.findByAccountId(request.accountId)
            ?: return signUpPort.saveUser(
                User(
                    null,
                    request.accountId,
                    passwordEncodingPort.encoding(request.password),
                    request.name,
                    null,
                    false,
                    request.isHided,
                    null
                )
            )

        throw DuplicatedUserException
    }
}