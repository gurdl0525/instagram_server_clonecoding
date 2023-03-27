package com.example.instagram.global.config.filter

import com.example.instagram.global.config.jwt.JwtTokenParser
import com.example.instagram.global.config.jwt.JwtTokenResolver
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenFilter(
    private val jwtTokenResolver: JwtTokenResolver,
    private val jwtTokenParser: JwtTokenParser
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        jwtTokenResolver.resolveToken(request)
            ?.run {
                SecurityContextHolder.getContext().authentication = jwtTokenParser.getAuthentication(this)
            }

        filterChain.doFilter(request, response)
    }
}