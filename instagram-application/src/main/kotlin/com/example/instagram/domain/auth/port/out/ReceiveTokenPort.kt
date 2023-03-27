package com.example.instagram.domain.auth.port.out

import com.example.instagram.domain.auth.dto.response.TokenResponse

interface ReceiveTokenPort {

    fun receiveToken(accountId: String): TokenResponse
}