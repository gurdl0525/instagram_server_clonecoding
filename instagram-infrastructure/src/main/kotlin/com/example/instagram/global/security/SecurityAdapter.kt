package com.example.instagram.global.security

import com.example.instagram.domain.persistense.user.mapper.UserMapper
import com.example.instagram.domain.persistense.user.repository.UserRepository
import com.example.instagram.domain.user.exception.UserNotFoundException
import com.example.instagram.domain.user.model.User
import com.example.instagram.domain.user.port.out.UserSecurityPort
import com.example.instagram.global.config.security.principal.AuthDetails
import com.example.instagram.global.exception.InternalServerErrorException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class SecurityAdapter(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
): UserSecurityPort {

    override fun getUserByToken(): User? {

        val authDetails = (SecurityContextHolder.getContext().authentication
            ?: throw UserNotFoundException).principal as AuthDetails

        val user = userRepository.findByAccountId(authDetails.username)

        return userMapper.toDomain(user)
    }

    override fun encoding(password: String): String = passwordEncoder.encode(password)

    override fun passwordMatch(password: String, encodedPassword: String) =
        passwordEncoder.matches(
            password,
            encodedPassword
        )
}