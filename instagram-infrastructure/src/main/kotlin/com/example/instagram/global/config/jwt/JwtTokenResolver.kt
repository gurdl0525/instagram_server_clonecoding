package com.example.instagram.global.config.jwt

import org.springframework.stereotype.Component
import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenResolver {

    companion object{
        private const val REGEX_BEARER_TOKEN = "Bearer [(a-zA-Z0-9-._~+/=*)]{30,600}"
    }

    fun resolveToken(httpServletRequest: HttpServletRequest) = parseToken(
        httpServletRequest.getHeader("Authorization")
    )

    private fun parseToken(token: String?) = if (token != null && Pattern.matches(REGEX_BEARER_TOKEN, token)) {
        token.substring(7)
    } else {
        null
    }
}