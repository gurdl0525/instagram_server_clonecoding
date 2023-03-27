package com.example.instagram.domain.auth.port.out

import com.example.instagram.domain.auth.dto.response.TokenResponse


interface JwtPort: ReceiveTokenPort {

    override fun receiveToken(accountId: String): TokenResponse
}
