package com.example.instagram.global.config.jwt

import com.example.instagram.global.exception.ExpiredTokenException
import com.example.instagram.global.exception.InternalServerErrorException
import com.example.instagram.global.exception.InvalidTokenException
import com.example.instagram.global.config.jwt.property.JwtProperties
import com.example.instagram.global.config.security.principal.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtTokenParser(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw InternalServerErrorException
            }
        }
    }

    fun getAuthentication(token: String): Authentication {

        val claims = getClaims(token)

        val authDetails = authDetailsService.loadUserByUsername(
            claims.subject ?: throw InvalidTokenException
        )

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }
}