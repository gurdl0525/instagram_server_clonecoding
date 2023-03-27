package com.example.instagram.global.config.security

import com.example.instagram.global.config.filter.FilterConfig
import com.example.instagram.global.config.jwt.JwtTokenParser
import com.example.instagram.global.config.jwt.JwtTokenResolver
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val jwtTokenParser: JwtTokenParser,
    private val jwtTokenResolver: JwtTokenResolver
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .formLogin().disable()
            .cors().and()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeHttpRequests()
            .antMatchers("*").permitAll()
            .anyRequest().permitAll()

            .and().apply(FilterConfig(objectMapper, jwtTokenParser, jwtTokenResolver))

            .and().build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}