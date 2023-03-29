package com.example.instagram.adapter.`in`.auth

import com.example.instagram.adapter.`in`.auth.dto.LoginWebRequest
import com.example.instagram.adapter.`in`.auth.dto.SignUpWebRequest
import com.example.instagram.domain.auth.dto.request.LoginRequest
import com.example.instagram.domain.auth.dto.request.SignUpRequest
import com.example.instagram.domain.auth.dto.response.TokenResponse
import com.example.instagram.domain.auth.usecase.LoginUseCase
import com.example.instagram.domain.auth.usecase.SignUpUseCase
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
@Validated
class AuthController(
    private val signUpUseCase: SignUpUseCase,
    private val loginUseCase: LoginUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(
        @RequestBody @Valid
        request: SignUpWebRequest
    ){

        signUpUseCase.execute(
            SignUpRequest(
                request.accountId,
                request.password,
                request.name,
                request.isHided!!
            )
        )
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    fun login(
        @RequestBody @Valid
        request: LoginWebRequest
    ): TokenResponse{
        return loginUseCase.execute(
            LoginRequest(
                request.accountId,
                request.password
            )
        )
    }
}