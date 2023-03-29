package com.example.instagram.global.config.jwt

import com.example.instagram.global.config.jwt.property.JwtProperties
import com.example.instagram.global.config.security.principal.AuthDetails
import com.example.instagram.global.config.security.principal.AuthDetailsService
import com.example.instagram.global.exception.ExpiredTokenException
import com.example.instagram.global.exception.InvalidTokenException
import com.example.instagram.global.exception.UnAuthorizedException
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

    private fun getSubject(token: String): String {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token).body.subject
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw UnAuthorizedException
            }
        }
    }

    fun getAuthentication(token: String): Authentication {

        val subject = getSubject(token)

        val authDetails = authDetailsService.loadUserByUsername(subject) as AuthDetails

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }
}